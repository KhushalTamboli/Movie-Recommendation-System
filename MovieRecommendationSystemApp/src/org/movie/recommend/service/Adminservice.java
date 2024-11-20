package org.movie.recommend.service;

import org.movie.recommend.config.*;
import java.util.*;
import java.sql.*;

import org.movie.recommend.model.*;
import org.movie.recommend.repository.*;
public class Adminservice {
	
	AdminRepository admRepo= new AdminRepository();
	Movie_service movie_service=new Movie_service();
	Scanner xyz=new Scanner(System.in);	
	

    String current_admin_name;
    String current_admin_password;
		
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		public void Admin_Login(){   
			boolean adminflag=false;
		System.out.println("Enter Admin the name:-");  
		String admin_temp_name=xyz.next();            //for taking admin name
		System.out.println("Enter the Password:-");
		String admin_temp_password=xyz.next();          //for taking admin password
		
		List<Admin>list=admRepo.getAlladmin();
		if(list!=null) {
			for (Admin admin : list) {
				if(admin.getAdminusername().equals(admin_temp_name)&&admin.getAdminpassword().equals(admin_temp_password))   //comparing the admin name and password to the database admin credentials.
				{
					adminflag=true;  // if found  admin then true the value.
					current_admin_name=admin.getAdminusername();
					current_admin_password=admin.getAdminpassword();
					
					
					
				}

				}
			
			if(adminflag==true) {        
				System.out.println("===================================================================");
				System.out.println("Admin Login Successfully");
				System.out.println("===================================================================");
				int Adminpanelchoice;
				do {
					System.out.println("1:Add New Admin");
					System.out.println("2:Update Admin Credentials");
					System.out.println("3:Show all Admin");
					System.out.println("4:Delete Admin");
					System.out.println("5:Add movie");
					System.out.println("6:Update Movie details");
					System.out.println("7:Dashboard");
					System.out.println("8:View all movies details");
					System.out.println("9:Delete Movie");
					System.out.println("10:For Exit ");
					System.out.println("Enter the choice:-");
					Adminpanelchoice=xyz.nextInt();
					System.out.println("==========================================================================");
					
					
					switch(Adminpanelchoice) {
					case 1:
						int admindatabase_count=0;
						int indentified_admin_count=0;
						System.err.println("Important Note:All Admin Permission required");
						
						if(list!=null) {
							for (Admin admin : list) {
								admindatabase_count++;
								//if(admin.getAdminusername().equals(admin_temp_name)&&admin.getAdminpassword().equals(admin_temp_password))  
								System.out.println("Admin name:-"+admin.getAdminusername());
								System.out.println("Enter the password");
								String newpasswordadmin=xyz.next();
								
								if(admin.getAdminpassword().equals(newpasswordadmin)) {
									indentified_admin_count++;
									System.out.println("Correct Password");
								}
								else {
									System.err.println("Invalids Password");
									break;
								}
								}
						
							
							
							if(admindatabase_count==indentified_admin_count) {
								System.out.println("All Admin Permission Granted");
								System.out.println("Enter the New Admin name:-");
								String New_admin_name=xyz.next();
								System.out.println("Set password:-");
								String New_admin_password=xyz.next();
								Admin admin=new Admin();
								admin.setAdminusername(New_admin_name);
								admin.setAdminpassword(New_admin_password);
								boolean b=admRepo.isAddNewAdmin(admin);
								if(b) {
									System.out.println(" New Admin Added Successfully");
									System.out.println("==========================================================================");
								}
								
								else {
									System.err.println("Problem in New Admin Registration");
								}	
							}
						}
						
						break;
						
					case 2:
						boolean updateadminflag=false;
						System.out.println("2:Update Admin Credentials");
//						System.out.println("Enter the Admin_name:-");  
//						 String admin_name=xyz.next();            //for taking admin name
						System.out.println("Enter the Password for update Credentials:-");
						String admin_password=xyz.next();          //for taking admin password
						
						
						if(admin_password.equals(current_admin_password)) {
							if(list!=null) {
								for (Admin admin : list) {
									if(admin.getAdminpassword().equals(admin_password))   //comparing the admin name and password to the database admin credentials.
									{
										System.out.println("Set the Adminname:-");
										 String new_admin_name=xyz.next();       
										System.out.println("Set the Password:-");
										String new_admin_password=xyz.next();   
										 boolean b=admRepo.isUpdateAdmin(new_admin_name,new_admin_password,current_admin_name);
										updateadminflag=true;  // if found  admin then true the value.
									}
								}
								if(updateadminflag==true) {
									System.out.println("Admin info Update Successfully");
								}
								else {
									System.out.println("Problem in Admin info Updation");
								}
							}
	
						}
						else {
							System.out.println("Password not match!");
						}
						
						
				
						
						break;
						
					case 3:
						admRepo.getAlladmin_names();
//					
						break;
						
					case 4:

						int Delete_admindatabase_count=0;
						int Delete_indentified_admin_count=0;
						System.err.println("Important Note:All Admin Permission required");
						
						if(list!=null) {
							for (Admin admin : list) {
								Delete_admindatabase_count++;
								//if(admin.getAdminusername().equals(admin_temp_name)&&admin.getAdminpassword().equals(admin_temp_password))  
								System.out.println("Admin name:-"+admin.getAdminusername());
								System.out.println("Enter the password");
								String newpasswordadmin=xyz.next();
								
								if(admin.getAdminpassword().equals(newpasswordadmin)) {
									Delete_indentified_admin_count++;
									System.out.println("Correct Password");
								}
								else {
									System.err.println("Invalids Password");
									break;
								}
								}
						
							
							
							if(Delete_admindatabase_count==Delete_indentified_admin_count) {
								System.out.println("All Admin Permission Granted");
								System.out.println("Enter the Admin name to Delete:-");
								String Delete_admin_name=xyz.next();
								
								Admin admin=new Admin();
//								admin.setAdminusername(Delete_admin_name);
//								admin.setAdminpassword(New_admin_password);
							
								boolean b=admRepo.isDeleteAdmin(Delete_admin_name);
								if(b) {
									System.out.println(" Admin Deleted Successfully");
									System.out.println("==========================================================================");
									break;
								}
								
								else {
									System.err.println("Problem in Admin Deletion");
								}	
							}
						}
						break;
					case 5:
						movie_service.new_movie_add();

						break;
						
					case 6:
						movie_service.movie_update();
						break;
						
					case 7:
						
						movie_service.movie_dashboard();
						break;
						
						
					case 8:
						movie_service.view_All_movie_details();
						break;
					case 9:
						movie_service.movie_delete();
						break;
						
						
					default:
						System.err.println("Exit");
						System.err.println("==========================================================================");
					}
					
					
					System.out.println("Please Enter the choice:-");
				  }while(Adminpanelchoice<=8);
			}
			else {
				System.err.println("Invalid Admin Credentials");
				System.err.println("==========================================================================");
			}
				
			}
		
		else {
			System.out.println("No Admin are present");
		}
	}	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	
	

}
