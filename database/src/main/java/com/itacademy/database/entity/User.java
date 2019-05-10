package com.itacademy.database.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;

@ToString
@Setter
@Getter
@Data
@AllArgsConstructor
@Builder
public class User {

    private long id;
    private String name;

}
