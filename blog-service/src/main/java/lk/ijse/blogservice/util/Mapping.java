package lk.ijse.blogservice.util;

import lk.ijse.blogservice.dto.impl.BlogDTO;
import lk.ijse.blogservice.entity.impl.BlogEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<BlogDTO> toBlogDTOList(List<BlogEntity> blogEntitiesList) {
        return modelMapper.map(blogEntitiesList,new TypeToken<List<BlogDTO>>() {}.getType());
    }

    public List<BlogEntity> toBlogEntityList(List<BlogDTO> blogDTOList) {
        return modelMapper.map(blogDTOList,new TypeToken<List<BlogEntity>>() {}.getType());
    }
}
