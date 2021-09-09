package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.ResumeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ResumeDao;
import kodlama.io.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService{

	ResumeDao resumeDao;
	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		super();
		this.resumeDao = resumeDao;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll());
	}

	@Override
	public DataResult<Resume> getById(int id) {
		return new SuccessDataResult<Resume>(this.resumeDao.findById(id).get());
	}

	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("added");
	}

	@Override
	public Result update(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("updated");
	}

	@Override
	public Result delete(int id) {
		this.resumeDao.deleteById(id);
		return new SuccessResult("deleted");
	}

	/*@Override
	public DataResult<ResumeDto> getResumeDto(int id) {
		return new SuccessDataResult<ResumeDto>(this.resumeDao.getResumeDto(id));
	}*/

	@Override
	public DataResult<Resume> getByJobseekerId(int id) {
		return new SuccessDataResult<Resume>(this.resumeDao.getByJobseeker_Id(id));
	}

	
}
