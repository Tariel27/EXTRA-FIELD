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
        Map<String, Object> data = Maps.newHashMap();

        final String model = request.getModel();
        final String name = (String) request.getData().get("name");
        final String type = (String) request.getData().get("type");

        final String xmlString = viewManagementFindViewService.getViewXml(name, type, model);

        if(xmlString == null){
            LOG.debug("Requested view have not been found");
            data.put("view", null);
        }else {
            final AbstractView view;
            try {
                ObjectViews objectView = viewManagementMarshallerService.unmarshal(xmlString);

                if(objectView == null) {
                    LOG.debug("Xml config data hove not been found");
                    data.put("view", null);
                } else{
                    view = (AbstractView) objectView.getFormOrGridOrTree().get(0);
                    data.put("view", view);
                }

            } catch (JAXBException e) {
                LOG.debug("RuntimeException raised while unmarshalling given data. Message is: "+e.getMessage());
                data.put("view", null);
            } catch (IOException e) {
                LOG.debug("IOException raised while unmarshalling given data. Message is: "+e.getMessage());
                data.put("view", null);
            }
        }

        Response response = new Response();
        response.setData(data);
        response.setStatus(Response.STATUS_SUCCESS);
        return response;
    }

    public void validateView(ActionRequest request, ActionResponse response){
        Map<String, Object> data = Maps.newHashMap();
        MetaView metaView = request.getContext().asType(MetaView.class);
        String xmlString = metaView.getXml();

        AbstractView view = null;
        try {
            ObjectViews objectView = viewManagementMarshallerService.unmarshal(xmlString);

            if(objectView == null) {
                LOG.debug("Xml config data hove not been found");
                data.put("view", null);
            } else{
                view = (AbstractView) objectView.getFormOrGridOrTree().get(0); // this string is needed in case if casting the type will not work properly
                //data.put("view", view);
            }

        }catch (Exception e) {
            ActionValidateBuilder validateBuilder =
                    new ActionValidateBuilder(ValidatorType.ERROR).setMessage(e.getCause().getLocalizedMessage());
            data.putAll(validateBuilder.build());
        }

        response.setData(ImmutableList.of(data));
    }
}