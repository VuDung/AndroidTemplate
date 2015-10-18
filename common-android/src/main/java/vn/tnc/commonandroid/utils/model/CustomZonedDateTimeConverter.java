package vn.tnc.commonandroid.utils.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.lang.reflect.Type;

/**
 * Created by md101 on 10/18/15.
 */
public class CustomZonedDateTimeConverter implements JsonSerializer<ZonedDateTime>, JsonDeserializer<ZonedDateTime> {
    /** Formatter. */
    private final DateTimeFormatter mDateTimeFormatter;

    /**
     * Create instance with the given {@link DateTimeFormatter}.
     *
     * @param formatter the given {@link DateTimeFormatter}.
     */
    public CustomZonedDateTimeConverter(final DateTimeFormatter formatter) {
        mDateTimeFormatter = formatter;
    }

    /**
     * Gson invokes this call-back method during serialization when it encounters a field of the
     * specified type. <p>
     *
     * In the implementation of this call-back method, you should consider invoking
     * {@link JsonSerializationContext#serialize(Object, Type)} method to create JsonElements for
     * any
     * non-trivial field of the {@code src} object. However, you should never invoke it on the
     * {@code src} object itself since that will cause an infinite loop (Gson will call your
     * call-back method again).
     *
     * @param src the object that needs to be converted to Json.
     * @param typeOfSrc the actual type (fully genericized version) of the source object.
     * @return a JsonElement corresponding to the specified object.
     */
    @Override
    public JsonElement serialize(final ZonedDateTime src, final Type typeOfSrc,
                                 final JsonSerializationContext context) {
        return new JsonPrimitive(mDateTimeFormatter.format(src));
    }

    /**
     * Gson invokes this call-back method during deserialization when it encounters a field of the
     * specified type. <p>
     *
     * In the implementation of this call-back method, you should consider invoking
     * {@link JsonDeserializationContext#deserialize(JsonElement, Type)} method to create objects
     * for any non-trivial field of the returned object. However, you should never invoke it on the
     * the same type passing {@code json} since that will cause an infinite loop (Gson will call
     * your
     * call-back method again).
     *
     * @param json The Json data being deserialized
     * @param typeOfT The type of the Object to deserialize to
     * @return a deserialized object of the specified type typeOfT which is a subclass of {@code T}
     * @throws JsonParseException if json is not in the expected format of {@code typeOfT}
     */
    @Override
    public ZonedDateTime deserialize(final JsonElement json, final Type typeOfT,
                                     final JsonDeserializationContext context) throws JsonParseException {
        return mDateTimeFormatter.parse(json.getAsString(), ZonedDateTime.FROM);
    }
}