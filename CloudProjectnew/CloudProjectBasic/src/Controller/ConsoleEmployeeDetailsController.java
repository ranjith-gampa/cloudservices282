package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.EmployeeDetails;
import Model.ConsoleEmployeeDetailsModel;

/**
 * Servlet implementation class ConsoleTesterDetailsController
 */
@WebServlet("/ConsoleEmployeeDetailsController")
public class ConsoleEmployeeDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsoleEmployeeDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 HttpSession s =  request.getSession(); 
	     String username = (String)s.getAttribute("u");
	     System.out.println("Logged In As:"+username);
	     String email=(String)s.getAttribute("email");
	     EmployeeDetails bean = new EmployeeDetails();
	     //System.out.println(bean.getUsername());
	     bean.setEmail(email);
	     ConsoleEmployeeDetailsModel ref2 = new ConsoleEmployeeDetailsModel();
	     
	     ArrayList<EmployeeDetails> obj =ref2.employeeDetails(bean);
	     
	     
	     
	     
	     request.setAttribute("Em",obj);
	     //Object obj2 = null;
		
	     
	     RequestDispatcher d=request.getRequestDispatcher("EmployeeDetails.jsp");
	     d.forward(request, response);
	     
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
