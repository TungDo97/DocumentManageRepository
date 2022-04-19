package com.example.documentmanageapplication.models;

import javax.persistence.*;
import java.util.Base64;
import java.util.Date;

@Entity
@Table
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameFile;
    private Long sizeFile;
    private byte[] content;
    private Date uploadedDate;

    public Document(){

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameFile() {
        return this.nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public Long getSizeFile() {
        return this.sizeFile;
    }

    public void setSizeFile(Long sizeFile) {
        this.sizeFile = sizeFile;
    }

    public byte[] getContent() {
        return this.content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Date getUploadedDate() {
        return this.uploadedDate;
    }

    public void setUploadedDate(Date uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    @Transient
    private String imageBase64;

    public String getImageBase64() {
        if( this.content != null){
            this.imageBase64 = Base64.getEncoder().encodeToString( this.content);
        }
        return this.imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}
