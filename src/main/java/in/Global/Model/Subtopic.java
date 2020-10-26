package in.Global.Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subtopic")
public class Subtopic {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subtopic_id")
	private int subtopicId;
    
    @Column(name="subtopic_name")
    private String subtopicName;
    
    @ManyToOne
    @JoinColumn(name="topic_id")
    private Topic topic;

    @OneToMany(mappedBy = "subtopic")
    private Set<Question> question;
    
	

	public Subtopic(int subtopicId, String subtopicName, Topic topic, Question question) {
		super();
		this.subtopicId = subtopicId;
		this.subtopicName = subtopicName;
		this.topic = topic;
		this.question = (Set<Question>) question;
	}

	public Question getQuestion() {
		return (Question) question;
	}

	public void setQuestion(Question question) {
		this.question = (Set<Question>) question;
	}

	public Subtopic() {
		super();
	}

	public int getSubtopicId() {
		return subtopicId;
	}

	public void setSubtopicId(int subtopicId) {
		this.subtopicId = subtopicId;
	}

	public String getSubtopicName() {
		return subtopicName;
	}

	public void setSubtopicName(String subtopicName) {
		this.subtopicName = subtopicName;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Subtopic [subtopicId=" + subtopicId + ", subtopicName=" + subtopicName + ", topic=" + topic
				+ ", question=" + question + "]";
	}


	
    
    
    
    
}
