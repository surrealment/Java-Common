package com.surrealment;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class seSettings {

    public static class Container {
        public String help = "";
        public String value = "";

        public Container(String value, String help) {
            this.value = value;
            this.help = help;
        }
    }

    // Contains default settings data.
    private static Map<String, Map<String, Container>> defaults = new HashMap<>();

    // Contains parsed settings data.
    private static Map<String, Map<String, Container>> database = new HashMap<>();

    /**
     * Load save file
     * Note: This defines category ([Category])
     * This defines name and value (name = value)
     *
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
        String help = "";
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            line = line.trim();
            if (line.startsWith("[") && line.endsWith("]"))
                category = line.substring(1, line.length() - 2);
            else if (line.startsWith("//") || line.startsWith(";"))
                help += (help.length() > 0) ? "\n" + line : line;
            else if (line.contains("=")) {
                int e = line.indexOf("=");
                String name = line.substring(0, e).trim();
                String value = line.substring(e + 1).trim();

                if (name.length() == 0 || value.length() == 0)
                    continue;

                if (!database.containsKey(category))
                    database.put(category, new HashMap<String, Container>());

                Map<String, Container> c = database.get(category);

                if (!c.containsKey(name))
                    c.put(name, new Container(value, help));
                else
                    c.replace(name, new Container(value, help));

                database.replace(category, c);
                help = "";
            }
        }
        br.close();
        Save(path);
    }

    /**
     * Saves current database first, and uses the default database to replace missing items.
     *
     * @param path
     * @throws IOException
     */
    public static void Save(String path) throws IOException {
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        Set<String> defaultCategories = defaults.keySet();
        for (String category : defaultCategories) {
            writer.println("[" + category.toUpperCase() + "]");
            Map<String, Container> db = defaults.get(category);
            Set<String> defaultNames = db.keySet();
            for (String name : defaultNames) {
                Container container = GetContainer(category, name);
                if (container.help.length() > 0)
                    writer.println(container.help);
                writer.println(name + " = " + container.value);
            }
            writer.println();
        }
        writer.close();
    }

    /**
     * Add default values, this should be handled before loading.
     *
     * @param category
     * @param name
     * @param value
     */
    public static void AddDefault(String category, String name, String value) {
        AddDefault(category, name, value, "");
    }

    /**
     * Add default values, this should be handled before loading.
     *
     * @param category
     * @param name
     * @param value
     */
    public static void AddDefault(String category, String name, String value, String help) {
        category = category.toUpperCase();
        if (!defaults.containsKey(category))
            defaults.put(category, new HashMap<String, Container>());

        Map<String, Container> db = defaults.get(category);

        Container container = new Container(value, help);

        if (!db.containsKey(name))
            db.put(name, container);
        else
            db.replace(name, container);

        defaults.replace(category, db);
    }

    /**
     * Retrieves database values if empty gets default values if they exist.
     *
     * @param category
     * @param name
     * @return
     */
    public static String Get(String category, String name) {
        if (database.containsKey(category))
            if (database.get(category).containsKey(name)) {
                Container container = database.get(category).get(name);
                if (container.value.length() > 0)
                    return container.value;
            }

        if (defaults.containsKey(category))
            if (defaults.get(category).containsKey(name))
                return defaults.get(category).get(name).value;

        return "";
    }


    /**
     * Retrieves database values if empty gets default values if they exist.
     *
     * @param category
     * @param name
     * @return
     */
    private static Container GetContainer(String category, String name) {
        if (database.containsKey(category))
            if (database.get(category).containsKey(name)) {
                Container container = database.get(category).get(name);
                if (container.value.length() > 0)
                    return container;
            }

        if (defaults.containsKey(category))
            if (defaults.get(category).containsKey(name))
                return defaults.get(category).get(name);

        return null;
    }

}
