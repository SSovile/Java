package com.factory.manager;

import com.factory.details.Detail;

import com.factory.valiable.DetailType;

import com.factory.valiable.Sort;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Manager {
    private List<Detail> details = new ArrayList<>();
    public void addDetails(List<Detail>details) {
        this.details.addAll(details);
    }
    public void addDetail(Detail detail) {
        this.details.add(detail);
    }
    public List<Detail> findChassis(int mSerNum) {
        return details.stream().filter(detail -> detail.getSer_num() >= mSerNum && detail.getDetailType() == DetailType.Chassis).collect(Collectors.toList());
    }

    public List<Detail> sortBySer_num(Sort order, List<Detail> details) {
        if (order == Sort.ASC) {
            return details.stream().sorted(Comparator.comparing(Detail::getSer_num)).collect(Collectors.toList());
        }
        else {
            return details.stream().sorted(Comparator.comparing(Detail::getSer_num).reversed()).collect(Collectors.toList());
        }
    }
}
