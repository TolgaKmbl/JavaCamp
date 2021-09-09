package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.LanguageJobseeker;


public interface LanguageJobseekerService {
	DataResult<List<LanguageJobseeker>> getAll();
	DataResult<LanguageJobseeker> getById(int id);
	Result add(int id,LanguageJobseeker languageJobseeker);
	Result update(LanguageJobseeker languageJobseeker);
	Result delete(int id);
}
