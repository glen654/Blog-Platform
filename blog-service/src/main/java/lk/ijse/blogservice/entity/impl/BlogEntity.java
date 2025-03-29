package lk.ijse.blogservice.entity.impl;

import jakarta.persistence.*;
import lk.ijse.blogservice.entity.Status;
import lk.ijse.blogservice.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "blogs")
public class BlogEntity implements SuperEntity {
    @Id
    private String id;
    @Column(nullable = false, length = 255)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    @Column(nullable = false)
    private Long authorId;
    @Column(nullable = false)
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    @ElementCollection
    @CollectionTable(name = "blog_tags", joinColumns = @JoinColumn(name = "blog_id"))
    private List<String> tags;
    @Enumerated(EnumType.STRING)
    private Status status;
}
