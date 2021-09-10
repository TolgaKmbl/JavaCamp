package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.business.abstracts.LanguageJobseekerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.City;
import kodlama.io.hrms.entities.concretes.LanguageJobseeker;

@RestController
@RequestMapping("/api/languagejobseekers")
@CrossOrigin
public class LanguageJobseekerController {
	private LanguageJobseekerService languageJobseekerService;
    @Autowired
	public LanguageJobseekerController(LanguageJobseekerService languageJobseekerService) {
		super();
		this.languageJobseekerService = languageJobseekerService;
	}
    @GetMapping("/getall")
    public DataResult<List<LanguageJobseeker>> getAll(){
  	  return this.languageJobseekerService.getAll();
    }
    @GetMapping("/getbyid/{id}")
    public DataResult<LanguageJobseeker> getById(@PathVariable int id){
  	  return this.languageJobseekerService.getById(id);
    }
    @PostMapping("/add")
    public Result add(int id,@RequestBody LanguageJobseeker languageJobseeker){
  	  return this.languageJobseekerService.add(id,languageJobseeker);
    }
   
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return this.languageJobseekerService.delete(id);
    }
}
