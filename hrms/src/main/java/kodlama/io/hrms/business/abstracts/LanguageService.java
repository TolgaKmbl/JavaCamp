package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Language;

public interface LanguageService {
	DataResult<List<Language>> getAll();
	DataResult<Language> getById(int id);
	Result add(Language language);
	Result update(Language language);
	Result delete(int id);
}
