package com.example.firstcodeandroid.Views.ListView;

/**
 * Created by JackR on 2018/3/23.
 */

public class NinePatchMsg {

    public static final int TYPE_RECEIVED = 0 ;
    public static final int TYPE_SENT = 1;
    private String content;
    private int type;

    public NinePatchMsg(String _content, int _type){
        this.content = _content;
        this.type = _type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
