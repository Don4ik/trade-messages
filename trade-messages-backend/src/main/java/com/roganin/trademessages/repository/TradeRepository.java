package com.roganin.trademessages.repository;


import com.roganin.trademessages.model.TradeMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<TradeMessage, Integer> {
}
