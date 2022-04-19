package com.example.documentmanageapplication.services;

import com.example.documentmanageapplication.Repositories.DocumentRepository;
import com.example.documentmanageapplication.models.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public boolean processUploadFile(MultipartFile multipartFile) throws IOException {
        Document newDocument = new Document();
        newDocument.setNameFile( multipartFile.getOriginalFilename());
        try {
            newDocument.setContent( multipartFile.getBytes());
        }
        catch (IOException e){
            throw new IOException();
        }

        newDocument.setSizeFile( multipartFile.getSize() );
        newDocument.setUploadedDate( new Date());
        this.documentRepository.save( newDocument);
        return true;
    }

    public boolean processDownloadFile(HttpServletResponse httpServletResponse, Integer idDocument) throws Exception{
        Optional<Document> existsDocument = this.documentRepository.findById(idDocument);

        if( !existsDocument.isPresent() ){
            throw new Exception(" Can't find this document with ID: " + idDocument);
        }
        Document document = existsDocument.get();

        httpServletResponse.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=" + document.getNameFile();

        httpServletResponse.setHeader( headerKey, headerValue);
        ServletOutputStream outputStream= httpServletResponse.getOutputStream();
        outputStream.write(document.getContent());
        outputStream.flush();
        outputStream.close();

        return true;
    }

    public List<Document> getAllDocs(){
        return this.documentRepository.findAll();
    }


}