package com.moaaz.wuzzufmostaql.Service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileService {

    public static String savePdf(MultipartFile file) {
        // Create the file path
        String projectPath = "E:\\Spring Projects\\wuzzuf-mostaql\\src\\main\\java\\com\\moaaz\\wuzzufmostaql\\pdfs\\";
        String filePath = projectPath + file.getOriginalFilename();
        // Save the file
        save(file, filePath);
        return filePath;
    }

    public static String saveImage(MultipartFile file) {
        // Create the file path
        String projectPath = "E:\\Spring Projects\\wuzzuf-mostaql\\src\\main\\java\\com\\moaaz\\wuzzufmostaql\\images\\";
        String filePath = projectPath + file.getOriginalFilename();
        // Save the file
        save(file, filePath);
        return filePath;
    }

    public static String saveLogo(MultipartFile file) {
        // Create the file path
        String projectPath = "E:\\Spring Projects\\wuzzuf-mostaql\\src\\main\\java\\com\\moaaz\\wuzzufmostaql\\logo\\";
        String filePath = projectPath + file.getOriginalFilename();
        // Save the file
        save(file, filePath);
        return filePath;
    }


    @SneakyThrows
    private static void save(MultipartFile file, String filePath) {

        try {
            File dest = new File(filePath);
            file.transferTo(dest);
        } catch (Exception exception) {
            throw exception;
        }
    }
}
