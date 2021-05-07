package com.jiahui.blog.services.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiahui.blog.Mapper.TbTestMapper;
import com.jiahui.blog.bo.WaterLevelBO;
import com.jiahui.blog.pojo.TbTest;
import com.jiahui.blog.services.TbTestService;
import com.jiahui.blog.utils.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TbTestServiceImpl implements TbTestService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private TbTestMapper tbTestMapper;

    @Override
    public int deleteByPrimaryKey(Long testId) {
        return tbTestMapper.deleteByPrimaryKey(testId);
    }

    @Override
    public int insert(TbTest record) {
        return tbTestMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(TbTest record) {
        return tbTestMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(TbTest record) {
        return tbTestMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(TbTest record) {
        return tbTestMapper.insertSelective(record);
    }

    @Override
    public TbTest selectByPrimaryKey(Long testId) {
        return tbTestMapper.selectByPrimaryKey(testId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbTest record) {
        return tbTestMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbTest record) {
        return tbTestMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<TbTest> list) {
        return tbTestMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<TbTest> list) {
        return tbTestMapper.batchInsert(list);
    }

    @Override
    public int updateBatchSelective(List<TbTest> list) {
        return tbTestMapper.updateBatchSelective(list);
    }

    @Override
    public String testCalendar() throws Exception {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, 0);

        Date nowTime = new Date();
        String tDate = "2021-03-03";
        Date timeByFormat = DateTimeUtil.getTimeByFormat(tDate, 1, 2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.format(nowTime);
//        Date parse = sdf.parse(tDate);
//        sdf.parse(sdf.format(nowTime));

        return "year:" + year + "month:" + month + "date:" + date + "day:" + day;
    }

    public Integer testInputStreamToJsonObject() {
        String pathStr = "1-2-3-4-5";
        String[] split = pathStr.split("-");
        String jsonStr = "{\"code\":20000,\"message\":\"查询成功\",\"data\":[{\"realTimeWaterLevel\":4.90" +
                ",\"typhoonLevel\":23.00,\"rainyLevel\":1.00,\"testId\":1},{\"realTimeWaterLevel\":5.90" +
                ",\"typhoonLevel\":33.00,\"rainyLevel\":2.00,\"testId\":2}]}";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(jsonStr.getBytes());
        JSONObject jsonObject = new JSONObject();
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            StringBuilder respomseStrBuilder = new StringBuilder();
            String inputStr = "";
            while ((inputStr = streamReader.readLine()) != null) {
                respomseStrBuilder.append(inputStr);
            }
            jsonObject = JSONObject.parseObject(respomseStrBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("字节流转换jsonObject失败!");
        }
//        JSONObject jsonObject = JSON.parseObject(jsonStr);
        JSONArray jsonData = jsonObject.getJSONArray("data");
        List<WaterLevelBO> waterLevelBOS = jsonData.toJavaList(WaterLevelBO.class);
//        List<BigDecimal> realTimeWaterLevel = waterLevelBOS.stream().map(WaterLevelBO::getRealTimeWaterLevel).collect(Collectors.toList());
        long time = new Date().getTime();
        List<BigDecimal> realTimeWaterLevel = waterLevelBOS.stream().filter(i -> i.getRealTimeWaterLevel() != null)
                .sorted(Comparator.comparing(WaterLevelBO::getRealTimeWaterLevel).reversed())
                .map(WaterLevelBO::getRealTimeWaterLevel).collect(Collectors.toList());
        long time1 = new Date().getTime();
        System.out.println(time1 - time);
        System.out.println(realTimeWaterLevel);
        String code = jsonObject.getString("code");
        System.out.println(code);
        return 1;
    }

    public int testRedis(){
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
//            valueOperations.set("testKey03","123456789");
            String testKey03 = valueOperations.get("testKey03").toString();
            System.out.println(testKey03);
            HashOperations hashOps = redisTemplate.opsForHash();
            hashOps.put("testHash","hash00","000");
            hashOps.put("testHash","hash01","001");
            hashOps.put("testHash","hash02","002");
            return 1;
        }catch (Exception e){
            log.error("redis储存失败!");
            return 0;
        }
    }

}


