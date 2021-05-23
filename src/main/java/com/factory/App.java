package com.factory;

import java.util.ArrayList;
import java.util.List;

import com.factory.details.Detail;
import com.factory.details.Door;
import com.factory.details.Wheel;
import com.factory.details.Motor;
import com.factory.manager.Manager;
import com.factory.valiable.Sort;



public class App {
    public static void main(String[] args) {
        Manager manager = new Manager();

        List<Detail> details = new ArrayList<>();

        details.add(new Wheel(10));
        details.add(new Wheel(9));
        details.add(new Motor(100));
        details.add(new Motor(140));
        details.add(new Door("Closed"));
        details.add(new Door("Open"));

        manager.addDetails(details);

        System.out.println("----All----");

        manager.getDetails().forEach(detail -> {
            System.out.println(detail);
        });

        List<Detail> chassis = manager.findChassis(10);

        System.out.println("----ASC----");

        manager.sortBySer_num(Sort.ASC, chassis).forEach(detail -> {
            System.out.println(detail);
        });

        System.out.println("------DASC-------");

        manager.sortBySer_num(Sort.DESC, chassis).forEach(detail -> {
            System.out.println(detail);
        });
    }
}
