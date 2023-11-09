package com.axelor.apps.viewmanagement.service.impl;

import com.axelor.apps.viewmanagement.db.ViewManagementBackup;
import com.axelor.apps.viewmanagement.db.repo.ViewManagementBackupRepository;
import com.axelor.apps.viewmanagement.service.ViewManagementCreateBackupService;
import com.axelor.apps.viewmanagement.service.ViewManagementFindViewService;
import com.axelor.apps.viewmanagement.web.ImportExportController;
import com.axelor.inject.Beans;
import com.axelor.meta.db.MetaView;
import com.axelor.meta.db.repo.MetaViewRepository;
import com.google.common.base.Joiner;
import com.google.inject.persist.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ViewManagementCreateBackupServiceImpl implements ViewManagementCreateBackupService {
    private static final Logger LOG = LoggerFactory.getLogger(ViewManagementCreateBackupServiceImpl.class);
    @Override
    @Transactional(rollbackOn = {Exception.class})
    public ViewManagementBackup create(ViewManagementBackup viewManagementBackup){
        final ViewManagementBackupRepository backupRepository = Beans.get(ViewManagementBackupRepository.class);

        try{
            backupRepository.persist(viewManagementBackup);
        }catch (Exception e){
            LOG.debug("Could not persist backup. Message: " + e.getMessage());
            return null;
        }


        return viewManagementBackup;
    }

}
