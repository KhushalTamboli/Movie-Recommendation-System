package org.movie.recommend.repository;

import java.sql.*;
import java.util.*;

import org.movie.recommend.config.DBHelper;
import org.movie.recommend.model.Admin;
import org.movie.recommend.model.Movie;


public class Movie_Repository extends DBHelper{
	
	//Below method is usefull for add movie in the database and get data from Movie class.
			public boolean isAdd_New_Movie(Movie movie) {


				try {
					stmt=conn.prepareStatement("insert into movieinfo values('0',?,?,?,?)");
					stmt.setString(1,movie.getMovie_name());
					stmt.setString(2,null);
				
					stmt.setString(3,movie.getDateof_release());
					stmt.setString(4,movie.getMovie_budget());
					int value=stmt.executeUpdate();
					return value>0?true:false;
				}
				catch(Exception ex) {
					System.out.println("Error is"+ex);
					return false;
				}
				
			}
		
		
			//this method return the all Movie info.
			   public List<Movie> getAllmovies(){
					   List<Movie>movie_list=new ArrayList<Movie>();

				   try {
					  stmt=conn.prepareStatement("select *from movieinfo");
					  rs=stmt.executeQuery();
					  while(rs.next()) {
						  Movie movie=new Movie();
						  movie.setMovie_id(rs.getInt(1));
						  movie.setMovie_name(rs.getString(2));
						  movie.setDateof_release(rs.getString(4));
						  movie.setMovie_budget(rs.getString(5));
						  
						  movie_list.add(movie);
						  
					  }
					  return movie_list.size()>0?movie_list:null;
				   }
				   catch(Exception ex) {
					   System.out.println("Error is"+ex);
					   return null;
				   }

			   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			// this method is for delete the movie from database.
			   public boolean isDelete_Movie(String delete_movie_name) {


					try {
						int v=stmt.executeUpdate("delete from movieinfo where movie_name='"+delete_movie_name+"'");
//					
						return v>0?true:false;
					}
					catch(Exception ex) {
						System.out.println("Error is"+ex);
						return false;
					}
					
					
					//return false;
				}
			   
			   
			   
			   //this method is for update movie info in database.

			public boolean isUpdate_Movie(String update_movie_name,String update_dateof_release, String update_movie_budget,String New_movie_name) {
			
				try {
					int v=stmt.executeUpdate("update movieinfo set movie_name='"+update_movie_name+"',dateof_release='"+update_dateof_release+"',movie_budget='"+update_movie_budget+"' where movie_name='"+New_movie_name+"'");
				}			

				catch(Exception ex) {
					System.out.println("Error is"+ex);
					return false;
				}
				
				
				
				return false;
			}
			
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
			//Below method is usefull for add category_id and movie_id in moviecategoryjoin table
			public boolean isAdd_movie_category_join(int movie_id,int get_category_id) {


				try {
					stmt=conn.prepareStatement("insert into moviecategoryjoin values(?,?)");
					stmt.setInt(1,get_category_id);
					stmt.setInt(2,movie_id);
				
				
					int value=stmt.executeUpdate();
					return value>0?true:false;
				}
				catch(Exception ex) {
					System.out.println("Error is"+ex);
					return false;
				}
				
			}
			
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
			
			
			//Below method is usefull for add user_id and movie_id in usermoviejoin table
			public boolean isAdd_User_Movie_join(int movie_id,int current_user_id) {


				try {
					stmt=conn.prepareStatement("insert into usermoviejoin values(?,?)");
					stmt.setInt(1,current_user_id);
					stmt.setInt(2,movie_id);
				
				
					int value=stmt.executeUpdate();
					return value>0?true:false;
				}
				catch(Exception ex) {
					System.out.println("Error is"+ex);
					return false;
				}
				
			}	
			
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
			
			
			//Below method is usefull for add user_id , movie_id , rating and review in rating_table table
			public boolean isAdd_rating(int movie_id,int current_user_id,int rating,String reviews) {


				try {
					stmt=conn.prepareStatement("insert into rating_table values(?,?,?,?)");
					stmt.setInt(1,current_user_id);
					stmt.setInt(2,movie_id);
					stmt.setInt(3,rating);
					stmt.setString(4,reviews);
				
				
					int value=stmt.executeUpdate();
					return value>0?true:false;
				}
				catch(Exception ex) {
					System.out.println("Error is"+ex);
					return false;
				}
				
			}
			
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
			
			//this method is usefull for returing the movie which got above 3 rating.
			   public void getAllmovies_above_three_rating(){
					
				   try {
					  stmt=conn.prepareStatement(" select m.movie_name, avg(r.rating) as average_rating, case when avg(r.rating) > 3 then 'good' ELSE 'not good'end as review_value from movieinfo m JOIN rating_table r on m.movie_id = r.movie_id group by m.movie_id, m.movie_name having average_rating > 3");
					   rs=stmt.executeQuery();
					   System.out.println("\tMovie name \t\taverage_rating \t\tReviews_value");
					   System.out.println("__________________________________________________________________________________________________");
					  while(rs.next()) {

						  String Movie_name=rs.getString(1);
						  float average_rating=rs.getFloat(2);
						  String review=rs.getString(3);
						  System.out.println("\t"+Movie_name+"\t\t\t"+average_rating+"\t\t\t"+review+"");
						//  System.out.println("=================================================================================================");
					  }
				   }
				   catch(Exception ex) {
					   System.out.println("Error is"+ex);
			
				   }
			   }
			
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
			
				
				//this method is usefull for returing the movie which got below 3 rating.
				   public void getAllmovies_below_three_rating(){
//						   
					
					   try {
//						  stmt=conn.prepareStatement("select u.user_name,m.movie_name,r.rating,r.review,ct.category_name from userinfo u inner join rating_table r on u.user_id=r.user_id inner join movieinfo m on m.movie_id=r.movie_id inner join moviecategoryjoin mj on mj.movie_id=m.movie_id inner join category_table ct on ct.category_id=mj.category_id where r.rating>3");
						   stmt=conn.prepareStatement("select  m.movie_name, avg(r.rating) AS average_rating, case when avg(r.rating) < 3 then 'bad' ELSE 'not good'end as review_value from movieinfo m JOIN rating_table r on m.movie_id = r.movie_id group by m.movie_id, m.movie_name having average_rating <3");
						   rs=stmt.executeQuery();
						   System.out.println("\tMovie name \t\taverage_rating \t\tReviews_value");
						   System.out.println("__________________________________________________________________________________________________");
						 
						  while(rs.next()) {

							  String Movie_name=rs.getString(1);
							  float average_rating=rs.getFloat(2);
							  String review=rs.getString(3);
							  System.out.println("\t"+Movie_name+"\t\t\t"+average_rating+"\t\t\t"+review+"");
							//System.out.println("=================================================================================================");
						  }
					   }
					   catch(Exception ex) {
						   System.out.println("Error is"+ex);
				
					   }
				   }
			
			
			
			
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
			
					
					//this method is usefull for returing the movie which got  3 rating.
					   public void getAllmovies_which_has_three_rating(){
//					   	   
						
						   try {
//							  stmt=conn.prepareStatement("select u.user_name,m.movie_name,r.rating,r.review,ct.category_name from userinfo u inner join rating_table r on u.user_id=r.user_id inner join movieinfo m on m.movie_id=r.movie_id inner join moviecategoryjoin mj on mj.movie_id=m.movie_id inner join category_table ct on ct.category_id=mj.category_id where r.rating>3");
							   stmt=conn.prepareStatement("select  m.movie_name, avg(r.rating) AS average_rating, case when avg(r.rating) = 3 then 'better' ELSE 'not good'end as review_value from movieinfo m JOIN rating_table r on m.movie_id = r.movie_id group by m.movie_id, m.movie_name having average_rating = 3");
							   rs=stmt.executeQuery();
							   System.out.println("\tMovie name \t\taverage_rating \t\tReviews_value");
							   System.out.println("__________________________________________________________________________________________________");
							 
							  while(rs.next()) {

								  String Movie_name=rs.getString(1);
								  float average_rating=rs.getFloat(2);
								  String review=rs.getString(3);

								  System.out.println("\t"+Movie_name+"\t\t\t"+average_rating+"\t\t\t"+review+"");
									// System.out.println("=================================================================================================");
							  }
						   }
						   catch(Exception ex) {
							   System.out.println("Error is"+ex);
					
						   }
					   }
////////////////////////////////////////////////////////////////////////////////////////////////
					   
					   public void getAllmovies_top3_three_latest(){
						
						
					   try {
						  stmt=conn.prepareStatement("select m.movie_name, m.dateof_release, AVG(r.rating) AS average_rating from movieinfo m join rating_table r ON m.movie_id = r.movie_id where m.dateof_release LIKE '2024%' group by m.movie_id, m.movie_name, m.dateof_release order by average_rating desc limit 3");
						   rs=stmt.executeQuery();
						  
						  while(rs.next()) {

							  String moviename=rs.getString(1);
							  String mrealesedate=rs.getString(2);
							  float rating=rs.getFloat(3);
							//  String review=rs.getString(4);

							  System.out.println("Movie name:- "+moviename+"\nmovie_realse_date:-"+mrealesedate+"\nRating [out of 5]:- "+rating+"\n");
							 // System.out.println("=================================================================================================");
						  }
					   }
					   catch(Exception ex) {
						   System.out.println("Error is"+ex);
				
					   }
				   }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					 //this method is used for latest top three movie with full rating
					   public void getAllmovies_lates_top_three_rating(){
					   try {
						  stmt=conn.prepareStatement("select m.movie_name, m.dateof_release, AVG(r.rating) AS average_rating from movieinfo m join rating_table r ON m.movie_id = r.movie_id where m.dateof_release LIKE '2024%' group by m.movie_id, m.movie_name, m.dateof_release order by average_rating desc limit 3");
						   rs=stmt.executeQuery();
						   System.out.println("\tmovie name \tmovie Release_date \t\tRating [out of 5]");
						   System.out.println("___________________________________________________________________________");
						  while(rs.next()) {
							  
                                
							  String moviename=rs.getString(1);
							  String mreleasedate=rs.getString(2);
							  float rating=rs.getFloat(3);
							  

							 // System.out.println("\nMovie name:- "+moviename+"\nMovie Release_date:-"+mreleasedate+"\nRating [out of 5]:- "+rating+"\n");
							  System.out.println("\t"+moviename+"\t\t"+mreleasedate+"\t\t\t"+rating+"");
							//  System.out.println("=================================================================================================");
						  }
					   }
					   catch(Exception ex) {
						   System.out.println("Error is"+ex);
				
					   }
				   }
					   
///////////////////////////////////////////////////////////////////////////////////////////////
					   public void getAllmovies_movie_recommend_for_user(){
						   try {
							  stmt=conn.prepareStatement("select m.movie_name, watch_stats.watch_count, rating_stats.average_rating from movieinfo m join ( select umj.movie_id, count(umj.user_id) as watch_count from usermoviejoin umj group by umj.movie_id) watch_stats on m.movie_id = watch_stats.movie_id join ( select r.movie_id, avg(r.rating) as average_rating from rating_table r group by r.movie_id) rating_stats on m.movie_id = rating_stats.movie_id order by watch_stats.watch_count desc,rating_stats.average_rating desc limit 7");
							   rs=stmt.executeQuery();
							   System.out.println("\tmovie name \tTotal view \tavarage_rating");
							   System.out.println("_______________________________________________________");
							  while(rs.next()) {
								  
	                                
								  String moviename=rs.getString(1);
								  String Totalview=rs.getString(2);
								  float avarage_rating=rs.getFloat(3);
								  

								  
								  System.out.println("\t"+moviename+"\t\t"+Totalview+"\t\t"+avarage_rating+"");
//								  System.out.println("=================================================================================================");
							  }
						   }
						   catch(Exception ex) {
							   System.out.println("Error is"+ex);
					
						   }
					   }
}
