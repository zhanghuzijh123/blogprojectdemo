package com.jiahui.blog.mapper;

import com.jiahui.blog.pojo.AppUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * AppUserMapper
 *
 * @author Administrator
 * @date 2021/9/13 0013
 */
public interface AppUserMapper {
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

    int batchInsert(@Param("list") List<AppUser> list);

    List<AppUser> selectAllByIds(@Param("ids") List<Long> ids);
}