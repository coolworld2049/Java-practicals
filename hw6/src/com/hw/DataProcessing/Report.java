package com.hw.DataProcessing;

import com.hw.Objects.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Report
{
    public static void SaveReport()
    {
        try (FileWriter reportWriter = new FileWriter("Report.txt"))
        {
            List<Employee> employeeData = Employee.employeeList;

            reportWriter.write("\nОТЧЕТ\n\n");
            for (Employee empl : employeeData)
            {
                reportWriter.write(empl.name + "\n");
                reportWriter.write("Рабочие часы " + empl.workingHours + "\n");
                reportWriter.write("Заработанные деньги " + empl.cash + "\n\n");
            }

            //запись данных из класса FilterData происходит только после выполнения его методов
            if((FilterData.greatestTasks != null) & (FilterData.greatestEmployees != null))
            {
                reportWriter.write("\nЗадание с наибольшим вознаграждением\n\n"
                        + "Название: " + FilterData.greatestTasks.get().taskName + "\n"
                        + "Оплата($): " + FilterData.greatestTasks.get().reward + "\n");

                reportWriter.write("\nТоп-3 лучших работника\n\n");
                for(int i = 0; i < 3; i++)
                {
                    reportWriter.write(i+1
                            + ". ФИО: " + FilterData.greatestEmployees.get(i).name  + "\n\t"
                            + "Кол-во рабочих часов: " +  FilterData.greatestEmployees.get(i)
                            .workingHours + "\n\t"
                            + "Счет($): " +  FilterData.greatestEmployees.get(i).cash  + "\n"
                    );
                }
            }
            else
            {
                System.out.println("\n5 пункт не выполнен\n");
            }
        }

        catch (IOException e)
        {
            Log.writeInto("[“Report”][“SaveReport()”] Произошла ошибка: "
                    + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }
}
