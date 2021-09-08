package kodlama.io.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.adapters.EmailVerificationService;
import kodlama.io.hrms.core.adapters.HrmsPersonnelVerificationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	List<String> mailList = new ArrayList<String>();
	
	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private HrmsPersonnelVerificationService hrmsPersonnelVerificationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,
			EmailVerificationService emailVerificationService,
			HrmsPersonnelVerificationService hrmsPersonnelVerificationService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.hrmsPersonnelVerificationService = hrmsPersonnelVerificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers succesfully returned.");
	}

	@Override
	public Result add(Employer employer) {
		if(emailVerificationService.isRealEmail(employer) == true
				&& mailList.contains(employer.getEmail())==false
				&& hrmsPersonnelVerificationService.isRealEmployer(employer) == true) {			
			mailList.add(employer.getEmail());
			this.employerDao.save(employer);
			return new SuccessResult("Employer added.");
		} else 
		{
			return new ErrorResult("Something went wrong");
		}
	}

}
