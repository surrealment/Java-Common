package com.surrealment;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class seSettings {

    // Contains default settings data.
    private static Map<String, Map<String, String>> defaults = new HashMap<>();

    // Contains parsed settings data.
    private static Map<String, Map<String, String>> database = new HashMap<>();

    /**
     * Load save file
     * Note: This defines category ([Category])
     *       This defines name and value (name = value)
     * @param path
     * @throws IOException
     */
    public static void Load(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            Save(path);
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String category = "";
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            line = line.trim();
            if (line.startsWith("[") && line.endsWith("]"))
                category = line.substring(1, line.length() - 2);
            else if (line.contains("=")) {
                int e = line.indexOf("=");
                String name = line.substring(0, e).trim();
                String value = line.substring(e + 1).trim();

                if (name.length() == 0 || value.length() == 0)
                    continue;

                if (!database.containsKey(category))
                    database.put(category, new HashMap<String, String>());

                Map<String, String> c = database.get(category);

                if (!c.containsKey(name))
                    c.put(name, value);
                else
                    c.replace(name, value);

                database.replace(category, c);
            }
        }
        br.close();
        Save(path);
    }

    /**
     * Saves current database first, and uses the default database to replace missing items.
     * @param path
     * @throws IOException
     */
    public static void Save(String path) throws IOException {
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        Set<String> defaultCategories = defaults.keySet();
        for (String category : defaultCategories) {
            Map<String, String> c = defaults.get(category);
            Set<String> defaultNames = c.keySet();
            for (String name : defaultNames)
                writer.println(name + " = " + Get(category, name));
            writer.println();
        }
        writer.close();
    }

    /**
     * Add default values, this should be handled before loading.
     * @param category
     * @param name
     * @param value
     */
    public static void AddDefault(String category, String name, String value) {
        if (!defaults.containsKey(category))
            defaults.put(category, new HashMap<String, String>());

        Map<String, String> c = defaults.get(category);

        if (!c.containsKey(name))
            c.put(name, value);
        else
            c.replace(name, value);

        defaults.replace(category, c);
    }

    /**
     * Retrieves database values if empty gets default values if they exist.
     * @param category
     * @param name
     * @return
     */
    public static String Get(String category, String name) {
        if (database.containsKey(category))
            if (database.get(category).containsKey(name)) {
                String value = database.get(category).get(name);
                if (value.length() > 0)
                    return value;
            }

        if (defaults.containsKey(category))
            if (defaults.get(category).containsKey(name))
                return defaults.get(category).get(name);

        return "";
    }


}
