package com.olympicFamily.olympicFamily.BackEnd.Admin.setting;

import com.olympicFamily.olympicFamily.Common.Entity.Setting;
import com.olympicFamily.olympicFamily.Common.Entity.SettingCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SettingRepository extends CrudRepository<Setting, String> {

    public List<Setting> findByCategory(SettingCategory category);
}
