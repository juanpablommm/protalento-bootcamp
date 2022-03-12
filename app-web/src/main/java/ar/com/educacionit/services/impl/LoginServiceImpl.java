package ar.com.educacionit.services.impl;

import javax.sql.rowset.serial.SerialException;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.impl.SocioDaoImpl;
import ar.com.educacionit.dao.impl.UserDaoImpl;
import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.LoginService;

public class LoginServiceImpl implements LoginService {

    private UserDao userDao;
    private SociosDao sociosDao;
    
    
    public LoginServiceImpl() {
        this.userDao = new UserDaoImpl();
        this.sociosDao = new SocioDaoImpl();
    }


    @Override
    public Users getUserByUserName(String userName) throws SerialException {
        return null;
    }

}
