package kodlama.io.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.mockWebService.MockUserVerification;

@Service
public class UserVerificationAdapter implements UserVerificationService {
	
	@Override
	public boolean isRealPerson(JobSeeker jobSeeker) {
		MockUserVerification mockUserVerification = new MockUserVerification();
		
		try {
			mockUserVerification.isRealPerson(Long.parseLong(jobSeeker.getIdentityNumber()), 
					jobSeeker.getFirstName(), 
					jobSeeker.getLastName(), 
					jobSeeker.getBirthYear());	
			return true;
		} catch (Exception e){
			return false;
		}		
		
	}
	
}
