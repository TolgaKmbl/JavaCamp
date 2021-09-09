package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CoverLetterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.CoverLetter;
@Service
public class CoverLetterManager implements  CoverLetterService{

	private CoverLetterDao coverLetterDao;
	private JobSeekerDao jobseekerDao;
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao,JobSeekerDao jobseekerDao) {
		super();
		this.coverLetterDao = coverLetterDao;
		this.jobseekerDao=jobseekerDao;
	}
	@Override
	public DataResult<List<CoverLetter>> getAll() {
		
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll(),"listelendi.");
	}

	

	@Override
	public DataResult<CoverLetter> getById(int id) {
		return new SuccessDataResult<CoverLetter>(this.coverLetterDao.findById(id).get());
	}

	@Override
	public Result add(int id, CoverLetter coverLetter) {
		coverLetter.setJobseeker(this.jobseekerDao.findById(id).get());
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("cover letter added");
	}

	@Override
	public Result update(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("cover letter updated");
	}

	@Override
	public Result delete(int id) {
		this.coverLetterDao.deleteById(id);
		return new SuccessResult("cover letter deleted");
	}

}
