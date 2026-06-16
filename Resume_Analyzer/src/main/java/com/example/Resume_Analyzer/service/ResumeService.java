package com.example.Resume_Analyzer.service;

import com.example.Resume_Analyzer.dto.AnalysisResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

@Service
public class ResumeService {

    private final AIService aiService;
    private final ObjectMapper objectMapper;

    public ResumeService(AIService aiService) {
        this.aiService = aiService;
        this.objectMapper = new ObjectMapper();
    }

    public AnalysisResponse analyzeResume(MultipartFile file, String jobDescription) {

        try {
            // Step 1: Extract text (basic approach)
            String resumeText = extractText(file);

            // Step 2: Call AI Service
            String aiResponse = aiService.analyzeResume(resumeText, jobDescription);

            // Step 3: Extract JSON from AI response
            String json = extractJson(aiResponse);

            // Step 4: Convert JSON → DTO
            return objectMapper.readValue(json, AnalysisResponse.class);

        } catch (Exception e) {
            throw new RuntimeException("Error analyzing resume: " + e.getMessage());
        }
    }

    /**
     * Basic text extraction (works for simple text resumes)
     */
    private String extractText(MultipartFile file) throws Exception {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream())
        );

        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }

        return content.toString();
    }

    /**
     * Extract JSON from OpenAI response
     */
    private String extractJson(String response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<?, ?> map = mapper.readValue(response, Map.class);

            // Step 1: Navigate safely
            var candidates = (List<?>) map.get("candidates");
            var content = (Map<?, ?>) ((Map<?, ?>) candidates.get(0)).get("content");
            var parts = (List<?>) content.get("parts");
            String text = (String) ((Map<?, ?>) parts.get(0)).get("text");

            // Step 2: Clean markdown (IMPORTANT)
            text = text.replace("```json", "")
                    .replace("```", "")
                    .trim();

            // Step 3: Extract only JSON part
            int start = text.indexOf("{");
            int end = text.lastIndexOf("}");

            return text.substring(start, end + 1);

        } catch (Exception e) {
            e.printStackTrace(); // IMPORTANT for debugging
            throw new RuntimeException("Error parsing Gemini response");
        }
    }
}