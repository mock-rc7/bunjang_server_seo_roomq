package com.example.demo.src.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class GetProductDetailRes {

    private List<GetProductImgRes> getProductImgRes;
    private String price;
    private String productName;
    private String location;
    private boolean productStatus;
    private int count;
    private boolean trade;
    private String description;
    private String categoryName;
    private boolean safePay;

}
