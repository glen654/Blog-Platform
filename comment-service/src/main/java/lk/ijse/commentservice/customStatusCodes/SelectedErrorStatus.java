package lk.ijse.commentservice.customStatusCodes;

import lk.ijse.commentservice.dto.CommentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedErrorStatus implements CommentStatus {
    private int statusCode;
    private String statusMessage;
}
