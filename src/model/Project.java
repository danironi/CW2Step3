package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Project implements Comparable<Project> {

    private String title;
    private Date start, end;
    private Queue<TeamMember> teamMembers = new LinkedList<>();
    private Project left, right;

    public Project(String title, Date start, Date end) {
        this.title = title;
        this.start = start;
        this.end = end;
    }

    public static Project findSmallestNode(Project root) {
        if (root.left == null) {
            return root;
        } else {
            return findSmallestNode(root.left);
        }
    }

    public void copyTo(Project p) {
        p.title = this.title;
        p.start = this.start;
        p.end = this.end;
        p.teamMembers = this.teamMembers;
    }

    public Project getLeft() {
        return left;
    }

    public void insert(Project project) {
        if (this.compareTo(project) > 0) {
            if (this.left == null) {
                this.left = project;
            } else {
                this.left.insert(project);
            }
        } else if (this.compareTo(project) < 0) {
            if (this.right == null) {
                this.right = project;
            } else {
                this.right.insert(project);
            }
        }
    }

    public Project findByTitle(String title) {
        if (this.title.equals(title)) {
            return this;
        }
        Project found = null;
        if (this.left != null && this.title.compareTo(title) > 0) {
            found = this.left.findByTitle(title);
        }
        if (found != null) {
            return found;
        }
        if (this.right != null && this.title.compareTo(title) < 0) {
            found = this.right.findByTitle(title);
        }
        return found;
    }

    public void setLeft(Project p) {
        this.left = p;
    }

    public Project getRight() {
        return right;
    }

    public String getTitle() {
        return title;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    @Override
    public int compareTo(Project project) {
        return this.title.compareTo(project.title);
    }

    public boolean find(TeamMember tMember) {
        for (TeamMember name : teamMembers) {
            if (tMember == name) {
                return true;
            }

        }
        return false;
    }

    public boolean addMember(TeamMember tMember) {
        if (!find(tMember)) {
            teamMembers.add(tMember);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
        String s = "Project title: " + title + "\nStarting date: " + simpleDateFormat.format(start) +
                "\nEnding date: " + simpleDateFormat.format(end)+ "\n" + "\nTeam Members: \n";
        for (TeamMember t : teamMembers) {
            s += t.toString() + "\n\n";

        }
        return s;
    }

    public String toMemberNumberString() {
        String s = title + ": " + teamMembers.size() + " members";
        return s;
    }

    public boolean findByName(String name) {
        for (TeamMember members : teamMembers) {
            if (members.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void printInOrder() {
        if (this.left != null) {
            this.left.printInOrder();
        }
        System.out.println(this.toString());
        if (this.right != null) {
            this.right.printInOrder();
        }
    }

    public void printMemberNumberInOrder() {
        if (this.left != null){
            this.left.printMemberNumberInOrder();
        }
        System.out.println(this.toMemberNumberString());
        if (this.right != null){
            this.right.printMemberNumberInOrder();
        }
    }

    public TeamMember getByName(String name) {
        for (TeamMember members : teamMembers) {
            if (members.getName().equals(name)) {
                return members;
            }
        }
        return null;
    }

    public boolean remove(String title, Project parent) {
        if (this.title.compareTo(title) > 0) {
            if (left != null) {
                return left.remove(title, this);
            } else {
                return false;
            }
        } else if (this.title.compareTo(title) < 0) {
            if (right != null) {
                return right.remove(title, this);
            } else {
                return false;
            }
        } else {
            if (left != null && right != null) {
                findSmallestNode(right).copyTo(this);
                right.remove(this.title, this);
            } else if (parent.left == this) {
                if (left != null) {
                    parent.left = left;
                } else {
                    parent.left = right;
                }
            } else if (parent.right == this) {
                if (left != null) {
                    parent.right = left;
                } else {
                    parent.right = right;
                }
            }
            return true;
        }
    }

    public boolean removeTeamMemberByName(String name) {
        TeamMember temp = getByName(name);
        if (temp != null) {
            teamMembers.remove(temp);
            return true;
        } else {
            return false;
        }
    }
}
