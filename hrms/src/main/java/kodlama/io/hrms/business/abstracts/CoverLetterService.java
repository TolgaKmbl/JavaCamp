package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {

	DataResult<List<CoverLetter>> getAll();
	DataResult<CoverLetter> getById(int id);
	Result add(int id,CoverLetter coverLetter);
	Result update(CoverLetter coverLetter);
	Result delete(int id);
}
