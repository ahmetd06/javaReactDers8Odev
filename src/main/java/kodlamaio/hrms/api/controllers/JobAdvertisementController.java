package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {

		this.jobAdvertisementService.add(jobAdvertisement);
		return new SuccessResult();
	}
	
	@PostMapping("/changeActive")
	public Result changeActive(@RequestBody JobAdvertisement jobAdvertisement) {

		this.jobAdvertisementService.changeActive(jobAdvertisement.getId());
		return new SuccessResult();
	}
	
	
	@GetMapping("/getAllActive")
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvert(){
		return jobAdvertisementService.getAllActive();
	}
	
	@GetMapping("/getByIsActiveTrueOrderByReleaseDateDesc")
	public DataResult<List<JobAdvertisement>> getAllByCreationDateAsc(){
		return jobAdvertisementService.getByIsActiveTrueOrderByReleaseDateDesc();
	}

	@PostMapping("/getAllActiveJobAdvertisementByCompanyName")
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertByCompanyName(@RequestParam("companyName") String companyName) {
		return jobAdvertisementService.getAllActiveJobAdvertisementByCompanyName(companyName);
	}
}
