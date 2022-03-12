package ar.com.educacionit.dao;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.exceptions.GenericException;

public interface UserDao {

    public Users getUserByUserName(String userName) throws GenericException;
}
