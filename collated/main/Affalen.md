# Affalen
###### \java\seedu\address\logic\commands\FindCommand.java
``` java
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (non-case sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " n/Alice \n"
            + "Example: " + COMMAND_WORD + " p/12345678 \n"
            + "Example: " + COMMAND_WORD + " e/alice@gmail.com \n"
            + "Example: " + COMMAND_WORD + " a/138 Clementi Road \n"
            + "Example: " + COMMAND_WORD + " t/[Friends] \n"
            + "Example: " + COMMAND_WORD + " r/Likes coffee \n"
            + "Example: " + COMMAND_WORD + " b/21-10-1995 \n";

    private Predicate predicate;
    public FindCommand(Predicate predicate) {
        this.predicate = predicate; //All different fields can be found using the FindCommand with different predicates
    }
```
###### \java\seedu\address\logic\parser\FindCommandParser.java
``` java
        /**
         * Used for initial separation of command word and args.
         */
        final Pattern commandFormat = Pattern.compile("(?<commandWord>\\w/)(?<arguments>.*)");
        final Matcher matcher = commandFormat.matcher(args.trim());
        //We use the same Pattern and Matcher as AddressBookParser to separate the command word and arguments
```
###### \java\seedu\address\logic\parser\FindCommandParser.java
``` java
        if (!matcher.matches()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }

        String commandWord = matcher.group("commandWord");
        String arguments = matcher.group("arguments");

        String[] keywords = arguments.split("\\s", 0); //This regex allows FindCommand to find multiple arguments in the input.

        switch(commandWord) {

        case ("n/"):
            return new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList(keywords)));

        case ("p/"):
            return new FindCommand(new NumberContainsKeywordsPredicate(Arrays.asList(keywords)));

        case ("e/"):
            return new FindCommand(new EmailContainsKeywordsPredicate(Arrays.asList(keywords)));

        case ("t/"):
            return new FindCommand(new TagContainsKeywordsPredicate(Arrays.asList(keywords)));

        case("a/"):
            return new FindCommand(new AddressContainsKeywordsPredicate(Arrays.asList(keywords)));

        case("r/"):
            return new FindCommand(new RemarkContainsKeywordsPredicate(Arrays.asList(keywords)));

        case("b/"):
            return new FindCommand(new BirthdayContainsKeywordsPredicate(Arrays.asList(keywords)));

        default:
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }
    }
}
```
###### \java\seedu\address\model\person\AddressContainsKeywordsPredicate.java
``` java
package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code ReadOnlyPerson}'s {@code Address} matches any of the keywords given.
 */
public class AddressContainsKeywordsPredicate implements Predicate<ReadOnlyPerson> {
    private final List<String> keywords;

    public AddressContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(ReadOnlyPerson person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getAddress().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressContainsKeywordsPredicate // instanceof handles nulls
                && this.keywords.equals(((AddressContainsKeywordsPredicate) other).keywords)); // state check
    }
}
```
###### \java\seedu\address\model\person\BirthdayContainsKeywordsPredicate.java
``` java
package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code ReadOnlyPerson}'s {@code Birthday} matches any of the keywords given.
 */
public class BirthdayContainsKeywordsPredicate implements Predicate<ReadOnlyPerson> {
    private final List<String> keywords;

    public BirthdayContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(ReadOnlyPerson person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getBirthday().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof BirthdayContainsKeywordsPredicate // instanceof handles nulls
                && this.keywords.equals(((BirthdayContainsKeywordsPredicate) other).keywords)); // state check
    }
}
```
###### \java\seedu\address\model\person\EmailContainsKeywordsPredicate.java
``` java
package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code ReadOnlyPerson}'s {@code Email} matches any of the keywords given.
 */
public class EmailContainsKeywordsPredicate implements Predicate<ReadOnlyPerson> {
    private final List<String> keywords;

    public EmailContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(ReadOnlyPerson person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getEmail().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EmailContainsKeywordsPredicate // instanceof handles nulls
                && this.keywords.equals(((EmailContainsKeywordsPredicate) other).keywords)); // state check
    }

}
```
###### \java\seedu\address\model\person\NameContainsKeywordsPredicate.java
``` java
package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code ReadOnlyPerson}'s {@code Name} matches any of the keywords given.
 */
public class NameContainsKeywordsPredicate implements Predicate<ReadOnlyPerson> {
    private final List<String> keywords;

    public NameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(ReadOnlyPerson person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getName().fullName, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NameContainsKeywordsPredicate // instanceof handles nulls
                && this.keywords.equals(((NameContainsKeywordsPredicate) other).keywords)); // state check
    }

}
```
###### \java\seedu\address\model\person\NumberContainsKeywordsPredicate.java
``` java
package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code ReadOnlyPerson}'s {@code Number} matches any of the keywords given.
 */
public class NumberContainsKeywordsPredicate implements Predicate<ReadOnlyPerson> {
    private final List<String> keywords;

    public NumberContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(ReadOnlyPerson person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getPhone().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NumberContainsKeywordsPredicate // instanceof handles nulls
                && this.keywords.equals(((NumberContainsKeywordsPredicate) other).keywords)); // state check
    }

}
```
###### \java\seedu\address\model\person\RemarkContainsKeywordsPredicate.java
``` java
package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code ReadOnlyPerson}'s {@code Remark} matches any of the keywords given.
 */
public class RemarkContainsKeywordsPredicate implements Predicate<ReadOnlyPerson> {
    private final List<String> keywords;

    public RemarkContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(ReadOnlyPerson person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getRemark().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof RemarkContainsKeywordsPredicate // instanceof handles nulls
                && this.keywords.equals(((RemarkContainsKeywordsPredicate) other).keywords)); // state check
    }

}
```
###### \java\seedu\address\model\person\TagContainsKeywordsPredicate.java
``` java
package seedu.address.model.person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import seedu.address.model.tag.Tag;

/**
 * Tests that a {@code ReadOnlyPerson}'s {@code Tag} matches any of the keywords given.
 */
public class TagContainsKeywordsPredicate implements Predicate<ReadOnlyPerson> {
    private final List<String> keywords;

    public TagContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(ReadOnlyPerson person) {
        ArrayList <Tag> tags = new ArrayList<>(person.getTags());
        return keywords.stream()
                .anyMatch(keywords -> tags.stream().anyMatch(tagLabel -> keywords.contains(tagLabel.toString())));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TagContainsKeywordsPredicate // instanceof handles nulls
                && this.keywords.equals(((TagContainsKeywordsPredicate) other).keywords)); // state check
    }

}
```
###### \java\seedu\address\ui\BrowserPanel.java
``` java
    public static final String GOOGLE_MAP_URL_PREFIX = "https://www.google.com.sg/maps/search/";
```
###### \java\seedu\address\ui\BrowserPanel.java
``` java
    private void loadPersonPage(ReadOnlyPerson person) {
        loadPage(GOOGLE_MAP_URL_PREFIX + person.getAddress().toString().replaceAll(" ", "+"));
    }
```
