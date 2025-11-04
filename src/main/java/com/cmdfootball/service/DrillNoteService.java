package com.cmdfootball.service;

import com.cmdfootball.model.DrillNote;
import com.cmdfootball.data.DrillNoteData;
import java.util.List;

public class DrillNoteService {
    public List<DrillNote> getNotes() {
        return DrillNoteData.getAllNotes();
    }
}

