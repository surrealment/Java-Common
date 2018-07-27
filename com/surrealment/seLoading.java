package com.surrealment;

public class sLoading {

    // String array used to create a load string.
    final private static String[] loadString = new String[]{
            "|O- - - - - - - |",
            "| o - - - - - - |",
            "| -o- - - - - - |",
            "| - o - - - - - |",
            "| - -o- - - - - |",
            "| - - o - - - - |",
            "| - - -o- - - - |",
            "| - - - o - - - |",
            "| - - - -o- - - |",
            "| - - - - o - - |",
            "| - - - - -o- - |",
            "| - - - - - o - |",
            "| - - - - - -o- |",
            "| - - - - - - o |",
            "| - - - - - - -O|",
            "| - - - - - - o |",
            "| - - - - - -o- |",
            "| - - - - - o - |",
            "| - - - - -o- - |",
            "| - - - - o - - |",
            "| - - - -o- - - |",
            "| - - - o - - - |",
            "| - - -o- - - - |",
            "| - - o - - - - |",
            "| - -o- - - - - |",
            "| - o - - - - - |",
            "| -o- - - - - - |",
            "| o - - - - - - |"
    };

    // Value of current index.
    private static int loadStringIndex = 0;

    /**
     * Gets next loadString each iteration.
     * Note: Use sOut.Print() to show properly.
     *
     * @return
     */
    final public static String GetLoadString() {
        if (loadStringIndex >= loadString.length)
            loadStringIndex = 0;
        return loadString[loadStringIndex++];
    }

    /**
     * Reset index.
     */
    final public static void Reset() {
        loadStringIndex = 0;
    }

}
