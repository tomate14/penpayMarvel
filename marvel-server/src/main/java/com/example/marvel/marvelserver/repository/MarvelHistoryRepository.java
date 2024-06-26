package com.example.marvel.marvelserver.repository;

import com.example.marvel.marvelserver.entity.MarvelHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarvelHistoryRepository extends JpaRepository<MarvelHistory, Long> {
}
