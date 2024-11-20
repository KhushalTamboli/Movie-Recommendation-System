package org.movie.recommend.repository;

import java.sql.*;
import java.util.*;

import org.movie.recommend.config.DBHelper;
import org.movie.recommend.model.*;
public class AdminRepository extends DBHelper{
	
	private List<Admin>list=new ArrayList<Admin>();
	//Below method is usefull for add admin in the database and get data from Admin class.
	public boolean isAddNewAdmin(Admin admin) {


		try {
			stmt=conn.prepareStatement("insert into admin values('0', ,?)");
			stmt.setString(1,admin.getAdminusername());
			stmt.setString(2,admin.getAdminpassword());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
			return false;
		}
		
		
		//return false;
	}
	
	//this method return the all admin details.
	   public List<Admin> getAlladmin(){
		   try {
			  stmt=conn.prepareStatement("select *from admin");
			  rs=stmt.executeQuery();
			  while(rs.next()) {
				  Admin admin=new Admin();

				  admin.setAdminusername(rs.getString(2));
				  admin.setAdminpassword(rs.getString(3));
				  list.add(admin);
			  }
			  return list.size()>0?list:null;
		   }
		   catch(Exception ex) {
			   System.out.println("Error is"+ex);
			   return null;
		   }

	   }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//this method return the all admin details.
	   public void getAlladmin_names(){
		   try {
			  stmt=conn.prepareStatement("select adminname from admin");
			  rs=stmt.executeQuery();
			  while(rs.next()) {				 
				 String adminname=rs.getString(1);
				 System.out.println("Adminname:- "+adminname+"\n");

			  }

		   }
		   catch(Exception ex) {
			   System.out.println("Error is"+ex);
		   }

	   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	   public boolean isDeleteAdmin(String Delete_admin_name) {


			try {
				int v=stmt.executeUpdate("delete from admin where adminname='"+Delete_admin_name+"'");
//			
				return v>0?true:false;
			}
			catch(Exception ex) {
				System.out.println("Error is"+ex);
				return false;
			}
			
			
			//return false;
		}
	   
	   
	   
	   
	   public boolean isUpdateAdmin(String new_admin_name,String new_admin_password,String current_admin_name) {
		  
			try {
				int v=stmt.executeUpdate("update admin set adminname='"+new_admin_name+"',adminpassword='"+new_admin_password+"' where adminname='"+current_admin_name+"'");
//			
				return v>0?true:false;
			}
			catch(Exception ex) {
				System.out.println("Error is"+ex);
				return false;
			}
			
			
			//return false;
		}

}
