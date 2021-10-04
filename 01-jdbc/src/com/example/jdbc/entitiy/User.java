package com.example.jdbc.entitiy;

public class User extends Entitiy {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	private String website;
	private Address address;
	private Company company;

	public User() {

	}

	public User(String name, String email, String phone, String website, Address address,
			Company company) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.website = website;
		this.address = address;
		this.company = company;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", website=" + website
				+ ", address=" + address + ", company=" + company + "]";
	}


}
