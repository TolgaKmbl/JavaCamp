package kodlama.io.hrms.core.verification.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.verification.abstracts.VerificationCodeService;
import kodlama.io.hrms.entities.concretes.User;
@Service
public class VerificationCodeManager implements VerificationCodeService{

	@Override
	public boolean sendEmail(User user) {
		
		return true;
	}

}
