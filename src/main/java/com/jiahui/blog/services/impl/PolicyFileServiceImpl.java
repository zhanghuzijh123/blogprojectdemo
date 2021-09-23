package com.jiahui.blog.services.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.jiahui.blog.mapper.PolicyFileMapper;
import com.jiahui.blog.pojo.PolicyFile;
import com.jiahui.blog.services.PolicyFileService;
@Service
public class PolicyFileServiceImpl implements PolicyFileService{

    @Resource
    private PolicyFileMapper policyFileMapper;

    @Override
    public int deleteByPrimaryKey(Long fileId) {
        return policyFileMapper.deleteByPrimaryKey(fileId);
    }

    @Override
    public int insert(PolicyFile record) {
        return policyFileMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(PolicyFile record) {
        return policyFileMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(PolicyFile record) {
        return policyFileMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(PolicyFile record) {
        return policyFileMapper.insertSelective(record);
    }

    @Override
    public PolicyFile selectByPrimaryKey(Long fileId) {
        return policyFileMapper.selectByPrimaryKey(fileId);
    }

    @Override
    public int updateByPrimaryKeySelective(PolicyFile record) {
        return policyFileMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PolicyFile record) {
        return policyFileMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<PolicyFile> list) {
        return policyFileMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<PolicyFile> list) {
        return policyFileMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<PolicyFile> list) {
        return policyFileMapper.batchInsert(list);
    }

}
