package com.roganin.trademessages.service.impl;


import com.roganin.trademessages.controller.TradeController;
import com.roganin.trademessages.model.TradeMessage;
import com.roganin.trademessages.repository.TradeRepository;
import com.roganin.trademessages.service.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {

    private final TradeRepository tradeRepository;

    private static final Logger log = LoggerFactory.getLogger(TradeServiceImpl.class);

    @Autowired
    public TradeServiceImpl(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Override
    public void saveMessage(TradeMessage message) {
        log.info("Processing trade message: {}", message);
        tradeRepository.save(message);
    }

    @Override
    public List<TradeMessage> getMessages() {
        return tradeRepository.findAll();
    }
}
