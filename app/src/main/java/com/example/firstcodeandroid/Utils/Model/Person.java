package com.example.firstcodeandroid.Utils.Model;

import java.io.Serializable;

/**
 * Created by JackR on 2018/3/29.
 * 序列化model
 * Person person = new Person();
 * person.setName("123");
 * person.setAge(1)
 * Intent intent = new Intent(..,..);
 * intent.putExtra("person", person);
 * 取值：
 * Person person = (Person)getIntent().getSerializableExtra("person");
 */

public class Person implements Serializable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
