package in.Global.Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="company_id")
	private int companyId;
	
	@Column(name="company_name")
	private String companyName;
	
	@OneToMany(mappedBy = "company")
	private Set<Question> question;

	
	
	public Company() {
		super();
	}

      public Company(int companyId, String companyName, Set<Question> question) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.question = question;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", question=" + question + "]";
	}
	
	
	
	
}
