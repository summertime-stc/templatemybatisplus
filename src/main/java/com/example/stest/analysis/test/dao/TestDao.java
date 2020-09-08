package com.example.stest.analysis.test.dao;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TestDao")
@Mapper
public interface TestDao {
    List findAll();


}
