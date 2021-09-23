package com.jiahui.blog.mapper;

import com.jiahui.blog.pojo.PolicyFile;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface PolicyFileMapper {
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

    int batchInsert(@Param("list") List<PolicyFile> list);
}