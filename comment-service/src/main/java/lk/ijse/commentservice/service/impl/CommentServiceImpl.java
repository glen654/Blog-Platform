package lk.ijse.commentservice.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.commentservice.dao.CommentDao;
import lk.ijse.commentservice.dto.impl.CommentDTO;
import lk.ijse.commentservice.entity.impl.CommentEntity;
import lk.ijse.commentservice.exception.CommentNotFoundException;
import lk.ijse.commentservice.exception.DataPersistException;
import lk.ijse.commentservice.service.CommentService;
import lk.ijse.commentservice.util.AppUtil;
import lk.ijse.commentservice.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveComment(CommentDTO commentDTO) {
        commentDTO.setId(AppUtil.generateCommentId());
        CommentEntity saveComment = commentDao.save(mapping.toCommentEntity(commentDTO));
        if (saveComment == null) {
            throw new DataPersistException("Save Comment Unsuccessful");
        }
    }

    @Override
    public void updateComment(String id, CommentDTO commentDTO) {
        Optional<CommentEntity> tmpComment = commentDao.findById(id);
        if(!tmpComment.isPresent()) {
            throw new CommentNotFoundException("Comment Not Found");
        }else {
            tmpComment.get().setAuthorId(commentDTO.getAuthorId());
            tmpComment.get().setBlogId(commentDTO.getBlogId());
            tmpComment.get().setContent(commentDTO.getContent());
            tmpComment.get().setCreatedAt(commentDTO.getCreatedAt());
        }
    }

    @Override
    public void deleteComment(String id) {
        Optional<CommentEntity> foundedComment = commentDao.findById(id);
        if(!foundedComment.isPresent()) {
            throw new CommentNotFoundException("Comment Not Found");
        }else {
            commentDao.deleteById(id);
        }
    }
}
