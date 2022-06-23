package com.hacakathon.vegetable.controller;


import com.hacakathon.vegetable.dto.content.vege.VegeImgUploadRequest;
import com.hacakathon.vegetable.service.ImgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
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

    @PostMapping("/content/vege/img")
    public ResponseEntity<String> saveVegeImg(
            @RequestParam String authorization,
            @RequestParam Long contentId,
            @RequestParam MultipartFile file
    ) throws IOException {
        System.out.println("contentId = " + contentId);
        return ResponseEntity.ok(imgService.saveVegefile(authorization, contentId, file));
    }

    @PostMapping(value = "/content/recepi/img",
            produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public ResponseEntity<String> saveRecepiImg(
            @RequestParam String authorization,
            @RequestParam Long contentId,
            @RequestParam MultipartFile file
    ) throws IOException {
        System.out.println("contentId = " + contentId);
        return ResponseEntity.ok(imgService.saveRecepifile(authorization, contentId, file));
    }

    @GetMapping("/content/vege/img")
    public ResponseEntity<List<byte[]>> loadVegeImg(
            @RequestParam String authorization,
            @RequestParam Long contentId) throws IOException{

        return ResponseEntity.ok(imgService.loadVegeImg(authorization, contentId));
    }

    @GetMapping("/content/recepi/img")
    public ResponseEntity<List<byte[]>> loadRecepiImg(
            @RequestParam String authorization,
            @RequestParam Long contentId) throws IOException {
        return ResponseEntity.ok(imgService.loadRecepiImg(authorization, contentId));
    }

}
