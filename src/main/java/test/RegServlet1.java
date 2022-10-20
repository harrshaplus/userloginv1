package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/reg1")
public class RegServlet1 extends GenericServlet{
 public void service(ServletRequest req,ServletResponse res)throws
 ServletException,IOException{
 UserBean ub = new UserBean();//Bean Object
 ub.setuName(req.getParameter("uname"));
 ub.setpWord(req.getParameter("pword"));
 ub.setfName(req.getParameter("fname"));
 ub.setlName(req.getParameter("lname"));
 ServletContext sct = this.getServletContext();
 //Accessing the reference of ServletContext
 sct.setAttribute("bean",ub);//Adding attribute to ServletContext
 RequestDispatcher rd = req.getRequestDispatcher("reg2.html");
 rd.forward(req,res);
 }
}