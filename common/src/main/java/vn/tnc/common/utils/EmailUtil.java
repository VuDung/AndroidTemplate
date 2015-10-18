package vn.tnc.common.utils;

import java.util.regex.Pattern;

/**
 * Created by md101 on 10/18/15.
 */
public class EmailUtil {
    private final Pattern mEmailPattern;

    /**
     * Create an {@link EmailUtil} instance with the given email re {@link Pattern}.
     *
     * @param emailPattern the email re {@link Pattern} to use in this instance.
     */
    public EmailUtil(final Pattern emailPattern) {
        mEmailPattern = emailPattern;
    }

    /**
     * Validate the given email string.
     *
     * @param email the email string to be validated.
     * @return {@code true} if the given string is a valid email, {@code false} if invalid.
     */
    public boolean isValidEmail(final String email) {
        return email != null && email.length() > 0 &&
                mEmailPattern.matcher(email).find();
    }
}
