package com.namma.user.Repository;

import com.namma.user.Entity.MetroCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetroCardRepository extends JpaRepository<MetroCard, Long> {
}
