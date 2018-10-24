package com.example.sandy.overloadingexamples;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testCreateStudent() {
        Student student = new Student(1, "Wilma", 21);
        assertEquals(1, student.getId());
        assertEquals("Wilma", student.getName());
        assertEquals(21, student.getAge());
    }

    @Test
    public void testEmptyStudent() {
        Student student = new Student();
        assertEquals(0,student.getId());
        assertNull(student.getName());
        assertEquals(0,student.getAge());
    }

    @Test
    public void testStudentHasNameOnly() {
        Student student = new Student("Jane");
        assertEquals(0,student.getId());
        assertEquals("Jane", student.getName());
        assertEquals(0,student.getAge());
    }

}
