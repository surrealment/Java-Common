package com.surrealment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sParameters {

    // Contains parsed string arg data.
    private static Map<String, String> database = new HashMap<String, String>();

    /**
     * Feed args to add to database.
     * Simple and basic arg parser.
     *
     * @param args
     */
    final public static void Parse(String... args) {
        if (args.length == 0)
            return;

        String combined = args[0];
        boolean lastE = false;
        for (int i = 1; i < args.length; i++) {
            if (args[i].indexOf(' ') != -1)
                args[i] = "\"" + args[i] + "\"";

            if (!lastE && !args[i].endsWith("="))
                combined += " ";
            combined += args[i];
            lastE = args[i].endsWith("=");
        }

        // Trim spaces on either size of the equals.
        combined = combined.replaceAll(" +=", "=").replaceAll("=+ ", "=").replaceAll("=+", "=");

        List<String> matchList = new ArrayList<String>();
        Pattern regex = Pattern.compile("(['\"])((?:\\\\\\1|.)+?)\\1|([^\\s\"']+)");
        Matcher regexMatcher = regex.matcher(combined);
        boolean endedEquals = false;
        while (regexMatcher.find()) {
            if (regexMatcher.group(2) != null) {
                // Add double-quoted string without the quotes
                if (endedEquals)
                    matchList.set(matchList.size() - 1, matchList.get(matchList.size() - 1) + regexMatcher.group(2));
                else
                    matchList.add(regexMatcher.group(2));
                endedEquals = regexMatcher.group(2).endsWith("=");
            } else if (regexMatcher.group(3) != null) {
                // Add single-quoted string without the quotes
                if (endedEquals)
                    matchList.set(matchList.size() - 1, matchList.get(matchList.size() - 1) + regexMatcher.group(3));
                else
                    matchList.add(regexMatcher.group(3));
                endedEquals = regexMatcher.group(3).endsWith("=");
            }
        }

        for (int i = 0; i < matchList.size(); i++) {
            String arg = matchList.get(i);
            String key = "";
            String value = null;
            int indexOfEquals = arg.indexOf('=');
            if (indexOfEquals > -1 && indexOfEquals < arg.length()) {
                key = arg.substring(0, indexOfEquals);
                value = arg.substring(indexOfEquals + 1);
            } else
                key = arg;
            if (database.containsKey(key))
                database.remove(key);
            database.put(key.toLowerCase(), value);
        }
    }

    /**
     * Check if key exist in the database.
     *
     * @param keys
     * @return
     */
    final public static boolean Exists(String... keys) {
        for (int i = 0; i < keys.length; i++)
            if (database.containsKey(keys[i]))
                return true;
        return false;
    }

    /**
     * Check if key exists with a number of values.
     *
     * @param key
     * @param values
     * @return
     */
    final public static boolean Equals(String key, String... values) {
        String value = Value(key);
        for (int i = 0; i < values.length; i++)
            if (value == values[i])
                return true;
        return false;
    }

    /**
     * Get value of first key found in database.
     *
     * @param keys
     * @return
     */
    final public static String Value(String... keys) {
        return ValueDefault(null, keys);
    }

    /**
     * Get value of first key found in database, else provide a default value.
     *
     * @param defaultValue
     * @param keys
     * @return
     */
    final public static String ValueDefault(String defaultValue, String... keys) {
        for (int i = 0; i < keys.length; i++)
            if (database.containsKey(keys[i]))
                return database.get(keys[i]);
        return defaultValue;
    }

    /**
     * Update first key value found in database.
     *
     * @param value
     * @param keys
     */
    final public static void Update(String value, String... keys) {
        for (int i = 0; i < keys.length; i++)
            if (database.containsKey(keys[i]))
                database.replace(keys[i], value);
    }

}
