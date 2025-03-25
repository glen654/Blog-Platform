package lk.ijse.blogservice.service;

import lk.ijse.blogservice.dto.impl.BlogDTO;

import java.util.List;

public interface BlogService {
    void saveBlog(BlogDTO blogDTO);
    void updateBlog(String id,BlogDTO blogDTO);
    void deleteBlog(String id);
    BlogDTO getBlog(String id);
    List<BlogDTO> getAllBlogs(String tag);
}
