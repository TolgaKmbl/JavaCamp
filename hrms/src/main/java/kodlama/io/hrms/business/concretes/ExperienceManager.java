package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.ExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ExperienceDao;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService{

	ExperienceDao experienceDao;
	JobSeekerDao jobseekerDao;
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao, JobSeekerDao jobseekerDao) {
		super();
		this.experienceDao = experienceDao;
		this.jobseekerDao=jobseekerDao;
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(),"listed.");
	}

	@Override
	public DataResult<Experience> getById(int id) {
		return new SuccessDataResult<Experience>(this.experienceDao.findById(id).get(),".");
	}

	@Override
	public Result add(Experience experience,int id) {
		experience.setJobseeker(this.jobseekerDao.findById(id).get());
		this.experienceDao.save(experience);
		return new SuccessResult("ekleme yapıldı");
	}

	@Override
	public Result update(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("update yapıldı");
	}

	@Override
	public Result delete(int id) {
		this.experienceDao.deleteById(id);
		return new SuccessResult("delete yapıldı");
	}

}
