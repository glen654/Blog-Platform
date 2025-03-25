package lk.ijse.blogservice.dao;

import lk.ijse.blogservice.entity.impl.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogDao extends JpaRepository<BlogEntity,String> {
    @Query("SELECT b FROM BlogEntity b WHERE :tag MEMBER OF b.tags")
    List<BlogEntity> findBlogByTag(@Param("tag") String tag);
}
