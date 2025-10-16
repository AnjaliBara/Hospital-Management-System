package com.user.servlet;

<<<<<<< HEAD
public class UserRegister {
=======
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/user_register")
public class UserRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String  fullName = req.getParameter("fullname");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			User u = new User(fullName,email,password);
			UserDao dao =new UserDao(DBConnect.getConn());
			boolean f = dao.register(u);
			if(f)
			{
				System.out.println("register successfull");
			}else {
				System.out.println("Something wrong on server");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
>>>>>>> cfb7e32 (Added Admin login and logout)

}
