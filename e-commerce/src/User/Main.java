package User;

import User.business.abstracts.UserService;
import User.business.concretes.UserManager;
import User.core.jGoogleManagerAdapter;
import User.dataAccess.abstracts.UserDao;
import User.dataAccess.concretes.UserActionsDao;
import User.entitites.concretes.Users;

public class Main {

	public static void main(String[] args) {
	
		UserService userService= new UserManager(new UserActionsDao(),new jGoogleManagerAdapter());
		Users tolga1 = new Users(1,"tolga","kumbul","deneme1@gmail.com","5pO115-");
		Users tolga2 = new Users(1,"tolga","kumbul","deneme2@gmail.com","5p9115-");
		Users tolga3 = new Users(1,"tolga","kumbul","deneme3@hotmail.com","5p8315-");
		Users tolga4 = new Users(1,"tolga","kumbul","deneme4@gmail.com","123144");
		Users tolga5 = new Users(1,"tolga","kumbul","deneme5@gmail.com","1Ab-");
		Users tolga6 = new Users(1,"a","bb","deneme6@gmail.com","5p8315-");

		userService.sigIn(tolga1);
		userService.signInWithGoogle(tolga2);
		userService.signInWithGoogle(tolga3);
		userService.logIn(tolga1);
		userService.logIn(tolga2);
		userService.logIn(tolga3);
		
		userService.deleteUser(tolga2);
		userService.logIn(tolga2);
		
		userService.sigIn(tolga4);
		userService.sigIn(tolga5);
		userService.sigIn(tolga6);
	}

}
