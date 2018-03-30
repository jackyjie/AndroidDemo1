package com.example.firstcodeandroid.Utils.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JackR on 2018/3/29.
 *  Person2 person = (Person2)getIntent().getParcelableExtra("person");
 */

public class Person2 implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    public static final Parcelable.Creator<Person2> CREATOR = new Parcelable.Creator<Person2>(){
        @Override
        public Person2 createFromParcel(Parcel source) {
            Person2 person = new Person2();
            person.name = source.readString();
            person.age = source.readInt();
            return person;
        }

        @Override
        public Person2[] newArray(int size) {
            return new Person2[size];
        }
    };
}
