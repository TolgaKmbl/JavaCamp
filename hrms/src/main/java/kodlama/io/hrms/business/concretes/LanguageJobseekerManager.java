package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.LanguageJobseekerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAccess.abstracts.LanguageJobseekerDao;
import kodlama.io.hrms.entities.concretes.LanguageJobseeker;
@Service
public class LanguageJobseekerManager implements  LanguageJobseekerService{

	private LanguageJobseekerDao languageJobseekerDao;
	private JobSeekerDao jobseekerDao;
	@Autowired
	public LanguageJobseekerManager(LanguageJobseekerDao languageJobseekerDao, JobSeekerDao jobseekerDao) {
		super();
		this.languageJobseekerDao = languageJobseekerDao;
		this.jobseekerDao = jobseekerDao;
	}

	@Override
	public DataResult<List<LanguageJobseeker>> getAll() {
		return new SuccessDataResult<List<LanguageJobseeker>>(this.languageJobseekerDao.findAll());
	}

	@Override
	public DataResult<LanguageJobseeker> getById(int id) {
		return new SuccessDataResult<LanguageJobseeker>(this.languageJobseekerDao.findById(id).get());
	}

	@Override
	public Result add(int id,LanguageJobseeker languageJobseeker) {
		languageJobseeker.setJobseeker(this.jobseekerDao.findById(id).get());
		this.languageJobseekerDao.save(languageJobseeker);
		return new SuccessResult("eklendi");
	}

	@Override
	public Result update(LanguageJobseeker languageJobseeker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		var result=this.languageJobseekerDao.findById(id);
		if(!result.isPresent()) {
			return new ErrorResult("böyle bir id yok");
		}
		this.languageJobseekerDao.deleteById(id);
		return new SuccessResult("silindi");
		
	}

}
