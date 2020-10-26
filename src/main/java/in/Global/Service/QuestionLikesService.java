package in.Global.Service;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import in.Global.Model.Question;
import in.Global.Model.QuestionLikes;
import in.Global.Model.User;
import in.Global.Repository.QuestionLikesRepository;
import in.Global.Repository.QuestionRepository;

@Service
public class QuestionLikesService {

	
	@Autowired
	QuestionLikesRepository quesLikesRepo;
	
	@Autowired
	QuestionRepository quesRepo;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Session giveSession() {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session ss = sessionFactory.openSession();
		return ss;
	}


	@Transactional
	public void save(QuestionLikes quesLikes,int quesId,User user)
	{
	Question ques=quesRepo.getOne(quesId);
	int likes=ques.getLikes();
	ques.setLikes(likes+1);
	quesRepo.save(ques);
	quesLikes.setUser2(user);
	quesLikes.setQuestion1(ques);
	quesLikesRepo.save(quesLikes);
	}

	public int getLikes(int questionId)
	{
		Question ques=quesRepo.getOne(questionId);
		Session ss=giveSession();
		Query query=(Query) ss.createQuery("from QuestionLikes q where q.question1=:ques");
		query.setParameter("ques", ques);
		List<Question> questions=query.getResultList();
		return questions.size();
	}
	
}
