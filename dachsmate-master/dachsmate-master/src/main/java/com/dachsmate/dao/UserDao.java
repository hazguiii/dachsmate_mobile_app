package com.dachsmate.dao;

import com.dachsmate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    User findForLoginPassword(String username,String userPassword);
    User findUserById(Integer id);
}
