package in.Global.Model;

import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "comment")
public class Comment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="comment_id")
	private int commentId;
	
	@Column(name="comment_text")
	private String commentText;
	
	@ManyToOne
	@JoinColumn(name="answer_id")
	private Answer answer;
	

    @ManyToOne
	@JoinColumn(name="user_id")
	private User user2;

	@Column(name="posted_on")
	private Date postedOn;
	
	
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public User getUserId() {
		return user2;
	}

	public void setUserId(User userId) {
		this.user2 = userId;
	}


	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public Comment(int commentId, String commentText, Answer answer, User userId, Date postedOn) {
		super();
		this.commentId = commentId;
		this.commentText = commentText;
		this.answer = answer;
		this.user2 = userId;
		this.postedOn = postedOn;
	}

	public Comment() {
		super();
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentText=" + commentText + ", answer=" + answer + ", userId="
				+ user2 + ", postedOn=" + postedOn + "]";
	}

	
	
	

}
