package com.jiahui.blog;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.jiahui.blog.exception.DefaultException;
import com.jiahui.blog.mapper.AppUserMapper;
import com.jiahui.blog.pojo.AppUser;
import com.jiahui.blog.pojo.Civilization;
import com.jiahui.blog.pojo.IPInfor;
import com.jiahui.blog.pojo.bo.StreamBO;
import com.jiahui.blog.pojo.thread.MyRunnable;
import com.jiahui.blog.services.impl.CivilizationServiceImpl;
import com.jiahui.blog.pojo.thread.MyThread;
import com.jiahui.blog.utils.CommonUtil;
import com.jiahui.blog.utils.MapUtils;
import com.jiahui.blog.utils.QRCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringRunner.class)
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
//        appUserMapper.updateBatchSelective(appUserList);
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
            System.out.println(":::::::::::::::::::开始在控制台打印日志::::::::::::::::::::::");
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
        System.out.println("localDate---------------------");
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusWeeks(1);
        System.out.println(localDate);
        LocalDate plus = now.plus(1, ChronoUnit.YEARS);
        System.out.println(plus);
        System.out.println("localDateTime---------------------");
        LocalDateTime localDateTime = LocalDateTime.now();
    }

    @Test
    public void mapTest() {
        RestTemplate restTemplate = new RestTemplate();
        String url = MapUtils.MAP_URL + "?ak=" + MapUtils.USER_AK + "&coor=" + MapUtils.COOR;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        IPInfor ipInfor = JSONObject.parseObject(forEntity.getBody(), IPInfor.class);
        System.out.println(11111111);
    }

    @Test
    public void weatherTest(){
        //萧山对应区划编号330109
        MapUtils.getWeatherByAreaCode("330109");
    }

    @Test
    public void zxingCodeTest() throws Exception{
        String imageUrl = "C:\\Users\\Administrator\\Desktop\\image\\11.png";
        String zxingContent = "二维码测试";
        String implantContent = "C:\\Users\\Administrator\\Desktop\\image\\rain.png";
        try {
            //生成二维码
            BufferedImage encode = QRCodeUtil.encode(zxingContent, implantContent, true);
            //将二维码BufferedImage类转成base64
            String baseCode = CommonUtil.bufferedImageToBase64(encode);
            System.out.println(baseCode);
            //二维码存在指定路径
            QRCodeUtil.encode(zxingContent,implantContent,imageUrl,true);
        }catch (Exception e){
            log.error("-----------------"+e);
        }
    }

    @Resource
    private CivilizationServiceImpl civilizationService;

    @Test
    public void playForCountry() {
        Civilization civilization = new Civilization();
        try {
            do {
                System.out.println("start------------"+"\n"+civilization);
                Scanner sc = new Scanner(System.in);
                System.out.println("---------------------");
                int read = sc.nextInt();
                if (civilization.getBarbarians() > 0) {
                    int i = Math.toIntExact(Math.round(Math.random() * 100));
                    Integer defence = civilizationService.attackMySelf(i, civilization);
                    if (defence <= 0) {
                        System.out.println("over");
                        break;
                    }
                    civilization.setDefence(defence);
                }
                if (read == 0) {
                    civilizationService.attackBarbarians(civilization);
                    System.out.println("attack");
                } else if (read == 1) {
                    civilizationService.exploreEvent(civilization);
                    System.out.println("explore");
                } else if (read == 2) {
                    civilizationService.productAttack(civilization);
                    System.out.println("product");
                } else {
                    log.error("error");
                }
                civilization.setFood(civilization.getFood() + 10 + civilization.getCampsite() * 5 + civilization.getCropper() * 10);
                civilization.setPerson(civilizationService.getCivilizationFood(civilization));
                System.out.println("end------------"+"\n"+civilization);
            } while (civilization.getDefence() > 0);
        } catch (Exception e) {
            log.error("入参有误!" + e);
            throw new DefaultException(e);
        }
    }

    @Test
    public void streamTest() {
        List<StreamBO> streamList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StreamBO stream = new StreamBO();
            stream.setStreamId(Long.valueOf(i));
            stream.setStreamName("stream" + i);
            stream.setCreateTime(new Date());
            stream.setStreamValue(BigDecimal.valueOf(i));
            streamList.add(stream);
        }
//        Stream.iterate(2, i -> i * 3).limit(10).forEach(System.out::println);
        List<Integer> collect = Stream.iterate(2, i -> i * 3).limit(10).collect(Collectors.toList());
        System.out.println(collect);
        List<Double> collect1 = Stream.generate(Math::random).limit(10).collect(Collectors.toList());
        System.out.println(collect1);
        List<StreamBO> boList = streamList.stream().filter(i -> i.getStreamValue().compareTo(BigDecimal.ZERO) > 0)
                .skip(0).limit(2).collect(Collectors.toList());
        System.out.println(boList);
//        streamList.stream().collect(Collectors.toMap())
        Optional<Long> first = streamList.stream().filter(i -> i.getStreamName() != null)
                .sorted(Comparator.comparing(StreamBO::getCreateTime).reversed())
                .map(StreamBO::getStreamId).findFirst();
        first.ifPresent(System.out::println);

        Map<Long, String> collect2 = streamList.stream()
                .collect(Collectors.toMap(StreamBO::getStreamId, StreamBO::getStreamName, (oldValue, newValue) -> newValue));

        Map<String, StreamBO> collect3 = streamList.stream().collect(Collectors.toMap(k -> String.format(k.getStreamId() + k.getStreamName()), v -> v));

        List<BigDecimal> collect4 = streamList.stream().sorted(Comparator.comparing(StreamBO::getStreamValue).reversed()    )
                .map(StreamBO::getStreamValue).collect(Collectors.toList());
        System.out.println("--------------------------------");
        Map<Long, List<BigDecimal>> collect5 = streamList.stream().collect(Collectors.toMap(StreamBO::getStreamId, list ->
                Lists.newArrayList(list.getStreamValue()), (List<BigDecimal> newList, List<BigDecimal> oldList) -> {
            oldList.addAll(newList);
            return oldList;
        }));
        System.out.println("----------------------");
    }

    @Test
    public void pwdTest(){
        Long userId = 123L;
        long time = System.currentTimeMillis() % 100000L;
        String str = "{\"userId\":"+userId+"}"+time;
        System.out.println(str);
    }

    @Test
    public void threadTest(){
        MyThread t1 = new MyThread("aa");
        t1.run();
        MyThread t2 = new MyThread("bb");
        t2.run();

        Thread t3 = new Thread(new MyRunnable("cc"));
        t3.run();
    }
}

