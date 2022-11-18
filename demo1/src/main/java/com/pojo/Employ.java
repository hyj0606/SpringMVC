package com.pojo;

/**
 * @ClassName Employ
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-18 11:53
 * @Version 1.0
 */

public class Employ {

    private int id;
    private String empName;

    public Employ() {
    }

    public Employ(int id, String empName) {
        this.id = id;
        this.empName = empName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
