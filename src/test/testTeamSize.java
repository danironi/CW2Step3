package test;

import model.Project;
import model.TeamMember;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testTeamSize {

    @Test
    void testProjectTeamSize(){

        Project project1 = new Project("testProject",new Date(), new Date());

        project1.addMember(new TeamMember("Jozsef",111111,"Web"));
        project1.addMember(new TeamMember("Robert", 345678, "Software"));

        String expectedResult = "testProject: 2 members";
        String actualResult = project1.toMemberNumberString();

        assertEquals(expectedResult,actualResult);
    }
}
