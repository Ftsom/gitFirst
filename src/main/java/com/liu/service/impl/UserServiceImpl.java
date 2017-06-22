package com.liu.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liu.dao.UserDao;
import com.liu.domain.User;
import com.liu.service.UserService;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired  
    private UserDao userDao; 
	
	public User selectUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.selectUserById(userId);
	}

	public void exportDataToExcel() {
		// TODO Auto-generated method stub
		try {
			WritableWorkbook wwb = null;
			
			String fileName = "D:\\user.xlsx";
			File file = new File(fileName);
	
				wwb = Workbook.createWorkbook(file);
			
			WritableSheet ws = wwb.createSheet("Test sheet 1", 0);
			
			List<User> userList = userDao.userList();
			Label labelId = new Label(0, 0, "±‡∫≈£®ID£©");
			Label labelName = new Label(1, 0, "–’√˚");
			Label labelPassword = new Label(2, 0, "√‹¬Î");
			Label labelEmail = new Label(3, 0, "” œ‰");
			
			ws.addCell(labelId);
			ws.addCell(labelName);
			ws.addCell(labelPassword);
			ws.addCell(labelEmail);
			
			for (int i = 0; i < userList.size(); i++) {
				Label labelId_i = new Label(0, i+1, userList.get(i).getUserId() + "");
				Label labelName_i = new Label(1, i+1, userList.get(i).getUserName() + "");
				Label labelPassword_i = new Label(2, i+1, userList.get(i).getUserPassword() + "");
				Label labelEmail_i = new Label(3, i+1, userList.get(i).getUserEmail() + "");
				ws.addCell(labelId_i);
				ws.addCell(labelName_i);
				ws.addCell(labelPassword_i);
				ws.addCell(labelEmail_i);
			}
			
			wwb.write();
			
			wwb.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
