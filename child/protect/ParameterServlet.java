package com.child.protect;

import com.child.dao.UpdateDB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterServlet
 */

public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UpdateDB updb =  new UpdateDB();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParameterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag").toString();
		
		int flag_value = Integer.parseInt(flag);
		System.out.println(flag_value);
		if(flag_value == 0){
			// for co-ordinates 
			System.out.println(request.getParameter("latitude").toString());
			String latitude = request.getParameter("latitude").toString();
			String temp_lang = latitude.substring(0,6);
			String longitude = request.getParameter("longitude").toString();
			String temp_long = longitude.substring(0,6);
			
			updb.updateLoc(temp_lang, temp_long);//, timestamp);
			}if(flag_value == 1){
				//incoming msg
				String sender = request.getParameter("sender").toString();
				String content = request.getParameter("content").toString();
				String timestamp = request.getParameter("timestamp").toString();
				System.out.println(timestamp);
				updb.updateIcMsg(sender, content, timestamp);
				}if(flag_value == 2){
					//outgoing msg
					String receiver = request.getParameter("receiver").toString();
					String content = request.getParameter("content").toString();
					String timestamp = request.getParameter("timestamp").toString();
					System.out.println("content"+content);
					updb.updateOgMsg(receiver, content, timestamp);
			
					}if(flag_value == 3){
						//missed call
						String caller = request.getParameter("caller").toString().trim();
						String timestamp = request.getParameter("timestamp").toString().trim();
						System.out.println(caller+timestamp);
						updb.updateMissCl(caller, timestamp);
						
						}if(flag_value == 4){
							//incoming call
							String caller = request.getParameter("caller").toString();
							String duration = request.getParameter("duration").toString();
							String timestamp = request.getParameter("timestamp").toString();
							updb.updateInCall(caller, duration, timestamp);
							
							}if(flag_value == 5){
								//outgoing call
								String caller = request.getParameter("caller").toString();
								String duration = request.getParameter("duration").toString();
								String timestamp = request.getParameter("timestamp").toString();
								updb.updateOutCall(caller, duration, timestamp);
							}
		
		
	}

}
