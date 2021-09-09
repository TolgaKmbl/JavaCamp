package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Skill;

public interface SkillService {
	DataResult<List<Skill>> getAll();
	DataResult<Skill> getById(int id);
	Result add(Skill skill);
	Result update(Skill skill);
	Result delete(int id);
}
