package com.example.Resume_Analyzer.dto;

import java.util.List;

public class AnalysisResponse {

    private List<String> matchedSkills;
    private List<String> missingSkills;
    private int score;
    private List<String> suggestions;
    private List<String> improvedPoints;

    // Getters & Setters

    public List<String> getMatchedSkills() {
        return matchedSkills;
    }

    public void setMatchedSkills(List<String> matchedSkills) {
        this.matchedSkills = matchedSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
    }

    public List<String> getImprovedPoints() {
        return improvedPoints;
    }

    public void setImprovedPoints(List<String> improvedPoints) {
        this.improvedPoints = improvedPoints;
    }
}