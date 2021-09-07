package User.dataAccess.abstracts;

import User.entitites.concretes.Users;

public interface UserDao {
	void signIn(Users user);
	void logIn(Users user);
	void deleteUser(Users user);

}
