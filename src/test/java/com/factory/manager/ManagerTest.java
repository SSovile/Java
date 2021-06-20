package com.factory.manager;

import com.factory.details.Detail;
import com.factory.details.Door;
import com.factory.details.Motor;
import com.factory.details.Wheel;
import com.factory.valiable.DetailType;
import com.factory.valiable.Sort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ManagerTest {
    List<Detail> details = List.of(new Wheel(10),new Wheel(9),new Motor(100),new Motor(140),
            new Door("Closed"),new Door("Open"));


    @Test
    public void findChassis() {
        Manager manager = new Manager();
        manager.addDetails(details);
        final int mSerNum = 10;
        List<Detail> testList = details.stream().filter(detail -> detail.getSer_num() >= mSerNum && detail.getDetailType() ==
                DetailType.Chassis).collect(Collectors.toList());
        assertEquals(testList, manager.findChassis(mSerNum));
    }

    @Test
    public void sortBySer_num() {
        Manager manager = new Manager();
        manager.addDetails(details);
        List<Detail> testList = details.stream().sorted(Comparator.comparing(Detail::getSer_num)).collect(Collectors.toList());
        assertEquals(testList, manager.sortBySer_num(Sort.ASC, details));
    }
}