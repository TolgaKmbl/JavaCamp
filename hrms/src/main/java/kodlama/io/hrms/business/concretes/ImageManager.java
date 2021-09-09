package kodlama.io.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.adapters.CloudService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ImageDao;
import kodlama.io.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{

	private ImageDao imageDao;
	private CloudService cloudService;
	private UserService userService;
	
	@Autowired
	public ImageManager(ImageDao imageDao, CloudService cloudService, UserService userService) {
		super();
		this.imageDao = imageDao;
		this.cloudService = cloudService;
		this.userService = userService;
	}
	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll(),"listelendi");
	}
	@Override
	public DataResult<Image> getById(int id) {
		return new SuccessDataResult<Image>(this.imageDao.findById(id).get(),"resim:");
	}
	@Override
	public DataResult<List<Image>> getByUserId(int id) {
		return new SuccessDataResult<List<Image>>(this.imageDao.getByUser_Id(id));
	}
	@Override
	public Result add(MultipartFile multipartFile,int id) {
		var result=this.cloudService.upload(multipartFile);
		if(!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		var user=this.userService.getById(id).getData();
		Image image=new Image();
		image.setUser(user);
		image.setImageUrl(result.getData().get("url"));
		image.setPublic_id(result.getData().get("public_id"));
		image.setUploadedDate(result.getData().get("created_at"));
		this.imageDao.save(image);
		return new SuccessResult("photo added");
	}
	@Override
	public Result delete(int id) throws IOException {
		var public_id=this.imageDao.findById(id).get().getPublic_id();
		var result=this.cloudService.delete(public_id);
		this.imageDao.deleteById(id);
		
		return new SuccessResult("deleted");
	}

	


}
