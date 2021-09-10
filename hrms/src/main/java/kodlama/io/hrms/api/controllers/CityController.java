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
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CityController {
	private CityService cityService;
    @Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
    @GetMapping("/getall")
    public DataResult<List<City>> getAll(){
  	  return this.cityService.getAll();
    }
    @GetMapping("/getbyid/{id}")
    public DataResult<City> getById(@PathVariable int id){
  	  return this.cityService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody City city){
  	  return this.cityService.add(city);
    }
    @PostMapping("/update")
    public Result update(@RequestBody City city){
  	  return this.cityService.update(city);
    }
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return this.cityService.delete(id);
    }
	
}
