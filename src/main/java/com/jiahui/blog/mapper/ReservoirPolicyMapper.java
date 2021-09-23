package com.jiahui.blog.mapper;

import com.jiahui.blog.pojo.ReservoirPolicy;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface ReservoirPolicyMapper {
    int deleteByPrimaryKey(Long policyId);

    int insert(ReservoirPolicy record);

    int insertOrUpdate(ReservoirPolicy record);

    int insertOrUpdateSelective(ReservoirPolicy record);

    int insertSelective(ReservoirPolicy record);

    ReservoirPolicy selectByPrimaryKey(Long policyId);

    int updateByPrimaryKeySelective(ReservoirPolicy record);

    int updateByPrimaryKey(ReservoirPolicy record);

    int updateBatch(List<ReservoirPolicy> list);

    int updateBatchSelective(List<ReservoirPolicy> list);

    int batchInsert(@Param("list") List<ReservoirPolicy> list);
}