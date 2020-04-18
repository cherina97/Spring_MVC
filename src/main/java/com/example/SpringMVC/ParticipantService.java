package com.example.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    private ParticipantRepo participantRepo;

    @Autowired
    public ParticipantService(ParticipantRepo participantRepo) {
        this.participantRepo = participantRepo;
    }

    public void createForUpdate (Participant participant){
        participantRepo.save(participant);
    }

    public void create(ParticipantDto participantDto) {
        Participant participant = new Participant(participantDto.getName(),
                participantDto.getEmail(), participantDto.getLevel(), participantDto.getPrimarySkill());
        participantRepo.save(participant);
    }

    public List<Participant> readAll() {
        return participantRepo.findAll();
    }

    public void deleteById(int id) {
        participantRepo.deleteById(id);
    }

    public Optional<Participant> getById(int id) {
        return participantRepo.findById(id);
    }
}
