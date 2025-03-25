package lk.ijse.blogservice.controller;

import lk.ijse.blogservice.dto.BlogStatus;
import lk.ijse.blogservice.dto.impl.BlogDTO;
import lk.ijse.blogservice.exception.DataPersistException;
import lk.ijse.blogservice.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blog")
@CrossOrigin
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveBlog(@RequestBody BlogDTO blogDTO) {
        try {
            blogService.saveBlog(blogDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateBlog(@PathVariable ("id") String id, @RequestBody BlogDTO blogDTO) {
        try{
            blogService.updateBlog(id, blogDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable("id") String id) {
        try{
            blogService.deleteBlog(id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BlogDTO> getAllBlogs(){
        return blogService.getAllBlogs();
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BlogStatus getSelectedBlog(@PathVariable ("id") String id) {
        return blogService.getBlog(id);
    }
    @GetMapping(value = "/{tag}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BlogDTO> getAllBlogsByTags(@PathVariable ("tag") String tag) {
        return blogService.getAllBlogsByTag(tag);
    }
}
