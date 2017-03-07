package com.fuicuiedu.xc.eventbus_20170307;

/**
 * 自定义一个事件类
 */

public class MessageEvent {

    private String msg;

    public MessageEvent(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
}
