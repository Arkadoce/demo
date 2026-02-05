package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ExpService {
    private static final int[] THRESHOLD = {
            0,0,300,900,2700,6500,14000,23000,34000,48000,
            64000,85000,100000,120000,140000,165000,
            195000,225000,265000,305000,355000
    };

    public int maxExpForLevel(int level) {
        if (level >= 20) return 0;
        return THRESHOLD[level + 1] - THRESHOLD[level];
    }

}

