package com.example.Student;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void testInsertStudent() throws Exception {
        Student student = new Student();
        student.setName("John");

        mockMvc.perform(post("/insertstudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John\"}"))
                .andExpect(status().isAccepted());

        verify(studentService).insertStudent(student);
    }

    @Test
    public void testGetStudentById() throws Exception {
        Student student = new Student();
        student.setRollNumber(1);
        student.setName("John");

        when(studentService.getStudent(1)).thenReturn(student);

        mockMvc.perform(get("/getstudent/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"));
    }

    @Test
    public void testGetAllStudents() throws Exception {
        Student student1 = new Student();
        student1.setRollNumber(1);
        student1.setName("John");
        Student student2 = new Student();
        student2.setRollNumber(2);
    }
}