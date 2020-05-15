package com.pluralsight.conferencedemoboot.controllers;

public class User {
    public User(String user_id, String char_name, String last_name, Long phone_no) {
        this.user_id = user_id;
        this.char_name = char_name;
        this.last_name = last_name;
        this.phone_no = phone_no;
    }

    private String user_id;
    private String char_name;
    private String last_name;
    private Long phone_no;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getChar_name() {
        return char_name;
    }

    public void setChar_name(String char_name) {
        this.char_name = char_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", char_name='" + char_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_no=" + phone_no +
                '}';
    }

    public Long getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(Long phone_no) {
        this.phone_no = phone_no;
    }
}
