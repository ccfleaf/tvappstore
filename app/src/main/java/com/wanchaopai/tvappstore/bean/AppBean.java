package com.wanchaopai.tvappstore.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class AppBean {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<AppItem> ITEMS = new ArrayList<AppItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, AppItem> ITEM_MAP = new HashMap<String, AppItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createAppItem(i));
        }
    }

    private static void addItem(AppItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static AppItem createAppItem(int position) {
        return new AppItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class AppItem {
        public final String id;
        public final String content;
        public final String details;

        public AppItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
