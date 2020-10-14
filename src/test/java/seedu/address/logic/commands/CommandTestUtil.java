package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_OPENING_HOURS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRICE_RANGE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RATING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_VISITED;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AttractionList;
import seedu.address.model.Model;
import seedu.address.model.attraction.Attraction;
import seedu.address.model.attraction.NameContainsKeywordsPredicate;
import seedu.address.testutil.EditAttractionDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_NAME_EIFFEL = "Eiffel Tower";
    public static final String VALID_NAME_MBS = "Marina Bay Sands";
    public static final String VALID_PHONE_EIFFEL = "33892701239";
    public static final String VALID_PHONE_MBS = "66888888";
    public static final String VALID_EMAIL_EIFFEL = "eiffel@example.com";
    public static final String VALID_EMAIL_MBS = "mbs@example.com";
    public static final String VALID_ADDRESS_EIFFEL = "Champ de Mars, 5 Avenue Anatole France, 75007";
    public static final String VALID_ADDRESS_MBS = "10 Bayfront Ave, 018956";
    public static final String VALID_DESCRIPTION_EIFFEL = "Gustave Eiffel's iconic, "
            + "wrought-iron 1889 tower, with steps and elevators to observation decks.";
    public static final String VALID_DESCRIPTION_MBS = "The Marina Bay Sands is an integrated "
            + "resort fronting Marina Bay within the Downtown Core district of Singapore.";
    public static final String VALID_LOCATION_EIFFEL = "France, Paris";
    public static final String VALID_LOCATION_MBS = "Singapore, Singapore";
    public static final String VALID_OPENING_HOURS_EIFFEL = "1000-2200";
    public static final String VALID_OPENING_HOURS_MBS = "0000-2359";
    public static final String VALID_PRICE_RANGE_EIFFEL = "HIGH";
    public static final String VALID_PRICE_RANGE_MBS = "HIGH";
    public static final String VALID_RATING_EIFFEL = "4.8";
    public static final String VALID_RATING_MBS = "4.7";
    public static final String VALID_VISITED_EIFFEL = "FALSE";
    public static final String VALID_VISITED_MBS = "TRUE";
    public static final String VALID_TAG_SIGHTSEEING = "sightseeing";
    public static final String VALID_TAG_ACTIVITY = "activity";

    public static final String NAME_DESC_EIFFEL = " " + PREFIX_NAME + VALID_NAME_EIFFEL;
    public static final String NAME_DESC_MBS = " " + PREFIX_NAME + VALID_NAME_MBS;
    public static final String PHONE_DESC_EIFFEL = " " + PREFIX_PHONE + VALID_PHONE_EIFFEL;
    public static final String PHONE_DESC_MBS = " " + PREFIX_PHONE + VALID_PHONE_MBS;
    public static final String EMAIL_DESC_EIFFEL = " " + PREFIX_EMAIL + VALID_EMAIL_EIFFEL;
    public static final String EMAIL_DESC_MBS = " " + PREFIX_EMAIL + VALID_EMAIL_MBS;
    public static final String ADDRESS_DESC_EIFFEL = " " + PREFIX_ADDRESS + VALID_ADDRESS_EIFFEL;
    public static final String ADDRESS_DESC_MBS = " " + PREFIX_ADDRESS + VALID_ADDRESS_MBS;
    public static final String DESCRIPTION_DESC_EIFFEL = " " + PREFIX_DESCRIPTION + VALID_DESCRIPTION_EIFFEL;
    public static final String DESCRIPTION_DESC_MBS = " " + PREFIX_DESCRIPTION + VALID_DESCRIPTION_MBS;
    public static final String LOCATION_DESC_EIFFEL = " " + PREFIX_LOCATION + VALID_LOCATION_EIFFEL;
    public static final String LOCATION_DESC_MBS = " " + PREFIX_LOCATION + VALID_LOCATION_MBS;
    public static final String OPENING_HOURS_DESC_EIFFEL = " " + PREFIX_OPENING_HOURS + VALID_OPENING_HOURS_EIFFEL;
    public static final String OPENING_HOURS_DESC_MBS = " " + PREFIX_OPENING_HOURS + VALID_OPENING_HOURS_MBS;
    public static final String PRICE_RANGE_DESC_EIFFEL = " " + PREFIX_PRICE_RANGE + VALID_PRICE_RANGE_EIFFEL;
    public static final String PRICE_RANGE_DESC_MBS = " " + PREFIX_PRICE_RANGE + VALID_PRICE_RANGE_MBS;
    public static final String RATING_DESC_EIFFEL = " " + PREFIX_RATING + VALID_RATING_EIFFEL;
    public static final String RATING_DESC_MBS = " " + PREFIX_RATING + VALID_RATING_MBS;
    public static final String VISITED_DESC_EIFFEL = " " + PREFIX_VISITED + VALID_VISITED_EIFFEL;
    public static final String VISITED_DESC_MBS = " " + PREFIX_VISITED + VALID_VISITED_MBS;
    public static final String TAG_DESC_SIGHTSEEING = " " + PREFIX_TAG + VALID_TAG_SIGHTSEEING;
    public static final String TAG_DESC_ACTIVITY = " " + PREFIX_TAG + VALID_TAG_ACTIVITY;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "Zoo&"; // '&' not allowed in names
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "mbs!yahoo"; // missing '@' symbol
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_DESCRIPTION_DESC = " " + PREFIX_DESCRIPTION;
    public static final String INVALID_LOCATION_DESC = " " + PREFIX_LOCATION; // empty string not allowed for locations
    public static final String INVALID_OPENING_HOURS_DESC = " " + PREFIX_OPENING_HOURS;
    public static final String INVALID_PRICE_RANGE_DESC = " " + PREFIX_PRICE_RANGE;
    public static final String INVALID_RATING_DESC = " " + PREFIX_RATING;
    public static final String INVALID_VISITED_DESC = " " + PREFIX_VISITED + "True1"; // numbers not allowed in VISITED
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "Sightseeing*"; // '*' not allowed in tags

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditCommand.EditAttractionDescriptor DESC_EIFFEL;
    public static final EditCommand.EditAttractionDescriptor DESC_MBS;

    static {
        DESC_EIFFEL = new EditAttractionDescriptorBuilder().withName(VALID_NAME_EIFFEL)
                .withPhone(VALID_PHONE_EIFFEL).withEmail(VALID_EMAIL_EIFFEL)
                .withAddress(VALID_ADDRESS_EIFFEL).withDescription(VALID_DESCRIPTION_EIFFEL)
                .withLocation(VALID_LOCATION_EIFFEL).withOpeningHours(VALID_OPENING_HOURS_EIFFEL)
                .withPriceRange(VALID_PRICE_RANGE_EIFFEL).withRating(VALID_RATING_EIFFEL)
                .withVisited(VALID_VISITED_EIFFEL).withTags(VALID_TAG_SIGHTSEEING).build();
        DESC_MBS = new EditAttractionDescriptorBuilder().withName(VALID_NAME_MBS)
                .withPhone(VALID_PHONE_MBS).withEmail(VALID_EMAIL_MBS)
                .withAddress(VALID_ADDRESS_MBS).withDescription(VALID_DESCRIPTION_MBS)
                .withLocation(VALID_LOCATION_MBS).withOpeningHours(VALID_OPENING_HOURS_MBS)
                .withPriceRange(VALID_PRICE_RANGE_MBS).withRating(VALID_RATING_MBS)
                .withVisited(VALID_VISITED_MBS).withTags(VALID_TAG_ACTIVITY, VALID_TAG_SIGHTSEEING).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - AttractionList, filtered attraction list and selected attraction in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AttractionList expectedAttractionList = new AttractionList(actualModel.getAttractionList());
        List<Attraction> expectedFilteredList = new ArrayList<>(actualModel.getFilteredAttractionList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAttractionList, actualModel.getAttractionList());
        assertEquals(expectedFilteredList, actualModel.getFilteredAttractionList());
    }
    /**
     * Updates {@code model}'s filtered list to show only the attraction at the given {@code targetIndex} in the
     * {@code model}'s AttractionList.
     */
    public static void showAttractionAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredAttractionList().size());

        Attraction attraction = model.getFilteredAttractionList().get(targetIndex.getZeroBased());
        final String[] splitName = attraction.getName().fullName.split("\\s+");
        model.updateFilteredAttractionList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredAttractionList().size());
    }

}
