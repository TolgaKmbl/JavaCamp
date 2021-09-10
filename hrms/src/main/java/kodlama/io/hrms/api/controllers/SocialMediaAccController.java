package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.SocialMediaAccService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.City;
import kodlama.io.hrms.entities.concretes.SocialMediaAccount;

@RestController
@RequestMapping("/api/socialmediaaccounts")
@CrossOrigin
public class SocialMediaAccController {
 
	private SocialMediaAccService socialMediaAccService;
    @Autowired
	public SocialMediaAccController(SocialMediaAccService socialMediaAccService) {
		super();
		this.socialMediaAccService = socialMediaAccService;
	}
    @GetMapping("/getall")
    public DataResult<List<SocialMediaAccount>> getAll(){
  	  return this.socialMediaAccService.getAll();
    }
    @GetMapping("/getbyid/{id}")
    public DataResult<SocialMediaAccount> getById(@PathVariable int id){
  	  return this.socialMediaAccService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestParam int id,@RequestBody SocialMediaAccount socialMediaAccount){
  	  return this.socialMediaAccService.add(id,socialMediaAccount);
    }
    @PostMapping("/update")
    public Result update(@RequestBody SocialMediaAccount socialMediaAccount){
  	  return this.socialMediaAccService.update(socialMediaAccount);
    }
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return this.socialMediaAccService.delete(id);
    }
}
