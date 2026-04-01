package com.example.Resume_Analyzer.controller;

import com.example.Resume_Analyzer.dto.AnalysisResponse;
import com.example.Resume_Analyzer.service.ResumeService;

import jakarta.validation.constraints.NotBlank;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "*")
public class ResumeController {

    private final ResumeService resumeService;

    // Constructor Injection
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    /**
     * Analyze Resume with Job Description
     */
    @PostMapping(value = "/analyze", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AnalysisResponse> analyzeResume(
            @RequestPart("file") MultipartFile file,
            @RequestParam("jobDescription") @NotBlank String jobDescription
    ) {

        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        AnalysisResponse response = resumeService.analyzeResume(file, jobDescription);

        return ResponseEntity.ok(response);
    }

    /**
     * Analyze Resume Only
     */
    @PostMapping(value = "/analyze-resume", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AnalysisResponse> analyzeOnlyResume(
            @RequestPart("file") MultipartFile file
    ) {

        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        AnalysisResponse response = resumeService.analyzeResume(file, "");

        return ResponseEntity.ok(response);
    }

    /**
     * Health Check
     */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("API is running");
    }
}