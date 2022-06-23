package com.hacakathon.vegetable.controller;


import com.hacakathon.vegetable.dto.content.vege.VegeImgUploadRequest;
import com.hacakathon.vegetable.service.ImgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class ImgController {

    private final ImgService imgService;
// PostMan작업을 위해서 Body의 form_data로 패킷을 날려야함, 안드로이드의 경우 multipart/form-data로 전송하면 된다
    @PostMapping("/content/vege/img")
    public ResponseEntity<String> saveVegeImg(
            @RequestParam String authorization,
            @RequestParam Long contentId,
            @RequestParam MultipartFile file
    ) throws IOException {
        System.out.println("contentId = " + contentId);
        return ResponseEntity.ok(imgService.saveVegefile(authorization, contentId, file));
    }

    @PostMapping("/content/recepi/img")
    public ResponseEntity<String> saveRecepiImg(
            @RequestParam String authorization,
            @RequestParam Long contentId,
            @RequestParam MultipartFile file
    ) throws IOException {
        System.out.println("contentId = " + contentId);
        return ResponseEntity.ok(imgService.saveRecepifile(authorization, contentId, file));
    }

//    @GetMapping("/content/vege/img")
//    public ResponseEntity<List<MultipartFile>> loadVegeImg(
//            @RequestParam String authorization,
//            @RequestParam Long contentId) throws IOException{
//
//        return ResponseEntity.ok(imgService.loadVegeImg(authorization, contentId));
//    }
//
//    @GetMapping("/content/recepi/img")
//    public ResponseEntity<List<MultipartFile>> loadRecepiImg(
//            @RequestParam String authorization,
//            @RequestParam Long contentId) throws IOException {
//        return ResponseEntity.ok(imgService.loadRecepiImg(authorization, contentId));
//    }

}
