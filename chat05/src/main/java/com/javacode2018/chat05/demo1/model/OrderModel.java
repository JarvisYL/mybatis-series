package com.javacode2018.chat05.demo1.model;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
    private Integer id;
    private Integer userId;
    private Long createTime;
    private Long upTime;
    //下单用户信息
    private UserModel userModel;
    //订单详情列表
    private List<OrderDetailModel> orderDetailModelList;
}