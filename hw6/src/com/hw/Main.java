package com.hw;

import com.hw.DataProcessing.*;
import com.hw.Display.View;
import com.hw.Objects.Employee;
import com.hw.Objects.Task;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    //переменная для проверки выполнения заданий, которая становится true в 3 пунтке меню
    //когда задания выполнены
    private static boolean checkCompletingTasks = false;

    public static void main(String[] args)
    {
        Employee employee = new Employee();
        Task task = new Task();

        //запуск логирования
        AutoSaveLogWorker.Logger();

        Log.writeInto("\n[“Main”][“task.GenerateTaskList()”, ”employee.GenerateEmployerList()”] " +
                "Генерация сотрудников и заданий");
        task.GenerateTaskList();
        employee.GenerateEmployerList();

        try
        {
            Log.writeInto("[“Main”][“Menu(employee,task)”] Открытие главного меню");
            Menu(employee,task);
        }
        catch (Exception e)
        {
            Log.writeInto("[“Log”][“writeInto()”] Произошла ошибка: "
                    + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }

    }

    public static void  Menu(Employee employee, Task task) throws Exception
    {
        AutoSaveLogWorker.Logger(); //запуск логирования

        System.out.println("\n\t\tМЕНЮ\n" +
                "\n1.Информация о сотрудниках" +
                "\n2.Информация об открытых заданиях\n" +
                "\n\t9.Сохранить список сотрудников в файл" +
                "\n\t10.Загрузить список сотрудников\n" +
                "\n3.Распределить и выполнить задания" +
                "\n4.Посмотреть исполнителей" +
                "\n5.Выборка данных!" +
                "\n6.Добавить сотрудника и задание" +
                "\n7.Сформировать отчет о работе сотрудников" +
                "\n8.Выход\n\n" +
                "№?: ");
        Scanner scanner2 = new Scanner(System.in);

        int tmp = scanner2.nextInt();
        Log.writeInto("[“Main”][“Menu(Employee employee, Task task)”] Пользователь ввёл " +
                "следующие данные: " + tmp);

        switch (tmp) {
            case 1 -> {
                View.ShowEmployees();
                Menu(employee, task);
            }
            case 2 -> {
                View.ShowOpenTasks();
                Menu(employee, task);
            }
            case 3 -> {
                Employee.UpdateTasks();
                Employee.CompletingTasks();
                View.ShowCompletedTasks();

                checkCompletingTasks = true;
                Menu(employee, task);
            }
            case 4 -> {
                View.ShowExecutors();
                Menu(employee, task);
            }
            case 5 -> {
                if (checkCompletingTasks) {
                    Log.writeInto("[“Main”][“Menu(employee,task)”] Открытие меню фильтрации");
                    FilteringMenu(employee, task);
                } else {
                    System.out.println("Задания не распределены и не выполнены");
                }
                Menu(employee, task);
            }
            case 6 -> {
                Employee.AddEmployer();
                Menu(employee, task);
            }
            case 7 -> {
                Report.SaveReport();
                Menu(employee, task);
            }
            case 8 -> {
            }

            case 9 -> {
                SaveLoadEmployee.Save();
                Menu(employee, task);
            }
            case 10 -> {
                SaveLoadEmployee.Load();
                Menu(employee, task);
            }
        }
    }

    public static void  FilteringMenu(Employee employee, Task task) throws Exception
    {
        AutoSaveLogWorker.Logger(); //запуск логирования

        System.out.println("\n\t\tВЫБОРКА ДАННЫХ\n" +
                "\n1.Топ-3 сотрудников по выполнению заданий в месяц" +
                "\n2.Показать задания с наибольшим вознаграждением" +
                "\n3.Выход в меню\n\n" +
                "№?: ");
        Scanner scanner2 = new Scanner(System.in);
        int tmp2 = scanner2.nextInt();
        Log.writeInto("[“Main”][“FilteringMenu(Employee employee, Task task)”] Пользователь ввёл " +
                "следующие данные: " + tmp2);
        switch (tmp2)
        {
            case 1 -> {
                FilterData.FilteringEmployees();
                FilteringMenu(employee,task);
            }
            case 2 -> {
                FilterData.FilteringRewards();
                FilteringMenu(employee,task);
            }
            case 3 -> {
                Menu(employee, task);
            }
        }
    }
}
