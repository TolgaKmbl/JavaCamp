package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobService;
import kodlama.io.hrms.core.utilities.business.BusinessRules;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobDao;
import kodlama.io.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}
	@Override
	public Result add(Job job) {
		Result result=BusinessRules.Run(CheckIfNameExist(job.getName()));
		if(result!=null) {
			return result;
		}
		jobDao.save(job);
		return new SuccessResult("job added");
	}
	public Result CheckIfNameExist(String name) {
		List<Job> jobs=jobDao.findAll();
		for(Job job:jobs) {
			if(job.getName().equals(name))
			{
				return new ErrorResult("Name is already exist");
			}
		}
		return new SuccessResult();
	}
	@Override
	public DataResult<List<Job>> getAll() {
		
		return new SuccessDataResult<List<Job>>(jobDao.findAll(),"jobs listed");
	}

}
