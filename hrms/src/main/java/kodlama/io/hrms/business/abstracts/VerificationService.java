package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Verification;

public interface VerificationService {
	DataResult<List<Verification>> getAll();
	DataResult<Verification> getById(int id);
	Result add(Verification verification);
	Result update(Verification verification);
	Result delete(int id);
}
