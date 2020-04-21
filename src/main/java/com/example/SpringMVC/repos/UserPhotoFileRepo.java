package com.example.SpringMVC.repos;

import com.example.SpringMVC.entities.UserPhotoFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPhotoFileRepo extends JpaRepository<UserPhotoFile, String> {
}
