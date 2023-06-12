package com.apiemployes.apiemployes;

import com.apiemployes.apiemployes.controller.EmployeeController;
import com.apiemployes.apiemployes.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeContollerTest {

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void testGetEmployee () throws Exception {
        mockMvc.perform(get("/employees")) // cette methode va déclencher la requete
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$[0].firstname" , is("Laurent")));

    }
}
