package lk.ijse.commentservice.dto.impl;

import lk.ijse.commentservice.dto.CommentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDTO implements CommentStatus {
    private String id;
    private String authorId;
    private String blogId;
    private String content;
    private LocalDateTime createdAt;
}
