package com.axelor.apps.viewmanagement.web;

import com.axelor.apps.viewmanagement.objectviews.AbstractView;
import com.axelor.apps.viewmanagement.objectviews.ObjectViews;
import com.axelor.apps.viewmanagement.service.ViewManagementFindViewService;
import com.axelor.apps.viewmanagement.service.ViewManagementMarshallerService;
import com.axelor.meta.db.MetaView;
import com.axelor.meta.schema.actions.validate.ActionValidateBuilder;
import com.axelor.meta.schema.actions.validate.validator.ValidatorType;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Request;
import com.axelor.rpc.Response;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Map;

@Path("/viewmanagement")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ViewManagementController{
    private static final Logger LOG = LoggerFactory.getLogger(ViewManagementController.class);

    @Inject
    private ViewManagementFindViewService viewManagementFindViewService;

    @Inject
    private ViewManagementMarshallerService viewManagementMarshallerService;
    @POST
    @Path("/home")
    public Response getView(Request request) {
        LOG.debug("Get view method started");
        Map<String, Object> data = Maps.newHashMap();

        final String model = request.getModel();
        final String name = (String) request.getData().get("name");
        final String type = (String) request.getData().get("type");

        final String xmlString = viewManagementFindViewService.getViewXml(name, type, model);

        if(xmlString == null){
            LOG.debug("getView method. Requested view have not been found");
            data.put("view", null);
        }else {
            final AbstractView view;
            try {
                LOG.debug("getView method. Starting an attempt to unmarshall the given form's xml");
                ObjectViews objectView = viewManagementMarshallerService.unmarshal(xmlString);

                if(objectView == null) {
                    LOG.debug("getView method. Could not unmarshall xml. Reason: Xml config data hove not been found");
                    data.put("view", null);
                } else{
                    LOG.debug("getView method. Unmarshalling finished successfully. Casting objectView to AbstractView");
                    view = (AbstractView) objectView.getFormOrGridOrTree().get(0);
                    data.put("view", view);
                }

            } catch (JAXBException e) {
                String message = null;
                if(e.getCause() == null){
                    message = e.getLocalizedMessage();
                }else{
                    message = e.getCause().getLocalizedMessage();
                }
                LOG.debug("getView method. RuntimeException raised while unmarshalling given data. Message is: "+message);
                data.put("view", null);
            } catch (IOException e) {
                String message = null;
                if(e.getCause() == null){
                    message = e.getLocalizedMessage();
                }else{
                    message = e.getCause().getLocalizedMessage();
                }
                LOG.debug("getView method. IOException raised while unmarshalling given data. Message is: "+message);
                data.put("view", null);
            }
        }

        Response response = new Response();
        response.setData(data);
        response.setStatus(Response.STATUS_SUCCESS);
        return response;
    }

    public void validateView(ActionRequest request, ActionResponse response){
        LOG.debug("Validate view method started");
        Map<String, Object> data = Maps.newHashMap();
        MetaView metaView = request.getContext().asType(MetaView.class);
        String xmlString = metaView.getXml();

        AbstractView view = null;
        try {
            LOG.debug("validateView method. Starting an attempt to unmarshall the given form's xml");
            ObjectViews objectView = viewManagementMarshallerService.unmarshal(xmlString);

            if(objectView == null) {
                LOG.debug("validateView method. Could not unmarshall xml. Reason: Xml config data hove not been found");
                data.put("view", null);
            } else{
                LOG.debug("validateView method. Unmarshalling finished successfully. Casting objectView to AbstractView");
                view = (AbstractView) objectView.getFormOrGridOrTree().get(0); // this string is needed in case if casting the type will not work properly
                //data.put("view", view);
            }

        }catch (Exception e) {
            String message = null;
            if(e.getCause() == null){
                message = e.getLocalizedMessage();
            }else{
                message = e.getCause().getLocalizedMessage();
            }
            ActionValidateBuilder validateBuilder =
                    new ActionValidateBuilder(ValidatorType.ERROR).setMessage(message);
            data.putAll(validateBuilder.build());
            LOG.debug("validateView method. Error validating the given xml. Message: "+message);
        }

        response.setData(ImmutableList.of(data));
    }
}