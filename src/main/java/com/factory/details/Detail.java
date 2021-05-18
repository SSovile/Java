package com.factory.details;

import com.factory.valiable.DetailType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Detail {
        protected DetailType detailType;
        protected double ser_num;
}
