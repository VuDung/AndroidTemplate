package vn.tnc.commonandroid.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.temporal.ChronoField;

import vn.tnc.common.Constants;
import vn.tnc.common.model.AutoGenTypeAdapterFactory;
import vn.tnc.commonandroid.utils.model.CustomZonedDateTimeConverter;

/**
 * Created by md101 on 10/18/15.
 */
public class GsonProvider {
    private GsonProvider() {
        // singleton
    }

    /**
     * Provide the {@link Gson} singleton instance. Should be only called in test cases, besides
     * {@link ProviderModule}.
     *
     * @return the singleton {@link Gson}.
     */
    static Gson provideGson() {
        return GsonHolder.sGson;
    }

    private static class GsonHolder {
        // lazy instantiate
        private static volatile DateTimeFormatter sDateTimeFormatter =
                new DateTimeFormatterBuilder().parseCaseInsensitive()
                        .append(DateTimeFormatter.ISO_LOCAL_DATE)
                        .appendLiteral('T')
                        .appendValue(ChronoField.HOUR_OF_DAY, 2)
                        .appendLiteral(':')
                        .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
                        .optionalStart()
                        .appendLiteral(':')
                        .appendValue(ChronoField.SECOND_OF_MINUTE, 2)
                        .appendLiteral('Z')
                        .toFormatter()
                        .withResolverStyle(ResolverStyle.STRICT)
                        .withChronology(IsoChronology.INSTANCE)
                        .withZone(ZoneId.systemDefault());

        private static volatile Gson sGson = new GsonBuilder()
                //.excludeFieldsWithoutExposeAnnotation()   //not exclude for auto parcel
                .registerTypeAdapterFactory(new AutoGenTypeAdapterFactory())
                .registerTypeAdapter(ZonedDateTime.class,
                        new CustomZonedDateTimeConverter(sDateTimeFormatter))
                .setDateFormat(Constants.TIME_FORMAT_ISO_8601)
                .setPrettyPrinting()
                .create();
    }
}
