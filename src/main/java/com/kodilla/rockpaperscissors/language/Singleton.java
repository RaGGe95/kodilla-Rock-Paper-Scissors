package com.kodilla.rockpaperscissors.language;

public class Singleton {

    private static Singleton INSTANCE = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        synchronized (INSTANCE) {
            if (INSTANCE == null) {
                INSTANCE = new Singleton();
            }
        }
        return INSTANCE;
    }

    /**
     * warszawa - barcelona, berlin
     * berlin - hannover, londyn
     * londyn - nowy jork
     *
     * foo("warszawa", "nowy jork")
     * foo("berlin", "nowy jork")
     * foo("londyn", "nowy jork")
     */
}
