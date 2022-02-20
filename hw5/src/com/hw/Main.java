package com.hw;
import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        ArrayList<DB> persons = new ArrayList<>();

        DB.Exception1(persons);    //IndexOutOfBoundsException
        DB.Exception2();           //FileNotFoundException
        DB.Exception3();           //InterruptedException
        DB.Exception4(null);    //NullPointerException
        DB.Exception5();           //ArithmeticException
    }
}
