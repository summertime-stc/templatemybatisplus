package com.example.stest.analysis.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("CHAT")
public class Chat {

    //以uuid插入
    @TableId(type= IdType.ASSIGN_UUID)
    private String msgId;
    @TableField("MSG_TYPE")
    private int msgtype;
    private Date msgCreatetime;
    private String msgContent;
    private int  msgIssend;
    private String msgUid;
    private String msgVsid;
    private byte[] msgBlob;
    private String  msgFilename;
    private int msgIsread;
    private String msgFilepath;


    //忽略数据库对应字段
    @TableField(exist = false)
    private boolean mark;
}
