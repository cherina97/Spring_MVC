package com.example.SpringMVC.controllers;

import com.example.SpringMVC.entities.UserPhotoFile;
import com.example.SpringMVC.services.UserPhotoFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user-photo")
public class UserPhotoFileController {

    @Autowired
    private UserPhotoFileService userPhotoFileService;

    @PostMapping("/upload")
    public String uploadPhoto(@RequestParam("userPhoto") MultipartFile file){
        UserPhotoFile userPhotoFile = userPhotoFileService.create(file);
        return userPhotoFile.getId();
    }

    @GetMapping("/download/{photoId}")
    public ResponseEntity<Resource> downloadPhoto(@PathVariable String photoId){
        UserPhotoFile photoFile = userPhotoFileService.getById(photoId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(photoFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + photoFile.getFileName())
                .body(new ByteArrayResource(photoFile.getData()));
    }
}
