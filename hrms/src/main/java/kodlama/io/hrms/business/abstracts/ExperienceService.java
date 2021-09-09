package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Experience;


public interface ExperienceService {
	DataResult<List<Experience>> getAll();
	DataResult<Experience> getById(int id);
	Result add(Experience experience,int id);
	Result update(Experience experience);
	Result delete(int id);
}
