package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface VerificationByNviService extends VerificationService{
	Result verify(User user);
}
