package com.example.stest.analysis.test.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.stest.analysis.test.dao.ChatMapper;
import com.example.stest.analysis.test.dao.TestDao;
import com.example.stest.analysis.test.entity.Chat;
import com.example.stest.analysis.utils.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestService {

    @Autowired
    private ChatMapper chatMapper;
    @Autowired
    private TestDao testDao;

    //空格适用windows和linux
    private static final String LINE_SEPARATOR=System.getProperty("line.separator");


    public void insert() {
        Chat chat=new Chat();
//        chat.setMsgId(999939);
        chat.setMsgContent("test");
        chat.setMark(true);

        int a=chatMapper.insert(chat);
        System.out.println("a:"+a);
    }

    public List<Chat> selectall() {

        return chatMapper.selectList(null);
    }


    public void selectone() {
        System.out.println("selectById:"+chatMapper.selectById(1));
    }

    public void selectmore() {
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println("selectBatchIds:"+chatMapper.selectBatchIds(list));
    }

    public void selectbyfilters() {
        Map<String,Object> map= new HashMap();
        map.put("MSG_UID","stc");
        map.put("MSG_VSID","swb");
        System.out.println("selectByMap:"+chatMapper.selectByMap(map));
    }

    public void selectbywrapper() {
        QueryWrapper<Chat> queryWrapper=new QueryWrapper<Chat>();
        queryWrapper.like("MSG_UID","stc").in("MSG_TYPE",1,2,3).orderByDesc("MSG_ID").orderByAsc("MSG_UID");
        System.out.println("selectbywrapper"+chatMapper.selectList(queryWrapper));
    }


    public MyPage  page(int msgtype, int pageIndex, int pageSize) {
        Page<Chat> page = new Page<>(pageIndex,pageSize);
        IPage<Chat> pages = chatMapper.getresult(page,msgtype);
        MyPage myPage = new MyPage(pages);
        return myPage;
    }


    public void selectorginall() {
        testDao.findAll();
    }

    public void updatebyid() {
        Chat chat=new Chat();
        chat.setMsgId("1");
        chat.setMsgContent("fefefe");
        chatMapper.updateById(chat);
    }

    public void deletebyid() {
        chatMapper.deleteById("1");

        //id集合删除
//        chatMapper.deleteBatchIds()

        //根据条件删除
//        chatMapper.deleteByMap();
    }
}
