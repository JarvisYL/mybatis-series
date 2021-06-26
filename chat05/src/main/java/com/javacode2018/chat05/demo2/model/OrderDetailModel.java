package com.javacode2018.chat05.demo2.model;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel {
    private Integer id;
    private Integer orderId;
    private Integer goodsId;
    private Integer num;
    private Double totalPrice;
}
