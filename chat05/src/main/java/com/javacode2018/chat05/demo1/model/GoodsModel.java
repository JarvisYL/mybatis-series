package com.javacode2018.chat05.demo1.model;
import lombok.*;



@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GoodsModel {
    private Integer id;
    private String name;
    private Double price;
}
