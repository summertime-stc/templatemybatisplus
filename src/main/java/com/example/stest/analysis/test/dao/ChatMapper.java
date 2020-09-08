package com.example.stest.analysis.test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.stest.analysis.test.entity.Chat;


public interface ChatMapper extends BaseMapper<Chat> {

    IPage<Chat> getresult(Page<Chat> page,int msgtype);

    void selectorginall();
}
