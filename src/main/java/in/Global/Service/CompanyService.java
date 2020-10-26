package in.Global.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import in.Global.Model.Company;
import in.Global.Repository.CompanyRepository;

import org.springframework.stereotype.Service;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository comRepo;
	
	public List<Company> getCompany()
	{
		return comRepo.findAll();
	}
}
