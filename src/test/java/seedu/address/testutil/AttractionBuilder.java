package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.attraction.Address;
import seedu.address.model.attraction.Attraction;
import seedu.address.model.attraction.Email;
import seedu.address.model.attraction.Location;
import seedu.address.model.attraction.Name;
import seedu.address.model.attraction.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Attraction objects.
 */
public class AttractionBuilder {

    public static final String DEFAULT_NAME = "Singapore Zoo";
    public static final String DEFAULT_PHONE = "62693411";
    public static final String DEFAULT_EMAIL = "zoo@example.com";
    public static final String DEFAULT_ADDRESS = "80 Mandai Lake Rd, 729826";
    public static final String DEFAULT_LOCATION = "Singapore, Singapore";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Location location;
    private Set<Tag> tags;

    /**
     * Creates a {@code PersonAttraction} with the default details.
     */
    public AttractionBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        location = new Location(DEFAULT_LOCATION);
        tags = new HashSet<>();
    }

    /**
     * Initializes the AttractionBuilder with the data of {@code attractionToCopy}.
     */
    public AttractionBuilder(Attraction attractionToCopy) {
        name = attractionToCopy.getName();
        phone = attractionToCopy.getPhone();
        email = attractionToCopy.getEmail();
        address = attractionToCopy.getAddress();
        location = attractionToCopy.getLocation();
        tags = new HashSet<>(attractionToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Attraction} that we are building.
     */
    public AttractionBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Attraction} that we are building.
     */
    public AttractionBuilder withTags(String... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Attraction} that we are building.
     */
    public AttractionBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Attraction} that we are building to be empty.
     */
    public AttractionBuilder withAddress() {
        this.address = new Address();
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Attraction} that we are building.
     */
    public AttractionBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Attraction} that we are building.
     */
    public AttractionBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Location} of the {@code Attraction} that we are building.
     */
    public AttractionBuilder withLocation(String location) {
        this.location = new Location(location);
        return this;
    }

    public Attraction build() {
        return new Attraction(name, phone, email, address, location, tags);
    }

}
