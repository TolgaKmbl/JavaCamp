package kodlama.io.hrms.core.verification.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.verification.abstracts.AdminCheckService;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class AdminCheckManager implements AdminCheckService{

	@Override
	public boolean isValid(Employer employer) {
		// TODO Auto-generated method stub
		return true;
	}

}
