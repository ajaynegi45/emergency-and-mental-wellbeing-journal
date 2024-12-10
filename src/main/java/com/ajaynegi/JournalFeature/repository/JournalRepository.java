package com.ajaynegi.JournalFeature.repository;


import com.ajaynegi.JournalFeature.model.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends MongoRepository<Journal, String> {
}
