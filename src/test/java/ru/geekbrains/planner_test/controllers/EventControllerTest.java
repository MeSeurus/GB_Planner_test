package ru.geekbrains.planner_test.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.apache.tomcat.util.json.JSONParserConstants;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import ru.geekbrains.planner_test.dtos.EventDto;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    static EventDto buildEventDto() {
        EventDto eventDto = new EventDto();
        eventDto.setId(null);
        eventDto.setTitle("TestDto1");
        eventDto.setEventStart(LocalDateTime.now());
        eventDto.setEventEnd(LocalDateTime.now());
        return eventDto;
    }

    static ObjectMapper mapper = JsonMapper.builder()
            .findAndAddModules()
            .build();


    @Test
    @Order(1)
    public void getAllEventsTest() throws Exception {

        mockMvc
                .perform(
                        get("/api/v1/event/all")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].title", is("testevent2")));

    }

    @Test
    @Order(2)
    public void getEventByIdTest() throws Exception {

        mockMvc
                .perform(
                        get("/api/v1/event/1")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isMap())
                .andExpect(jsonPath("title", is("testevent1")));

    }

    @Test
    @Order(3)
    public void createNewEventTest() throws Exception {

        mockMvc
                .perform(
                        post("/api/v1/event/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(buildEventDto()))
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

    }

    @Test
    @Order(4)
    public void editEventByIdTest() throws Exception {

        mockMvc
                .perform(
                        put("/api/v1/event/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(buildEventDto()))
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @Order(5)
    public void deleteEventByIdTest() throws Exception {

        mockMvc
                .perform(
                        delete("/api/v1/event/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(buildEventDto()))
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
