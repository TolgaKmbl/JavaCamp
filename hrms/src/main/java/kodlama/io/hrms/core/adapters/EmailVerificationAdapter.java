package kodlama.io.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.entities.abstracts.User;
import kodlama.io.hrms.mockWebService.MockEmailVerification;

@Service
public class EmailVerificationAdapter implements EmailVerificationService {

	@Override
	public boolean isRealEmail(User user) {
		MockEmailVerification emailVerification = new MockEmailVerification();
		try {
			emailVerification.isRealEmail(user.getEmail());	
			return true;
		} catch (Exception e){
			return false;
		}	
	}

}
