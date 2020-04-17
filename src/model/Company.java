package model;

import java.util.Date;

public class Company {

    private String name;
    private int id;
    private Project rootProject;

    public Company(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void addProject(Project p) {
        if (rootProject == null) {
            rootProject = p;
        }
        else{
            rootProject.insert(p);
        }
    }

    public void displayAll() {
        if (rootProject == null) {
            System.out.println("No projects.");
        } else {
            rootProject.printInOrder();
        };
    }

    public void displayAllMemberNumbers() {
        if (rootProject == null) {
            System.out.println("No projects.");
        } else {
            rootProject.printMemberNumberInOrder();
        }
    }

    public boolean findByTitle(String title) {
        return getByTitle(title) != null;
    }

    public Project getByTitle(String title) {
        if (rootProject == null) {
            return null;
        }
        return rootProject.findByTitle(title);
    }

    public boolean remove(Project project) {
        if (rootProject == null || project == null) {
            return false;
        } else {
            if (rootProject.equals(project)) {
                Project p = new Project(null, null, null);
                p.setLeft(rootProject);
                boolean success = rootProject.remove(project.getTitle(), p);
                rootProject = p.getLeft();
                return success;
            } else {
                return this.rootProject.remove(project.getTitle(), this.rootProject);
            }
        }
    }
}

