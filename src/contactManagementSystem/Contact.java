package contactManagementSystem;

public class Contact {
	private int id;
	private String name;
	private String phoneNo;
	private String email;
	


	public Contact(int id,String name,String phoneNo,String email){
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "ID : "+this.id+ " Name : "+ this.name+" Phone No : "+this.phoneNo+" Email: "+ this.email;
	}
}
