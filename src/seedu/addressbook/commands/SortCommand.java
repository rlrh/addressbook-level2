package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Lists last shown persons in the address book to the user in alphabetically sorted order.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts last shown persons in the address book in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> relevantPersonsCopy = new ArrayList<>(this.relevantPersons);
        relevantPersonsCopy.sort(Comparator.comparing(person -> person.getName().toString()));
        return new CommandResult(getMessageForPersonListShownSummary(relevantPersonsCopy), relevantPersonsCopy);
    }
}
