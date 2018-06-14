import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InsertingData extends HttpServlet{
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
        try{
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      out.println(username);
      out.println(password);
      Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
      PreparedStatement pst = con.prepareStatement("insert into emp_info values(?,?)");
      pst.setString(1,username);
      pst.setString(2,password);
      int i = pst.executeUpdate();
      if(i!=0){
        out.println("<br>Record has been inserted");
      }
      else{
        out.println("failed to insert the data");
      }
    }
    catch (Exception e){
      out.println(e);
    }
  }
}