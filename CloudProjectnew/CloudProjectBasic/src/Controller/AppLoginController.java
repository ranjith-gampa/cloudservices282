package Controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.*;
import Bean.EmployeeDetails;
import Model.AppLoginModel;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/AppLoginController")
public class AppLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		
		
		if(request.getParameter("user")!=null /*&& request.getParameter("user").equals("Employee")*/)  //Employee Login Control
		  {
			System.out.println("Employee Login Control");
			EmployeeDetails bean = new EmployeeDetails();	
			AppLoginModel l = new AppLoginModel();
			bean.setUsername(request.getParameter("username"));
			bean.setPassword(request.getParameter("password"));
			
			if(l.employeeLogin(bean))
			  {
				System.out.println(bean.getFirstName());
				HttpSession s= request.getSession();
				//HttpSession em=request.getSession();
           	    s.setAttribute("u",bean.getFirstName()+" "+bean.getLastName());
           	    s.setAttribute("email", bean.getEmail());
           	    response.sendRedirect("ConsoleEmployeeHome.jsp");
				System.out.println("Login success...");
				response.getWriter().append("Served at: ").append(request.getContextPath());
			  }
			else
			  {
				System.out.println("Login Failed");
				response.getWriter().append("Login Failed: ").append(request.getContextPath());
			  }
			
		  }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          Bean.Login bean=new Bean.Login();
          bean.setUsername(request.getParameter("user"));
          bean.setPassword(request.getParameter("pass"));
        
                 Model.AppLoginModel lo = new Model.AppLoginModel();
                                 int flag = lo.CheckLogin(bean);
                                      if(flag == 1)
                                        {
                                    	 String us= bean.getUsername(); 
                                    	 HttpSession s= request.getSession();
                                    	 s.setAttribute("u",us);
                                    	
                                         RequestDispatcher d= request.getRequestDispatcher("ConsoleEmployeeHome.jsp");
                                         d.forward(request,response);
                                    	  
                                        }
                                      
		
		  doGet(request, response);
	}

}
