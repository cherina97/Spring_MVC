package com.example.SpringMVC.services;

import com.example.SpringMVC.dtos.ParticipantDto;
import com.example.SpringMVC.entities.Participant;
import com.example.SpringMVC.repos.ParticipantRepo;
import com.example.SpringMVC.repos.UserPhotoFileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    private ParticipantRepo participantRepo;
    private UserPhotoFileRepo userPhotoFileRepo;

    @Autowired
    public ParticipantService(ParticipantRepo participantRepo, UserPhotoFileRepo userPhotoFileRepo) {
        this.participantRepo = participantRepo;
        this.userPhotoFileRepo = userPhotoFileRepo;
    }

    public void createForUpdate (Participant participant){
        participantRepo.save(participant);
    }

    public void create(ParticipantDto participantDto) {
        Participant participant = new Participant(participantDto.getName(),
                participantDto.getEmail(), participantDto.getLevel(), participantDto.getPrimarySkill());
        String userPhotoId = participantDto.getUserPhotoId();
        if(!userPhotoId.isEmpty()){
            participant.setUserPhotoId(userPhotoId);
        }
        participantRepo.save(participant);
    }

    public List<Participant> readAll() {
        return participantRepo.findAll();
    }

    public void deleteById(int id) {
        participantRepo.getUserPhotoIdByUserId(id)
                .ifPresent(photo -> userPhotoFileRepo.deleteById(photo));
        participantRepo.deleteById(id);
    }

    public Optional<Participant> getById(int id) {
        return participantRepo.findById(id);
    }
}
