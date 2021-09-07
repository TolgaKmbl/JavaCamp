package User.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import User.business.abstracts.UserService;
import User.core.GoogleService;
import User.dataAccess.abstracts.UserDao;
import User.dataAccess.concretes.UserActionsDao;
import User.entitites.concretes.Users;

public class UserManager implements UserService {

	List<String> mailList = new ArrayList<String>();
	List<Users> userList = new ArrayList<Users>();
	
	private UserDao userDao;
	private GoogleService googleService;
	
	public UserManager(UserDao userDao,GoogleService googleService) {
		super();
		this.userDao = userDao;
		this.googleService=googleService;
	}

	@Override
	public boolean mailVerification(Users user) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getMail());
		if(matcher.matches()==true && mailList.contains(user.getMail())==false){
			mailList.add(user.getMail());
			return true;
		}
		else{
			return false;
		}
	}


	@Override
	public boolean passwordVerification(Users user) {
		String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9\\\\s]).{6,}"; 
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getPassword());
		if(matcher.matches()==true){
			return true;
		}
		else{
			return false;
		}
	}	
	
	@Override
	public boolean nameVerification(Users user) {
		String regex = "[0-9a-zA-Z]{2,}";
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getFirstName());
	    Matcher matcherLastName = pattern.matcher(user.getLastName());
		if(matcher.matches()==true && matcherLastName.matches()==true){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean gmailVerification(Users user) {
		String regex = "^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$";
		Pattern pattern = Pattern.compile(regex);

	    Matcher matcher = pattern.matcher(user.getMail());
		if(matcher.matches()==true && mailList.contains(user.getMail())==false)
		{
			mailList.add(user.getMail());
			return true;
		}
		else
		{
			return false;
		}
	}


	@Override
	public void sigIn(Users user) {
		if(mailVerification(user)==true && nameVerification(user)==true && passwordVerification(user)==true){
			this.userDao.signIn(user);
			userList.add(user);
		}
		else {
			System.out.println("Please Fill in all the Information");
		}
		
	}

	@Override
	public void logIn(Users user) {
		if(userList.contains(user) && user.getMail() != null && user.getPassword() != null){
			this.userDao.logIn(user);
		}
		else {
			System.out.println("Incorrect Email or Password");
		}		
	}

	@Override
	public void signInWithGoogle(Users user) {
		if(gmailVerification(user) == true && nameVerification(user)==true && passwordVerification(user)==true){
			this.googleService.signInWithGoogle(user);
			userList.add(user);
		}
		else {
			System.out.println("Please Sign in with Your Google Account.");
		}
		
		
	}
	
	public void deleteUser(Users user) {
		if(userList.contains(user)) {
			this.userDao.deleteUser(user);
		} else {
			System.out.println("You have not signed in already !");
		}
	}



}
