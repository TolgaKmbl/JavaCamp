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

import kodlama.io.hrms.business.abstracts.ResumeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin
public class ResumeController {
 private ResumeService resumeService;
@Autowired
public ResumeController(ResumeService resumeService) {
	super();
	this.resumeService = resumeService;
}
@GetMapping("/getall")
public DataResult<List<Resume>> getAll(){
	  return this.resumeService.getAll();
}
@GetMapping("/getbyid/{id}")
public DataResult<Resume> getById(@PathVariable int id){
	  return this.resumeService.getById(id);
}
@GetMapping("/getbyjobseekerid/{id}")
public DataResult<Resume> getByJobseekerId(@PathVariable int id){
	  return this.resumeService.getByJobseekerId(id);
}
/*@GetMapping("/getdtobyid/{id}")
public DataResult<ResumeDto> getResumeDto(@PathVariable int id){
	  return this.resumeService.getResumeDto(id);
}*/
@PostMapping("/add")
public Result add(@RequestBody Resume Resume){
	  return this.resumeService.add(Resume);
}
@PostMapping("/update")
public Result update(@RequestBody Resume Resume){
	  return this.resumeService.update(Resume);
}
@PostMapping("/delete/{id}")
public Result delete(@PathVariable int id){
	  return this.resumeService.delete(id);
}
}
