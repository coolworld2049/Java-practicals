package com.hw.Display;

import com.hw.Objects.Employee;
import com.hw.Objects.Task;

public class View
{
    public static void ShowExecutors()
    {
        System.out.println("\n\tСписок заданий, выполняемых сотрудниками\n");

        for (Task assignedTask : Employee.assignedTasks) {

            System.out.println(
                    "\u001B[32m" + "|\tНомер задания: " + "\u001B[0m"
                            + assignedTask.taskId + "\n"
                            + "\u001B[32m" + "|\t\tЗадание: " + "\u001B[0m"
                            + assignedTask.taskName

                            + "\u001B[34m" + "\n|\t\tПодробности задания:" + "\u001B[0m"
                            + "\u001B[34m" + "\n|\t\t\tСрок выполнения(часы): " + "\u001B[0m"
                            + assignedTask.workTime
                            + "\u001B[34m" + "\n|\t\t\tОплата($): " + "\u001B[0m"
                            + assignedTask.reward + "\n|\n"

                            //+ "\u001B[32m" + "\t\tОписание: " + "\u001B[0m"
                            //+ assignedTasks.get(tmp).taskDescription + "\n"
                            + "\u001B[32m" + "|\t\tСтатус выполнения: " + "\u001B[0m"
                            + assignedTask.taskStatus + "\n"
                            + "\u001B[32m" + "|\t\tИсполнитель: " + "\u001B[0m"
                            + assignedTask.executor.name + "\n|"
                            + "\u001B[32m" + "\t\tКол-во рабочих часов в месяце: " + "\u001B[0m"
                            + assignedTask.executor.workingHours + "\n");
        }
    }

    public static void ShowEmployees()
    {
        System.out.println("\n\tСписок cотрудников\n");

        for(int i = 0; i< Employee.employeeList.size(); i++)
        {
            System.out.println(i+1
                    + ". ФИО: " + Employee.assignedTasks.get(i).executor.name  + "\n\t"
                    + "Возраст: " + Employee.assignedTasks.get(i).executor.age  + "\n\t"
                    + "Должность: " + Employee.assignedTasks.get(i).executor.position  + "\n\t"
                    + "Город: " + Employee.assignedTasks.get(i).executor.city  + "\n\t"
                    + "Кол-во рабочих часов: " + Employee.assignedTasks.get(i).executor.workingHours + "\n\t"
                    + "Счет($): " + Employee.assignedTasks.get(i).executor.cash  + "\n"
            );
        }
    }

    public static void ShowOpenTasks()
    {
        System.out.println("\n\tСписок открытых заданий\n");

        for(int i =0;i<Task.taskList.size();i++)
        {
            System.out.println();
            System.out.println(i+1
                    + ". Название: " + Task.taskList.get(i).taskName + "\n\t"
                    //+ "Описание: " + Task.taskList.get(i).taskDescription + "\n\t"
                    + "Срок выполнения(часы): " + Task.taskList.get(i).workTime  + "\n\t"
                    + "Оплата($): " + Task.taskList.get(i).reward  + "\n\t"
                    + "Статус выполнения: " + Task.taskList.get(i).taskStatus  + "\n\t");
        }
    }

    public static void ShowCompletedTasks()
    {
        System.out.println("\n\tСписок завершенных заданий\n");

        for(int i = 0; i< Employee.assignedTasks.size(); i++)
        {
            if(Employee.assignedTasks.get(i).taskStatus)
            {
                System.out.println(i+1
                        + ". Название: " + Employee.assignedTasks.get(i).taskName + "\n\t"
                        //+ "Описание: " + taskList.get(i).taskDescription + "\n\t"
                        + "Срок выполнения(часы): " + Employee.assignedTasks.get(i).workTime  + "\n\t"
                        + "Оплата($): " + Employee.assignedTasks.get(i).reward  + "\n\t"
                        + "Статус выполнения: " + Employee.assignedTasks.get(i).taskStatus + "\t\t"
                        + "[Исполнитель: " + Employee.assignedTasks.get(i).executor.name
                        + "]\n");
            }
        }
    }
}
