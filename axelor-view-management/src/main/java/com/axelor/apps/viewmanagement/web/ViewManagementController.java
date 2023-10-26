package com.axelor.apps.viewmanagement.web;

import com.axelor.meta.schema.views.AbstractView;
import com.axelor.meta.service.MetaService;
import com.axelor.rpc.Request;
import com.axelor.rpc.Response;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/viewmanagement")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ViewManagementController{
    private static final Logger LOG = LoggerFactory.getLogger(ViewManagementController.class);

    @Inject
    private MetaService service;
    @POST
    @Path("/home")
    public Response getView(Request request) {
        Map<String, Object> data = Maps.newHashMap();

        final String model = request.getModel();
        final String name = (String) request.getData().get("name");
        final String type = (String) request.getData().get("type");

        final Response response = service.findView(model, name, type);
        final AbstractView view = (AbstractView) response.getData();

        data.put("view", view);

        response.setData(data);
        response.setStatus(Response.STATUS_SUCCESS);
        return response;
    }
}