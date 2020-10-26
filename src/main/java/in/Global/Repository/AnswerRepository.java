package in.Global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.Global.Model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>{

}
