package org.alexeykozel.model;

import java.util.Date;
import java.util.Calendar;

public class Customer {

	private long id;

	private String firstname;

	private String lastname;

	private String email;

	private String sex;

	private Date birthdate;

	public Customer() {

	}

	public Customer(String firstname, String lastname, String email, String sex, Date birtdate ) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.sex = sex;
		this.birthdate = birtdate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public int getAge() {
		if (birthdate == null) {
			return 0;
		} else {
			return getDiffYears(birthdate);
		}
	}
	
	public static int getDiffYears(Date last) {
		Date first = new Date();
		Calendar birth = Calendar.getInstance();
		birth.setTime(last);
		Calendar curr = Calendar.getInstance();
		curr.setTime(first);
		int diff = curr.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
		if (birth.get(Calendar.MONTH) > curr.get(Calendar.MONTH)
				|| (birth.get(Calendar.MONTH) == curr.get(Calendar.MONTH) && birth
						.get(Calendar.DATE) > curr.get(Calendar.DATE))) {
			diff--;
		}
		return diff;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", sex="
				+ sex + ", birthdate=" + birthdate + "]";
	}

}
