package in.Global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.Global.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String username);
}
