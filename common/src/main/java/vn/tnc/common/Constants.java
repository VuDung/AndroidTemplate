package vn.tnc.common;

import java.util.regex.Pattern;

/**
 * Created by md101 on 10/18/15.
 */
public class Constants {
    // ============= begin Server Endpoint =============
    /**
     * Server endpoint, github service endpoint.
     */
    public static final String GITHUB_SERVER_ENDPOINT = "https://api.github.com/";
    // ============= begin Server Endpoint =============

    // ============= begin GithubAPIParams =============
    /**
     * Search service params, sort by followers.
     */
    public static final String GITHUB_API_PARAMS_SEARCH_SORT_FOLLOWER = "followers";

    /**
     * Search service params, sort by rrepositoriese.
     */
    public static final String GITHUB_API_PARAMS_SEARCH_SORT_REPO = "repositories";

    /**
     * Search service params, sort by joined date.
     */
    public static final String GITHUB_API_PARAMS_SEARCH_SORT_JOINED = "joined";

    /**
     * Search service params, ordered asc.
     */
    public static final String GITHUB_API_PARAMS_SEARCH_ORDER_ASC = "asc";

    /**
     * Search service params, ordered desc.
     */
    public static final String GITHUB_API_PARAMS_SEARCH_ORDER_DESC = "desc";
    // ============= end GithubAPIParams =============

    // ============= begin TimeFormat =============
    /**
     * Time format ISO_8601.
     */
    public static final String TIME_FORMAT_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    // ============= end TimeFormat =============

    // ============= begin REPatterns =============
    /**
     * Email re pattern.
     */
    public static final Pattern RE_PATTERNS_EMAIL_PATTERN =
            Pattern.compile("^[_A-Za-z0-9-\\+]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    // ============= end REPatterns =============

    // ============= begin IconifyIcons =============
    /**
     * Iconify icon {user}.
     */
    public static final String ICONIFY_ICONS_USER = "{md-person}";

    /**
     * Iconify icon {org}.
     */
    public static final String ICONIFY_ICONS_ORG = "{md-people}";
    // ============= end IconifyIcons =============

    /**
     * Error log format, {tag} {error message}
     */
    public static final String ERROR_LOG_FORMAT = "%s %s";

    private Constants() {
        // no instance
    }
}
