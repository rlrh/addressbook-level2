package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortCommandTest {

    @Test
    public void execute_typicalAddressBook() {

        TypicalPersons td = new TypicalPersons();
        AddressBook addressBook = TestUtil.createAddressBook(td.dan, td.candy, td.bill, td.amy);
        List<ReadOnlyPerson> original = addressBook.getAllPersons().immutableListView();

        SortCommand command = new SortCommand();
        command.setData(addressBook, original);
        CommandResult result = command.execute();

        assertTrue(result.getRelevantPersons().isPresent());

        List<? extends ReadOnlyPerson> actual = result.getRelevantPersons().get();
        List<? extends ReadOnlyPerson> expected = TestUtil.createList(td.amy, td.bill, td.candy, td.dan);

        assertTrue(actual.equals(expected));
    }

    @Test
    public void execute_emptyAddressBook() {

        AddressBook addressBook = TestUtil.createAddressBook();

        SortCommand command = new SortCommand();
        command.setData(addressBook, addressBook.getAllPersons().immutableListView());
        CommandResult result = command.execute();

        List<ReadOnlyPerson> expectedPersonList = Collections.emptyList();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    @Test
    public void execute_noRelevantPersonsAddressBook() {

        TypicalPersons td = new TypicalPersons();
        AddressBook addressBook = td.getTypicalAddressBook();

        SortCommand command = new SortCommand();
        command.setData(addressBook, Collections.emptyList());
        CommandResult result = command.execute();

        List<ReadOnlyPerson> expectedPersonList = Collections.emptyList();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

}
