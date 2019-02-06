package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;


/**
 * Lists all persons in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all persons in the address book in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> relevantPersonsCopy = new ArrayList<>(this.relevantPersons);
        relevantPersonsCopy.sort(Comparator.comparing(person -> person.getName().toString()));
        return new CommandResult(getMessageForPersonListShownSummary(relevantPersonsCopy), relevantPersonsCopy);
    }
}
