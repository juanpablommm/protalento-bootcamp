package ar.com.educacionit.services.impl;

import javax.sql.rowset.serial.SerialException;

import com.google.protobuf.ServiceException;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.impl.SocioDaoImpl;
import ar.com.educacionit.dao.impl.UserDaoImpl;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.domain.Users;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.web.enums.ViewEnums;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class LoginServiceImpl implements LoginService {

    private UserDao userDao;
    private SociosDao sociosDao;

    public LoginServiceImpl() {
        this.userDao = new UserDaoImpl();
        this.sociosDao = new SocioDaoImpl();
    }

    @Override
    public Users getUserByUserNameAndPassword(String userName, String passwrod) throws  ServiceException {
        try {
           Users users = this.userDao.getUserByUserName(userName);

           //valido password
           BCrypt.Result result = BCrypt.verifyer()
                       .verify(passwrod.getBytes(), users.getPassword().getBytes());
               if(!result.verified) {
                   throw new ServiceException("Credenciales invalidas");
               }
               if(users != null) {
               Socios socios = this.sociosDao.getSociosByUserId(users.getId());
               users.setSocio(socios);
           }
               return users;
        } catch (GenericException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
