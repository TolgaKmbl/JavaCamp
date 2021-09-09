package kodlama.io.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Image;

public interface ImageService {
	DataResult<List<Image>> getAll();
	DataResult<Image> getById(int id);
	DataResult<List<Image>> getByUserId(int id);
	Result add(MultipartFile multipartFile ,int id);
	Result delete(int id) throws IOException;
}
