package lk.ijse.blogservice.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.blogservice.dao.BlogDao;
import lk.ijse.blogservice.dto.impl.BlogDTO;
import lk.ijse.blogservice.service.BlogService;
import lk.ijse.blogservice.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveBlog(BlogDTO blogDTO) {

    }

    @Override
    public void updateBlog(String id, BlogDTO blogDTO) {

    }

    @Override
    public void deleteBlog(String id) {

    }

    @Override
    public BlogDTO getBlog(String id) {
        return null;
    }

    @Override
    public List<BlogDTO> getAllBlogs(String tag) {
        return List.of();
    }
}
