package in.Global.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import in.Global.Model.Answer;
import in.Global.Model.AnswerLikes;
import in.Global.Model.Comment;
import in.Global.Model.Question;
import in.Global.Model.QuestionLikes;
import in.Global.Model.User;
import in.Global.Service.AnswerLikesService;
import in.Global.Service.AnswerService;
import in.Global.Service.CommentService;
import in.Global.Service.QuestionLikesService;
import in.Global.Service.QuestionService;
import in.Global.Service.UserService;

@RestController
@RequestMapping(value = "/global")
public class QuestionAnswerController {
	
	@Autowired
	QuestionService quesService;
	
	@Autowired
	AnswerService ansService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	QuestionLikesService quesLikesService;
	
	@Autowired
	AnswerLikesService answerLikesService;
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/login")
	public String login(@RequestParam("userName")String username,HttpSession session)
	{
		User user=userService.getUser(username);
		session.setAttribute("user", user);
	    return "succefully login";
	}
	
	
	 @PostMapping(value="/questions" )
	 public String questions(Question question,HttpSession ss)
	 {

		 User user=(User) ss.getAttribute("user");
		 int quesId=quesService.save(question,user);
		 return "Your Question is Posted with questionId:"+quesId;
	 }

	 @PostMapping(value="/answers")
	 public String Answers(Answer answer,@RequestParam("quesId") int questionId,HttpSession ss)
	 {
		 User user=(User) ss.getAttribute("user");
		int answerId=ansService.save(answer, questionId,user);
		return "Your Answer is Posted with answerId:"+answerId;
	 }
	 

	 @PostMapping(value="/comments")
	 public String Comments(Comment comment,@RequestParam("ansId") int answerId,HttpSession ss)
	 {

		 User user=(User) ss.getAttribute("user");
		int commentId=commentService.save(comment, answerId,user);
		return "Your Comment is Posted with commentId:"+commentId;
	 }
	 

	 @PostMapping(value="/questionlikes")
	 public String questionLike(@RequestParam("likesId") int questionId,HttpSession ss)
	 {

		 User user=(User) ss.getAttribute("user");
		 
		 QuestionLikes quesLikes=new QuestionLikes();
		 quesLikesService.save(quesLikes,questionId,user);
		 return "Liked";
	 }
	 

	 @PostMapping(value="/answerlikes")
	 public String answerLike(@RequestParam("likesId") int answerId,HttpSession ss)
	 {

		 User user=(User) ss.getAttribute("user");
		 AnswerLikes answerLikes=new AnswerLikes();
		 answerLikesService.save(answerLikes,answerId,user);
		 return "Liked";
	 }
	 
	 @GetMapping(value="/questions")
	 public ModelAndView getAllQuestions(@RequestParam("questionId") int questionId)
	 {

		 ModelAndView mav = new ModelAndView("questionList");
		 Question ques=quesService.getQuestionDetails(questionId);
		 Set<Answer> answers=ques.getAnswer();
		 int questionLikes=quesLikesService.getLikes(questionId);
		 String CompanyName=ques.getCompany().getCompanyName();
		 if(CompanyName!=null)
		 {
			 mav.addObject("companyName",CompanyName);
		 }
		 mav.addObject("question", ques);
		 mav.addObject("answers", answers);
		 mav.addObject("questionLikes",questionLikes);
		 return mav;
	}
	 
	 
	 @GetMapping(value="/filterquestions")
	 public ModelAndView filtering(@RequestParam("company") Integer company,
			 @RequestParam("subtopic") Integer subtopic,
			 @RequestParam("likes") Integer likes,
			 @RequestParam("tags") String tags ) throws ParseException
	 {
		List<Question> questions=quesService.filteredQuestion(company, subtopic, likes, tags);
		List<Answer> answerMax=quesService.answerLikes(questions);
	    ModelAndView mav=new ModelAndView("QuetionFilterList");
		mav.addObject("questions",questions);
		mav.addObject("answerMax",answerMax);
		return mav; 
	 }
	 
}
