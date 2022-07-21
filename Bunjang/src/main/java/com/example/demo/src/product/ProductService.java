package com.example.demo.src.product;

import com.example.demo.config.BaseException;
import com.example.demo.src.product.model.*;
import com.example.demo.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.config.BaseResponseStatus.*;

@Service

public class ProductService {

    private final ProductDao productDao;
    private final ProductProvider productProvider;
    private final JwtService jwtService;

    @Autowired
    public ProductService(ProductDao productDao,ProductProvider productProvider,JwtService jwtService) {
        this.productDao = productDao;
        this.productProvider = productProvider;
        this.jwtService = jwtService;
    }

    // 상품 등록 전단계
    public void postProduct(int userIdx, PostProductReq postProductReq) throws BaseException {
        try {

            int result = productDao.postProduct(userIdx,postProductReq);

        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

}
