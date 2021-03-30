package seedu.duke.ui;

import seedu.duke.Lesson;
import seedu.duke.Module;
import seedu.duke.Student;
import seedu.duke.assignment.Answer;
import seedu.duke.assignment.Assignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Ui {
    private final Scanner in;
    private static final String exceptionGreeting = "OOPS!!! ";

    public Ui() {
        in = new Scanner(System.in);
    }

    public static void showLine() {
        System.out.println("\t---------------------------------------------------------------------");
    }

    public void showExitMessage() {
        System.out.println("\tBye. Hope to see you again soon!");
    }

    public void showWelcomeMessage() {
        String logo = " __  __           _   __  __\n"
                + "|  \\/  |         | | |  \\/  |\n"
                + "| \\  / | ___   __| | | \\  / | __ _ _ __\n"
                + "| |\\/| |/ _ \\ / _  | | |\\/| |/ _  |  _ \\\n"
                + "| |  | | (_) | (_| | | |  | | (_| | | | |\n"
                + "|_|  |_|\\___/ \\__'_| |_|  |_|\\__'_|_| |_|\n";
        System.out.println("Hello from\n" + logo);
    }

    public String readCommand() {
        String fullCommand = in.nextLine();
        return fullCommand;
    }

    public void showError(String message) {
        System.out.println("\t " + exceptionGreeting + message);
    }

    public void printNewAssignment(Module module, Assignment assignment) {
        System.out.println("\t I have added a new assignment to " + module.getModuleCode() + ":");
        System.out.println("\t " + assignment.getName());
    }

    public void printNewStudent(Module module, Student student) {
        System.out.println("\t I have assigned a new student to " + module.getModuleCode() + ":");
        System.out.println("\t " + student);
    }

    public void printEditAssignment(Module module, String oldName, String newName) {
        System.out.println("\t I have edited your assignment in " + module.getModuleCode() + " from:");
        System.out.println("\t - " + oldName);
        System.out.println("\t to");
        System.out.println("\t + " + newName);
    }

    public void printNewModule(Module module) {
        System.out.println("\t I have added a new module: " + module.getModuleCode());
    }

    public void printNewTimetable(String moduleCode, Lesson lesson) {
        System.out.println("\t Success! I have added the following timetable for the module - " + moduleCode);
        System.out.println("\t " + lesson.getLessonType() + ": " + lesson.toString()
                + " (" + lesson.getVenue() + ")");
    }

    public void listModuleAssignments(Module module) {
        ArrayList<Assignment> assignments = module.getAssignments();
        if (assignments.size() == 0) {
            System.out.println("\t You have not added any assignments to " + module.getModuleCode() + " yet.");
        } else {
            assert assignments.size() > 0 : "size of assignments should be greater than zero";
            System.out.println("\t Here are the assignments in " + module.getModuleCode() + ":");
            for (int i = 1; i <= assignments.size(); i++) {
                System.out.println("\t " + i + ". " + assignments.get(i - 1).toString());
            }
        }
    }

    public void listModuleStudents(Module module) {
        ArrayList<Student> students = module.getStudents();
        if (students.size() == 0) {
            System.out.println("\t You have not added any students to " + module.getModuleCode() + " yet.");
        } else {
            assert students.size() > 0 : "size of students should be greater than zero";
            System.out.println("\t Here are the students in " + module.getModuleCode() + ":");
            for (int i = 1; i <= students.size(); i++) {
                System.out.println("\t " + i + ". " + students.get(i - 1).getName());
            }
        }
    }

    public void listModuleStudentsDetails(Module module) {
        ArrayList<Student> students = module.getStudents();
        if (students.size() == 0) {
            System.out.println("\t Here are the details of all students enrolled in "
                    + module.getModuleCode() + ":");
        } else {
            assert students.size() > 0 : "size of students should be greater than zero";
            for (int i = 1; i <= students.size(); i++) {
                System.out.println("\t " + i + ". " + students.get(i - 1).toString());
            }
        }
    }

    public void listAssignmentStudentGrades(Assignment assignment) {
        System.out.println("\t Here are the students' grades for the " + assignment.getName() + " assignment:");
        HashMap<String, Float> studentGrades = assignment.getStudentGrades();
        Iterator it = studentGrades.entrySet().iterator();
        int index = 1;
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            System.out.println("\t " + index + ". " + pair.getKey() + " - " + pair.getValue());
            index++;
        }
    }

    public void listModuleTimetable(Module module) {
        ArrayList<Lesson> lessons = module.getLessons();
        Lesson lesson;
        if (lessons.size() == 0) {
            System.out.println("\t You have not added any lessons to " + module.getModuleCode() + " yet.");
        } else {
            assert lessons.size() > 0 : "size of lessons should be greater than zero";
            System.out.println("\t Here are the lessons in " + module.getModuleCode() + ":");
            for (int i = 1; i <= lessons.size(); i++) {
                lesson = lessons.get(i - 1);
                System.out.println("\t " + i + ". " + lesson.getLessonType() + ": " + lesson.toString()
                        + " (" + lesson.getVenue() + ")");
            }
        }
    }

    public void moduleNotFound(String moduleCode) {
        System.out.println("Module " + moduleCode + " not found.");
    }

    public void assignmentNotFoundMessage(String assignmentName, String moduleCode) {
        System.out.println("\t " + assignmentName + " not found in " + moduleCode);
    }

    public void printSetAssignmentGrade(String moduleCode, String assignmentName,
                                        String studentName, String grade) {
        System.out.println("\t " + "I have set " + studentName + "'s grade to " + grade
                + " for assignment " + assignmentName + " in " + moduleCode);
    }

    public void printSetAssignmentPercentage(String moduleCode, String assignmentName, float percentage) {
        System.out.println("\t " + "I have set " + assignmentName + "'s percentage to "
                + percentage + " in " + moduleCode);
    }

    public void printSetAssignmentDeadline(String moduleCode, String assignmentName, LocalDate deadline) {
        System.out.println("\t " + "I have set " + assignmentName + "'s deadline to "
                + deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " in " + moduleCode);
    }

    public void selectModuleMessage(String moduleCode) {
        System.out.println("\t Success! You are now working in: " + moduleCode);
    }

    public void printModules(ArrayList<Module> modules) {
        if (modules.size() == 0) {
            System.out.println("\t You have not added any modules to ModMan yet!");
        } else {
            System.out.println("\t Here are your modules: ");
            for (int i = 1; i <= modules.size(); i++) {
                System.out.println("\t " + i + ". " + modules.get(i - 1).getModuleCode());
            }
        }
    }

    public void removeModuleMessage(String moduleCode) {
        System.out.println("\t You have successfully removed module: " + moduleCode);
    }

    public void printModuleInfo() {
        System.out.println("\t You are not currently working in any module!");
        System.out.println("\t Please select a module by using the select command");
    }

    public void printModuleInfo(Module module) {

        System.out.println("\t You are currently working in: " + module.getModuleCode());
    }

    public void deleteModuleTimetable(String moduleCode, Lesson lesson) {
        System.out.println("\t You have successfully removed lesson: " + lesson.toString() + " from " + moduleCode);
    }

    public void editModuleTimetable(String moduleCode, Lesson lesson) {
        System.out.println("\t You have successfully edited the lesson to:");
        System.out.println("\t " + lesson.getLessonType() + ": " + lesson.toString()
                + " (" + lesson.getVenue() + ")");
    }

    public void printAnswers(Answer answer, String assignmentName) {
        if (answer.getAnswers().size() == 0) {
            System.out.println("\t Answer key is empty!");
        } else {
            System.out.println("\t Answer key for " + assignmentName);
            for (int i = 1; i <= answer.getAnswers().size(); i++) {
                System.out.println("\t " + i + ". " + answer.getAnswers().get(i - 1));
            }
        }
    }

    public void printScript(ArrayList<String> script, String assignmentName, String studentName, String studentNumber) {
        if (script.size() == 0) {
            System.out.println("\t Script is blank!");
        } else {
            System.out.println("\t " + studentName + "[" + studentNumber + "]'s script for " + assignmentName);
            for (int i = 1; i <= script.size(); i++) {
                System.out.println("\t " + i + ". " + script.get(i - 1));
            }
        }
    }

    public void listUngradedStudents(ArrayList<Student> ungraded) {
        if (ungraded.size() == 0) {
            System.out.println("\t All scripts have been graded!");
        } else {
            System.out.println("\t These are the students who have not submitted their assignments:");
            for (int i = 1; i <= ungraded.size(); i++) {
                System.out.println("\t " + i + ". " + ungraded.get(i - 1).toString());
            }
        }
    }
}