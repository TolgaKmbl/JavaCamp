package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Education;

public interface EducationService {
	DataResult<List<Education>> getAll();
	DataResult<Education> getById(int id);
	DataResult<List<Education>> getByJobseekerId(int id);
	Result add(Education education,int jobseekerId);
	Result update(Education education);
	Result delete(int id);
}
