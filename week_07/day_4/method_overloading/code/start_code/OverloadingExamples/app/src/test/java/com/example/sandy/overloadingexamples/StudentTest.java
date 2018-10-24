package com.example.sandy.overloadingexamples;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StudentTest {

    @Test
    public void testCreateStudent() {
        Student student = new Student(1, "Wilma", 21);
        assertEquals(1, student.getId());
        assertEquals("Wilma", student.getName());
        assertEquals(21, student.getAge());
    }
}
