package in.Global.Model;

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
@Table(name = "answer")
public class Answer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="answer_id")
	private int answerId;
	
	@Column(name="answer_text")
	private String answerText;
	
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user1;
    
    @Column(name="likes")
    private int likes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;
     
    @OneToMany(mappedBy ="answer")
    private Set<Comment> comment;
    
    @OneToMany(mappedBy ="answer1")
    private Set<AnswerLikes> answerLikes;
    
    
    
	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}


	

	public Set<Comment> getComment() {
		return comment;
	}


	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}




	public Set<AnswerLikes> getAnswerLikes() {
		return answerLikes;
	}

	public void setAnswerLikes(Set<AnswerLikes> answerLikes) {
		this.answerLikes = answerLikes;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public Answer() {
		super();
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Answer(int answerId, String answerText, User user1, int likes, Question question, Set<Comment> comment,
			Set<AnswerLikes> answerLikes) {
		super();
		this.answerId = answerId;
		this.answerText = answerText;
		this.user1 = user1;
		this.likes = likes;
		this.question = question;
		this.comment = comment;
		this.answerLikes = answerLikes;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answerText=" + answerText + ", user1=" + user1 + ", likes=" + likes
				+ ", question=" + question + ", comment=" + comment + ", answerLikes=" + answerLikes + "]";
	}


		
	
}
