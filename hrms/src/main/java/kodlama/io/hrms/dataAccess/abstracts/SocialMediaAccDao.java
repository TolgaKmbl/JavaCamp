package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.SocialMediaAccount;

public interface SocialMediaAccDao extends JpaRepository<SocialMediaAccount,Integer>{

}
