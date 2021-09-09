package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.SkillJobseekerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAccess.abstracts.SkillJobseekerDao;
import kodlama.io.hrms.entities.concretes.SkillJobseeker;
@Service
public class SkillJobseekerManager implements SkillJobseekerService{

	private SkillJobseekerDao skillJobseekerDao;
	private JobSeekerDao jobseekerDao;
	@Autowired
	public SkillJobseekerManager(SkillJobseekerDao skillJobseekerDao, JobSeekerDao jobseekerDao) {
		super();
		this.skillJobseekerDao = skillJobseekerDao;
		this.jobseekerDao = jobseekerDao;
	}

	@Override
	public DataResult<List<SkillJobseeker>> getAll() {
		return new SuccessDataResult<List<SkillJobseeker>>(this.skillJobseekerDao.findAll());
	}

	@Override
	public DataResult<SkillJobseeker> getById(int id) {
		return new SuccessDataResult<SkillJobseeker>(this.skillJobseekerDao.findById(id).get());
	}

	@Override
	public Result add(int id, SkillJobseeker skillJobseeker) {
		skillJobseeker.setJobseeker(this.jobseekerDao.findById(id).get());
		return new SuccessResult("eklendi");
	}

	@Override
	public Result update(SkillJobseeker skillJobseeker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		this.skillJobseekerDao.deleteById(id);
		return new SuccessResult("deleted");
	}

}
