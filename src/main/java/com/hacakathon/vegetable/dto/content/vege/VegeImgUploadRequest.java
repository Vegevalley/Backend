package com.hacakathon.vegetable.dto.content.vege;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
@ToString
public class VegeImgUploadRequest {
    private String authorization;
    private Long contentId;
    private MultipartFile file;

    @Builder
    public VegeImgUploadRequest(String authorization, Long contentId, MultipartFile file){
        this.authorization = authorization;
        this.contentId = contentId;
        this.file = file;
    }
}
