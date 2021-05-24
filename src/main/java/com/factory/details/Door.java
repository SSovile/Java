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
    private Integer id;
    public Door() {
        super(DetailType.Chassis, 23);
    }
}
