package com.jiahui.blog.services;

import com.jiahui.blog.pojo.TbTest;
import java.util.List;

public interface TbTestService {


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

    int batchInsert(List<TbTest> list);

    String testCalendar() throws Exception;

    Integer testInputStreamToJsonObject();

    int testRedis();

    int testRedisTemplateSaveString();

    String getRedisTemplateStringValue();

    int test();

    int testDate() throws Exception;

    int isEmptyTest();
}


