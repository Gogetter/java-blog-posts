package dev.etimbuk;

import dev.etimbuk.record.EmailData;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

class EmailDataTest {
    @Test
    void testGivenEmailDataThenValidObject() {
        EmailData emailData = new EmailData("test@tester.com", "Just testing", "A test message", Set.of());

        assertThat(emailData, notNullValue());
        assertThat(emailData.message(), equalTo("A test message"));
    }
}
