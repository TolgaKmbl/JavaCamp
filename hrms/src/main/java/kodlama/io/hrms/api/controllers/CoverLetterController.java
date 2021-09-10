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

import kodlama.io.hrms.business.abstracts.CoverLetterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CoverLetter;

@RestController
@RequestMapping("/api/coverletters")
@CrossOrigin
public class CoverLetterController {

	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLetterController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	  @GetMapping("/getall")
	    public DataResult<List<CoverLetter>> getAll(){
	  	  return this.coverLetterService.getAll();
	    }
	    @GetMapping("/getbyid/{id}")
	    public DataResult<CoverLetter> getById(@PathVariable int id){
	  	  return this.coverLetterService.getById(id);
	    }
	    @PostMapping("/add")
	    public Result add(@RequestParam int id, @RequestBody CoverLetter coverletter){
	  	  return this.coverLetterService.add(id,coverletter);
	    }
	    @PostMapping("/update")
	    public Result update(@RequestBody CoverLetter coverletter){
	  	  return this.coverLetterService.update(coverletter);
	    }
	    @PostMapping("/delete/{id}")
	    public Result delete(@PathVariable int id){
	  	  return this.coverLetterService.delete(id);
	    }
}