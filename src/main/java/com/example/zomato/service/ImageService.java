package com.example.zomato.service;

import com.cloudinary.Cloudinary;
import lombok.AllArgsConstructor;
import org.apache.hc.client5.http.entity.mime.MultipartPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

@AllArgsConstructor
public class ImageService {
    private final Cloudinary cloudinary;

    public String uploadImage(MultipartFile file) throws IOException {
        Map result = cloudinary.uploader().upload(file.getBytes(), Map.of());
        return result.get("url").toString();
    }
}
