package com.roganin.trademessages.service;


import com.roganin.trademessages.model.TradeMessage;

import java.util.List;

public interface TradeService {

    void saveMessage(TradeMessage message);

    List<TradeMessage> getMessages();
}
