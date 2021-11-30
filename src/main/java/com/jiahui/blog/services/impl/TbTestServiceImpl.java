package com.jiahui.blog.services.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiahui.blog.bo.*;
import com.jiahui.blog.config.RedisTemplateConfig;
import com.jiahui.blog.mapper.TbTestMapper;
import com.jiahui.blog.config.BlogConfig;
import com.jiahui.blog.pojo.ObjectText;
import com.jiahui.blog.pojo.ResponseObject;
import com.jiahui.blog.pojo.TbTest;
import com.jiahui.blog.services.TbTestService;
import com.jiahui.blog.utils.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Service
@Slf4j
public class TbTestServiceImpl implements TbTestService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private TbTestMapper tbTestMapper;

    @Autowired
    private BlogConfig blogConfig;

    @Resource
    private RedisTemplateConfig redisTemplateConfig;

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

    public int testRedis() {
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
//            valueOperations.set("testKey03","123456789");
            String testKey03 = valueOperations.get("testKey03").toString();
            System.out.println(testKey03);
            HashOperations hashOps = redisTemplate.opsForHash();
            hashOps.put("testHash", "hash00", "000");
            hashOps.put("testHash", "hash01", "001");
            hashOps.put("testHash", "hash02", "002");
            hashOps.put("testHash", "hash03", "003");
            return 1;
        } catch (Exception e) {
            log.error("redis储存失败!");
            return 0;
        }
    }

    public int testRedisTemplateSaveString() {
        try {
            //1、通过redisTemplate设置值
            redisTemplate.boundValueOps("StringKey001").set("StringValue001");
            redisTemplate.boundValueOps("StringKey002").set("StringValue002", 1, TimeUnit.MINUTES);

            //2、通过BoundValueOperations设置值
            BoundValueOperations stringKey = redisTemplate.boundValueOps("StringKey003");
            //stringKey.set("StringValue003");
            stringKey.set("StringValue003", 1, TimeUnit.MINUTES);

            //3、通过ValueOperations设置值
            ValueOperations ops = redisTemplate.opsForValue();
            ops.set("StringKey004", "StringValue004");
            ops.set("StringValue005", "StringValue005", 1, TimeUnit.MINUTES);

            return 1;
        } catch (Exception e) {
            log.error("redisTemplate缓存string类型失败!");
            return 0;
        }
    }


    public String getRedisTemplateStringValue() {
        try {
            //1、通过redisTemplate设置值
            String str1 = (String) redisTemplate.boundValueOps("StringKey001").get();

            //2、通过BoundValueOperations获取值
            BoundValueOperations stringKey = redisTemplate.boundValueOps("StringKey003");
            String str2 = (String) stringKey.get();

            //3、通过ValueOperations获取值
            ValueOperations ops = redisTemplate.opsForValue();
            String str3 = (String) ops.get("StringKey004");
            return "通过redisTemplate设置值:" + str1 + ";通过BoundValueOperations获取值:" + str2 + ";通过ValueOperations获取值" + str3;
        } catch (Exception e) {
            log.error("redisTemplate获取string类型失败");
            return null;
        }
    }

    public int test() {
        try {
            Map<Integer, String> map = new HashMap<>();
            map.put(1, "value 1");
            map.put(2, "value 2");
            map.put(3, "value 3");
            List<Integer> list = new ArrayList<>();
            list.add(2);
            list.add(3);
            map.keySet().removeIf(k -> list.contains(k));
            System.out.println(map);

            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list1.add(2);
            list1.add(3);
            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            list2.add(2);
            boolean contains = list1.containsAll(list2);
            System.out.println(contains);
            list1.retainAll(list2);
            System.out.println(list1);
            List<Integer> collect = list2.stream().limit(3).collect(Collectors.toList());
            System.out.println(collect);

            List<String> str1 = new ArrayList<>();
            str1.add("39");
            BigDecimal bigDecimal = new BigDecimal(39);
            boolean contains1 = str1.contains(bigDecimal.toPlainString());

            List<ObjectText> objectTextList = new ArrayList<>();
            ObjectText object = new ObjectText();
            object.setTId(1L);
            object.setTName("1111");
            objectTextList.add(object);
            ObjectText objectText = new ObjectText();
            objectText.setTName("2222");
            objectTextList.add(objectText);
            Map<Long, List<ObjectText>> mapMerge = new HashMap<>();
            for (ObjectText text : objectTextList) {
                mapMerge.merge(text.getTId(), new ArrayList<ObjectText>() {{
                    add(text);
                }}, (oldValue, newValue) -> {
                    oldValue.addAll(newValue);
                    return oldValue;
                });
            }
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int testDate() throws Exception {
        try {
            Date nowDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
            String startTime = "04-15";
            String endTime = "10-15";
            nowDate = sdf.parse(sdf.format(nowDate));
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);
            boolean effectiveDate = DateTimeUtil.isEffectiveDate(nowDate, startDate, endDate);
            System.out.println(effectiveDate);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int isEmptyTest() {
        long start1 = System.currentTimeMillis();
        long sum = LongStream.range(0L, 10000000000L).parallel().sum();
        System.out.println(System.currentTimeMillis() - start1);
        long start2 = System.currentTimeMillis();
        long sum1 = LongStream.range(0L, 10000000000L).sum();
        System.out.println(System.currentTimeMillis() - start2);
        long start3 = System.currentTimeMillis();
        long sum2 = LongStream.range(0L, 10000000000L).parallel().reduce(Long::sum).getAsLong();
        System.out.println(System.currentTimeMillis() - start3);
        long start4 = System.currentTimeMillis();
        long sum3 = LongStream.range(0L, 10000000000L).reduce(Long::sum).getAsLong();
        System.out.println(System.currentTimeMillis() - start4);
        return 0;
    }

    public int testRestTemplate(Long tId){
        String kjcBootUrl = blogConfig.getKjcBoot();
        RestTemplate restTemplate = new RestTemplate();
        ResponseObject forObject = restTemplate.getForObject(kjcBootUrl + "/reach/info?id={id}", ResponseObject.class, tId);
        System.out.println(kjcBootUrl);
        return 1;
    }
}


