package com.example.thishouse.controller;

import com.example.thishouse.domain.house.House_picture;
import com.example.thishouse.mapper.RealEstateMapper;
import com.example.thishouse.service.RealEstateService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
public class FileUploadController {

    private final String uploadPath = "C:/upload/";

    private final RealEstateService realEstateService;

    public FileUploadController(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    @GetMapping("/upload")
    public String handleFileUploadView() {
        return "test_kong/uploadFile";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("files") List<MultipartFile> files) {
        List<String> filePaths = new ArrayList<>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    String originalFilename = file.getOriginalFilename();
                    String saveFilename = generateSaveName(originalFilename);
                    String filePath = uploadPath + saveFilename;
                    file.transferTo(new File(filePath));

                    filePaths.add(filePath);
                    System.out.println("파일 경로: " + filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        for (String filePath : filePaths) {
            House_picture house_picture = new House_picture();
            house_picture.setFilePath(filePath);

            realEstateService.insert_picture(house_picture);

            System.out.println("파일 경로를 활용한 처리: " + filePath);
        }

        return "redirect:/images";
    }

    private String generateSaveName(String original_name) {
        String uuid = UUID.randomUUID().toString();
        String extension = original_name.substring(original_name.lastIndexOf("."));
        String saveName = uuid + extension;
        return saveName;
    }

    @GetMapping("/images")
    public String viewImages(Model model) {
        List<House_picture> housePictures = realEstateService.getHousePictures();
        model.addAttribute("housePictures", housePictures);
        return "test_kong/imageGallery";
    }

    @GetMapping("/images/{filePath}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filePath) throws FileNotFoundException {
        Resource file = realEstateService.loadFileAsResource(filePath);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
