package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jdk.dynalink.linker.LinkerServices;
import kodlama.io.hrms.business.abstracts.LinkService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Link;

@RestController
@RequestMapping("/api/links")
public class LinkController {

	private LinkService linkService;


	@Autowired
	public LinkController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Link link){
		return this.linkService.add(link);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Link link){
		return this.linkService.update(link);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.linkService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Link> getById(@RequestParam("id") int id){
		return this.linkService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Link>> getAll(){
		return this.linkService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<Link>> getAllByJobseekerId(@RequestParam int id){
		return this.linkService.getAllByJobseekerId(id);
	}
}
