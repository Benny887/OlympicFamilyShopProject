package com.olympicFamily.olympicFamily.FrontEnd.setting;

import java.util.List;

import com.olympicFamily.olympicFamily.Common.Entity.Setting;
import com.olympicFamily.olympicFamily.Common.Entity.SettingCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface FESettingRepository extends CrudRepository<Setting, String> {
    List<Setting> findByCategory(SettingCategory category);

    @Query("SELECT s FROM Setting s WHERE s.category = ?1 OR s.category = ?2")
    List<Setting> findByTwoCategories(SettingCategory catOne, SettingCategory catTwo);
}
