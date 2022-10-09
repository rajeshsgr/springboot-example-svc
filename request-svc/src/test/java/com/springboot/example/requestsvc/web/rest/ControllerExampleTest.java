package com.springboot.example.requestsvc.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import com.springboot.example.requestsvc.model.Employee;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author rajeshp
 * @Date 10/8/22
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest(ControllerExample.class)
public class ControllerExampleTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testEmployeeById() throws Exception {

        mockMvc.perform(get("/v1/api/employee/100"))
                .andExpect(status().isOk());

    }

    @Test
    void testEmployeeByNameId() throws Exception {
        mockMvc.perform(get("/v1/api/employee/Daniel/100"))
                .andExpect(status().isOk());
    }

    @Test
    void testListHeaders() throws Exception {
        mockMvc.perform(get("/v1/api/listHeaders"))
                .andExpect(status().isOk());
    }

    @Test
    void testListSpecificHeaders() throws Exception {
        mockMvc.perform(get("/v1/api/listSpecificHeaders") .
                header("content-type", "json").
                header("emp-name", "fkeName"))
                .andExpect(status().isOk())
                .andExpect(content().string("Recieved json;charset=UTF-8 & fkeName header values"));
    }

    @Test
    void testArbitaryJson() throws Exception {
        String jsonBody ="{ \"accountType\": \"SAVINGS\", \"balance\": 5000.0 }";

        mockMvc.perform(post("/v1/api/arbitaryJSON")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void testpostEmployeeRequest() throws Exception {
        String requestBody = "{\"firstName\":\"fkFName\",  \"lastName\":\"PL\",\"startDate\":\"12-Oct-2021\", \"empID\":1 }";

        mockMvc.perform(post("/v1/api/mapJSON2Object")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(requestBody));
}

    }

