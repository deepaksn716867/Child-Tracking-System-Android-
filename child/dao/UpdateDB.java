package com.child.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class UpdateDB {
	public int a=1;
	
	
	Connection conn = ConnectionManager.getConnection();
	
	public void updateLoc(String latitude,String longitude){
		try {
			 int b=++a;
			Statement st = conn.createStatement();
			st.execute("INSERT INTO locations(sno,latitude,longitude) values('"+b+"','"+latitude+"','"+longitude+"')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateIcMsg(String sender,String content,String timestamp){
		try {
			Statement st = conn.createStatement();
			st.execute("INSERT INTO inmsg(sender,content,timestamp) values('"+sender+"','"+content+"','"+timestamp+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateOgMsg(String receiver,String content,String timestamp){
		try {
			Statement st = conn.createStatement();
			st.execute("INSERT INTO ogmsg(receiver,content,timestamp) values('"+receiver+"','"+content+"','"+timestamp+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateMissCl(String caller, String timestamp) {
		
		// TODO Auto-generated method stub
		
		try {
			Statement st = conn.createStatement();
			st.execute("INSERT INTO misscl(caller,timestamp) values('"+caller+"','"+timestamp+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateInCall(String caller, String duration, String timestamp) {
		// TODO Auto-generated method stub
		try {
			Statement st = conn.createStatement();
			st.execute("INSERT INTO incall(caller,duration,timestamp) values('"+caller+"','"+duration+"','"+timestamp+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateOutCall(String caller, String duration, String timestamp) {
		// TODO Auto-generated method stub
		try {
			Statement st = conn.createStatement();
			st.execute("INSERT INTO outcall(caller,duration,timestamp) values('"+caller+"','"+duration+"','"+timestamp+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
