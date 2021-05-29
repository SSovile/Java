package com.factory.details;

import com.factory.valiable.DetailType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Wheel extends Detail {
    private int radius;

    public Wheel(int radius) {
        super(DetailType.Chassis, 23);
        this.radius = radius;
    }
}