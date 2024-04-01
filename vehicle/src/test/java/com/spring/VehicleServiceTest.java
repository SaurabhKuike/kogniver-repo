package com.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.spring.entity.Vehicle;
import com.spring.repository.VehicleRepository;
import com.spring.service.VehicleService;

public class VehicleServiceTest {

	Vehicle v1=new Vehicle(1, "Santro", "20/12/22", "petrol");
	Vehicle v2=new Vehicle(2, "Xuv300", "20/12/22", "petrol");
	Vehicle v3=new Vehicle(3, "magnite", "20/12/22", "petrol");
	Vehicle v4=new Vehicle(4, "Ritz", "20/12/22", "petrol");

    @Mock
	private VehicleRepository repo;
	
	@InjectMocks
	private VehicleService service;
	
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	@Test
	public void testinsertVehicle() {
		
		when(repo.save(v1)).thenReturn(v1);
		Vehicle insertVehicle = service.insertVehicle(v1);
		assertEquals(insertVehicle.getVehicle_name(), v1.getVehicle_name());
		verify(repo, times(1)).save(v1);
	}
	
	@Test
	public void testgetallVehicle() {
        List<Vehicle> vehiclelist = List.of(v1, v2, v3, v4);
		when(repo.findAll()).thenReturn(vehiclelist);
		List<Vehicle> getallVehicle = service.getallVehicle();
		assertEquals(getallVehicle.size(), 4);
		verify(repo,times(1)).findAll();
	}
	

	@Test
	public void testgetvehiclebyid() {
		Vehicle v1=new Vehicle(1, "Santro", "20/12/22", "petrol");
		int id=1;
		when(repo.findById(id)).thenReturn(Optional.of(v1));
		Vehicle vehicle = service.getVehicle(id);
		assertEquals(vehicle, v1);
		assertEquals(vehicle.getV_id(),id);
	}
	@Test
	public void testdeleteVehicle() {
		Vehicle v1=new Vehicle(1, "Santro", "20/12/22", "petrol");
		int id=1;
		when(repo.findById(id)).thenReturn(Optional.of(v1));
		Vehicle deleteVehicle = service.deleteVehicle(id);
		assertEquals(deleteVehicle, v1);
		assertEquals(deleteVehicle.getV_id(), id);
	}
	@Test
	public void testupdatevehicle() {
		Vehicle v1=new Vehicle(1, "Santro", "20/12/22", "petrol");
		int id=1;
		when(repo.findById(id)).thenReturn(Optional.of(v1));
		Vehicle v2=new Vehicle(1,"Omni","20/11/2022","Diesel");
		Vehicle updateVehicle = service.updateVehicle(id, v2);
		assertEquals(updateVehicle, v2);
		assertEquals(updateVehicle.getV_id(), 1);
	}
}
