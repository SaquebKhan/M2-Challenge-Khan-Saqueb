package com.company.M2ChallengeKhanSaqueb.controller;

import com.company.M2ChallengeKhanSaqueb.models.MathEquation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.sum;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathConverterController.class)
public class MathConverterControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {



    }

    //    ADDITION TESTS
    @Test
    public void addOperandSuccessfulResponse() throws Exception {
        MathEquation MathEquation = new MathEquation(3, 2);
        MathEquation.setAnswer(5);
        MathEquation.setOperator("Addition");

        String outputAdd = mapper.writeValueAsString(MathEquation);

        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                        .content(outputAdd)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputAdd));
    }

    @Test
    public void addOperandReqNonInt442Error() throws Exception {
        Map<String, String> MathEquation = new HashMap<>();
        MathEquation.put("operand1", "6");
        MathEquation.put("operand2", "hotdog");

        String inputAdd = mapper.writeValueAsString(MathEquation);

        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                        .content(inputAdd)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addMissingOperand442Error() throws Exception {
        Map<String, String> MathEquation = new HashMap<>();
        MathEquation.put("operand1", "6");

        String inputAdd = mapper.writeValueAsString(MathEquation);

        mockMvc.perform(MockMvcRequestBuilders.post("/add")
                        .content(inputAdd)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }


    //    SUBTRACT TESTS
    @Test
    public void subtractOperandSuccessfulResponse() throws Exception {
        MathEquation MathEquation = new MathEquation(3, 2);
        MathEquation.setAnswer(1);
        MathEquation.setOperator("Subtraction");

        String outputSubtract = mapper.writeValueAsString(MathEquation);

        mockMvc.perform(MockMvcRequestBuilders.post("/subtract")
                        .content(outputSubtract)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputSubtract));
    }

    @Test
    public void subtractOperandReqNonInt442Error() throws Exception {
        Map<String, String> MathEquation = new HashMap<>();
        MathEquation.put("operand1", "hotdog");
        MathEquation.put("operand2", "99");

        String inputSubtract = mapper.writeValueAsString(MathEquation);

        mockMvc.perform(MockMvcRequestBuilders.post("/subtract")
                        .content(inputSubtract)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void subtractMissingOperand442Error() throws Exception {
        Map<String, String> MathEquation = new HashMap<>();
        MathEquation.put("operand1", "6");

        String input = mapper.writeValueAsString(MathEquation);

        mockMvc.perform(MockMvcRequestBuilders.post("/subtract")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //    MULTIPLY TESTS
    @Test
    public void multiplyOperandSuccessfulResponse() throws Exception {
        MathEquation MathEquation = new MathEquation(3, 2);
        MathEquation.setAnswer(6);
        MathEquation.setOperator("Multiply");

        String outputMultiply = mapper.writeValueAsString(MathEquation);

        mockMvc.perform(MockMvcRequestBuilders.post("/multiply")
                        .content(outputMultiply)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputMultiply));
    }

    @Test
    public void multiplyOperandReqNonInt442Error() throws Exception {
        Map<String, String> MathEquation = new HashMap<>();
        MathEquation.put("operand1", "dog is hot");
        MathEquation.put("operand2", "3");

        String inputMultiply = mapper.writeValueAsString(MathEquation);

        mockMvc.perform(MockMvcRequestBuilders.post("/multiply")
                        .content(inputMultiply)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void multiplyMissingOperand442Error() throws Exception {
        Map<String, String> MathEquation = new HashMap<>();
        MathEquation.put("operand1", "6");

        String input = mapper.writeValueAsString(MathEquation);

        mockMvc.perform(MockMvcRequestBuilders.post("/multiply")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    //    DIVIDE TESTS
    @Test
    public void divideOperandSuccessfulResponse() throws Exception {
        MathEquation MathEquation = new MathEquation(8, 2);
        MathEquation.setAnswer(4);
        MathEquation.setOperator("Divide");

        String outputDivide = mapper.writeValueAsString(MathEquation);

        mockMvc.perform(MockMvcRequestBuilders.post("/divide")
                        .content(outputDivide)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputDivide));
    }

    @Test
    public void divideOperandReqNonInt442Error() throws Exception {
        Map<String, String> MathEquation = new HashMap<>();
        MathEquation.put("operand1", "6");
        MathEquation.put("operand2", "hotdog");

        String inputDivide = mapper.writeValueAsString(MathEquation);

        mockMvc.perform(MockMvcRequestBuilders.post("/divide")
                        .content(inputDivide)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void divideMissingOperand442Error() throws Exception {
        Map<String, String> MathEquation = new HashMap<>();
        MathEquation.put("operand1", "6");

        String input = mapper.writeValueAsString(MathEquation);

        mockMvc.perform(MockMvcRequestBuilders.post("/divide")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void divideByZeroReqNonInt442Error() throws Exception {
//        Map<String, String> MathEquation = new HashMap<>();
//        MathEquation.put("operand1", "6");
//        MathEquation.put("operand2", "0");

        MathEquation MathEquation = new MathEquation(8, 0);
        MathEquation.setOperator("Divide");

        String inputDivide = mapper.writeValueAsString(MathEquation);

        mockMvc.perform(MockMvcRequestBuilders.post("/divide")
                        .content(inputDivide)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }


}