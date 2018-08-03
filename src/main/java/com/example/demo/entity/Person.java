package com.example.demo.entity;

public class Person {
    private Integer id;
    private String aa;

    private String dd;
    private String cc;
    private String bb;

    public Person() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public Person(Integer id, String aa, String bb, String cc, String dd) {
        this.id = id;
        this.aa = aa;
        this.bb = bb;
        this.cc = cc;
        this.dd = dd;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", aa='" + aa + '\'' +
                ", bb='" + bb + '\'' +
                ", cc='" + cc + '\'' +
                ", dd='" + dd + '\'' +
                '}';
    }
}
