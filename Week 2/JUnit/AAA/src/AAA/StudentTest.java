package AAA;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {

    Student student;

    @Before
    public void setUp() {
        student = new Student();
        System.out.println("Setup completed");
    }

    @Test
    public void testGetGrade() {

        // Arrange
        int marks = 75;

        // Act
        String result = student.getGrade(marks);

        // Assert
        assertEquals("Pass", result);
    }

    @After
    public void tearDown() {
        student = null;
        System.out.println("Teardown completed");
    }
}