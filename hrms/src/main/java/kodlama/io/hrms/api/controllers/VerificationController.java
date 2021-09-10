package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.VerificationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Verification;

@RestController
@RequestMapping("/api/verifications")
@CrossOrigin
public class VerificationController {
	private VerificationService verificationServie;
	public VerificationController(VerificationService verificationServie) {
		super();
		this.verificationServie = verificationServie;
	}
	@GetMapping("/getall")
    public DataResult<List<Verification>> getAll(){
  	  return this.verificationServie.getAll();
    }
    @GetMapping("/getbyid/{id}")
    public DataResult<Verification> getById(@PathVariable int id){
  	  return this.verificationServie.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Verification verification){
  	  return this.verificationServie.add(verification);
    }
    @PostMapping("/update")
    public Result update(@RequestBody Verification verification){
  	  return this.verificationServie.update(verification);
    }
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return this.verificationServie.delete(id);
    }
}
