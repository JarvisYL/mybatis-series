package com.javacode2018.chat05.demo2.model;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Integer id;
    private String name;
}
