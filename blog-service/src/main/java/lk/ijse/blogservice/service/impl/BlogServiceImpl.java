package lk.ijse.blogservice.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.blogservice.customStatusCodes.SelectedErrorStatus;
import lk.ijse.blogservice.dao.BlogDao;
import lk.ijse.blogservice.dto.BlogStatus;
import lk.ijse.blogservice.dto.impl.BlogDTO;
import lk.ijse.blogservice.entity.impl.BlogEntity;
import lk.ijse.blogservice.exception.BlogNotFoundException;
import lk.ijse.blogservice.exception.DataPersistException;
import lk.ijse.blogservice.service.BlogService;
import lk.ijse.blogservice.util.AppUtil;
import lk.ijse.blogservice.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveBlog(BlogDTO blogDTO) {
        blogDTO.setId(AppUtil.generateBlogId());
        BlogEntity saveBlog = blogDao.save(mapping.toBlogEntity(blogDTO));
        if (saveBlog == null) {
            throw new DataPersistException("Save Blog Unsuccessful");
        }
    }

    @Override
    public void updateBlog(String id, BlogDTO blogDTO) {
        Optional<BlogEntity> tmpBlog = blogDao.findById(id);
        if(!tmpBlog.isPresent()) {
            throw new BlogNotFoundException("Blog Not Found");
        }else {
            tmpBlog.get().setTitle(blogDTO.getTitle());
            tmpBlog.get().setContent(blogDTO.getContent());
            tmpBlog.get().setAuthorId(blogDTO.getAuthorId());
            tmpBlog.get().setCreateDate(blogDTO.getCreateDate());
            tmpBlog.get().setUpdateDate(blogDTO.getUpdateDate());
            tmpBlog.get().setTags(blogDTO.getTags());
            tmpBlog.get().setStatus(blogDTO.getStatus());
        }
    }

    @Override
    public void deleteBlog(String id) {
        Optional<BlogEntity> foundedBlog = blogDao.findById(id);
        if(!foundedBlog.isPresent()) {
            throw new BlogNotFoundException("Blog Not Found");
        }else {
            blogDao.deleteById(id);
        }
    }

    @Override
    public BlogStatus getBlog(String id) {
        if(blogDao.existsById(id)){
            var selectedBlog = blogDao.getReferenceById(id);
            return mapping.toBlogDTO(selectedBlog);
        }else {
            return new SelectedErrorStatus(2,"Selected Blog Not Found");
        }
    }

    @Override
    public List<BlogDTO> getAllBlogsByTag(String tag) {
        List<BlogEntity> foundedBlogs = blogDao.findBlogByTag(tag);
        return mapping.toBlogDTOList(foundedBlogs);
    }

    @Override
    public List<BlogDTO> getAllBlogs() {
        List<BlogEntity> allBlogs = blogDao.findAll();
        return mapping.toBlogDTOList(allBlogs);
    }


}
