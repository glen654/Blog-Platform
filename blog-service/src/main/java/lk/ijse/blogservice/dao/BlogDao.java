package lk.ijse.blogservice.dao;

import lk.ijse.blogservice.entity.impl.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDao extends JpaRepository<BlogEntity,Long> {
}
