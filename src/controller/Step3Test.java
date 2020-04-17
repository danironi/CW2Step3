package controller;

import model.Company;
import model.Project;
import model.TeamMember;
import view.UI;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Step3Test {

    private static Company testCompany = new Company("Test", 1);
    private static UI ui = new UI();

    public static void main(String[] args) {

        do {
            switch (ui.menu()) {
                case 1:
                    String title = ui.getString("Please enter project title");
                    if (testCompany.findByTitle(title)) {
                        System.out.println("Project by name " + title + " already exists");
                    } else {
                        Date start, end;
                        while(true){

                                start = ui.getDate("Please enter start date");
                                end = ui.getDate("Please enter end date");
                            if (end.before(start)) {
                                System.out.println("End date should be after start date");
                            } else {
                                break;
                            }
                        }
                        testCompany.addProject(new Project(title, start, end));
                        System.out.println(title + " added successfully");
                    }
                    break;
                case 2:
                    String projectTitle = ui.getString("Please enter project title");
                    Project temp = testCompany.getByTitle(projectTitle);
                    if (temp == null) {
                        System.out.println("Project " + projectTitle + " not found.");
                        break;
                    }
                    String name = ui.getString("Please enter name of team member");
                    if(temp.findByName(name)){
                        System.out.println("Team member "+name+" already exists.");
                    }
                    else{
                        Serializable id = ui.getInt("Please enter a number with 6 digits", 6);
                        String division = ui.getString("Please enter division name");
                        temp.addMember(new TeamMember(name, id, division));
                        System.out.println(name + " added successfully to " + temp.getTitle());
                    }

                    break;
                case 3:
                    projectTitle = ui.getString("Please enter project title");
                    temp = testCompany.getByTitle(projectTitle);
                    if (temp == null) {
                        System.out.println("Project " + projectTitle + " not found.");
                        break;
                    }
                    name = ui.getString("Please enter name of team member");
                    if (temp.removeTeamMemberByName(name)) {
                        System.out.println(name + " removed from " + projectTitle);
                    } else {
                        System.out.println(name + " not found in " + projectTitle);
                    }
                    break;
                case 4:
                    projectTitle = ui.getString("Please enter project title");
                    temp = testCompany.getByTitle(projectTitle);
                    if (testCompany.remove(temp)) {
                        System.out.println("Project " + projectTitle + " removed");
                    } else {
                        System.out.println("Project " + projectTitle + " not found.");
                    }
                    break;
                case 5:
                    projectTitle = ui.getString("Please enter project title");
                    temp = testCompany.getByTitle(projectTitle);
                    if (temp == null) {
                        System.out.println("Project " + projectTitle + " not found.");
                        break;
                    }
                    System.out.println(temp.toString());
                    break;
                case 6:
                    testCompany.displayAll();
                    break;
                case 7:
                    testCompany.displayAllMemberNumbers();
                    break;
                case 8:
                    Set<String> answers = new HashSet<String>();
                    answers.add("y");
                    answers.add("Y");

                    String answer= ui.getString("Quit? (y/n)");
                    if (answers.contains(answer)){
                        System.exit(0);
                    }

                    break;
            }
        } while (ui.repeat());
    }
}

