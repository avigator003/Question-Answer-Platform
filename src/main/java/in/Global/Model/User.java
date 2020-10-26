package in.Global.Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;

	@OneToMany(mappedBy = "user1",fetch = FetchType.EAGER)
	private Set<Answer> answer;
	

	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private Set<Question> question;
	

	@OneToMany(mappedBy = "user3",fetch = FetchType.EAGER)
	private Set<AnswerLikes> answerLikes;
	

	@OneToMany(mappedBy = "user2",fetch = FetchType.EAGER)
	private Set<Comment> comment;
	
	@OneToMany(mappedBy = "user5",fetch = FetchType.EAGER)
	private Set<QuestionLikes> questionLikes;
	
	public User() {
		super();
	}

	public User(int userId, String userName, Set<Answer> answer, Set<Question> question, Set<AnswerLikes> answerLikes,
			Set<Comment> comment, Set<QuestionLikes> questionLikes) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.answer = answer;
		this.question = question;
		this.answerLikes = answerLikes;
		this.comment = comment;
		this.questionLikes = questionLikes;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(Set<Answer> answer) {
		this.answer = answer;
	}

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}

	public Set<AnswerLikes> getAnswerLikes() {
		return answerLikes;
	}

	public void setAnswerLikes(Set<AnswerLikes> answerLikes) {
		this.answerLikes = answerLikes;
	}

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public Set<QuestionLikes> getQuestionLikes() {
		return questionLikes;
	}

	public void setQuestionLikes(Set<QuestionLikes> questionLikes) {
		this.questionLikes = questionLikes;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", answer=" + answer + ", question=" + question
				+ ", answerLikes=" + answerLikes + ", comment=" + comment + ", questionLikes=" + questionLikes + "]";
	}
	
	
}