package com.hacakathon.vegetable.service;

import com.hacakathon.vegetable.domain.ImgInfo;
import com.hacakathon.vegetable.domain.VegeContent;
import com.hacakathon.vegetable.dto.content.vege.VegeImgUploadRequest;
import com.hacakathon.vegetable.repository.ImgInfoRepository;
import com.hacakathon.vegetable.repository.RecipeContentRepository;
import com.hacakathon.vegetable.repository.UserRepository;
import com.hacakathon.vegetable.repository.VegeContentRepository;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImgService {

    private final ImgInfoRepository imgInfoRepository;
    private final UserRepository userRepository;
    private final VegeContentRepository vegeContentRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final RecipeContentRepository recipeContentRepository;

    public String saveVegefile(String authorization, Long contentId, MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            String filename = file.getOriginalFilename();
            UUID uuid = UUID.randomUUID();
            String imgUuidName = uuid + "." + filename.substring(filename.lastIndexOf(".") + 1);
            FileOutputStream fileOutputStream = new FileOutputStream(imgUuidName);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
            imgInfoRepository.save(ImgInfo.builder()
                    .vegeContent(vegeContentRepository.findByVegeContentId(contentId))
                    .recepiContent(null)
                    .imgEXE(filename.substring(filename.lastIndexOf(".") + 1))
                    .imgName(imgUuidName)
                    .imgMaker(jwtTokenProvider.getUserId(authorization))
                    .build()
            );
        }
        return "업로드 성공";
    }

    public String saveRecepifile(String authorization, Long contentId, MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            String filename = file.getOriginalFilename();
            UUID uuid = UUID.randomUUID();
            String imgUuidName = uuid + "." + filename.substring(filename.lastIndexOf(".") + 1);
            FileOutputStream fileOutputStream = new FileOutputStream(imgUuidName);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
            imgInfoRepository.save(ImgInfo.builder()
                    .vegeContent(null)
                    .recepiContent(recipeContentRepository.findByRecepiContentId(contentId))
                    .imgEXE(filename.substring(filename.lastIndexOf(".") + 1))
                    .imgName(imgUuidName)
                    .imgMaker(jwtTokenProvider.getUserId(authorization))
                    .build()
            );
        }
        return "업로드 성공";
    }

//    public List<MultipartFile> loadVegeImg(String authorization, Long contentId) throws IOException{
//
//        return List<MultipartFile>;
//    }
//
//    public List<MultipartFile>loadRecepiImg(String authorization, Long contentId) throws IOException{
//
//        return List<MultipartFile>;
//    }
}
