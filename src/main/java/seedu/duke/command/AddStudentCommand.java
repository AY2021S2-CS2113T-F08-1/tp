package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.Student;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

public class AddStudentCommand extends Command {
    public String moduleCode;
    public String studentName;
    public String studentNumber;
    public String contactNumber;
    public String email;

    public AddStudentCommand(String moduleCode, String studentName, 
                             String studentNumber, String contactNumber, String email) {
        this.moduleCode = moduleCode;
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.contactNumber = contactNumber;
        this.email = email;

        assert this.moduleCode != null : "Module code cannot be null";
        assert this.studentName != null : "Student name cannot be null";
        assert this.studentNumber != null : "Student number cannot be null";
        assert this.contactNumber != null : "Student contact number cannot be null";
        assert this.email != null : "Student email cannot be null";

    }

    public void execute(Data data, Ui ui) {
        Module module = data.find(moduleCode);
        Student student = new Student(studentName, studentNumber, contactNumber, email);
        module.addStudent(student);
        ui.printNewStudent(module, student);
    }
}
