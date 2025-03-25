package lk.ijse.blogservice.util;

import lk.ijse.blogservice.dto.impl.BlogDTO;
import lk.ijse.blogservice.entity.impl.BlogEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public BlogEntity toBlogEntity(BlogDTO blogDTO) {
        return modelMapper.map(blogDTO, BlogEntity.class);
    }

    public BlogDTO toBlogDTO(BlogEntity blogEntity) {
        return modelMapper.map(blogEntity, BlogDTO.class);
    }
}
