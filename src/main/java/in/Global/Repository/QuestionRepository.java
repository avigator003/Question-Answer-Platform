package in.Global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.Global.Model.Question;

public interface QuestionRepository  extends JpaRepository<Question, Integer>{

}
