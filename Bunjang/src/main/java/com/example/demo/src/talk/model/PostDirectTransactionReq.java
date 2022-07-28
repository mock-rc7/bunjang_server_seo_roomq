package com.example.demo.src.talk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class PostDirectTransactionReq {

    private int sendUserIdx;
    private int receiveUserIdx;
    private String saleOrBuy;
    private int productId;
    private String price;
    private String deliveryTip;
    @JsonFormat(pattern = "yyyy년 MM월 dd일", timezone = "Asia/Seoul")
    private LocalDate transactionDate;
    private String transactionLocation;

}
