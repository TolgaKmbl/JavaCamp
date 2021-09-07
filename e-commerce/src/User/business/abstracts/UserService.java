package User.business.abstracts;

import User.entitites.concretes.Users;

public interface UserService {

	boolean mailVerification(Users user);
	boolean passwordVerification(Users user);
	boolean nameVerification(Users user);
	void sigIn(Users user);
	void logIn(Users user);
	void signInWithGoogle(Users user);
	void deleteUser(Users user);
	
}
