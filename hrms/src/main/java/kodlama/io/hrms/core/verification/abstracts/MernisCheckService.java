package kodlama.io.hrms.core.verification.abstracts;

import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface MernisCheckService {

	boolean checkIfRealPerson(JobSeeker jobSeeker);
}
