package in.Global.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Global.Model.Subtopic;
import in.Global.Repository.SubtopicRepository;

@Service
public class SubtopicService {

	@Autowired
	SubtopicRepository subRepo;
	
	public List<Subtopic> getSubTopics()
	{
		List<Subtopic> list=subRepo.findAll();
		
		return list;
	}
	
}
