package Bean;

public class EmployeeDetails {
	private String Username;
	private int empid;
	private String repTo;
	private String repToTitle;
	private String[] officeaddress;
	public String[] getOfficeaddress() {
		return officeaddress;
	}
	public void setOfficeaddress(String[] officeaddress) {
		this.officeaddress = officeaddress;
	}
	public String getRepToTitle() {
		return repToTitle;
	}
	public void setRepToTitle(String repToTitle) {
		this.repToTitle = repToTitle;
	}
	private String Password;
	private String firstName;
	private String lastName;
	private String email;
	private String empNumber;
	private int officeCode;
	private String jobTitle;
	private String ext;
	
	public String getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}
	public int getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(int officeCode) {
		this.officeCode = officeCode;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		this.Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getRepTo() {
		return repTo;
	}
	public void setRepTo(String repTo) {
		this.repTo = repTo;
	}
	

}
