package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.EmployeeDetails;
public class ConsoleEmployeeDetailsModel {
	String repTo,repToTitle;
	String[] officeaddress=new String[5];
	int i=0;
	public static String url = "jdbc:mysql://us-cdbr-azure-west-c.cloudapp.net:3306/acsm_90810a19358144c?useSSL=false";
	public static String username = "b475de1c4476f1";
	public static String password = "a5706aa1";
	public ArrayList<EmployeeDetails> employeeDetails(EmployeeDetails b)
	 {
		ArrayList<EmployeeDetails> obj=new ArrayList<EmployeeDetails>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection(url,username,password);
			PreparedStatement st=c.prepareStatement("select * from employees where email=?");
			PreparedStatement st1=c.prepareStatement("select firstName,lastName,jobTitle from employees where employeeNumber=?");
			PreparedStatement st2=c.prepareStatement("select addressLine1,addressLine2,city,state,country from offices where officeCode=?");
			System.out.println("Email: " +b.getEmail());
			st.setString(1, b.getEmail());				
	    	ResultSet rs =st.executeQuery();
	    	rs.next();
	    	st1.setString(1, rs.getString(8));
	    	st2.setInt(1, rs.getInt(7));
	    	ResultSet rs1=st1.executeQuery();
	    	rs1.next();
	    	ResultSet rs2=st2.executeQuery();
	    	rs2.next();
	    	if(rs1.getString(2).isEmpty())
	    		repTo="Self";
	    	else
	    		repTo=rs1.getString(1)+" "+rs1.getString(2);	
	    		
	    		
	    	repToTitle=rs1.getString(3);
	    	officeaddress[0]=rs2.getString(1);
	    	officeaddress[1]=rs2.getString(2);
	    	officeaddress[2]=rs2.getString(3);
	    	officeaddress[3]=rs2.getString(4);
	    	officeaddress[4]=rs2.getString(5);
	    	b.setFirstName(rs.getString(3));
	    	b.setLastName(rs.getString(2));
	    	b.setUsername(rs.getString(3)+" "+rs.getString(2));
	    	b.setEmail(rs.getString(5));
	    	b.setEmpNumber(rs.getString(1));
	    	b.setExt(rs.getString(4));
	    	b.setOfficeCode(rs.getInt(7));
	    	b.setRepTo(repTo);
	    	b.setRepToTitle(repToTitle);
	    	b.setJobTitle(rs.getString(9));
	    	
	    	b.setOfficeaddress(officeaddress);
	    	obj.add(b);
	    	
	    	
	    	st2.close();
	    	st1.close();
			st.close();
			c.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
	 }
	public ArrayList<ArrayList<EmployeeDetails>> allEmployeeDetails(EmployeeDetails b, String s)
	 {
		ArrayList<ArrayList<EmployeeDetails>> str=new ArrayList<ArrayList<EmployeeDetails>>();
		ArrayList<EmployeeDetails> obj2=new ArrayList<EmployeeDetails>();
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","Rohit");
			PreparedStatement st3=c.prepareStatement("select * from employees where email!=?");
			st3.setString(1, s);
			ResultSet rs4=st3.executeQuery();
			while(rs4.next()){
			rs4.getString(5);
			PreparedStatement st=c.prepareStatement("select * from employees where email=?");
			PreparedStatement st1=c.prepareStatement("select firstName,lastName,jobTitle from employees where employeeNumber=?");
			PreparedStatement st2=c.prepareStatement("select addressLine1,addressLine2,city,state,country from offices where officeCode=?");
			System.out.println("Email: " +rs4.getString(5));
			st.setString(1, b.getEmail());				
	    	ResultSet rs =st.executeQuery();
	    	rs.next();
	    	st1.setString(1, rs.getString(8));
	    	st2.setInt(1, rs.getInt(7));
	    	ResultSet rs1=st1.executeQuery();
	    	rs1.next();
	    	ResultSet rs2=st2.executeQuery();
	    	rs2.next();
	    	repTo=rs1.getString(1)+" "+rs1.getString(2);
	    	repToTitle=rs1.getString(3);
	    	officeaddress[0]=rs2.getString(1);
	    	officeaddress[1]=rs2.getString(2);
	    	officeaddress[2]=rs2.getString(3);
	    	officeaddress[3]=rs2.getString(4);
	    	officeaddress[4]=rs2.getString(5);
	    	b.setFirstName(rs.getString(3));
	    	b.setLastName(rs.getString(2));
	    	b.setUsername(rs.getString(5));
	    	b.setEmail(rs.getString(5));
	    	b.setEmpNumber(rs.getString(1));
	    	b.setExt(rs.getString(4));
	    	b.setOfficeCode(rs.getInt(7));
	    	b.setRepTo(repTo);
	    	b.setRepToTitle(repToTitle);
	    	b.setJobTitle(rs.getString(9));
	    	
	    	b.setOfficeaddress(officeaddress);
	    	obj2.add(b);
				
	    	str.add(obj2);
	    	st2.close();
	    	st1.close();
			st.close();
				}
			st3.close();
			c.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return str;
	 }
	    	
	    	
	    	
	 
}
