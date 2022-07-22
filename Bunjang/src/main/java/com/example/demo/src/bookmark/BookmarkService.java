package com.example.demo.src.bookmark;

import com.example.demo.config.BaseException;
import com.example.demo.config.secret.Secret;
import com.example.demo.src.bookmark.model.*;
import com.example.demo.utils.AES128;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import static com.example.demo.config.BaseResponseStatus.*;

@Service

public class BookmarkService {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BookmarkDao bookmarkDao;
    private final BookmarkProvider bookmarkProvider;
    private final JwtService jwtService;

    @Autowired
    public  BookmarkService(BookmarkDao bookmarkDao, BookmarkProvider bookmarkProvider, JwtService jwtService) {
        this.bookmarkDao = bookmarkDao;
        this.bookmarkProvider = bookmarkProvider;
        this.jwtService = jwtService;
    }

    // 찜 추가/취소
    public String createPatchBookmark(int userIdx, int productIdx) throws BaseException {
        try{
            if(bookmarkProvider.checkBookmark(userIdx,productIdx) == 1){
                int b = bookmarkDao.patchBookmark(userIdx,productIdx);
                String result = "상품이 찜 목록에서 삭제되었습니다.";
                return result;
            } else {
                int a = bookmarkDao.createBookmark(userIdx, productIdx);
                String result = "상품이 찜 목록에 추가되었습니다.";
                return result;
            }

        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }


}
