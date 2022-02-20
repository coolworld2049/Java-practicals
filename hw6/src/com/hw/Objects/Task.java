package com.hw.Objects;

import com.hw.DataProcessing.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task
{
    private static final String[] taskDescriptions;

    static {
        taskDescriptions = new String[]{

                "Возьмите один из веб-фреймворков для изучаемого \n" +
                        " \t\t\t\tвами языка и напишите сайт, который выводит на главной странице надпись\n" +
                        " \t\t\t\t«Привет, мир!». В случае с Haskell, к примеру, таким фреймворком будет Yesod,\n" +
                        " \t\t\t\tScotty, Happstack или Snap.",

                "Добавьте форму для ввода имени пользователя, после отправки которой появляется\n" +
                        " \t\t\t\tнадпись «Привет, (имя пользователя)!».",

                "Добавьте сохранение информации о пользователе в кукисах, чтобы посетителю не\n" +
                        " \t\t\t\tприходилось каждый раз вводить свое имя при заходе на сайт. Сделайте\n" +
                        " \t\t\t\tкнопку «выход», при нажатии на которую кукисы удаляются.",

                "Напишите телефонную книгу с использованием какой-нибудь реляционной СУБД,\n" +
                        " \t\t\t\tнапример, SQLite, MySQL или PostgreSQL. Телефонная книга — это\n" +
                        " \t\t\t\tприложение, которое хранит информацию о ваших знакомых и способах,\n" +
                        " \t\t\t\tкоторыми можно связаться с ними. Вы можете создавать, редактировать\n" +
                        " \t\t\t\tи удалять людей, а также различные их контакты — телефоны, скайпы,\n" +
                        " \t\t\t\t адреса блогов и так далее.",

                "Существуют ли ORM для изучаемого вами языка программирования? Сделайте так,\n" +
                        " \t\t\t\tчтобы приложение из предыдущего пункта могло работать с любыми \n" +
                        " \t\t\t\tдвумя РСУБД, используя один и тот же код.",

                "Напишите телефонную книгу, используя для хранения информации одну из NoSQL\n" +
                        " \t\t\t\tбаз данных, например, MongoDB, Couchbase, Cassandra или Riak.",

                "Напишите программу, выводящую последние 10 твитов, содержащих указанный\n" +
                        " \t\t\t\tхэштэг. Используйте HTTP API социальной сети Twitter.",

                "Напишите программу, собирающую статистику поисковых запросов, по которым\n" +
                        " \t\t\t\tпользователи заходят на некоторый сайт. Для этого пропарсите при\n" +
                        " \t\t\t\tпомощи регулярных выражений логи веб-сервера за месяц.",

                "Напишите библиотеку для поиска на графах в глубину и в ширину, а также при \n" +
                        " \t\t\t\tпомощи алгоритма A*. Реализуйте прямой, обратный и двунаправленный\n" +
                        " \t\t\t\tпоиск.",

                "Напишите программу, считающую MD5, SHA1, SHA256 или иную хэш-функцию от\n" +
                        " \t\t\t\tзаданной строки. Напишите программу, считающую ту же хэш-функцию\n" +
                        " \t\t\t\tот большого файла на диске.",

                "Напишите программу, шифрующую файлы при помощи AES или иного симметричного\n" +
                        " \t\t\t\tшифра.",

                "Найдите библиотеку, реализующую алгоритм RSA. Напишите с ее помощью программу\n" +
                        " \t\t\t\tдля обмена ключами по открытому каналу (например, электронной почте)\n" +
                        " \t\t\t\tи передачи по этому же каналу зашифрованных и защищенных цифровой\n" +
                        " \t\t\t\tподписью сообщений.",

                "Можно ли на изучаемом вами языке программирования сделать скриншот экрана и\n" +
                        " \t\t\t\tсохранить его в bmp-файл? Если да, то попробуйте написать программу,\n" +
                        " \t\t\t\tделающую это.",

                "Напишите генератор Excel-отчетов с графиками и гистограммами. Проверьте, что\n" +
                        " \t\t\t\tон нормально отображается в Microsoft Office, Libre Office и\n" +
                        " \t\t\t\tGoogle Docs.",

                "Напишите свою реализацию хэш-таблиц, RB-деревьев, двусвязных списков, а \n" +
                        " \t\t\t\tтакже других структур данных на ваш выбор."};
    }


    private static final String[] taskNames = {"Напишите сайт",
            "Добавьте форму для ввода имени пользователя",
            "Добавьте сохранение информации о пользователе в кукисах",
            "Напишите телефонную книгу",
            "Сделайте так чтобы приложение могло работать с  двумя РСУБД",
            "Напишите телефонную книгу, используя для хранения информации одну из NoSQL",
            "Напишите программу, выводящую последние 10 твитов",
            "Напишите программу, собирающую статистику поисковых запросов",
            "Напишите библиотеку для поиска на графах в глубину и в ширину",
            "Напишите программу, считающую MD5, SHA1, SHA256 или иную хэш-функцию",
            "Напишите программу, шифрующую файлы при помощи AES",
            "Напишите программу для обмена ключами по открытому каналу",
            "Cделать скриншот экрана и сохранить его в bmp-файл",
            "Напишите генератор Excel-отчетов с графиками и гистограммами",
            "Напишите свою реализацию хэш-таблиц, RB-деревьев, двусвязных списков"};

    public int taskId;
    public String taskName;
    public String taskDescription;
    public int workTime;
    public int reward;
    public boolean taskStatus = false;
    public Employee executor;
    public static List<Task> taskList = new ArrayList<>();


    public Task(int taskId, String taskName, String taskDescription, int workTime, int reward,
                boolean taskStatus)
    {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.workTime = workTime;
        this.reward = reward;
        this.taskStatus = taskStatus;
    }

    public Task() {}

    public int getReward()
    {
        return reward;
    }

    public static void AddTask() throws Exception
    {
        try
        {
            System.out.println("\nВведите данные задания\n");
            Scanner input = new Scanner (System.in);

            int newTaskId = taskList.size()+1;

            System.out.print("Please enter the TaskName of the task: ");
            String newTaskName = input.next();
            Log.writeInto("[“Task”][“AddTask()”][”String newTaskName”] Пользователь ввёл следующие данные:"
                    + newTaskName);

            System.out.print("Please enter the TaskDescription of the task: ");
            String newTaskDescription = input.next();
            Log.writeInto("[“Task”][“AddTask()”][”String newTaskDescription”] Пользователь ввёл следующие данные:"
                    + newTaskDescription);

            System.out.print("Please enter the workTime of the task: ");
            int newWorkTime = input.nextInt();
            Log.writeInto("[“Task”][“AddTask()”][”int newReward”] Пользователь ввёл следующие данные:"
                    + newWorkTime);

            System.out.print("Please enter the reward of the task: ");
            int newReward = input.nextInt();
            Log.writeInto("[“Task”][“AddTask()”][”int newReward”] Пользователь ввёл следующие данные:"
                    + newReward);

            taskList.add(
                    new Task(
                            newTaskId,
                            newTaskName,
                            newTaskDescription,
                            newWorkTime,
                            newReward,
                            false));

            //нозначение нового задания исполнителю
            Employee.assignedTasks.get(Employee.assignedTasks.size()-1).executor =
                    Employee.employeeList.get(Employee.employeeList.size()-1);
        }

        catch (Exception e)
        {
            Log.writeInto("[“Task”][“AddTask()”] Произошла ошибка: "
                    + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }

    public void GenerateTaskList()
    {
        for(int i =0;i<taskNames.length;i++)
        {
            Task task = new Task(
                    i+1,
                    taskNames[i],
                    taskDescriptions[i],
                    ThreadLocalRandom.current().nextInt(12,45),
                    ThreadLocalRandom.current().nextInt(1000,15625),
                    false);

            taskList.add(task);
        }
    }
}
