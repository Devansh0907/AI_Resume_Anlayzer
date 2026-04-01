package com.example.Resume_Analyzer.model;

import java.util.List;

public class ResumeData {

    private String name;
    private String email;
    private String phone;

    private List<String> skills;
    private List<String> education;
    private List<String> experience;
    private List<String> projects;

    private String rawText; // full extracted resume text

    // Constructors
    public ResumeData() {}

    public ResumeData(String name, String email, String phone,
                      List<String> skills, List<String> education,
                      List<String> experience, List<String> projects,
                      String rawText) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.skills = skills;
        this.education = education;
        this.experience = experience;
        this.projects = projects;
        this.rawText = rawText;
    }

    // Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getEducation() {
        return education;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    public List<String> getExperience() {
        return experience;
    }

    public void setExperience(List<String> experience) {
        this.experience = experience;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }
}