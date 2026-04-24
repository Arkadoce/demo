package com.example.demo.dto;

public record StatsDto(
        int Str,
        int strMod,
        int Dex,
        int dexMod,
        int Con,
        int conMod,
        int Int,
        int intMod,
        int Wis,
        int wisMod,
        int Cha,
        int chaMod
) {

    public String format(int score, int mod) {
        return score + " (" + (mod >= 0 ? "+" : "") + mod + ")";
    }
}
