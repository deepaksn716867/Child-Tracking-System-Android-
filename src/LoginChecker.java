
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginChecker extends HttpServlet {
    
     Connection con;
    Statement st;
    ResultSet rs;

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
             String user=request.getParameter("user");
                String pass=request.getParameter("pass"); 
                String url="jdbc:mysql://instance38152.db.xeround.com:6198/cps";
            
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(url,"admin","admin");
                st=con.createStatement();
                rs=st.executeQuery("select * from userlogin");
                boolean flag=false;
                
                while(rs.next())
                {
                   String dbuser=rs.getString(1);
                   String dbpass=rs.getString(2);
                   if(user.equalsIgnoreCase(dbuser)&&pass.equals(dbpass))
                   {
                       flag=true;
                       break;
                   }
                    
                }
                if(flag)
                {
                   response.sendRedirect("ChildLogs.html"); 
                }
                else
                {
                    response.sendRedirect("index.jsp?result=invalid");
                }
                
           
        }
         catch (ClassNotFoundException ex)
       {
           Logger.getLogger(LoginChecker.class.getName()).log(Level.SEVERE, null, ex);
       }
        finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
		