package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.Storage;
import seedu.duke.data.Data;
import seedu.duke.ui.Ui;

public class ListModuleTimetableCommand extends Command {

    private String moduleCode;

    public ListModuleTimetableCommand(String moduleCode) {
        this.moduleCode = moduleCode;
        assert this.moduleCode != null : "Module code cannot be null";
    }

    @Override
    public void execute(Data data, Ui ui, Storage storage) {
        Module module = data.find(moduleCode);
        if (module == null) {
            ui.moduleNotFound(moduleCode);
        } else {
            ui.listModuleTimetable(module);
        }
    }

}
