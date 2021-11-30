package com.jiahui.blog.services;

import java.util.List;
import com.jiahui.blog.pojo.AppUser;
import com.jiahui.blog.req.AppUserInsertOrUpdateReq;

public interface AppUserService {


    int deleteByPrimaryKey(Long id);

    int insert(AppUser record);

    int insertOrUpdate(AppUser record);

    int insertOrUpdateSelective(AppUser record);

    int insertSelective(AppUser record);

    AppUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppUser record);

    int updateByPrimaryKey(AppUser record);

    int updateBatch(List<AppUser> list);

    int updateBatchSelective(List<AppUser> list);

    int batchInsert(List<AppUser> list);

    int getAppUserMethod(AppUserInsertOrUpdateReq req);
}


