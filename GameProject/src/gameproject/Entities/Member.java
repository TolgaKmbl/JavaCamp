package gameproject.Entities;

public class Member {
private String email;
private String password;
private String firstName;
private String lastName;
private int dateOfBirth;
private String nationalId;
private int balance;

public Member(String email, String password, String firstName, String lastName, int dateOfBirth, String nationalId,int balance) {
	super();
	this.email = email;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.nationalId = nationalId;
	this.balance=balance;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public int getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(int dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

public String getNationalId() {
	return nationalId;
}

public void setNationalId(String nationalId) {
	this.nationalId = nationalId;
}


public int getBalance() {
	return balance;
}


public void setBalance(int balance) {
	this.balance = balance;
}



}
