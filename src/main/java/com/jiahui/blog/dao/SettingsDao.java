package com.jiahui.blog.dao;

import com.jiahui.blog.pojo.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SettingsDao extends JpaRepository<Settings,String>, JpaSpecificationExecutor<Settings> {
    Settings findOneByKey(String key);
}
