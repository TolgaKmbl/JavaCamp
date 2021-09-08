package kodlama.io.hrms.core.adapters;

import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface UserVerificationService {
	
	boolean isRealPerson(JobSeeker jobSeeker);
}
