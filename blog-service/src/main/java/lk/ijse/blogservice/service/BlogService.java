package lk.ijse.blogservice.service;

import lk.ijse.blogservice.dto.BlogStatus;
import lk.ijse.blogservice.dto.impl.BlogDTO;

import java.util.List;

public interface BlogService {
    void saveBlog(BlogDTO blogDTO);
    void updateBlog(String id,BlogDTO blogDTO);
    void deleteBlog(String id);
    BlogStatus getBlog(String id);
    List<BlogDTO> getAllBlogsByTag(String tag);
    List<BlogDTO> getAllBlogs();
}
