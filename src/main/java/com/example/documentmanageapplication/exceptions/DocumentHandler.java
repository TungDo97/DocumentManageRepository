package com.example.documentmanageapplication.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class DocumentHandler {

    @Value("${spring.servlet.multipart.max-file-size}")
    String maxFileSize;

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String processExceededSizeException(RedirectAttributes re){
        System.out.println("processing exceeded size exception");
        re.addFlashAttribute("errorMessage","You cannot upload a file with size larger than " + this.maxFileSize );
        return "redirect:/";
    }

}
