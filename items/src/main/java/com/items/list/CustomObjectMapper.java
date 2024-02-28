package com.items.list;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomObjectMapper {

	public static void main(String[] args) throws Exception {
        // Create an instance of ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Serialize a Java object to JSON
        User user = new User("John Doe", 30);
        String json = objectMapper.writeValueAsString(user);
        System.out.println("Serialized JSON: " + json);

        // Deserialize JSON to a Java object
        String jsonInput = "{\"name\":\"Jane Smith\",\"age\":25}";
        User newUser = objectMapper.readValue(jsonInput, User.class);
        System.out.println("Deserialized User: " + newUser);
    }

    static class User {
        private String name;
        private int age;

        // Constructors, getters, and setters
        public User() {}

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
