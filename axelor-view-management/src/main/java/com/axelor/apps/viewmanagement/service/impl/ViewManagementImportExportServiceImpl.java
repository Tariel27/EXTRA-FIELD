package com.axelor.apps.viewmanagement.service.impl;

import com.axelor.apps.viewmanagement.service.ViewManagementImportExportService;
import com.axelor.inject.Beans;
import com.axelor.meta.MetaFiles;
import com.axelor.meta.db.MetaFile;
import com.axelor.meta.db.MetaView;
import com.axelor.meta.db.repo.MetaFileRepository;
import com.axelor.meta.db.repo.MetaViewRepository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewManagementImportExportServiceImpl implements ViewManagementImportExportService {
    private final String SEPARATOR = ",";
    private final String ENDLINE = "\n";

    public MetaFile exportViews(String module) {
        List<MetaView> metaViewList = getModelViews(module);

        if(metaViewList == null || metaViewList.isEmpty()){
            return null;
        }

        MetaFile createdFile = createCSVFile(metaViewList, module);

        if(createdFile == null) {
            return null;
        }
        return createdFile;
    }

    private List<MetaView> getModelViews(String module){
        List<MetaView> metaViewList = new ArrayList<>();

        MetaViewRepository metaViewRepository = Beans.get(MetaViewRepository.class);
        metaViewList = metaViewRepository.findByModule(module).fetch();

        return metaViewList;
    }

    private MetaFile createCSVFile(List<MetaView> metaViewList, String module){
        String content = "";
        for (MetaView view:
             metaViewList) {
            content += "\"" + view.getName() + "\"" + SEPARATOR +
                    "\"" + view.getTitle() + "\"" + SEPARATOR +
                    "\"" + view.getType() + "\"" + SEPARATOR +
                    "\"" + view.getModel() + "\"" + SEPARATOR +
                    "\"" + view.getModule() + "\"" + SEPARATOR +
                    "\"" + view.getXml() + "\"" + ENDLINE;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date currentDate = new Date();

        String formattedDate = dateFormat.format(currentDate);

        String fileName = formattedDate+"-" + module + ".csv";

        File csvFile = new File(fileName);

        FileWriter fileWriter = null;

        MetaFile metaFile = null;
        try {
            fileWriter = new FileWriter(csvFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(content);
            bufferedWriter.close();
            fileWriter.close();

            MetaFiles metaFiles = Beans.get(MetaFiles.class);

            metaFile = metaFiles.upload(csvFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return metaFile;
    }
}
