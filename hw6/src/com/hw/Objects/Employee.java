package com.hw.Objects;

import com.hw.DataProcessing.Log;
import com.hw.Display.View;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Employee implements Serializable
{
    private final String[] firstNames = {"Борислав", "Авдей", "Филимон",
            "Артур" , "Лука", "Матвей", "Юрий", "Никанор", "Руслан","Антон","Андрей","Василий",
            "Александр","Алексей","Владимир"};

    private final String[] lastNames = {"Мосенцов", "Салтыков", "Менделеев", "Шульц",
            "Анников", "Жевлаков", "Таушев", "Десятков", "Бармыкин", "Поличев",
            "Бабанов", "Теребов", "Жиленко", "Канадин", "Порсев"};

    private final String[] middleNames = {"Леонович", "Капитонович", "Егорович",
            "Трофимович", "Юлиевич", "Борисович", "Маркович", "Трофимович", "Ираклиевич",
            "Маркович", "Евгениевия", "Василиевич", "Тарасович", "Аникитевич",
            "Константиновия"};

    private final String[] positions = {"Администратор", "Аналитик", "Аудитор", "Аукционист",
            "Биржевой маклер", "Брокер", "Брокер торговый", "Бухгалтер", "Бухгалтер-ревизор",
            "Дилер", "Диспетчер", "Документовед", "Инженер", "Инженер-конструктор",
            "Инженер-лаборант"};

    private final String[] cities = {"Париж", "Рим ", "Венеция", "Рио-де-Жанейро" , "Стамбул",
            "Нью-Йорк", "Амстердам", "Прага","Афины","Железногорск","Заволжье","Каспийск",
            "Коломна","Москва","Фокино"};


    public String firstName;
    public String middleName;
    public String lastName;
    public String name;
    public int age;
    public String position;
    public String city;
    public int workingHours;
    public int cash;
    public static List<Employee> employeeList = new ArrayList<>(); //список сотрудников
    public static List<Task> assignedTasks = new ArrayList<>(); //назначенные задачи конкретному сотруднику

    public int getCash() { return cash; }

    public Employee(String firstName, String middleName, String lastName, String name, int age,
                    String position, String city, int workingHours, int cash,
                    List<Task> assignedTasks)
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.name =   lastName + " " + firstName + " " + middleName;
        this.age = age;
        this.position = position;
        this.city = city;
        this.cash = cash;
        this.workingHours = workingHours;
        Employee.assignedTasks = assignedTasks;
    }

    public Employee() {}

    public static void AddEmployer() throws Exception
    {
        System.out.println("\nВведите данные сотрудника\n");
        Scanner input = new Scanner (System.in);

        try
        {
            System.out.print("Please enter the newFirstName of the employee: ");
            String newFirstName = input.next();
            Log.writeInto("[“Employee”][“AddEmployer()”][“String newFirstName”] Пользователь ввёл следующие данные:"
                    + newFirstName);

            System.out.print("Please enter the middleName of the employee: ");
            String newMiddleName = input.next();
            Log.writeInto("[“Employee”][“AddEmployer()”][“String newMiddleName”] Пользователь ввёл следующие данные:"
                    + newMiddleName);

            System.out.print("Please enter the lastName of the employee: ");
            String newLastName = input.next();
            Log.writeInto("[“Employee”][“AddEmployer()”][“String newLastName”] Пользователь ввёл следующие данные:"
                    + newLastName);

            String newName = newLastName + " " + newFirstName + " " + newMiddleName;

            System.out.print("Please enter the age of the employee: ");
            int age = input.nextInt();
            Log.writeInto("[“Employee”][“AddEmployer()”][“int age”] Пользователь ввёл следующие данные:"
                    + age);

            System.out.print("Please enter the position of the employee: ");
            String newPosition = input.next();
            Log.writeInto("[“Employee”][“AddEmployer()”][“String newPosition”] Пользователь ввёл следующие данные:"
                    + newPosition);

            System.out.print("Please enter the city of the employee: ");
            String newCity = input.next();
            Log.writeInto("[“Employee”][“AddEmployer()”][“String newCity”] Пользователь ввёл следующие данные:"
                    + newCity);

            System.out.print("Please enter the workingHours of the employee: ");
            int newWorkingHours = input.nextInt();
            Log.writeInto("[“Employee”][“AddEmployer()”][“int newWorkingHours”] Пользователь ввёл следующие данные:"
                    + newWorkingHours);

            employeeList.add(new Employee(
                    newFirstName,
                    newMiddleName,
                    newLastName,
                    newName,
                    age,
                    newPosition,
                    newCity,
                    newWorkingHours,
                    0,
                    assignedTasks)
            );

            Task.AddTask(); //вызова методоа для добавления задания в общий список taskList
        }

        catch (Exception e)
        {
            Log.writeInto("[“Task”][“AddTask()”] Произошла ошибка: "
                    + e.getClass() + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }

    public void GenerateEmployerList()
    {
        //генерация сотрудника с рандомными значениями полей
        //каждый сотрудник получает список заданий из класса Task
        for (int i = 0; i < firstNames.length; i++)
        {
            Employee employee = new Employee(
                    firstNames[i],
                    middleNames[i],
                    lastNames[i],
                    firstName + " " + middleName + " " + lastName,
                    ThreadLocalRandom.current().nextInt(20, 50),
                    positions[ThreadLocalRandom.current().nextInt(positions.length)],
                    cities[ThreadLocalRandom.current().nextInt(cities.length)],
                    ThreadLocalRandom.current().nextInt(64, 180),
                    0,
                    Task.taskList
            );
            employeeList.add(employee);
        }

        //назачение заданий сотрудникам
        for (int j = 0; j < employeeList.size(); j++)
        {
            //Каждое задание в спике assignedTasks имеет своего исполнителя из employeeList
            assignedTasks.get(j).executor = employeeList.get(j);
        }
    }

    public static void CompletingTasks()
    {
        for(int i =0;i<employeeList.size();i++)
        {
            //время,необходимое на выполнение каждого задания вычитается из рабочего
            //времени сотрудника
            assignedTasks.get(i).executor.workingHours -= assignedTasks.get(i).workTime;

            //Если его рабочее время,которое он тратит на выполненеие заданий больше
            //требуемого в задании то он получает вознаграждение
            if (assignedTasks.get(i).executor.workingHours >= assignedTasks.get(i).workTime)
            {
                assignedTasks.get(i).taskStatus = true;
                assignedTasks.get(i).executor.cash += assignedTasks.get(i).reward;
            }
            else if (assignedTasks.get(i).executor.workingHours < assignedTasks.get(i).workTime)
            {
                assignedTasks.get(i).taskStatus = false;
            }

            if (assignedTasks.get(i).executor.workingHours < 0)
            {
                assignedTasks.get(i).executor.workingHours = 0;
            }
        }
    }

    public static void UpdateTasks()
    {
        //обновление статуса заданий для повторного выполнения
        for(int i =0;i<employeeList.size();i++)
        {
            assignedTasks.get(i).taskStatus = false;
        }
    }
}
