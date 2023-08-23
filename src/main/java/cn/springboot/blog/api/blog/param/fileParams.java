package cn.springboot.blog.api.blog.param;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
public class fileParams implements Serializable {
    MultipartFile[] photos;
    String originalEmail;
}
