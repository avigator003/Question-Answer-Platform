package in.Global.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Global.Model.Answer;
import in.Global.Model.AnswerLikes;
import in.Global.Model.User;
import in.Global.Repository.AnswerLikesRepository;
import in.Global.Repository.AnswerRepository;

@Service
public class AnswerLikesService {

	@Autowired
	AnswerLikesRepository answerLikesRepo;
	
	@Autowired
	AnswerRepository ansRepo;
	
	@Transactional
	public void save(AnswerLikes ans,int answerId,User user)
	{
		;
		Answer answer=ansRepo.getOne(answerId);
        int likes=answer.getLikes();
		answer.setLikes(likes+1);
		ans.setUser3(user);
		ansRepo.save(answer);
		ans.setAnswer1(answer);
		answerLikesRepo.save(ans);
	}
	
}
