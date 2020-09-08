package com.example.stest.analysis.test.controller;

import com.example.stest.analysis.StestApplication;
import com.example.stest.analysis.test.entity.Chat;
import com.example.stest.analysis.test.service.Test2Service;
import com.example.stest.analysis.test.service.TestService;
import com.example.stest.analysis.utils.MyPage;
import com.example.stest.common.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;


@Controller
@Api(tags = "demo")
public class TestController extends BaseController {

    @Value("${test.test.name}")
    private String name;


    @Autowired
    private TestService testService;

    @Autowired
    @Qualifier("test2ServiceImpl")
    private Test2Service test2Service;

    private static Logger logger = LoggerFactory.getLogger(StestApplication.class);

    @ApiOperation(value = "遍历json")
    @PostMapping("/test001")
    //事务
    @Transactional
    @ResponseBody
    public void test1(){
        testService.selectorginall();
    }


    @GetMapping("/test11")
    public String test11(){
        return "xx";
    }


    @GetMapping("/test12")
    public String test12(){
        return "tc/behaviorviolation";
    }


    @PostMapping("/insert")
    @ResponseBody
    public String insert(){
        testService.insert();
        return null;
    }

    @PostMapping("/selectall")
    @ResponseBody
    public List<Chat> selectall(){

        return testService.selectall();
    }


    /*
    * 通用查询
    * */
    @PostMapping("/select")
    @ResponseBody
    public void select(){
        //根据主键查找
        testService.selectone();

        //根据主键集查找
        testService.selectmore();

        //根据多条件查找
        testService.selectbyfilters();
    }

    /*
    * 更新
    * */
    @PostMapping("/update")
    @ResponseBody
    public void update(){
        //根据主键更新
        testService.updatebyid();

    }


    /*
     * 更新
     * */
    @PostMapping("/delete")
    @ResponseBody
    public void delete(){
        //根据主键更新
        testService.deletebyid();
    }


    /*
    * 条件构造器
    * */
    @PostMapping("/selectwrapper")
    @ResponseBody
    public void selectwrapper(){
        //构造条件
        testService.selectbywrapper();
    }

    /*
     * 分页
     * */
    @PostMapping("/page")
    @ResponseBody
    public MyPage page(){
        //构造条件
        int msgtype=1;
        int pageIndex=1;
        int pageSize=3;
        return testService.page(msgtype,pageIndex,pageSize);
    }

    @PostMapping("/service1")
    @ResponseBody
    public String service1(){
        test2Service.test();
       return null;
    }


}
