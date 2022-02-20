package com.hw.DataProcessing;

import com.hw.Objects.Employee;
import com.hw.Objects.Task;
import java.util.*;
import java.util.stream.Collectors;

public class FilterData
{
    public static Optional<Task> greatestTasks;
    public static List<Employee> greatestEmployees = new ArrayList<>();

    //Вывод задания с наибольшим гонораром за выполнение
    public static void FilteringRewards()
    {
        greatestTasks = Employee.assignedTasks.stream()
                .max(Comparator.comparingInt(Task::getReward));

        if(greatestTasks.isPresent())
        {
            System.out.println(
                    "\nЗадание с наибольшим вознаграждением\n\n"
                            + "Название: " + greatestTasks.get().taskName + "\n"
                            + "Оплата($): " + greatestTasks.get().reward + "\n");
        }
        else
        {
            System.out.println("???");
        }
    }

    //Вывод топ-3 сотрудников по выполнению заданий в месяц, выполнение которых считаем с помощью
    //общей суммы денег у сотрудника
    public static void FilteringEmployees()
    {
        greatestEmployees = Employee.employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getCash).reversed())
                .collect(Collectors.toList());

        System.out.println("\nТоп-3 лучших работника\n");

        for(int i = 0; i < 3; i++)
        {
            System.out.println(i+1
                    + ". ФИО: " + greatestEmployees.get(i).name  + "\n\t"
                    + "Кол-во рабочих часов: " +  greatestEmployees.get(i).workingHours + "\n\t"
                    + "Счет($): " +  greatestEmployees.get(i).cash  + "\n"
            );
        }
    }
}
