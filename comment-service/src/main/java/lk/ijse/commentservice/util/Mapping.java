package lk.ijse.commentservice.util;

import lk.ijse.commentservice.dto.impl.CommentDTO;
import lk.ijse.commentservice.entity.impl.CommentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public CommentEntity toCommentEntity(CommentDTO commentDTO) {
        return modelMapper.map(commentDTO, CommentEntity.class);
    }

    public CommentDTO toCommentDTO(CommentEntity commentEntity) {
        return modelMapper.map(commentEntity, CommentDTO.class);
    }
}
