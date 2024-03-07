package com.spring.food;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.spring.food.Service.FoodService;
import com.spring.food.bean.Food;
import com.spring.food.repository.FoodRepository;


public class FoodServiceTest {

    Food f1 = new Food(1, "Amul Milk", 70, "Tetra Pack");
    Food f2 = new Food(2, "Kurkure", 20, "Chilli Chatka");
    Food f3 = new Food(4, "Cashew", 230, "Tata Cashew");
    Food f4 = new Food(3, "Lays", 70, "Super Saver");
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Mock
    FoodRepository foodrepository;

    @InjectMocks
    private FoodService foodService; 
    
    @Test
    void testFindAll() {
    	List<Food>list=List.of(f1,f2,f3,f4);
    	when(foodrepository.findAll()).thenReturn(list);
    	
    	List<Food>foodlist=foodService.getallfood();
    	assertEquals(4, foodlist.size());
    	verify(foodrepository,times(1)).findAll();
    }
    
    @Test
    void testfindbyid() {
    	when(foodrepository.findById(3)).thenReturn(Optional.of(f4));
    	Food result=foodService.getfood(3);
    	assertEquals(f4, result);
    	verify(foodrepository).findById(3);
    }
    
    @Test
    void testinsertfood() {
    	when(foodrepository.save(any(Food.class))).thenReturn(f3);
    	
    	Food result=foodService.insertFood(f3);
    	
    	assertEquals(result, f3);
    	
    	verify(foodrepository).save(f3);
    
    }
    
    @Test
    void testupdatefood() {
    	Food existingfood=new Food(6, "samosa", 20, "before update");
    	Food updatedfood=new Food(6,"Kachori",20,"after update");
    	when(foodrepository.findById(6)).thenReturn(Optional.of(existingfood));
    	Food result=foodService.updateFood(6, updatedfood);
    	System.out.println(result.hashCode()+" "+updatedfood.hashCode());
    	assertEquals(updatedfood, result);
    	
    	verify(foodrepository).save(existingfood);
    	
    }
    
    @Test
    void deletefoodtest() {
    	Food deletefood=new Food(7,"Tea",5,"Sugar Free");
    	when(foodrepository.findById(Mockito.anyInt())).thenReturn(Optional.of(deletefood));
    	Food result=foodService.deleteFood(7);
    	assertEquals(result, deletefood);
    	verify(foodrepository).deleteById(7);
    }
    
}
