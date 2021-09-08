package kodlama.io.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.mockWebService.MockHrmsPersonnelVerification;

@Service
public class HrmsPersonnelVerificationAdapter implements HrmsPersonnelVerificationService{

	@Override
	public boolean isRealEmployer(Employer employer) {
		MockHrmsPersonnelVerification hrmsPersonnelVerification = new MockHrmsPersonnelVerification();
		try {
			hrmsPersonnelVerification.isRealEmployer(employer);
			return true;
		} catch (Exception e){
			return false;
		}		
		
	}

}
