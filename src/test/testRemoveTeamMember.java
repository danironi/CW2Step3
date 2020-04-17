package test;

import static org.junit.jupiter.api.Assertions.*;

import model.Project;
import model.TeamMember;
import org.junit.jupiter.api.Test;

import java.util.Date;
public class testRemoveTeamMember {

    @Test
    void testRemoveMember(){

        Project project1 = new Project("testProject",new Date(), new Date());

        project1.addMember(new TeamMember("Jozsef",111111,"Web"));

        project1.removeTeamMemberByName("Jozsef");

        boolean expectedResult = false;
        boolean actualResult = project1.findByName("Jozsef");

        assertEquals(expectedResult,actualResult);
    }
}
