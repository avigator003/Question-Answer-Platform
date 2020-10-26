package in.Global.Service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Global.Model.Answer;
import in.Global.Model.Comment;
import in.Global.Model.User;
import in.Global.Repository.AnswerRepository;
import in.Global.Repository.CommentRepository;

@Service
public class CommentService {

	
	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	AnswerRepository answerRepo;
	

	@Transactional
	public int save(Comment comment,int answerId,User user)
	{
		Answer answer=answerRepo.getOne(answerId);
		comment.setUserId(user);
		comment.setPostedOn(new Date());
		comment.setAnswer(answer);
		Comment com= commentRepo.save(comment);
		return com.getCommentId();
	}
}
