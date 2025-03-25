package lk.ijse.blogservice.customStatusCodes;

import lk.ijse.blogservice.dto.BlogStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedErrorStatus implements BlogStatus {
    private int statusCode;
    private String statusMessage;
}
