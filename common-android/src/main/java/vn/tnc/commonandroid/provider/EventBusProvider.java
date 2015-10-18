package vn.tnc.commonandroid.provider;

import de.greenrobot.event.EventBus;

/**
 * Created by md101 on 10/18/15.
 */
public class EventBusProvider {

    private EventBusProvider() {
        // singleton
    }

    /**
     * Provide the {@link EventBus} singleton instance.
     *
     * @return the singleton {@link EventBus}.
     */
    static EventBus provideEventBus() {
        return EventBusHolder.sEventBus;
    }

    private static class EventBusHolder {
        // lazy instantiate
        private static volatile EventBus sEventBus = EventBus.builder()
                .logNoSubscriberMessages(false)
                .sendNoSubscriberEvent(false)
                .eventInheritance(true)
                .throwSubscriberException(true)
                .build();
    }
}
