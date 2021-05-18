package com.factory.details;

import com.factory.valiable.DetailType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Motor extends Detail {
    private int power;
    public Motor(int power) {
        super(DetailType.Nochassis,
                1 + (int)(Math.random() * ((4000 - 1))));
        this.power = power;
    }
}
