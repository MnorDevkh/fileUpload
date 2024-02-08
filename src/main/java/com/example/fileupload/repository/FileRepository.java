package com.example.fileupload.repository;


import com.example.fileupload.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository  extends JpaRepository<File, String> {
}
