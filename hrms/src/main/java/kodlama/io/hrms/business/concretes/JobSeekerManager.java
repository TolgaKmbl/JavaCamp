package kodlama.io.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.adapters.EmailVerificationService;
import kodlama.io.hrms.core.adapters.UserVerificationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	
	List<String> mailList = new ArrayList<String>();
	List<String> identityNumber = new ArrayList<String>();
	
	private JobSeekerDao jobSeekerDao;
	private UserVerificationService userVerificationService;
	private EmailVerificationService emailVerificationService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, 
			UserVerificationService userVerificationService, 
			EmailVerificationService emailVerificationService) 
	{
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userVerificationService = userVerificationService;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Users succesfully returned.");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {	
		if(userVerificationService.isRealPerson(jobSeeker)  == true 
				&& emailVerificationService.isRealEmail(jobSeeker) == true
				&& mailList.contains(jobSeeker.getEmail())==false
				&& identityNumber.contains(jobSeeker.getIdentityNumber())==false) 
		{ 
			identityNumber.add(jobSeeker.getIdentityNumber());
			mailList.add(jobSeeker.getEmail());
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("User added.");	
		} 
		else 
		{
			return new ErrorResult("Something went wrong");
		}
				
	}

}
