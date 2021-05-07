package com.jiahui.blog.services;

import java.util.List;
import com.jiahui.blog.pojo.ReservoirPolicy;
public interface ReservoirPolicyService{


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

    int batchInsert(List<ReservoirPolicy> list);

}
