package com.example.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping("/")
    public String showAll(HttpServletRequest request){
        request.setAttribute("participants", participantService.readAll());
        request.setAttribute("mode", "VIEW");
        return "index";
    }

    @GetMapping("/addNew")
    public String addNew (HttpServletRequest request){
        request.setAttribute("mode", "CREATE");
        return "index";
    }

    @PostMapping("/create")
    public String createNew (HttpServletRequest request, @ModelAttribute ParticipantDto participantDto){
        participantService.create(participantDto);
        request.setAttribute("participants", participantService.readAll());
        request.setAttribute("mode", "VIEW");
        return "index";
    }

    @GetMapping("/delete")
    public String deleteById(HttpServletRequest request, @RequestParam(name = "id") int participantId){
        participantService.deleteById(participantId);
        request.setAttribute("participants", participantService.readAll());
        request.setAttribute("mode", "VIEW");
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update (HttpServletRequest request, @RequestParam(name = "id") int participantId){
        Optional<Participant> participantMaybe = participantService.getById(participantId);
        if (participantMaybe.isPresent()){
            request.setAttribute("participant", participantMaybe.get());
            request.setAttribute("mode", "EDIT");
            return "index";
        }
        return "NoParticipantExist";
    }

    @PostMapping("/save")
    public String saveChanges (HttpServletRequest request, @ModelAttribute Participant participant){
        participantService.createForUpdate(participant);
        request.setAttribute("participants", participantService.readAll());
        request.setAttribute("mode", "VIEW");
        return "index";
    }
}
