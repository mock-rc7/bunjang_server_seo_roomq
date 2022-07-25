package com.example.demo.src.address;

import com.example.demo.config.BaseException;
import com.example.demo.src.address.model.DeleteAddressReq;
import com.example.demo.src.address.model.PatchAddressReq;
import com.example.demo.src.address.model.PostAddressReq;
import com.example.demo.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class AddressService {

    private final AddressDao addressDao;
    private final AddressProvider addressProvider;
    private final JwtService jwtService;

    @Autowired
    public AddressService(AddressDao addressDao, AddressProvider addressProvider, JwtService jwtService) {
        this.addressDao = addressDao;
        this.addressProvider = addressProvider;
        this.jwtService = jwtService;
    }

    public void addAddress(PostAddressReq postAddressReq) throws BaseException{
        try {
            if (postAddressReq.getStatus().equals("기본"))addressDao.postAddressStatus(postAddressReq);
             addressDao.addAddress(postAddressReq);
        }catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public void deleteAddress(DeleteAddressReq deleteAddressReq) throws BaseException{
        try {
            addressDao.deleteAddress(deleteAddressReq);
        }catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public void modifyAddress(PatchAddressReq patchAddressReq) throws BaseException{
        try {
            if (patchAddressReq.getStatus().equals("기본"))addressDao.updateAddressStatus(patchAddressReq);
            addressDao.modifyAddress(patchAddressReq);
        }catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

}