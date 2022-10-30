package com.gmr.porfolio.services;

import com.gmr.porfolio.dao.UserMatchDao;
import com.gmr.porfolio.models.UserMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Service
public class UserMatchService {
    @Autowired
    private UserMatchDao userMatchDao;

    public void setDataMatch(Long idUser){
        UserMatch uMatch = new UserMatch();
        uMatch.setIdUser(idUser);
        uMatch.setAvatar("");
        uMatch.setPoints(0);
        userMatchDao.addUserMatch(uMatch);
    }

    public void deleteUserMatch(Long idUser) throws NoSuchAlgorithmException, InvalidKeySpecException {
        userMatchDao.deleteUserMatch(idUser);
    }

    public UserMatch getDataMatch(Long idUser) throws NoSuchAlgorithmException, InvalidKeySpecException {
        UserMatch m = userMatchDao.getData(idUser);
        System.out.println(m.getPoints());
        return m;
    }
}
