package com.surrealment;

public class seLoading {

    // String array used to create a load string.
    public static String[] loadString = new String[]{
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
    public static String GetLoadString() {
        if (loadStringIndex >= loadString.length)
            loadStringIndex = 0;
        if(loadString == null || loadString.length == 0)
            return "";
        return loadString[loadStringIndex++];
    }

    /**
     * Reset index.
     */
    public static void Reset() {
        loadStringIndex = 0;
    }

}
