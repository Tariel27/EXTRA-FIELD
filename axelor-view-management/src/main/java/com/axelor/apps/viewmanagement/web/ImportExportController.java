package com.axelor.apps.viewmanagement.web;

import com.axelor.apps.viewmanagement.db.ViewManagementBackup;
import com.axelor.apps.viewmanagement.objectviews.AbstractView;
import com.axelor.apps.viewmanagement.objectviews.ObjectViews;
import com.axelor.apps.viewmanagement.service.ViewManagementCreateBackupService;
import com.axelor.apps.viewmanagement.service.ViewManagementFindViewService;
import com.axelor.apps.viewmanagement.service.ViewManagementImportExportService;
import com.axelor.apps.viewmanagement.service.ViewManagementMarshallerService;
import com.axelor.meta.db.MetaFile;
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
    private ViewManagementImportExportService viewManagementImportExportService;

    @Inject
    private ViewManagementCreateBackupService viewManagementCreateBackupService;

    public void exportViews(ActionRequest request, ActionResponse response){
        LOG.debug("Export views method started");
        Map<String, Object> data = Maps.newHashMap();
        if(!request.getContext().containsKey("moduleName")){
            LOG.debug("Export views: module name not found");
            ActionValidateBuilder validateBuilder =
                    new ActionValidateBuilder(ValidatorType.ERROR).setMessage("Export views:  module name not found");
            data.putAll(validateBuilder.build());
            response.setData(ImmutableList.of(data));
            return;
        }

        String module = (String) request.getContext().get("moduleName");
        if(module == null || module.isEmpty()){
            LOG.debug("Export views: Module name is required. Found - null");
            ActionValidateBuilder validateBuilder =
                    new ActionValidateBuilder(ValidatorType.ERROR).setMessage("Export views: Module name is required. Found - null");
            data.putAll(validateBuilder.build());
            response.setData(ImmutableList.of(data));
            return;
        }

        ViewManagementBackup backup = new ViewManagementBackup();
        backup.setModuleName(module);

        LOG.debug("Export views: export started");
        MetaFile createdFile = viewManagementImportExportService.exportViews(module);

        if (createdFile == null){
            LOG.debug("Export views: Views not found or could not create backup file");
            ActionValidateBuilder validateBuilder =
                    new ActionValidateBuilder(ValidatorType.ERROR).setMessage("Export views: Views not found or could not create backup file");
            data.putAll(validateBuilder.build());
            response.setData(ImmutableList.of(data));
            return;
        }

        backup.setBackupMetaFile(createdFile);

        LOG.debug("Export views: persisting backup entity");
        if(viewManagementCreateBackupService.create(backup) == null){
            LOG.debug("Export views: Could not persist backup");
            ActionValidateBuilder validateBuilder =
                    new ActionValidateBuilder(ValidatorType.ERROR).setMessage("Export views: Could not persist backup");
            data.putAll(validateBuilder.build());
            response.setData(ImmutableList.of(data));
            return;
        }

        LOG.debug("Export views: persisting backup entity finished successfully!");
        ActionValidateBuilder validateBuilder =
                new ActionValidateBuilder(ValidatorType.INFO).setMessage("Export views: Backup file created successfully!");
        data.putAll(validateBuilder.build());
        response.setData(ImmutableList.of(data));
        response.setAlert("Backup file created successfully!", "Success!");
        response.setCanClose(true);
    }
}