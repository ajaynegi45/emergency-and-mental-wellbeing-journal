package com.ajaynegi.JournalFeature.service;

import com.ajaynegi.JournalFeature.model.Journal;
import com.ajaynegi.JournalFeature.repository.JournalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JournalService {

    private final JournalRepository journalRepository;

    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public List<Journal> getAllJournals(String userId) {
        List<Journal> journals = journalRepository.findAll();

        // Log the fetched journals and userId
        System.out.println("Fetched journals: " + journals.toString());
        System.out.println("UserId passed: " + userId);

//        List<Journal> filteredJournals = journals.stream()
//                .filter(journal -> journal.getUserId() != null && j.getUserId().equals(userId))
//                .collect(Collectors.toList());


        List<Journal> filteredJournals = journals.stream().filter(journal -> journal.getUserId().equals(userId)).collect(Collectors.toList());

        // Log the filtered results
        System.out.println("Filtered journals: " + filteredJournals);

        return filteredJournals;
    }


    public Optional<Journal> getJournalById(String id) {
        return journalRepository.findById(id);
    }

    public Journal createJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    public void deleteJournal(String id) {
        journalRepository.deleteById(id);
    }

    public Journal updateJournal(Journal updatedJournal) {
        return journalRepository.save(updatedJournal); // Save the updated journal in the database
    }

}
