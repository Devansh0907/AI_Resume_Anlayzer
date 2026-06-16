package com.example.Resume_Analyzer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class AIService {

    private final WebClient webClient;
    private final String apiKey;

    public AIService(@Value("${gemini.api.key}") String apiKey) {
        this.apiKey = apiKey;
        this.webClient = WebClient.builder()
                .baseUrl("https://generativelanguage.googleapis.com/v1/models/gemini-2.5-flash:generateContent")
                .build();
    }

    public String analyzeResume(String resumeText, String jobDescription) {

        String prompt = """
You are an ATS system.

Return ONLY valid JSON. No explanation, no markdown, no extra text.

Format:
{
  "matchedSkills": [],
  "missingSkills": [],
  "score": number,
  "suggestions": [],
  "improvedPoints": []
}

Resume:
%s

Job Description:
%s
""".formatted(resumeText, jobDescription);

        Map<String, Object> requestBody = Map.of(
                "contents", new Object[]{
                        Map.of(
                                "parts", new Object[]{
                                        Map.of("text", prompt)
                                }
                        )
                }
        );

        String response = webClient.post()
                .uri(uriBuilder -> uriBuilder.queryParam("key", apiKey).build())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("GEMINI RAW RESPONSE: " + response);

        return response;
    }
}