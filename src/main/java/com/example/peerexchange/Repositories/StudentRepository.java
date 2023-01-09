package com.example.peerexchange.Repositories;

import com.example.peerexchange.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
