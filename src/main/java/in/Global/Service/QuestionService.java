package in.Global.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import in.Global.Model.Answer;
import in.Global.Model.Company;
import in.Global.Model.Question;
import in.Global.Model.Subtopic;
import in.Global.Model.User;
import in.Global.Repository.CompanyRepository;
import in.Global.Repository.QuestionRepository;
import in.Global.Repository.SubtopicRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository quesRepo;
	
	@Autowired
	CompanyRepository companyRepo;
	
	@Autowired
	SubtopicRepository subRepo;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Session giveSession() {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session ss = sessionFactory.openSession();
		return ss;
	}
	

	@Transactional
	public int save(Question ques,User user)
	{
		
		ques.setActive(true);
		 System.out.println("user"+user);
		ques.setUser(user);
		 System.out.println("user"+user);
		Question question=quesRepo.save(ques);
		return question.getQuestionId();
	}
	
	public List<Question> getQuestion()
	{
		return quesRepo.findAll();
	}
	
	public Question getQuestionDetails(int questionId)
	{
		
		return quesRepo.getOne(questionId);
	}
	

	public List<Question> filteredQuestion(Integer companyId,Integer subtopicId,Integer likes,String tags)
	{
		 System.out.println("called");
	     Session ss=giveSession();
	     String query="from Question where active is true";
	     if(companyId!=null)
	     {
	    	 query+=" and company=:companyId";
	     }
	     if(subtopicId!=null)
	     {
	    	 query+=" and subtopic=:subtopicId";
	     }
	     if(likes!=null)
	     {
	    	 query+=" and likes>=:likes";
	     }

	     System.out.println(query);
	     Query qu=ss.createQuery(query);
	     if(companyId!=null)
	     qu.setInteger("companyId", companyId);
	     if(subtopicId!=null)
	     qu.setInteger("subtopicId", subtopicId);
	     if(likes!=null)
	    	 qu.setInteger("likes", likes);
	     List<Question> question=qu.getResultList();
	     return question;
	}
	
	public List<Answer> answerLikes(List<Question> questions)
	{
		List<Answer> likes=new ArrayList<Answer>();
		Session ss=giveSession();
		for(Question qu:questions)
		{
			List<Answer> answers=(List<Answer>) qu.getAnswer();
			int like=answers.get(0).getLikes();
			Answer ans1=new Answer();
			for(Answer ans :answers)
			{
				if(ans.getLikes()>like)
				{
					like=ans.getLikes();
					ans1=ans;
				}
			}
			System.out.println(ans1);
			likes.add(ans1);
		}
		return likes;
	}
	
}


