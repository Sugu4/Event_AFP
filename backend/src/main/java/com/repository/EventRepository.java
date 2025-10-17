package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Event;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e " +
            "JOIN FETCH e.organisator " +
            "JOIN FETCH e.location " +
            "JOIN FETCH e.eventTyp " +
            "WHERE e.id = :id")
    Optional<Event> findByIdWithDetails(@Param("id") Long id);
}