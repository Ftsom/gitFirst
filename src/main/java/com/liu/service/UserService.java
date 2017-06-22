package com.liu.service;

import com.liu.domain.User;

public interface UserService {  
	
    User selectUserById(Integer userId);  
    
    void exportDataToExcel();
    
}  