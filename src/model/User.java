package model;

public class User {
	private String username,password;
	private String hoTen,email,sdt;
	
	public User(String username, String password, String hoTen, String email, String sdt) {
		super();
		this.username = username;
		this.password = password;
		this.hoTen = hoTen;
		this.email = email;
		this.sdt = sdt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", hoTen=" + hoTen + ", email=" + email
				+ ", sdt=" + sdt + "]";
	}

	
}
