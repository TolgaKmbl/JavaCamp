package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.SystemStaff;

public interface SystemStaffDao extends JpaRepository<SystemStaff,Integer>{

}
