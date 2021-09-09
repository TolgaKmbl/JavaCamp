package kodlama.io.hrms.core.verification.abstracts;
import kodlama.io.hrms.entities.concretes.User;

public interface VerificationCodeService {

	boolean sendEmail(User user);
}
