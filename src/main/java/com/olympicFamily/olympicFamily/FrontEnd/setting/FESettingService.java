package com.olympicFamily.olympicFamily.FrontEnd.setting;

import java.util.List;

import com.olympicFamily.olympicFamily.Common.Entity.Setting;
import com.olympicFamily.olympicFamily.Common.Entity.SettingCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FESettingService {
    @Autowired
    private FESettingRepository repo;


    public List<Setting> getGeneralSettings() {
        return repo.findByTwoCategories(SettingCategory.GENERAL, SettingCategory.CURRENCY);
    }

}
