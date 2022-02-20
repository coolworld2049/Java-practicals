package com.hw;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Worker
{
    private String[] names = {"Pshep","Fedor","Muttr","Shtrd","Pesel","Mopsl"};
    private String[] lastNames = {"Asct","Mask","Mark","Pplm","Jztx","Mxck"};
    private String[] genders = {"M","W"};
    private String[] catNames = {"ggw","sar","axc","otd","lcv","scb","No.","No.","No."};
    private String[] departmentNames = {"Memlogy","JavaGDv","CyberSp","MainigB"};
    private String[] positions = {"Junior.","Middle.","Senior.","TeamLD."};

    public String name;
    public String lastName;
    public String gender;
    public String catName;
    public String departmentName;
    public String position;
    public int age;
    public int wage;
    public int meritPay;
    public int workLife;

    public Worker()
    {
        this.name = this.names[ThreadLocalRandom.current().nextInt(this.names.length)];
        this.lastName = this.lastNames[ThreadLocalRandom.current().nextInt(this.lastNames.length)];
        this.gender = this.genders[ThreadLocalRandom.current().nextInt(this.genders.length)];
        this.catName = this.catNames[ThreadLocalRandom.current().nextInt(this.catNames.length)];
        this.departmentName = this.departmentNames[ThreadLocalRandom.current().nextInt(this.departmentNames.length)];
        this.position = this.positions[ThreadLocalRandom.current().nextInt(this.positions.length)];
        this.age = ThreadLocalRandom.current().nextInt(25,100);
        this.wage = ThreadLocalRandom.current().nextInt(100000,200000);
        this.meritPay = ThreadLocalRandom.current().nextInt(0,50000);
        this.workLife = ThreadLocalRandom.current().nextInt(1,25);
    }

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getGender() {
        return gender;
    }
    public String getCatName() {
        return catName;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public String getPosition() {
        return position;
    }
    public int getAge() {
        return age;
    }
    public int getWage() {
        return wage;
    }
    public int getMeritPay() {
        return meritPay;
    }
    public int getWorkLife() {
        return workLife;
    }
    public int getBestWorker() {
        return wage + meritPay;
    }

}
