package in.Global.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.Global.Model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
