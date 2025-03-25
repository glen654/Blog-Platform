package lk.ijse.blogservice.util;

import java.util.UUID;

public class AppUtil {
    public static String generateBlogId(){
        return "BLOG-" + UUID.randomUUID();
    }
}
