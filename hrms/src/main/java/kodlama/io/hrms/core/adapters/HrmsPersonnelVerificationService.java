package kodlama.io.hrms.core.adapters;

import kodlama.io.hrms.entities.concretes.Employer;

public interface HrmsPersonnelVerificationService {
	
	boolean isRealEmployer(Employer employer);
}
