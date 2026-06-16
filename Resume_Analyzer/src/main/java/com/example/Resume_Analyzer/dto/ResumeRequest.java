package com.example.Resume_Analyzer.dto;

import org.springframework.web.multipart.MultipartFile;

public class ResumeRequest {

    private MultipartFile file;
    private String jobDescription;

    // Constructors
    public ResumeRequest() {
    }

    public ResumeRequest(MultipartFile file, String jobDescription) {
        this.file = file;
        this.jobDescription = jobDescription;
    }

    // Getters and Setters
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}