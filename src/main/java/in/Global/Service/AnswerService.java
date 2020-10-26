package in.Global.Service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Global.Model.Answer;
import in.Global.Model.Question;
import in.Global.Model.User;
import in.Global.Repository.AnswerRepository;
import in.Global.Repository.QuestionRepository;

@Service
public class AnswerService {

	@Autowired
	AnswerRepository ansRepo;
	
	@Autowired
	QuestionRepository quesRepo;
	

	@Transactional
	public int save(Answer answer,int questionId,User user)
	{
		Question ques=quesRepo.getOne(questionId);
		answer.setUser1(user);
		answer.setQuestion(ques);
		Answer ans=ansRepo.save(answer);
		return ans.getAnswerId();
	}
	
	public List<Answer> getAnswers()
	{
		return ansRepo.findAll();
	}
}
