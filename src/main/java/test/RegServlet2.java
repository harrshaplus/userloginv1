package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/reg2")
public class RegServlet2 extends GenericServlet{
 public void service(ServletRequest req,ServletResponse res)throws
 ServletException,IOException{
 PrintWriter pw = res.getWriter();
 res.setContentType("text/html");
 ServletContext sct = this.getServletContext();
 //Accessing the reference of ServletContext object
 UserBean ub = (UserBean)sct.getAttribute("bean");//getting attribute
 ub.setAddr(req.getParameter("addr"));
 ub.setPhNo(Long.parseLong(req.getParameter("phno")));
 ub.setmId(req.getParameter("mid"));
 int k = new InsertDAO().insert(ub);
 if(k>0){
 pw.println("User registered Successfully...<br>");
 RequestDispatcher rd = req.getRequestDispatcher("login.html");
 rd.include(req,res);
 }
 }
}
