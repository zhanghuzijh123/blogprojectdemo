package com.jiahui.blog.services.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.jiahui.blog.pojo.ReservoirPolicy;
import com.jiahui.blog.mapper.ReservoirPolicyMapper;
import com.jiahui.blog.services.ReservoirPolicyService;
@Service
public class ReservoirPolicyServiceImpl implements ReservoirPolicyService{

    @Resource
    private ReservoirPolicyMapper reservoirPolicyMapper;

    @Override
    public int deleteByPrimaryKey(Long policyId) {
        return reservoirPolicyMapper.deleteByPrimaryKey(policyId);
    }

    @Override
    public int insert(ReservoirPolicy record) {
        return reservoirPolicyMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(ReservoirPolicy record) {
        return reservoirPolicyMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(ReservoirPolicy record) {
        return reservoirPolicyMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(ReservoirPolicy record) {
        return reservoirPolicyMapper.insertSelective(record);
    }

    @Override
    public ReservoirPolicy selectByPrimaryKey(Long policyId) {
        return reservoirPolicyMapper.selectByPrimaryKey(policyId);
    }

    @Override
    public int updateByPrimaryKeySelective(ReservoirPolicy record) {
        return reservoirPolicyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ReservoirPolicy record) {
        return reservoirPolicyMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<ReservoirPolicy> list) {
        return reservoirPolicyMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<ReservoirPolicy> list) {
        return reservoirPolicyMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<ReservoirPolicy> list) {
        return reservoirPolicyMapper.batchInsert(list);
    }

}
