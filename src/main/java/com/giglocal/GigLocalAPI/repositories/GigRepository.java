package com.giglocal.GigLocalAPI.repositories;

import com.giglocal.GigLocalAPI.entities.Gig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GigRepository extends JpaRepository<Gig, Integer>{
}
