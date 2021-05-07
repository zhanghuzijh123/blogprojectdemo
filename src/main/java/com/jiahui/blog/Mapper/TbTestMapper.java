package com.jiahui.blog.Mapper;

import com.jiahui.blog.pojo.TbTest;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbTestMapper {
    int deleteByPrimaryKey(Long testId);

    int insert(TbTest record);

    int insertOrUpdate(TbTest record);

    int insertOrUpdateSelective(TbTest record);

    int insertSelective(TbTest record);

    TbTest selectByPrimaryKey(Long testId);

    int updateByPrimaryKeySelective(TbTest record);

    int updateByPrimaryKey(TbTest record);

    int updateBatch(List<TbTest> list);

    int updateBatchSelective(List<TbTest> list);

    int batchInsert(@Param("list") List<TbTest> list);
}