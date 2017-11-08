package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddPhotoCommand;
import seedu.address.logic.commands.BirthdayCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.HistoryCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.RemarkCommand;
import seedu.address.logic.commands.SelectCommand;
import seedu.address.logic.commands.SortCommand;
import seedu.address.logic.commands.UndoCommand;
import seedu.address.logic.commands.UpcomingBirthdayCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_ALIAS:
        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case AddPhotoCommand.COMMAND_ALIAS:
        case AddPhotoCommand.COMMAND_WORD:
            return new AddPhotoCommandParser().parse(arguments);
        //@@author zengfengw
        case BirthdayCommand.COMMAND_ALIAS:
        case BirthdayCommand.COMMAND_WORD:
            return new BirthdayCommandParser().parse(arguments);
        //@@author
        case EditCommand.COMMAND_ALIAS:
        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);


        case SelectCommand.COMMAND_ALIAS:
        case SelectCommand.COMMAND_WORD:
            return new SelectCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_ALIAS:
        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_ALIAS:
        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_ALIAS:
        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);
        //@@author Affalen
        case RemarkCommand.COMMAND_ALIAS:
        case RemarkCommand.COMMAND_WORD:
            return new RemarkCommandParser().parse(arguments);
        //@@author
        case ListCommand.COMMAND_ALIAS:
        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case HistoryCommand.COMMAND_ALIAS:
        case HistoryCommand.COMMAND_WORD:
            return new HistoryCommand();

        //@@author Estois
        case SortCommand.COMMAND_ALIAS:
        case SortCommand.COMMAND_WORD:
            return new SortCommandParser().parse(arguments);
        //@@author

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case UndoCommand.COMMAND_ALIAS:
        case UndoCommand.COMMAND_WORD:
            return new UndoCommand();

        case RedoCommand.COMMAND_ALIAS:
        case RedoCommand.COMMAND_WORD:
            return new RedoCommand();
        //@@author zengfengw
        case UpcomingBirthdayCommand.COMMAND_ALIAS:
        case UpcomingBirthdayCommand.COMMAND_WORD:
            return new UpcomingBirthdayCommand();
        //@@author

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
