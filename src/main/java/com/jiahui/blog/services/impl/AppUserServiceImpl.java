package com.jiahui.blog.services.impl;

import com.jiahui.blog.exception.DefaultException;
import com.jiahui.blog.req.AppUserInsertOrUpdateReq;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import com.jiahui.blog.pojo.AppUser;
import com.jiahui.blog.mapper.AppUserMapper;
import com.jiahui.blog.services.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Resource
    private AppUserMapper appUserMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return appUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AppUser record) {
        return appUserMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(AppUser record) {
        return appUserMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(AppUser record) {
        return appUserMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(AppUser record) {
        return appUserMapper.insertSelective(record);
    }

    @Override
    public AppUser selectByPrimaryKey(Long id) {
        return appUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AppUser record) {
        return appUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AppUser record) {
        return appUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<AppUser> list) {
        return appUserMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<AppUser> list) {
        return appUserMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<AppUser> list) {
        return appUserMapper.batchInsert(list);
    }

    @Override
    public int getAppUserMethod(AppUserInsertOrUpdateReq req) {
        if (req.getIds().isEmpty()) {
            throw new DefaultException("没有选中需要修改的用户");
        }
        long time = new Date().getTime();
        List<AppUser> appUsers = appUserMapper.selectAllByIds(req.getIds());
        long time1 = new Date().getTime();
        if (appUsers.size() != req.getIds().size()) {
            throw new DefaultException("选中用户与需要修改用户数量不等!");
        }
        appUsers.stream().forEach(i -> {
            i.setUpdateTime(new Date());
            i.setIsDelete(1);
        });
        System.out.println("-------------------");
        System.out.println(time1 - time);
        return appUserMapper.updateBatchSelective(appUsers);
    }
}


