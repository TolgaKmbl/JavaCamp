package kodlama.io.hrms.core.verification.abstracts;

import kodlama.io.hrms.entities.concretes.Employer;

public interface AdminCheckService {
  boolean isValid(Employer employer);
}
