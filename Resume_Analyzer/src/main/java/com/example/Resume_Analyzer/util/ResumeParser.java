package com.example.Resume_Analyzer.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Component
public class ResumeParser {

    public String parseResume(MultipartFile file) {

        try {
            String fileName = file.getOriginalFilename();

            if (fileName == null) {
                throw new RuntimeException("Invalid file");
            }

            if (fileName.endsWith(".pdf")) {
                return parsePDF(file);
            } else if (fileName.endsWith(".docx")) {
                return parseDOCX(file);
            } else if (fileName.endsWith(".txt")) {
                return new String(file.getBytes());
            } else {
                throw new RuntimeException("Unsupported file format");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error parsing resume: " + e.getMessage());
        }
    }

    /**
     * PDF Parsing using PDFBox
     */
    private String parsePDF(MultipartFile file) throws Exception {
        try (InputStream input = file.getInputStream()) {
            PDDocument document = PDDocument.load(input);
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }

    /**
     * DOCX Parsing using Apache POI
     */
    private String parseDOCX(MultipartFile file) throws Exception {

        try (InputStream inputStream = file.getInputStream();
             XWPFDocument document = new XWPFDocument(inputStream)) {

            StringBuilder text = new StringBuilder();

            document.getParagraphs().forEach(p ->
                    text.append(p.getText()).append("\n")
            );

            return text.toString();
        }
    }
}