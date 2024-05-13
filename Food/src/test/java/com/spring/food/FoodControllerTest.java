package com.spring.food;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.food.Service.FoodService;
import com.spring.food.bean.Food;
import com.spring.food.controller.FoodController;

@WebMvcTest(FoodController.class)
@WithMockUser(username = "Saurabh", roles = {"ADMIN,USER"},password = "$Aurabh123")
public class FoodControllerTest {

    Food f1 = new Food(1, "Amul Milk", 70, "Tetra Pack");
    Food f2 = new Food(2, "Kurkure", 20, "Chilli Chatka");
    Food f3 = new Food(4, "Cashew", 230, "Tata Cashew");
    Food f4 = new Food(3, "Lays", 70, "Super Saver");
    @MockBean
    FoodService foodservice;
    
    @Autowired
    private MockMvc mockMvc;

    @Test

    public void testgetallfood() throws Exception {
        
        
        List<Food> list = List.of(f1, f2, f3, f4);
        
       when(foodservice.getallfood()).thenReturn(list);
        
        mockMvc.perform(get("/getfood"))
            .andExpect(status().isFound())
            .andExpect(jsonPath("$", Matchers.hasSize(4)))
            .andExpect(jsonPath("$[0].name", Matchers.is("Amul Milk")));
    }
    
    @Test
    @WithMockUser(username = "Saurabh", roles = {"ADMIN,USER"},password = "$Aurabh123")
    public void testgetfoodbyid() throws Exception{
    	Mockito.when(foodservice.getfood(3)).thenReturn(f4);
    	
    	mockMvc.perform(get("/getfood/3"))
    	.andExpect(status().isFound())
    	.andExpect(jsonPath("$.name", Matchers.is("Lays")));
    }
    @Test
    @WithMockUser(username = "Saurabh", roles = {"ADMIN,USER"})
    public void testInsertFood() throws Exception {
        // Create a sample Food object to insert
    	Food f=new Food(5, "Spinach", 20.0, "High in Protien and Fibre");

        // Mock the behavior of the FoodService to return the same Food object
        Mockito.when(foodservice.insertFood(Mockito.any(Food.class))).thenReturn(f);

        // Perform the POST request with JSON content
        mockMvc.perform(post("/insertfood")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(f)))
                .andExpect(status().isCreated()) // Expecting 201 Created status
              .andExpect(jsonPath("$.name").value("Spinach")) // Verify the returned Food's name
             .andExpect(jsonPath("$.price").value(20.0)); // Verify the returned Food's price
    }

    // Utility method to convert object to JSON string
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Test
    @WithMockUser(username = "Saurabh", roles = {"ADMIN,USER"})
    public void testUpdateFood() throws Exception {
    	Food f=new Food(5, "Spinach", 20.0, "High in Protien and Fibre");
    	Mockito.when(foodservice.updateFood(Mockito.anyInt(),Mockito.any(Food.class))).thenReturn(f);
    	mockMvc.perform(put("/updatefood/5")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content(asJsonString(f)))
    			.andExpect(status().isAccepted())
    			.andExpect(jsonPath("$.name").value("Spinach"))
    			.andExpect(jsonPath("$.price").value(20.0));
    }
    
    @Test
    @WithMockUser(username = "Saurabh", roles = {"ADMIN,USER"})
    public void deleteFoodtest() throws Exception{
    	Food f=new Food(5, "Spinach", 20.0, "High in Protien and Fibre");
    	
    	Mockito.when(foodservice.deleteFood(Mockito.anyInt())).thenReturn(f);
    
    	mockMvc.perform(delete("/deletefood/5"))
    	.andExpect(status().isGone())
    	.andExpect(jsonPath("$.name").value("Spinach"))
    	.andExpect(jsonPath("$.price").value(20.0));
    }
    
}
