package lk.ijse.commentservice.util;

import java.util.UUID;

public class AppUtil {
    public static String generateCommentId(){
        return "COMMENT-" + UUID.randomUUID();
    }
}
