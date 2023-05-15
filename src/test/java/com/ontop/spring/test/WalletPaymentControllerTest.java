/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ontop.spring.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontop.spring.test.model.AccountPaymentModel;
import com.ontop.spring.test.model.Beneficiary;
import com.ontop.spring.test.model.DestinationPaymentModel;
import com.ontop.spring.test.model.Tutorial;
import com.ontop.spring.test.model.request.PaymentRequest;
import com.ontop.spring.test.model.request.SourcePaymentModel;
import com.ontop.spring.test.repository.BeneficiaryRepo;
import com.ontop.spring.test.repository.TutorialRepository;
import java.math.BigDecimal;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author BasharOthman
 */
@SpringBootTest
@AutoConfigureMockMvc
public class WalletPaymentControllerTest {

    @Autowired
    private BeneficiaryRepo beneficiaryRepo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void createBeneficiary(){
        System.out.println("TEST TEst");
        Beneficiary beneficiary=new Beneficiary();
        beneficiary.setAccountNumber("1885226711");
        beneficiary.setNationalIdentificationNumber("123456789");
        beneficiary.setRoutingNumber("028444018");
        beneficiary.setFirstName("TONY");
        beneficiary.setLastName("STARK");
        beneficiary.setId("1");
        
        beneficiaryRepo.save(beneficiary);
        
    }
    
    @Test
    void shouldSendMoney() throws Exception {
        //Tutorial tutorial = new Tutorial(1, "Spring Boot @WebMvcTest", "Description", true);
        String request = "{\n"
                + "    \"source\": {\n"
                + "        \"type\": \"COMPANY\",\n"
                + "        \"sourceInformation\": {\n"
                + "            \"name\": \"ONTOP INC\"\n"
                + "        },\n"
                + "        \"account\": {\n"
                + "            \"accountNumber\": \"0245253419\",\n"
                + "            \"currency\": \"USD\",\n"
                + "            \"routingNumber\": \"028444018\"\n"
                + "        }\n"
                + "    },\n"
                + "    \"destination\": {\n"
                + "        \"name\": \"TONY STARK\",\n"
                + "        \"account\": {\n"
                + "            \"accountNumber\": \"1885226711\",\n"
                + "            \"currency\": \"USD\",\n"
                + "            \"routingNumber\": \"211927207\"\n"
                + "        }\n"
                + "    },\n"
                + "    \"amount\": 1000\n"
                + "}";

        mockMvc.perform(post("http://localhost:8080/api/v1/payments").contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isCreated())
                .andDo(print());
    }
}
