package ar.com.educacionit.services;

import javax.sql.rowset.serial.SerialException;

import ar.com.educacionit.domain.Users;

public interface LoginService {

    public Users getUserByUserName(String userName) throws SerialException;
}
