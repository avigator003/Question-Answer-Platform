package in.Global.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Global.Model.User;
import in.Global.Repository.UserRepository;

@Service
public class UserService  {

	@Autowired
	UserRepository userRepository;
	
	public User getUser(String username)
	{
		return userRepository.findByUserName(username);
	}
	
}
