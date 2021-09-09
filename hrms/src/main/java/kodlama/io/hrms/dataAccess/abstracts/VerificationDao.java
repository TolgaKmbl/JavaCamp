package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Verification;

public interface VerificationDao extends JpaRepository<Verification,Integer>{

}
