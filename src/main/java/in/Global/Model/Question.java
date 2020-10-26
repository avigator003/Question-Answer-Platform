package in.Global.Model;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="question_id")
	private int questionId;
	
	@Column(name="question_text")
	private String questionText;
	
	@Column(name="posted_on")
	private Date postedOn;
	

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subtopic_id")
    private Subtopic subtopic;
 
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
     

 
    @OneToMany(mappedBy = "question")
    private Set<Answer> answer;
    
    @OneToMany(mappedBy="question1")
    private Set<QuestionLikes> questionLikes;
    
    
    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;
    
    @Column(name="active")
    private boolean active;

    @Column(name="likes")
    private int likes;
    
	public Question() {
		super();
	}



	public int getQuestionId() {
		return questionId;
	}



	public int getLikes() {
		return likes;
	}



	public void setLikes(int likes) {
		this.likes = likes;
	}



	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}



	public String getQuestionText() {
		return questionText;
	}



	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}



	public Date getPostedOn() {
		return postedOn;
	}



	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}



	public Subtopic getSubtopic() {
		return subtopic;
	}



	public void setSubtopic(Subtopic subtopic) {
		this.subtopic = subtopic;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}






	public Set<Answer> getAnswer() {
		return answer;
	}



	public void setAnswer(Set<Answer> answer) {
		this.answer = answer;
	}



	public Set<QuestionLikes> getQuestionLikes() {
		return questionLikes;
	}



	public void setQuestionLikes(Set<QuestionLikes> questionLikes) {
		this.questionLikes = questionLikes;
	}



	public Company getCompany() {
		return company;
	}



	public void setCompany(Company company) {
		this.company = company;
	}



	



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}






	public Question(int questionId, String questionText, Date postedOn, Subtopic subtopic, User user,
			 Set<Answer> answer, Set<QuestionLikes> questionLikes, Company company,
			boolean active, int likes) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.postedOn = postedOn;
		this.subtopic = subtopic;
		this.user = user;
		this.answer = answer;
		this.questionLikes = questionLikes;
		this.company = company;
		this.active = active;
		this.likes = likes;
	}



	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", postedOn=" + postedOn
				+ ", subtopic=" + subtopic + ", user=" + user + ", answer="
				+ answer + ", questionLikes=" + questionLikes + ", company=" + company + ", active=" + active
				+ ", likes=" + likes + "]";
	}



	






	
    
    
	
	
}
