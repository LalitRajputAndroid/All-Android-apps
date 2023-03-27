package com.example.textermessenger;

public class contacts_Model {
    private int img;
    private  String name;
    private String msg;
    private String time;

    public contacts_Model(int img,String name,String msg,String time){
        this.img = img;
        this.name = name;
        this.msg = msg;
        this.time = time;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
