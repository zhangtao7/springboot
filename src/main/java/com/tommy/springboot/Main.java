package com.tommy.springboot;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static final String URL="jdbc:mysql://192.168.56.101:3306/uckefu?characterEncoding=utf8&useSSL=false";
	public static final String USER="root";
	public static final String PASSWORD="123456";
	
	
    public static  Connection getConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
	 public static void change(String str){
         str = "welcome";
     }

	public static void main(String[] args) {
//		String str = "1234";
//        change(str);
//        System.out.println(str);
		
		try {
			System.out.println(Main.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
	 private static class Null{
	        public static void hello(){
	            System.out.println("hello");
	        }
	        public static void main(String[] args) {
	            ((Null)null).hello();
	            Null _null = (Null)null;
	            _null.hello();
	        }
	    }
}
