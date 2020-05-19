package com.github.hcsp;

public class Home {
    Cat cat;

    public static void main(String[] args) {

        Home home = new Home();
        Cat mimi = new Cat();
        home.cat = mimi;
        mimi.name = "咪咪";
    }
}
