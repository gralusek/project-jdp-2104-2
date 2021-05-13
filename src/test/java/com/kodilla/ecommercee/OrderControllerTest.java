package com.kodilla.ecommercee;

import com.kodilla.ecommercee.Dto.OrderDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@Import(OrderController.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetOrders() throws Exception {
        //Given
        RequestBuilder request = MockMvcRequestBuilders.get("/v1/order/getOrders");
        MvcResult result = mockMvc.perform(request).andReturn();

        //Then
        assertEquals("[]", result.getResponse().getContentAsString());

    }

    @Test
    public void testGetOrder() throws Exception {
        // Given
        OrderDto mockOrder = new OrderDto(1L, "example Order");
        RequestBuilder request = MockMvcRequestBuilders.get("/v1/order/getOrder?id=" + mockOrder.getId());

        //When
        MvcResult result = mockMvc.perform(request).andReturn();

        //Then
        assertEquals(String.format("{\"id\":%s,\"status\":\"%s\"}", mockOrder.getId(), mockOrder.getStatus()),
                result.getResponse().getContentAsString());
    }

    @Test
    public void testAddOrder() throws Exception {
        // Given
        OrderDto mockOrder = new OrderDto(1L, "new Order");
        RequestBuilder request = MockMvcRequestBuilders.post("/v1/order/addOrder").
                content(String.format("{\"id\":%s,\"status\":\"%s\"}", mockOrder.getId(), mockOrder.getStatus())).
                contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();

        // Then
        assertEquals(String.format("{\"id\":%s,\"status\":\"%s\"}", mockOrder.getId(), mockOrder.getStatus()),
                result.getResponse().getContentAsString());
    }

    @Test
    public void testUpdateOrder() throws Exception {
        // Given
        OrderDto mockOrder = new OrderDto(2L, "updated status");

        // When
        RequestBuilder request = MockMvcRequestBuilders.put("/v1/order/updateOrder").
                content(String.format("{\"id\":%s,\"status\":\"%s\"}", mockOrder.getId(), mockOrder.getStatus())).
                contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();

        //Then
        assertEquals(String.format("{\"id\":%s,\"status\":\"%s\"}", mockOrder.getId(), mockOrder.getStatus()),
                result.getResponse().getContentAsString());
    }

    @Test
    void testDeleteOrder() throws Exception {
        // Given
        RequestBuilder request = MockMvcRequestBuilders.delete("/v1/order/deleteOrder?id=1L");
        MvcResult result = mockMvc.perform(request).andReturn();

        //Then
        assertEquals("", result.getResponse().getContentAsString());
    }



}
