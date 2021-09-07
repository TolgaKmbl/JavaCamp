package User.core;

import User.entitites.concretes.Users;
import User.jGoogle.jGoogleManager;

public class jGoogleManagerAdapter implements GoogleService {

	@Override
	public void signInWithGoogle(Users user) {
		jGoogleManager googleManager=new jGoogleManager();
		googleManager.signIn(user);
	}

}
