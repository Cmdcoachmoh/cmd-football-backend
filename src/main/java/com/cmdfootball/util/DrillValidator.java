package com.cmdfootball.util;

public class DrillValidator {

    public static boolean isValidLevel(int level) {
        return level >= 1 && level <= 6;
    }

    public static boolean isValidBonus(int bonus) {
        return bonus >= 0 && bonus <= 6;
    }

    public static boolean isValidMalus(int malus) {
        return malus >= 0 && malus <= 6;
    }

    public static boolean isValidDrill(String name, int level, int bonus, int malus) {
        return name != null && !name.trim().isEmpty()
            && isValidLevel(level)
            && isValidBonus(bonus)
            && isValidMalus(malus);
    }
}
