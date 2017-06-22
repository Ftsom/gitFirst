package com.liu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.liu.domain.User;
@Repository
public interface UserDao {  
	
    public User selectUserById(Integer userId);  
    
    public List<User> userList();
    
}