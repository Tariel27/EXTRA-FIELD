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

public class ImportExportController {
    private static final Logger LOG = LoggerFactory.getLogger(ImportExportController.class);

    @Inject
    private ViewManagementFindViewService viewManagementFindViewService;

    @Inject
    private ViewManagementMarshallerService viewManagementMarshallerService;

    public void exportViews(ActionRequest request, ActionResponse response){
        LOG.debug("Export views method started");
        Map<String, Object> data = Maps.newHashMap();
        String model = (String) request.getContext().get("modelName");

        if(model == null){
            LOG.debug("Export views: Model name is required. Found - null");
            ActionValidateBuilder validateBuilder =
                    new ActionValidateBuilder(ValidatorType.ERROR).setMessage("Export views: Model name is required. Found - null");
            data.putAll(validateBuilder.build());
            response.setData(ImmutableList.of(data));
            return;
        }


        response.setData(ImmutableList.of(data));
    }
}