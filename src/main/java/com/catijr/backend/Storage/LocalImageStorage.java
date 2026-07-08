package com.catijr.backend.Storage;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

@Component
public class LocalImageStorage {

    private final Path uploadDir = Paths.get("uploads/images");

    public LocalImageStorage() throws IOException {
        Files.createDirectories(uploadDir);
    }

    public String save(MultipartFile file) throws IOException, NoSuchAlgorithmException {
        byte[] bytes = file.getBytes();

        String filename = hashContent(bytes) + extractExtension(file.getOriginalFilename());

        Path destination = uploadDir.resolve(filename);
        if (!Files.exists(destination)) {
            Files.write(destination, bytes);
        }

        return filename;
    }

    public static String toUrl(String imagePath) {
        return imagePath != null ? "/images/" + imagePath : null;
    }

    private String extractExtension(String originalFilename) {
        if (originalFilename == null || !originalFilename.contains(".")) {
            return "";
        }

        return originalFilename.substring(originalFilename.lastIndexOf("."));
    }

    private String hashContent(byte[] bytes) throws NoSuchAlgorithmException {
        // 
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        byte[] hashBytes = digest.digest(bytes);

        return HexFormat.of().formatHex(hashBytes);
    }
}
