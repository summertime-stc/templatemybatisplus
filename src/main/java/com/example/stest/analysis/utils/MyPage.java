package com.example.stest.analysis.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyPage<T>{
    private List data;
    private long total;
    private long size;
    private long current;

    public MyPage(IPage<T> pages) {
        this.data = pages.getRecords();
        this.total = pages.getTotal();
        this.size = pages.getSize();
        this.current = pages.getCurrent();
    }
}
