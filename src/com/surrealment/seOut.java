package com.surrealment;

public class seOut {

    private static String lastOut = "";

    /**
     * Adds new line to console.
     */
    public static void NextLine() {
        System.out.println();
    }

    /**
     * Adds new line to console using NextLine().
     *
     * @deprecated use {@link #NextLine()} instead.
     */
    @Deprecated
    public static void PrintLine() {
        NextLine();
    }

    /**
     * Adds string then begins new line in console.
     *
     * @param s
     */
    public static void PrintLine(String s) {
        lastOut = s;
        System.out.println(s);
    }

    /**
     * Adds string to console while replacing the current line.
     *
     * @param s
     */
    public static void Print(String s) {
        Print(s, true);
    }

    /**
     * Adds string to console in the current line.
     * Note: Using orgin false may ruin index for clearing the current line.
     *
     * @param s
     * @param orgin If true will replace current line.
     */
    public static void Print(String s, boolean orgin) {
        lastOut = s;
        if (orgin)
            System.out.print("\r" + s);
        else
            System.out.print(s);
    }

    /**
     * Clear current line.
     */
    public static void Clear() {
        System.out.print("\r" + seString.ReplicateCharacter(' ', lastOut.length()));
    }

    /**
     * Replace the current line with a certain character.
     * Note: Use NextLine() then ClearWith('-') to underline the last string.
     *
     * @param character
     */
    public static void ClearWith(char character) {
        System.out.print("\r" + seString.ReplicateCharacter(character, lastOut.length()));
    }

}
