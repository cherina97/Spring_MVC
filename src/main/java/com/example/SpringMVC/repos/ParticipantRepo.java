package com.example.SpringMVC.repos;

import com.example.SpringMVC.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRepo extends JpaRepository<Participant, Integer> {

    @Query("select p.userPhotoId from Participant p where p.id = :userId")
    Optional <String> getUserPhotoIdByUserId(@Param("userId") int userId);


}
