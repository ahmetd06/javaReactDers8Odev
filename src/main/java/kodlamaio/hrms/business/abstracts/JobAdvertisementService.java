package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);

	Result changeActive(int id);

	DataResult<List<JobAdvertisement>> getAllActive();

	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByReleaseDateDesc();
	
	DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByCompanyName(String companyName);
}
