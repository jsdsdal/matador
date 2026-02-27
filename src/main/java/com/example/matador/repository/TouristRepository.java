package com.example.matador.repository;

import com.example.matador.model.TouristAttraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TouristRepository extends JpaRepository<TouristAttraction, Integer> {
    Optional<TouristAttraction> findByNameIgnoreCase(String name);
    void deleteByNameIgnoreCase(String name);
}