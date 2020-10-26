package in.Global.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import in.Global.Model.Answer;
import in.Global.Model.Company;
import in.Global.Model.Question;
import in.Global.Model.Subtopic;
import in.Global.Service.AnswerService;
import in.Global.Service.CompanyService;
import in.Global.Service.QuestionService;
import in.Global.Service.SubtopicService;
@Controller
@RequestMapping(value = "/global")
public class WebController {

	@Autowired
	SubtopicService subService;
	
	@Autowired
	QuestionService quesService;
	
	@Autowired
	AnswerService ansService;
	
	
	@Autowired
	CompanyService comService;
	
	
	@RequestMapping(value="/loginpage")
	public String loginPage()
	{
   return "login";		
	}
	@RequestMapping(value="/question")
	public String askQuestions(ModelMap map)
	{
		List<Subtopic> subTopics=subService.getSubTopics();
		List<Company> company=comService.getCompany();
		map.put("subTopic", subTopics);
		map.put("company", company);
		
  		return "questions";
	}
	

	@RequestMapping(value="/answer")
	public String giveAnswer(ModelMap map)
	{
		List<Question> questions=quesService.getQuestion();
		map.put("questions", questions);
	    
  		return "answer";
	}
	
	@RequestMapping(value="/comment")
	public String giveComments(ModelMap map)
	{
		List<Question> questions= quesService.getQuestion();
		map.put("questions", questions);
		return "comments";
  	}
	@RequestMapping(value="/questioninfo")
	public String getQuestionInfo(ModelMap map)
	{
		return "questionform";
  	}
	
	@RequestMapping(value="/filterquestion" )
	public String FilterQuestion(ModelMap map)
	{
        List<Subtopic> subTopics=subService.getSubTopics();
		List<Company> company=comService.getCompany();
		map.put("subTopic", subTopics);
		map.put("company", company);
		return "FilterQuestion";
  	}
	
}
