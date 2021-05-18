package com.factory.details;

import com.factory.valiable.DetailType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Wheel extends Detail {
    private int radius;

    public Wheel(int radius) {
        super(DetailType.Chassis, 1 + (int)(Math.random() * ((4000 - 1))));
        this.radius = radius;
    }
}