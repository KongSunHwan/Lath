package com.example.thishouse.util;

import com.example.thishouse.domain.Report;
import com.example.thishouse.domain.house.House_picture;
import com.example.thishouse.service.HouseService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class FileUpload {
    public final String uploadPath = "C:/Timp/img/";

    public void processFile(MultipartFile file, String fieldName, Report report) {
        if (!file.isEmpty()) {
            try {
                byte[] fileBytes = file.getBytes();

                String fileName = fieldName + "_" + UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                System.out.println("업로드된 파일 이름: " + fileName); // 파일 이름 출력

                Path filePath = Paths.get(uploadPath + fileName);
                Files.write(filePath, fileBytes);

                if (fieldName.equals("report_content_pic")) {
                    report.setReport_content_pic(fileName);
                } else if (fieldName.equals("report_seller_pic")) {
                    report.setReport_seller_pic(fileName);
                } else if (fieldName.equals("report_house_pic")) {
                    report.setReport_house_pic(fileName);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String generateSaveName(String original_name) {
        String uuid = UUID.randomUUID().toString();
        String extension = original_name.substring(original_name.lastIndexOf("."));
        String saveName = uuid + extension;

        // 파일명 중복 방지를 위해 파일명에 UUID 추가
        String filePath = uploadPath + saveName;
        while (Files.exists(Paths.get(filePath))) {
            uuid = UUID.randomUUID().toString();
            saveName = uuid + extension;
            filePath = uploadPath + saveName;
        }

        return saveName;
    }
    // 저장 파일명 생성
    public String extractFileNameFromPath(String filePath) {
        File file = new File(filePath);
        return file.getName();
    }
}
