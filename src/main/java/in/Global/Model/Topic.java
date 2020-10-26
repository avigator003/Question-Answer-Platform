package in.Global.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "topic")
public class Topic {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="topic_id")
	private int topicId;
    
    @Column(name="topic_name")
    private String topicName;
    
    @OneToMany(mappedBy = "topic",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Subtopic> sub;

	public Topic() {
		super();
	}

	public Topic(int topicId, String topicName, Set<Subtopic> sub) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.sub = sub;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Set<Subtopic> getSub() {
		return sub;
	}

	public void setSub(Set<Subtopic> sub) {
		this.sub = sub;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicName=" + topicName + ", sub=" + sub + "]";
	}
    
    
}
