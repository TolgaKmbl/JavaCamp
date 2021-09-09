package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.verification.abstracts.MailCheckService;
import kodlama.io.hrms.core.verification.abstracts.MernisCheckService;
import kodlama.io.hrms.core.verification.abstracts.VerificationCodeService;
import kodlama.io.hrms.core.utilities.business.BusinessRules;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private MernisCheckService mernisCheckService;
	private VerificationCodeService verificationCodeService;
	private MailCheckService mailCheckService;
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService,
			VerificationCodeService verificationCodeService,MailCheckService mailCheckService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisCheckService = mernisCheckService;
		this.verificationCodeService = verificationCodeService;
		this.mailCheckService=mailCheckService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		// TODO Auto-generated method stub
	  
		return new SuccessDataResult<List<JobSeeker>>
		(this.jobSeekerDao.findAll(),"job seeker listed");	
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		Result result=BusinessRules.Run(NullControl(jobSeeker),
				IdentityControl(jobSeeker.getNational_identity()));
		if(result!=null) {
			return result;
		}
		else if(!mernisCheckService.checkIfRealPerson(jobSeeker)) {
			return new ErrorResult("hey men! are you kidding me? you are fake.");
		}
		//else if(!verificationCodeService.sendEmail(jobSeeker)) {
		//	return new ErrorResult("verify your email address and then come back.");
		//}
		//else if(!mailCheckService.checkEmail(jobSeeker.getEmail())) {
		//	return new ErrorResult("Email is not valid.");
		//}
		
			jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Job Seeker Added.");
		
		
	}
	public Result NullControl(JobSeeker jobSeeker) {
		if(jobSeeker.getBirth_date()==null
				||jobSeeker.getLast_name()==null
				||jobSeeker.getUser().getId()==0
				||jobSeeker.getFirst_name()==null
				
				) {
			return new ErrorResult("please fill all the fields.");
		}
		    return new SuccessResult();
		
	}
	public Result IdentityControl(String identity) {
		List<JobSeeker> results=jobSeekerDao.findAll();
		for(JobSeeker result:results) {
			if(result.getNational_identity().equals(identity)) {
				return new ErrorResult("User is already exist!");
			}
		}
		
		return new SuccessResult();
		
	}


}
