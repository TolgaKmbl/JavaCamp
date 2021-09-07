package User.jGoogle;

import User.entitites.concretes.Users;

public class jGoogleManager {
	
	public void signIn(Users user)
	{
		System.out.println(user.getFirstName()+" signed in with a Google account.");
	}
	

}
