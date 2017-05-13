package com.example.user.decaming;

/**
 * Created by User on 2017-05-13.
 */

public class Calc {
    private Dday dday=new Dday();
    private String result;
    private String ing;
    public Calc(){

    }
    public String ing(){
        result = String.valueOf(dday.dayy("2017-03-16")-1);
        ing = result.replace("-","");
        return ing;
    }
    public String one(){
        result = String.valueOf(dday.dayy("2017-06-23"));
        return result;
    }
    public String one1(){
        result = String.valueOf(dday.dayy("2017-10-01"));
        return result;
    }
    public String one2(){
        result = String.valueOf(dday.dayy("2017-10-03"));
        return result;
    }public String one3(){
        result = String.valueOf(dday.dayy("2018-01-09"));
        return result;
    }public String one4(){
        result = String.valueOf(dday.dayy("2018-03-16"));
        return result;
    }public String one5(){
        result = String.valueOf(dday.dayy("2018-03-24"));
        return result;
    }public String one6(){
        result = String.valueOf(dday.dayy("2018-04-19"));
        return result;
    }public String one7(){
        result = String.valueOf(dday.dayy("2018-07-28"));
        return result;
    }public String one8(){
        result = String.valueOf(dday.dayy("2018-10-03"));
        return result;
    }public String one9(){
        result = String.valueOf(dday.dayy("2018-11-05"));
        return result;
    }public String one10(){
        result = String.valueOf(dday.dayy("2019-02-13"));
        return result;
    }public String one11(){
        result = String.valueOf(dday.dayy("2019-03-16"));
        return result;
    }public String one12(){
        result = String.valueOf(dday.dayy("2019-03-24"));
        return result;
    }public String one13(){
        result = String.valueOf(dday.dayy("2019-05-24"));
        return result;
    }public String one14(){
        result = String.valueOf(dday.dayy("2019-09-01"));
        return result;
    }public String one15(){
        result = String.valueOf(dday.dayy("2019-10-03"));
        return result;
    }public String one16(){
        result = String.valueOf(dday.dayy("2019-12-10"));
        return result;
    }

}
