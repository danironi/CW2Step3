package test;

import static org.junit.jupiter.api.Assertions.*;

import model.Company;
import model.Project;
import model.TeamMember;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class testRemoveProject {

    @Test
    void testRemoveAProject(){
        Company testCompany = new Company("Test", 1);
        Project project1 = new Project("project", new Date(), new Date());
        testCompany.addProject(project1);

        testCompany.remove(project1);

        boolean expectedResult = false;
        boolean actualResult = testCompany.findByTitle("project");

        assertEquals(expectedResult,actualResult);
    }

}
