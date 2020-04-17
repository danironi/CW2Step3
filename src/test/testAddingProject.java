package test;
import static org.junit.jupiter.api.Assertions.*;

import model.Company;
import model.Project;
import org.junit.jupiter.api.Test;

import java.util.Date;

class testAddingProject {
    @Test
    void testWithAddingProject(){
        Company testCompany = new Company("Test", 1);
        testCompany.addProject(new Project("project", new Date(), new Date()));

        boolean expectedResult = true;
        boolean actualResult = testCompany.findByTitle("project");

        assertEquals(expectedResult,actualResult);
    }
}
