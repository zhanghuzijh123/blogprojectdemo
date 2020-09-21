package com.jiahui.blog.controller;

import com.jiahui.blog.dao.LabelsDao;
import com.jiahui.blog.pojo.Labels;
import com.jiahui.blog.pojo.User;
import com.jiahui.blog.response.ResponseResult;
import com.jiahui.blog.utils.Constants;
import com.jiahui.blog.utils.SnowflakeIdWorker;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

@Transactional
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    @Autowired
    private LabelsDao labelsDao;

    /**
     * springboot方法测试
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public ArrayList<Integer> helloHello(){
        //java8新的时间日期API
        log.info("java8新的时间日期API------------------");
        LocalDateTime dt=LocalDateTime.now();
        System.out.println(dt);
        LocalDate dt1=dt.toLocalDate();
        System.out.println(dt1);
        Month month=dt.getMonth();
        int day=dt.getDayOfMonth();
        int second=dt.getSecond();
        System.out.println(month+"月"+day+"日"+second+"秒");
        //java foreach()+lambda表达式
        log.info("java foreach()+lambda表达式------------------");
        HashMap<String,Integer> map=new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);
        map.forEach((i,j)->{
            if (i.equals("B")){
                System.out.println("Hello B"+"------------------"+j);
            }
        });
        //冒泡排序
        ArrayList<Integer> ary=new ArrayList<>();
        ary.add(0,4);
        ary.add(1,2);
        ary.add(2,5);
        ary.add(3,1);
        ary.add(4,9);
        int a=0;
        for (int i=0;i<ary.size();i++){
            for (int j=i;j<ary.size();j++){
                if (ary.get(i)<ary.get(j)){
                    a=ary.get(i);
                    ary.set(i,ary.get(j));
                    ary.set(j,a);
                }
            }
        }
        return ary;
    }

    /**
     * java8新特性Stream csdn链接:https://blog.csdn.net/y_k_y/article/details/84633001
     */
    @RequestMapping(value = "/stream",method = RequestMethod.GET)
    public void streamTest(){
        /* filter：过滤流中的某些元素
        limit(n)：获取n个元素
        skip(n)：跳过n元素，配合limit(n)可实现分页
        distinct：通过流中元素的 hashCode() 和 equals() 去除重复元素 */
        Stream<Integer> stream = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
        Stream<Integer> newStream = stream.filter(s -> s > 5) //6 6 7 9 8 10 12 14 14
                .distinct() //6 7 9 8 10 12 14
                .skip(2) //9 8 10 12 14
                .limit(2); //9 8
        newStream.forEach(System.out::println);

        List<String> list = Arrays.asList("a,b,c", "1,2,3");
        //将每个元素转成一个新的且不带逗号的元素
        Stream<String> s1 = list.stream().map(s -> s.replaceAll(",", ""));
        s1.forEach(System.out::println); // abc  123
        Stream<String> s3 = list.stream().flatMap(s -> {
            //将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        });
        s3.forEach(System.out::println); // a b c 1 2 3

    }

    @GetMapping(value = "/returnResult")
    public ResponseResult responseResult(){
        /*ResponseResult responseResult=new ResponseResult(ResponseState.SUCCESS);
        return responseResult;*/
        User user=new User();
        user.setUserName("nikoo");
        user.setPassword("111111");
        return ResponseResult.SUCCESS().setData(user);
    }

    @PostMapping("/label")
    public ResponseResult addLabels(@RequestBody Labels labels){
        labels.setId(snowflakeIdWorker.nextId()+"");
        labels.setCreateTime(new Date());
        labels.setUpdateTime(new Date());
        labelsDao.save(labels);
        return ResponseResult.SUCCESS("测试用例label添加成功");
    }

    @DeleteMapping("/label/{labelId}")
    public ResponseResult deleteLabels(@PathVariable("labelId") String labelId){
        int deleteResult=labelsDao.deleteOneById(labelId);
        log.info("deleteResult:"+deleteResult);
        if (deleteResult>0){
            return ResponseResult.SUCCESS("测试用例label删除成功");
        }else {
            return ResponseResult.FAILED("测试用例label删除失败");
        }
    }

    @PutMapping("/label/{labelId}")
    public ResponseResult updateLabels(@PathVariable("labelId") String labelId,@RequestBody Labels labels){
        Labels newLabel=labelsDao.findOneById(labelId);
        if (newLabel==null){
            return ResponseResult.FAILED("测试用例label不存在");
        }
        newLabel.setName(labels.getName());
        newLabel.setCount(labels.getCount());
        newLabel.setUpdateTime(new Date());
        labelsDao.save(newLabel);
        return ResponseResult.SUCCESS("测试用例label更新成功");
    }

    @GetMapping("/label/{labelId}")
    public ResponseResult getLabels(@PathVariable("labelId") String labelId){
        Labels labels=labelsDao.findOneById(labelId);
        if (labels==null){
            return ResponseResult.FAILED("测试用例label不存在");
        }
        return ResponseResult.SUCCESS("测试用例label以获取").setData(labels);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/label/list/{page}/{size}")
    public ResponseResult listLabels(@PathVariable("page") int page,@PathVariable("size") int size){
        if (page<1){
            page=1;
        }
        if (size<=0){
            size= Constants.DEFAULT_SIZE;
        }
        Sort sort=new Sort(Sort.Direction.DESC,"createTime");
        Pageable pageable= PageRequest.of(page-1,size,sort);
        Page<Labels> pageLabel=labelsDao.findAll(pageable);
        return ResponseResult.SUCCESS("测试用例label分页获取成功").setData(pageLabel);
    }

    @GetMapping("/label/search")
    public ResponseResult labelDoSearch(@RequestParam("name") String name,@RequestParam("count") Long count){
        List<Labels> all=labelsDao.findAll(new Specification<Labels>() {
            @Override
            public Predicate toPredicate(Root<Labels> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //Predicate predicate=criteriaBuilder.equal(root.get("name").as(String.class),name);
                //模糊查询
                Predicate predicate1 = criteriaBuilder.like(root.get("name").as(String.class), "%"+name+"%");
                //并行查询
                Predicate predicate2 = criteriaBuilder.equal(root.get("count").as(Long.class),count);
                Predicate predicate =criteriaBuilder.and(predicate1,predicate2);
                return predicate;
            }
        });
        if (all.size()==0){
            return ResponseResult.FAILED("测试用例label按关键词查找失败");
        }
        return ResponseResult.SUCCESS("测试用例label按关键词查找成功").setData(all);
    }

    /**
     * 图形验证码
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        // 设置内置字体
        specCaptcha.setFont(Captcha.FONT_1);
        // 设置系统字体
        specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));  // 有默认字体，可以不用设置
        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_NUM_AND_UPPER);

        // 验证码存入session(如果前后端分离建议存入redis)
        request.getSession().setAttribute("captcha", specCaptcha.text().toLowerCase());

        // 输出图片流
        specCaptcha.out(response.getOutputStream());
    }
}
