package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.VerificationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.VerificationDao;
import kodlama.io.hrms.entities.concretes.Verification;

@Service
public class VerificationManager implements VerificationService {

	private VerificationDao verificationDao;
	@Autowired
	public VerificationManager(VerificationDao verificationDao) {
		super();
		this.verificationDao = verificationDao;
	}

	@Override
	public DataResult<List<Verification>> getAll() {
		return new SuccessDataResult<List<Verification>>(this.verificationDao.findAll(),"listelendi");
	}

	@Override
	public DataResult<Verification> getById(int id) {
		return new SuccessDataResult<Verification>(this.verificationDao.findById(id).get());
	}

	@Override
	public Result add(Verification verification) {
		this.verificationDao.save(verification);
		return new SuccessResult("ekeleme işlemi yapıldı");
	}

	@Override
	public Result update(Verification verification) {
		this.verificationDao.save(verification);
		return new SuccessResult("update işlemi yapıldı");
	}

	@Override
	public Result delete(int id) {
		this.verificationDao.deleteById(id);
		return new SuccessResult("silme işlemi yapıldı");
	}

}
