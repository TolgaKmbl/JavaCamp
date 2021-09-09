package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.SocialMediaAccService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAccess.abstracts.SocialMediaAccDao;
import kodlama.io.hrms.entities.concretes.SocialMediaAccount;

@Service
public class SocialMediaAccManager implements SocialMediaAccService{

	private SocialMediaAccDao socialMediaAccDao;
	private JobSeekerDao jobseekerDao;
	@Autowired
	public SocialMediaAccManager(SocialMediaAccDao socialMediaAccDao,JobSeekerDao jobseekerDao) {
		super();
		this.socialMediaAccDao = socialMediaAccDao;
		this.jobseekerDao=jobseekerDao;
	}

	@Override
	public DataResult<List<SocialMediaAccount>> getAll() {
		return new SuccessDataResult<List<SocialMediaAccount>>(this.socialMediaAccDao.findAll());
	}

	@Override
	public DataResult<SocialMediaAccount> getById(int id) {
		return new SuccessDataResult<SocialMediaAccount>(this.socialMediaAccDao.findById(id).get());
	}

	@Override
	public Result add(int id,SocialMediaAccount socialMedia) {
		socialMedia.setJobseeker(this.jobseekerDao.findById(id).get());
		this.socialMediaAccDao.save(socialMedia);
		return new SuccessResult("added");
	}

	@Override
	public Result update(SocialMediaAccount socialMedia) {
		this.socialMediaAccDao.save(socialMedia);
		return new SuccessResult("updated");
	}

	@Override
	public Result delete(int id) {
		this.socialMediaAccDao.deleteById(id);;
		return new SuccessResult("deleted");
	}

}
