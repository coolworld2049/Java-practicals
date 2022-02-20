package com.hw.DataProcessing;

import java.util.ArrayList;

public class Log
{
    private static final ArrayList<String> logHistory = new ArrayList<>();

    public static void writeInto(String message)
    {
        System.out.println( "\u001B[36m" + message +  "\u001B[0m");
        logHistory.add(message);
    }

    public static ArrayList<String> getLogHistory()
    {
        return logHistory;
    }
}
