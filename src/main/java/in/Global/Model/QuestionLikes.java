package in.Global.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question_likes")
public class QuestionLikes {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="questionLikes_id")
	private int questionLikesId;
	
    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question1;
    
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user5;


	public QuestionLikes() {
		super();
	}


	public QuestionLikes(int questionLikesId, Question question1, User user2) {
		super();
		this.questionLikesId = questionLikesId;
		this.question1 = question1;
		this.user5 = user2;
	}


	public int getQuestionLikesId() {
		return questionLikesId;
	}


	public void setQuestionLikesId(int questionLikesId) {
		this.questionLikesId = questionLikesId;
	}


	public Question getQuestion1() {
		return question1;
	}


	public void setQuestion1(Question question1) {
		this.question1 = question1;
	}


	public User getUser2() {
		return user5;
	}


	public void setUser2(User user2) {
		this.user5 = user2;
	}


	@Override
	public String toString() {
		return "QuestionLikes [questionLikesId=" + questionLikesId + ", question1=" + question1 + ", user2=" + user5
				+ "]";
	}
    
    
    
}
