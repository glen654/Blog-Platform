package lk.ijse.commentservice.entity.impl;

import jakarta.persistence.*;
import lk.ijse.commentservice.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "comments")
public class CommentEntity implements SuperEntity {
    @Id
    private String id;
    @Column(nullable = false)
    private String authorId;
    @Column(nullable = false)
    private String blogId;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    @Column(nullable = false)
    private LocalDateTime createdAt;
}
