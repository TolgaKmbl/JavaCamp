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

import kodlama.io.hrms.business.abstracts.SystemStaffService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.City;
import kodlama.io.hrms.entities.concretes.SystemStaff;

@RestController
@RequestMapping("/api/systemstaffs")
@CrossOrigin
public class SystemStaffController {

	private SystemStaffService systemStaffService;

	@Autowired
	public SystemStaffController(SystemStaffService systemStaffService) {
		super();
		this.systemStaffService = systemStaffService;
	}
	@GetMapping("/getall")
    public DataResult<List<SystemStaff>> getAll(){
  	  return this.systemStaffService.getAll();
    }
    @GetMapping("/getbyid/{id}")
    public DataResult<SystemStaff> getById(@PathVariable int id){
  	  return this.systemStaffService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody SystemStaff systemStaff){
  	  return this.systemStaffService.add(systemStaff);
    }
    @PostMapping("/update")
    public Result update(@RequestBody SystemStaff systemStaff){
  	  return this.systemStaffService.update(systemStaff);
    }
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return this.systemStaffService.delete(id);
    }
	
}