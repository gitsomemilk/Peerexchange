package com.example.peerexchange.Repositories;

import com.example.peerexchange.Models.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
