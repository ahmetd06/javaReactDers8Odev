package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İlan eklendi");
	}

	@Override
	public Result changeActive(int id) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(id);
		if (jobAdvertisement == null) {
			return new ErrorResult("İlan bulunamadı");
		}
		
		jobAdvertisement.setActive(!jobAdvertisement.isActive());
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İlan aktifliği değiştirildi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActive() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByReleaseDateDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByReleaseDateDesc());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getAllActiveJobAdvertisementByEmployer_CompanyName(companyName));
	}

}
