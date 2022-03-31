package ar.com.educacionit.services;

import javax.sql.rowset.serial.SerialException;

import com.google.protobuf.ServiceException;

import ar.com.educacionit.domain.Users;

public interface LoginService {

    public Users getUserByUserNameAndPassword(String userName, String password) throws ServiceException;
}
