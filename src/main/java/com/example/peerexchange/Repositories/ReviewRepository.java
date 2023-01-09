package com.example.peerexchange.Repositories;

import com.example.peerexchange.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long > {
}
