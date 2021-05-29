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
                23);
        this.power = power;
    }
}
