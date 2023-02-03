package com.example.peerexchange.Repositories;

import com.example.peerexchange.Models.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    @Query(value = "SELECT * FROM submission ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Submission getRandomRow();
}
