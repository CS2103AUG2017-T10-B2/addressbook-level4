# Affalen
###### \java\seedu\address\logic\parser\AddressBookParserTest.java
``` java
                FindCommand.COMMAND_WORD + " " + "n/" + keywords.stream().collect(Collectors.joining(" ")));
```
###### \java\seedu\address\logic\parser\FindCommandParserTest.java
``` java
                new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList("Alice")));
        assertParseSuccess(parser, "n/Alice", expectedFindNameCommand);

        FindCommand expectedFindNumberCommand =
                new FindCommand(new NumberContainsKeywordsPredicate(Arrays.asList("98765432")));
        assertParseSuccess(parser, "p/98765432", expectedFindNumberCommand);

        FindCommand expectedFindAddressCommand =
                new FindCommand(new AddressContainsKeywordsPredicate(Arrays.asList("Clementi")));
        assertParseSuccess(parser, "a/Clementi", expectedFindAddressCommand);

        FindCommand expectedFindBirthdayCommand =
                new FindCommand(new BirthdayContainsKeywordsPredicate(Arrays.asList("10-10-1995")));
        assertParseSuccess(parser, "b/10-10-1995", expectedFindBirthdayCommand);

        FindCommand expectedFindEmailCommand =
                new FindCommand(new EmailContainsKeywordsPredicate(Arrays.asList("john@example.com")));
        assertParseSuccess(parser, "e/john@example.com", expectedFindEmailCommand);

        FindCommand expectedFindRemarkCommand =
                new FindCommand(new RemarkContainsKeywordsPredicate(Arrays.asList("Swimmer")));
        assertParseSuccess(parser, "r/Swimmer", expectedFindRemarkCommand);

        FindCommand expectedFindTagCommand =
                new FindCommand(new TagContainsKeywordsPredicate(Arrays.asList("friends")));
        assertParseSuccess(parser, "t/friends", expectedFindTagCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n n/Alice \n \t  \t", expectedFindNameCommand);

        assertParseSuccess(parser, " \n p/98765432 \n \t  \t", expectedFindNumberCommand);

        assertParseSuccess(parser, " \n a/Clementi \n \t  \t", expectedFindAddressCommand);

        assertParseSuccess(parser, " \n b/10-10-1995 \n \t  \t", expectedFindBirthdayCommand);

        assertParseSuccess(parser, " \n e/john@example.com \n \t  \t", expectedFindEmailCommand);

        assertParseSuccess(parser, " \n r/Swimmer \n \t  \t", expectedFindRemarkCommand);

        assertParseSuccess(parser, " \n t/friends \n \t  \t", expectedFindTagCommand);
    }

}
```
###### \java\seedu\address\testutil\TypicalPersons.java
``` java
    public static final String KEYWORD_MATCHING_MEIER = "n/Meier"; // A keyword that matches MEIER
```
###### \java\seedu\address\ui\BrowserPanelTest.java
``` java
        // associated web page of a person
        postNow(selectionChangedEventStub);
        URL expectedPersonUrl = new URL(GOOGLE_MAP_URL_PREFIX
                + ALICE.getAddress().toString().replaceAll(" ", "+"));


        waitUntilBrowserLoaded(browserPanelHandle);
        assertEquals(expectedPersonUrl.toString().substring(0, 40), browserPanelHandle.getLoadedUrl().toString()
                .substring(0, 40));
```
###### \java\systemtests\FindCommandSystemTest.java
``` java
        command = FindCommand.COMMAND_WORD + " n/Carl";
```
###### \java\systemtests\FindCommandSystemTest.java
``` java
        command = FindCommand.COMMAND_WORD + " n/Benson Daniel";
```
###### \java\systemtests\FindCommandSystemTest.java
``` java
        command = FindCommand.COMMAND_WORD + " n/Daniel Benson";
```
###### \java\systemtests\FindCommandSystemTest.java
``` java
        command = FindCommand.COMMAND_WORD + " n/Daniel Benson Daniel";
```
###### \java\systemtests\FindCommandSystemTest.java
``` java
        command = FindCommand.COMMAND_WORD + " n/Daniel Benson NonMatchingKeyWord";
```
###### \java\systemtests\FindCommandSystemTest.java
``` java
        command = FindCommand.COMMAND_WORD + " n/MeIeR";
```
###### \java\systemtests\FindCommandSystemTest.java
``` java
        command = FindCommand.COMMAND_WORD + " n/Mei";
```
###### \java\systemtests\FindCommandSystemTest.java
``` java
        command = FindCommand.COMMAND_WORD + " n/Meiers";
```
###### \java\systemtests\FindCommandSystemTest.java
``` java
        command = FindCommand.COMMAND_WORD + " n/Mark";
```
###### \java\systemtests\FindCommandSystemTest.java
``` java
        command = FindCommand.COMMAND_WORD + " " + "n/Daniel" + DANIEL.getPhone().value;
```
###### \java\systemtests\FindCommandSystemTest.java
``` java
        command = FindCommand.COMMAND_WORD + " " + "n/Daniel" + DANIEL.getAddress().value;
```
###### \java\systemtests\FindCommandSystemTest.java
``` java
        command = FindCommand.COMMAND_WORD + " " + "n/Daniel" + DANIEL.getEmail().value;
```
###### \java\systemtests\FindCommandSystemTest.java
``` java
        command = FindCommand.COMMAND_WORD + " " + "n/Daniel" + tags.get(0).tagName;
```
###### \java\systemtests\FindCommandSystemTest.java
``` java
        command = FindCommand.COMMAND_WORD + " n/Daniel";
```
