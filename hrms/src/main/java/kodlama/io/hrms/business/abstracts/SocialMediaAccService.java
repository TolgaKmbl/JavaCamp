package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.SocialMediaAccount;

public interface SocialMediaAccService {
	DataResult<List<SocialMediaAccount>> getAll();
	DataResult<SocialMediaAccount> getById(int id);
	Result add(int id, SocialMediaAccount socialMedia);
	Result update(SocialMediaAccount socialMedia);
	Result delete(int id);
	
}
