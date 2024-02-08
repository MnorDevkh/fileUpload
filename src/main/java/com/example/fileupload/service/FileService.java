package com.example.fileupload.service;

import com.example.fileupload.model.File;
import com.example.fileupload.repository.FileRepository;
import com.example.fileupload.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public File store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        File files = new File();
        files.setFileName(fileName);
        files.setFileType(file.getContentType());
        files.setFileData(ImageUtils.compressImage(file.getBytes()));
        System.out.println( "File"+ files);
        return fileRepository.save(files);
    }
    public File getFile(String id) {
        return fileRepository.findById(id).get();
    }

    public Stream<File> getAllFiles() {
        return fileRepository.findAll().stream();
    }

}
