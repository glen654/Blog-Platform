package lk.ijse.commentservice.dao;

import lk.ijse.commentservice.entity.impl.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<CommentEntity,String> {
}
