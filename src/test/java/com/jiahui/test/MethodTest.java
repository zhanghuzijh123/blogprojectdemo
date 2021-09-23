package com.jiahui.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiahui.blog.config.RedisTemplateConfig;
import com.jiahui.blog.mapper.AppUserMapper;
import com.jiahui.blog.pojo.AppUser;
import com.jiahui.blog.pojo.IPInfor;
import com.jiahui.blog.utils.MapUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Slf4j
@SpringBootTest
public class MethodTest {

    @Test
    public void test() {
        List<String> stringList = new ArrayList<>();
        Boolean status = stringList == null;
        System.out.println(status);
        status = stringList.isEmpty();
        System.out.println(status);
    }

    @Test
    public void readTxt() {
        try {
            StringBuffer buffer = new StringBuffer();
            BufferedReader bf = new BufferedReader(new FileReader("E:\\waterData.txt"));
            String s = null;
            while ((s = bf.readLine()) != null) {//使用readLine方法，一次读一行
                buffer.append(s.trim());
            }
            String xml = buffer.toString();
            JSONArray jsonArray = JSONArray.parseArray(xml);
            for (Object object : jsonArray) {
                Map<String,String> map = JSONObject.parseObject(JSONObject.toJSONString(object), Map.class);
                for (String key : map.keySet()) {
                    if ("JsonStr".equalsIgnoreCase(key)) {
                        System.out.println(key);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("文本读取失败");
        }
    }

    @Test
    public void optionalTest() {
        List<Integer> integerList = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88);
        List<Integer> integerList1 = new ArrayList<>();
        Optional<Integer> first = integerList.stream().findFirst();
        Optional<Integer> first1 = integerList1.stream().findFirst();
//        Optional<Optional<Integer>> integer = Optional.ofNullable(first1);
        System.out.println(first1.isPresent());
        Supplier<Integer> supplier = () -> new Random().nextInt();
        Integer asdasd = first1.orElseGet(supplier);
//        System.out.println(integer.get());
        System.out.println(1111);
    }
    @Resource
    private AppUserMapper appUserMapper;

    @Test
    public void test1111(){
        List<AppUser> appUserList = new ArrayList<>();
        AppUser appUser = new AppUser();
        appUser.setId(1L);
        appUser.setName("测试");
        appUser.setAge(22);
        appUser.setCreateTime(new Date());
        appUser.setUserValue(BigDecimal.ZERO);
        AppUser appUser1 = new AppUser();
        appUser1.setId(2L);
        appUser1.setName("测试2");
        appUser1.setAge(33);
        appUser1.setCreateTime(new Date());
        appUser1.setUserValue(BigDecimal.valueOf(0.0000));
        appUserList.add(appUser);
        appUserList.add(appUser1);
        AppUser appUser2 = new AppUser();
        appUser2.setId(3L);
        appUser2.setName("测试33");
        appUser2.setAge(44);
        appUser2.setCreateTime(new Date());
        appUser2.setUserValue(BigDecimal.valueOf(1000));
        appUserList.add(appUser2);
        appUserMapper.updateBatchSelective(appUserList);
//        Map<Long, String> collect = appUserList.stream().collect(Collectors.toMap(AppUser::getId, AppUser::getName, (oldValue, newValue) -> newValue));
//        Map<Long, List<Integer>> collect1 = appUserList.stream().collect(Collectors.toMap(AppUser::getId,
//                v -> Lists.newArrayList(v.getAge()), (List<Integer> oldAge, List<Integer> newAge) -> {
//            oldAge.addAll(newAge);
//            return oldAge;
//        }));
        System.out.println(11111);
    }

    @Test
    public void cmdTest(){
        try {
//            CmdUtil cmdUtil = new CmdUtil();
//            String commands[] = {"cmd","/c","ffmpeg -version"};
//            cmdUtil.executeCMDconsole(commands);
//            cmdUtil.executeCMDconsole("cmd /c ffmpeg -version");
//            cmdUtil.executeCMDconsole("ipconfig");
//            cmdUtil.executeCMDfile(commands, "D:/adb.logs", "C:/Users/wb-cjz286752");
//            String cmd[] = new String[]{"cmd","/c","ffmpeg -version"};
            String cmd = "cmd /c ffmpeg -version";
            String commands[] = {"path=D:\\ffmpeg-2021-09-05-git-a947098558-full_build\\bin"};
            Process p = Runtime.getRuntime().exec(cmd,commands);
            System.out.println(":::::::::::::::::::开始在控制台打印日志::::::::::::::::::::::>>>>>>");
            BufferedReader bReader = new BufferedReader(new InputStreamReader(p.getInputStream(), "gbk"));
            String line = null;
            StringBuffer b=new StringBuffer();
            while ((line = bReader.readLine()) != null){
                b.append(line+"\n");
            }
            System.out.println(b.toString());
        }catch (Exception e){
            System.out.println("11111111111");
        }
    }

    @Test
    public void dateTest(){
        Date date = new Date();
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, -2);
        System.out.println(calendar.getTime());
    }

    @Test
    public void mapTest() {
        RestTemplate restTemplate = new RestTemplate();
        String url = MapUtils.MAP_URL + "?ak=" + MapUtils.USER_AK + "&coor=" + MapUtils.COOR;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        JSONObject.parseObject(forEntity.getBody(), IPInfor.class);
        System.out.println(11111111);
    }
}

