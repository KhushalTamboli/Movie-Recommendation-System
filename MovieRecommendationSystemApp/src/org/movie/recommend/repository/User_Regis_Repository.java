package org.movie.recommend.repository;

import org.movie.recommend.config.DBHelper;
import java.sql.*;
import java.util.*;

import org.movie.recommend.config.DBHelper;
import org.movie.recommend.model.*;

public class User_Regis_Repository extends DBHelper{
	public boolean isAddNewUser(User_registration user_resig) {
		try {
			stmt=conn.prepareStatement("insert into userinfo values('0',?,?,?,?)");
			stmt.setString(1,user_resig.getUser_name());
			stmt.setString(2,user_resig.getUser_password());
			stmt.setString(3,user_resig.getUser_contact_number());
			stmt.setString(4,user_resig.getUser_city_name());
			
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
			return false;
		}
		//return false;
	}

}
