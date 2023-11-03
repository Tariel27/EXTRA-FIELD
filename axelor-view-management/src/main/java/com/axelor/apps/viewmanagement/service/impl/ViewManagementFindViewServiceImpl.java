package com.axelor.apps.viewmanagement.service.impl;

import com.axelor.apps.viewmanagement.service.ViewManagementFindViewService;
import com.axelor.inject.Beans;
import com.axelor.meta.db.MetaView;
import com.axelor.meta.db.repo.MetaViewRepository;
import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

public class ViewManagementFindViewServiceImpl implements ViewManagementFindViewService {
    public String getViewXml(String name, String type, String model){
        final MetaViewRepository views = Beans.get(MetaViewRepository.class);

        MetaView view = findMetaView(views, name, type, model);

        if(view == null){
            return null;
        }

        return view.getXml();
    }

    private static MetaView findMetaView(
            MetaViewRepository views, String name, String type, String model) {
        final List<String> select = new ArrayList<>();
        if (name != null) {
            select.add("self.name = :name");
        }
        if (type != null) {
            select.add("self.type = :type");
        }
        if (model != null) {
            select.add("self.model = :model");
        }

        select.add("(self.extension is null OR self.extension = false)");
        return views
                .all()
                .filter(Joiner.on(" AND ").join(select))
                .bind("name", name)
                .bind("type", type)
                .bind("model", model)
                .cacheable()
                .order("-priority")
                .fetchOne();
    }
}
