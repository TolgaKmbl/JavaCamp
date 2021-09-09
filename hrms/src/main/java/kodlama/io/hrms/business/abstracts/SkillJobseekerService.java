package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.SkillJobseeker;

public interface SkillJobseekerService {
	DataResult<List<SkillJobseeker>> getAll();
	DataResult<SkillJobseeker> getById(int id);
	Result add(int id,SkillJobseeker skillJobseeker);
	Result update(SkillJobseeker skillJobseeker);
	Result delete(int id);
}
