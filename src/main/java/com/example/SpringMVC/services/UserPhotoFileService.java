package com.example.SpringMVC.services;


import com.example.SpringMVC.entities.UserPhotoFile;
import com.example.SpringMVC.repos.UserPhotoFileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class UserPhotoFileService {

    private UserPhotoFileRepo userPhotoFileRepo;

    @Autowired
    public UserPhotoFileService(UserPhotoFileRepo userPhotoFileRepo) {
        this.userPhotoFileRepo = userPhotoFileRepo;
    }

    public UserPhotoFile create(MultipartFile file){
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        try{
            UserPhotoFile userPhotoFile = new UserPhotoFile(fileName, file.getContentType(), file.getBytes());
            return userPhotoFileRepo.save(userPhotoFile);
        } catch (IOException e) {
            throw new RuntimeException("Could not store file " + fileName, e);
        }
    }

    public UserPhotoFile getById(String photoId){
        return userPhotoFileRepo.findById(photoId)
                .orElseThrow(() -> new RuntimeException("File not found with id " + photoId));
    }

}
