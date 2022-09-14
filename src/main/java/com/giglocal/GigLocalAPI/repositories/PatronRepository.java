package com.giglocal.GigLocalAPI.repositories;

import com.giglocal.GigLocalAPI.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron, Integer> {
}
