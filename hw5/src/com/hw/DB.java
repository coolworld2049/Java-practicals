package com.hw;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class DB extends Exception
{
    private String[] names = {"Pshep","Fedor","Muttr","Shtrd","Pesel","Mopsl"};
    private String[] catNames = {"ggw","sar","axc","otd","lcv","scb","No.","No.","No."};
    public String name;
    public String catName;

    public DB()
    {
        this.name = this.names[ThreadLocalRandom.current().nextInt(this.names.length)];
        this.catName = this.catNames[ThreadLocalRandom.current().nextInt(this.catNames.length)];
    }

    public static void Exception1(ArrayList<DB> persons)    //IndexOutOfBoundsException
    {
        try
        {
            for (int i = 0; i<10;i++)
            {
                DB db = new DB();
                persons.add(db);
            }

            for (int i = 0; i<20;i++)
            {
                System.out.println(i + " " + persons.get(i).name + "\t\t" + persons.get(i).catName);
            }
        }

        catch (IndexOutOfBoundsException e)
        {
            System.out.println("\n    Outputting non-existent elements in the 'persons' array" +
                    "is greater than 10-->");
            System.out.println("1.IndexOutOfBoundsException");
        }
    }

    public static void Exception2()     //FileNotFoundException
    {
        try
        {
            System.out.println("    Search for a non-existent file-->");
            FileReader fileReader = new FileReader(
                    "C:\\Users\\R\\IdeaProjects\\hw5\\src\\com\\hw\\test.txt");
            String firstString = fileReader.toString();
            System.out.println(firstString);
        }

        catch (FileNotFoundException e)
        {
            System.out.println("2.FileNotFoundException");
        }
    }

    public static void Exception3()     //InterruptedException
    {
        try
        {
            Thread.sleep(1000);
            Thread.currentThread().interrupt();
            System.out.println("    Thread interrupted-->");

            if (Thread.interrupted())
            {
                throw new InterruptedException();
            }
        }

        catch (InterruptedException e)
        {
            System.out.println("3.InterruptedException");

        }
    }

    public static void Exception4(String s)     //NullPointerException
    {
        //Возвращает Optional описание указанного значения, если оно не равно null,
        //в противном случае возвращает пустой Optional.

        Optional<String> optName = Optional.ofNullable(s);
        String name = optName.orElse("4.NullPointerException");

        System.out.println("    The object passed by reference does not exist(null)-->");
        System.out.println(name);
    }

    public static void Exception5()     //ArithmeticException
    {
        try
        {
            System.out.println("    Divide by zero-->");

            int a = 30, b = 0;
            int result = a/b;

        }

        catch (ArithmeticException e)
        {
            System.out.println("5.ArithmeticException");

        }
    }

}
