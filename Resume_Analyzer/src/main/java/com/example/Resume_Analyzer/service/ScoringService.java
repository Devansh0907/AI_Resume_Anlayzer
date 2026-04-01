package com.example.Resume_Analyzer.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoringService {

    /**
     * Calculate ATS score based on matched vs missing skills
     */
    public int calculateScore(List<String> matchedSkills, List<String> missingSkills) {

        int matched = matchedSkills != null ? matchedSkills.size() : 0;
        int missing = missingSkills != null ? missingSkills.size() : 0;

        int total = matched + missing;

        if (total == 0) return 0;

        double score = ((double) matched / total) * 100;

        return (int) Math.round(score);
    }

    /**
     * Bonus scoring based on resume content quality
     */
    public int bonusScore(String resumeText) {

        int bonus = 0;

        if (resumeText == null || resumeText.isEmpty()) return 0;

        String lower = resumeText.toLowerCase();

        // Keywords that improve ATS score
        if (lower.contains("project")) bonus += 5;
        if (lower.contains("experience")) bonus += 5;
        if (lower.contains("internship")) bonus += 5;
        if (lower.contains("spring boot")) bonus += 5;
        if (lower.contains("api")) bonus += 5;

        return Math.min(bonus, 20); // max bonus = 20
    }

    /**
     * Final score combining AI + bonus
     */
    public int finalScore(int baseScore, int bonusScore) {

        int finalScore = baseScore + bonusScore;

        return Math.min(finalScore, 100); // cap at 100
    }
}