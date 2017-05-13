package com.example.user.decaming;

/**
 * Created by User on 2017-05-13.
 */

public class ListViewItem {
    private String text1;
    private String text2;
    private String text3;

    public ListViewItem(String text1,String text2,String text3){
        this.text1=text1;
        this.text2=text2;
        this.text3=text3;
    }
    public String getText1(){
        return this.text1;
    }
    public String getText2(){
        return this.text2;
    }
    public String getText3(){
        return this.text3;
    }
}
