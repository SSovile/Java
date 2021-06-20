package com.factory.details;

import com.factory.valiable.DetailType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class Door extends Detail {
    private String type_of_door;
    public Door(String type_of_door) {
        super(DetailType.Chassis, 1 + (int) (Math.random() * ((4000 - 1))));
        this.type_of_door = type_of_door;
    }
}
