package com.axelor.apps.viewmanagement.service.impl;

import com.axelor.apps.viewmanagement.db.ConfigData;
import com.axelor.apps.viewmanagement.db.repo.ConfigDataRepository;
import com.axelor.apps.viewmanagement.objectviews.ObjectViews;
import com.axelor.apps.viewmanagement.service.ViewManagementMarshallerService;
import com.axelor.inject.Beans;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.StringReader;

public class ViewManagementMarshallerServiceImpl implements ViewManagementMarshallerService {

    public ObjectViews unmarshal(String xmlString) throws JAXBException, IOException {
        final ConfigDataRepository configDataRepository = Beans.get(ConfigDataRepository.class);
        ConfigData configData = configDataRepository.findByName("default-xml-config");

        if(configData == null) return null;

        String headerFooter[] = configData.getValue().split("---");

        String resultXML = headerFooter[0] + xmlString + headerFooter[1];

        JAXBContext context = JAXBContext.newInstance(ObjectViews.class);
        StringReader reader = new StringReader(resultXML);
        return (ObjectViews) context.createUnmarshaller()
                .unmarshal(reader);
    }
}
