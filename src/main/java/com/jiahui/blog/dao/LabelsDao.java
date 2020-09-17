package com.jiahui.blog.dao;

import com.jiahui.blog.pojo.Labels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LabelsDao extends JpaRepository<Labels,String>, JpaSpecificationExecutor<Labels> {

    @Modifying
    int deleteOneById(String labelId);

    @Modifying
    @Query(value = "delete from `tb_labels` where id = ?",nativeQuery = true)
    int deleteLabelById(String labelId);

    Labels findOneById(String labelId);
}
