package lk.ijse.commentservice.service;

import lk.ijse.commentservice.dto.impl.CommentDTO;

public interface CommentService {
    void saveComment(CommentDTO commentDTO);
    void updateComment(String id,CommentDTO commentDTO);
    void deleteComment(String id);
}
