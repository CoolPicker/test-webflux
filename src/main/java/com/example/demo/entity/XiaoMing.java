package com.example.demo.entity;

public class XiaoMing extends Person {
    private String mm;
    private String nn;

    public XiaoMing(Integer id, String aa, String bb, String cc, String dd) {
        super(id, aa, bb, cc, dd);
    }

    public XiaoMing() {
        super();
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    public String getNn() {
        return nn;
    }

    public void setNn(String nn) {
        this.nn = nn;
    }
}
