package com.example.documentmanageapplication.controllers;

import com.example.documentmanageapplication.Repositories.DocumentRepository;
import com.example.documentmanageapplication.models.Document;
import com.example.documentmanageapplication.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping("/")
    public String getDocumentPage(Model model){
        model.addAttribute("docs",this.documentService.getAllDocs());
        return "index";
    }

    @PostMapping("/upload_file")
    public String processUploadFile(@RequestParam("fileAttachment")MultipartFile multipartFile) throws IOException {
        this.documentService.processUploadFile(multipartFile);
        return "redirect:/";
    }

    @GetMapping("/download_file/{id_document}")
    public void processDownloadFile(@PathVariable("id_document") Integer id_document, HttpServletResponse httpServletResponse) throws Exception{
        this.documentService.processDownloadFile(httpServletResponse, id_document);
    }

    @GetMapping("/find_your_current_location_on_map")
    public String findYourCurrentLocationOnMap(){
        return "find_your_current_location_on_map";
    }

    @GetMapping("/find_your_current_location_on_map_2")
    public String findYourCurrentLocationOnMap2(){
        return "takephotosdirectly";
    }

}
