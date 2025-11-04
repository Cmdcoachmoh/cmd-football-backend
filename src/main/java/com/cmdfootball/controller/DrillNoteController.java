package com.cmdfootball.controller;

import com.cmdfootball.model.DrillNote;
import com.cmdfootball.service.DrillNoteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/drills")
public class DrillNoteController {

    private final DrillNoteService service = new DrillNoteService();

    @GetMapping("/notes")
    public List<DrillNote> getDrillNotes() {
        return service.getNotes();
    }
}
