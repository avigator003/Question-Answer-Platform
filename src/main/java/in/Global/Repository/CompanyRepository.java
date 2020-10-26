package in.Global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.Global.Model.Company;

public interface CompanyRepository  extends JpaRepository<Company, Integer>{

}
