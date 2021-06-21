package com.javacode2018.chat03.demo4.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFindDto {
    private Long userId;
    private String userName;
}