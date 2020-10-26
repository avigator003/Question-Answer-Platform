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
@Table(name = "answer_likes")
public class AnswerLikes {

	
	  @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="answerLikes_id")
		private int answerLikesid;
		
	    @OneToOne
	    @JoinColumn(name="answer_id")
	    private Answer answer1;
	    
	    
	    @ManyToOne
	    @JoinColumn(name="user_id")
	    private User user3;


		public int getAnswerLikesid() {
			return answerLikesid;
		}


		public void setAnswerLikesid(int answerLikesid) {
			this.answerLikesid = answerLikesid;
		}


		public Answer getAnswer1() {
			return answer1;
		}


		public void setAnswer1(Answer answer1) {
			this.answer1 = answer1;
		}


		public User getUser3() {
			return user3;
		}


		public void setUser3(User user3) {
			this.user3 = user3;
		}


		public AnswerLikes(int answerLikesid, Answer answer1, User user3) {
			super();
			this.answerLikesid = answerLikesid;
			this.answer1 = answer1;
			this.user3 = user3;
		}


		public AnswerLikes() {
			super();
		}


		@Override
		public String toString() {
			return "AnswerLikes [answerLikesid=" + answerLikesid + ", answer1=" + answer1 + ", user3=" + user3 + "]";
		}


}
