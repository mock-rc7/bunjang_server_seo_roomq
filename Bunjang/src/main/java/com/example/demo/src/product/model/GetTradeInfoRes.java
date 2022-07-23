package com.example.demo.src.product.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetTradeInfoRes {
    private String productName;
    private String url1;
    private int price;
    private String storeName;
    //변경후 넣을값
    private String tradeMethod;
    private String orderNumber
}
