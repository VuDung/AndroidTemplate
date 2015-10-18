package vn.tnc.common.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;


/**
 * https://gist.github.com/Piasy/fa507251da452d36b221
 */
public final class AutoGenTypeAdapterFactory implements TypeAdapterFactory {

    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> type) {
        final Class<T> rawType = (Class<T>) type.getRawType();
        final AutoGson annotation = rawType.getAnnotation(AutoGson.class);

        // Only deserialize classes decorated with @AutoGson.
        return annotation == null ? null : (TypeAdapter<T>) gson.getAdapter(annotation.autoClass());
    }
}

