package kodlama.io.hrms.core.verification.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.verification.abstracts.MernisCheckService;

import kodlama.io.hrms.entities.concretes.JobSeeker;
@Service
public class MernisCheckManager implements MernisCheckService{

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return true;
	}


}
