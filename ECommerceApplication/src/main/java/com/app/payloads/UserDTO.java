package com.app.payloads;

import java.util.ArrayList;
import java.util.List;
import com.app.entites.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private Long userId;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	private String password;
	private List<Role> roles = new ArrayList<>();
	private AddressDTO address;
	private CartDTO cart;
}
