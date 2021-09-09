package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobAdvDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<JobAdvertisement> getById(int id);
	Result add(JobAdvertisement jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	Result delete(int id);
	Result makePassive(int id);
	DataResult<List<JobAdvertisement>> getByActiveStatus();
	DataResult<List<JobAdvertisement>> getAllSortedByDate();
	DataResult<List<JobAdvertisement>> getByEmployerId(int id);
	DataResult<List<JobAdvertisement>> getActiveAdvByEmployer(int employerId);
	
//	DataResult<List<JobAdvDto>> getDtoByActiveStatus();
}
