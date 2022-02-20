package com.hw.DataProcessing;

import com.hw.Objects.Employee;

import java.io.*;
import java.util.Arrays;


public class SaveLoadEmployee
{
    //Для сериализации объектов в поток используется класс ObjectOutputStream.
    //Сериализуется класс Employee
    public static void Save()
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("EmployeeList.dat")))
        {
            Log.writeInto("[“SaveLoadEmployee”][“Save()”] " +
                    "Данные о сотрудниках сохранены");

            for (int i = 0; i < Employee.assignedTasks.size(); i++)
            {
                //записываем исполнителя задания
                oos.writeObject(Employee.assignedTasks.get(i).executor);;
            }
        }

        catch (Exception e)
        {
            Log.writeInto("[“SaveLoadEmployee”][“Save()”] Произошла ошибка: "
                    + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }

    public static void Load()
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("EmployeeList.dat")))
        {
            Log.writeInto("[“SaveLoadEmployee”][“Load()”] " +
                    "Данные о сотрудниках загружены");
            for (int i = 0; i < Employee.assignedTasks.size(); i++)
            {
                //считвыаем объект из файла с преобразованием к классу Employee
                Employee.assignedTasks.get(i).executor = (Employee) ois.readObject();
            }
        }
        catch (Exception e)
        {
            Log.writeInto("[“SaveLoadEmployee”][“Load()”] Произошла ошибка: "
                    + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }
}
