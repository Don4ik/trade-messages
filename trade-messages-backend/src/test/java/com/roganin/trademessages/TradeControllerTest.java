package com.roganin.trademessages;

import com.roganin.trademessages.controller.TradeController;
import com.roganin.trademessages.model.TradeMessage;
import com.roganin.trademessages.repository.TradeRepository;
import com.roganin.trademessages.service.TradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TradeController.class)
public class TradeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TradeService tradeService;

    @Test
    public void tradeMessageCreatedSuccessfully() throws Exception {
        // Given

        // When
        mvc.perform(post("/messages").content("{\n" +
                "\t\"userId\": \"134256\",\n" +
                "\t\"currencyFrom\": \"EUR\",\n" +
                "\t\"currencyTo\": \"GBP\",\n" +
                "\t\"amountSell\": 1000,\n" +
                "\t\"amountBuy\": 747.10,\n" +
                "\t\"rate\": 0.7471,\n" +
                "\t\"timePlaced\": \"24-JAN-15 10:27:44\",\n" +
                "\t\"originatingCountry\": \"FR\"\n" +
                "}").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(201));

        // Then
        // Test passed

    }

    @Test
    public void badRequestOnInvalidJsonRequest() throws Exception {
        // Given

        // When
        mvc.perform(post("/messages").content("{\"user\": \"user1\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));

        // Then
        // Test passed

    }

    @Test
    public void listsAllTradeMessages() throws Exception {
        // Given
        TradeMessage message1 = new TradeMessage();
        message1.setUserId(111);
        TradeMessage message2 = new TradeMessage();
        message2.setUserId(222);

        List<TradeMessage> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);

        when(tradeService.getMessages()).thenReturn(messages);


        // When
        mvc.perform(get("/messages")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andExpect(jsonPath("$[0].userId", is(111)))
                .andExpect(jsonPath("$[1].userId", is(222)));

        // Then
        // Test passed

    }


}

