package com.roganin.trademessages.controller;

import com.roganin.trademessages.model.TradeMessage;
import com.roganin.trademessages.service.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/messages")
public class TradeController {

    // Test
    private final TradeService tradeService;

    private static final Logger log = LoggerFactory.getLogger(TradeController.class);

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @RequestMapping(method = POST)
    @CrossOrigin
    @ResponseStatus(CREATED)
    public void saveMessages(@RequestBody TradeMessage message) {
        log.info("Received trade message: {}", message);
        tradeService.saveMessage(message);
    }

    @RequestMapping(method = GET)
    @CrossOrigin
    public List<TradeMessage> getMessages() {
        log.info("Received request to list trade messages");
        return tradeService.getMessages();
    }
}
