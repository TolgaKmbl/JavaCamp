package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Resume;

public interface ResumeService {
	DataResult<List<Resume>> getAll();
	DataResult<Resume> getById(int id);
	DataResult<Resume> getByJobseekerId(int id);
	//DataResult<ResumeDto> getResumeDto(int id);
	Result add(Resume resume);
	Result update(Resume resume);
	Result delete(int id);
}
