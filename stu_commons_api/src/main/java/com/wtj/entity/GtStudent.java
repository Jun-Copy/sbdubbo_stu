package com.wtj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GtStudent implements Serializable {
    private Integer stuId;

    private String stuName;

    private String stuSex;

    private String stuDescribe;

    private Integer clId;
}