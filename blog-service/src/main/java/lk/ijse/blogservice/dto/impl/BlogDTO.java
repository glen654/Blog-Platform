package lk.ijse.blogservice.dto.impl;

import lk.ijse.blogservice.dto.BlogStatus;
import lk.ijse.blogservice.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogDTO implements BlogStatus {
    private String id;
    private String title;
    private String content;
    private Long authorId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private List<String> tags;
    private Status status;
}
