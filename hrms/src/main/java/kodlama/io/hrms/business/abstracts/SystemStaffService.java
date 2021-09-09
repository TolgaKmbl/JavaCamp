package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.SystemStaff;

public interface SystemStaffService {
	DataResult<List<SystemStaff>> getAll();
	DataResult<SystemStaff> getById(int id);
	Result add(SystemStaff systemStaff);
	Result update(SystemStaff systemStaff);
	Result delete(int id);
}
