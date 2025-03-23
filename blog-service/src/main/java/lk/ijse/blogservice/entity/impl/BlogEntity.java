package lk.ijse.blogservice.entity.impl;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lk.ijse.blogservice.entity.Status;
import lk.ijse.blogservice.entity.SuperEntity;

import java.time.LocalDateTime;
import java.util.List;

public class BlogEntity implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Long authorId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private List<String> tags;
    private List<Comment> comments;
    private Status status;
}