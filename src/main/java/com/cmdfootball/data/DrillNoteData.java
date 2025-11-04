package com.cmdfootball.data;

import com.cmdfootball.model.DrillNote;
import java.util.List;

public class DrillNoteData {
    public static List<DrillNote> getAllNotes() {
        return List.of(
            new DrillNote("Ali", "2V1UpDown", +1, "Quick transition"),
            new DrillNote("Zara", "2V2TwoNet", -1, "Lost defensive shape"),
            new DrillNote("Leo", "3v2Fixing", +1, "Fixed defender before pass"),
            new DrillNote("Maya", "3v2BackPass", -1, "Back pass under pressure"),
            new DrillNote("Ali", "Musketeer1", +1, "All players involved"),
            new DrillNote("Zara", "Musketeer2", -1, "Missed zone entry"),
            new DrillNote("Leo", "4V4TwoNet", +1, "Used weak-side net"),
            new DrillNote("Maya", "3v2BackPass2", -1, "No second wave"),
            new DrillNote("Ali", "4V4Possession", +1, "Maintained 5-pass sequence"),
            new DrillNote("Zara", "4V4BonusMalus", -1, "Lazy press"),
            new DrillNote("Leo", "5V5TwoJokers", +1, "Used joker effectively"),
            new DrillNote("Maya", "6V4HitOnGoal", -1, "Missed timing"),
            new DrillNote("Ali", "6V6CloseNet", +1, "One-touch play"),
            new DrillNote("Zara", "8V8Transmission", -1, "Slow zone switch"),
            new DrillNote("Leo", "7V7Zona", +1, "Covered zone well"),
            new DrillNote("Maya", "8V8BreakCone", -1, "Missed cone gate"),
            new DrillNote("Ali", "9v9HowToPlay", +1, "Pressed with discipline"),
            new DrillNote("Zara", "6V6Ronda", -1, "Static play")
        );
    }
}
