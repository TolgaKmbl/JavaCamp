package User.dataAccess.concretes;

import User.dataAccess.abstracts.UserDao;
import User.entitites.concretes.Users;

public class UserActionsDao implements UserDao{

	@Override
	public void signIn(Users user) {
		System.out.println("We have send an e-mail to your address " + user.getMail());		
	}

	@Override
	public void logIn(Users user) {
		System.out.println(user.getMail() + " has succesfully logged in.");
	}

	@Override
	public void deleteUser(Users user) {
		System.out.println(user.getMail() + " has deleted.");
		user.setFirstName(null);
		user.setId(0);
		user.setLastName(null);
		user.setMail(null);
		user.setPassword(null);		
	}

}
