package com.hw.DataProcessing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AutoSaveLogWorker
{
    public static void Logger()
    {
        try (FileWriter logWriter = new FileWriter("log.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(logWriter))
        {
            ArrayList<String> logBuffer = Log.getLogHistory();
            for (String s : logBuffer)
            {
                s += "\n";
                bufferedWriter.write(s);
            }
        }

        catch (IOException e)
        {
            Log.writeInto("[“AutoSaveLogWorker”][“run()”] Произошла ошибка: "
                    + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }
}
