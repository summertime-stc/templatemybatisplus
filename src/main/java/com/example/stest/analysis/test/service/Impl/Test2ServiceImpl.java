package com.example.stest.analysis.test.service.Impl;

import com.example.stest.analysis.test.service.Test2Service;
import org.springframework.stereotype.Service;

@Service
public class Test2ServiceImpl implements Test2Service {
    @Override
    public void test() {
        System.out.println("success");
    }
}
