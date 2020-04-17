package test;
import static org.junit.jupiter.api.Assertions.*;

import model.Project;
import model.TeamMember;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class testAddingTeamMember {

    @Test
    void testAddingMember(){
        Project project1 = new Project("testProject",new Date(), new Date());

        project1.addMember(new TeamMember("Jozsef",111111,"Web"));

        boolean expectedResult = true;
        boolean actualResult = project1.findByName("Jozsef");

        assertEquals(expectedResult,actualResult);
    }
}
