package dev.etimbuk;

import dev.etimbuk.record.Person;
import dev.etimbuk.utils.PersonHttpUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class PersonTest {
    @Test
    void testWhenPersonFetchedRecordComponentsNotNull() {
        Map<String, Object> fetchedPerson = PersonHttpUtil.fetchPerson();
        Person person = Person.from(fetchedPerson);

        assertThat(person, notNullValue());
        assertThat(person.email(), is(not(emptyOrNullString())));
        assertThat(person.fullName(), notNullValue());
        assertThat(person.fullName().first(), is(not(emptyOrNullString())));
        assertThat(person.fullName().last(), is(not(emptyOrNullString())));
    }
}
