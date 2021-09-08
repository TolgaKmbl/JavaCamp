package kodlama.io.hrms.core.adapters;

import kodlama.io.hrms.entities.abstracts.User;

public interface EmailVerificationService {
	
	boolean isRealEmail(User user);
}
