package com.hacakathon.vegetable.dto.content.img;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class ImgListResponse {
    private List<MultipartFile> multipartFileList;
}
