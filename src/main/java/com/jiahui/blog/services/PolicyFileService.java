package com.jiahui.blog.services;

import java.util.List;
import com.jiahui.blog.pojo.PolicyFile;
public interface PolicyFileService{


    int deleteByPrimaryKey(Long fileId);

    int insert(PolicyFile record);

    int insertOrUpdate(PolicyFile record);

    int insertOrUpdateSelective(PolicyFile record);

    int insertSelective(PolicyFile record);

    PolicyFile selectByPrimaryKey(Long fileId);

    int updateByPrimaryKeySelective(PolicyFile record);

    int updateByPrimaryKey(PolicyFile record);

    int updateBatch(List<PolicyFile> list);

    int updateBatchSelective(List<PolicyFile> list);

    int batchInsert(List<PolicyFile> list);

}
