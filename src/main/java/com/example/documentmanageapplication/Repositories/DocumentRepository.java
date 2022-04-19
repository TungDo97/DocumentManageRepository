package com.example.documentmanageapplication.Repositories;

import com.example.documentmanageapplication.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
