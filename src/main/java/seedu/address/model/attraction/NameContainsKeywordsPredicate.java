package seedu.address.model.attraction;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Attraction}'s {@code Name} matches any of the keywords given.
 */
public class NameContainsKeywordsPredicate implements Predicate<Attraction> {
    private final List<String> keywords;

    public NameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }


    // todo description is causing test case to fail
    @Override
    public boolean test(Attraction attraction) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(attraction.getName().fullName, keyword)
                        || StringUtil.containsWordIgnoreCase(attraction.getAddress().value, keyword)
                        // || StringUtil.containsWordIgnoreCase(attraction.getDescription().value, keyword)
                        || StringUtil.containsWordIgnoreCase(attraction.getEmail().value, keyword)
                        || StringUtil.containsWordIgnoreCase(attraction.getLocation().value, keyword)
                        || StringUtil.containsWordIgnoreCase(attraction.getOpeningHours().value, keyword)
                        || StringUtil.containsWordIgnoreCase(attraction.getPhone().value, keyword)
                        || StringUtil.containsWordIgnoreCase(attraction.getPriceRange().value, keyword)
                        || StringUtil.containsWordIgnoreCase(attraction.getRating().value, keyword)
                        || attraction.getTags().stream().anyMatch(tag -> tag.tagName.equals(keyword))
                );
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((NameContainsKeywordsPredicate) other).keywords)); // state check
    }

}
