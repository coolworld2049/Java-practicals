package com.hw;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.*;

public class Main {

    public static void main(String[] args)
    {
        ArrayList<Worker> persons = new ArrayList<>();
        Optional<Worker> tmpWageMin = null;
        Optional<Worker> tmpWageMax = null;
        List<Worker> tmpAgeSort = null;
        List<Worker> tmpAgeSortReverse = null;
        List<Worker> sampleByDep = null;
        List<Worker> bestWorker = null;
        long quantityEmployees = 0;
        long quantityEmployees1 = 0;
        long quantityEmployees2 = 0;
        long quantityEmployees3 = 0;


        System.out.println("Name" + "\t\t" + "Lastname" + "\t" + "Age" + "\t\t" + "Gender" + "\t" +
                "CatName" + "\t" + "DepName" + "\t\t" + "Pos" + "\t\t\t" + "Wage" + "\t\t" + "MeritPay"
                + "\t" + "WorkLife" + "\n");
        for (int i = 0; i<10 ;i++)
        {
            Worker worker = new Worker();
            persons.add(worker);
            System.out.println(
                    worker.getName() + "\t\t" + worker.getLastName() + "\t\t" +
                    worker.getAge() + "\t\t" + worker.getGender()  + "\t\t" +
                    worker.getCatName()  + "\t\t" + worker.getDepartmentName()  + "\t\t" +
                    worker.getPosition()  + "\t\t" + worker.getWage()  + "\t\t" +
                    worker.getMeritPay()  + "\t\t" + worker.getWorkLife() + "\t\t");

            Supplier<Stream<Worker>> stream = persons::stream;

            tmpWageMin = stream.get().min(Comparator.comparing(Worker::getWage));
            tmpWageMax = stream.get().max(Comparator.comparing(Worker::getWage));

            tmpAgeSort = stream.get()
                    .filter(e -> e.getAge() > 50)
                    .filter(e -> e.getCatName() != "No.")
                    .collect(Collectors.toList());

            tmpAgeSortReverse = stream.get()
                    .filter(e -> e.getAge() < 50)
                    .filter(e -> e.getCatName() != "No.")
                    .collect(Collectors.toList());

            sampleByDep = stream.get()
                    .filter(e -> e.getMeritPay() > 0)
                    .collect(Collectors.toList());

            bestWorker = stream.get()
                    .collect(Collectors.toList());

            quantityEmployees = stream.get()
                    .filter(e -> e.getDepartmentName() == "Memlogy")
                    .count();

            quantityEmployees1 = stream.get()
                    .filter(e -> e.getDepartmentName() == "JavaGDv")
                    .count();

            quantityEmployees2 = stream.get()
                    .filter(e -> e.getDepartmentName() == "CyberSp")
                    .count();

            quantityEmployees3 = stream.get()
                    .filter(e -> e.getDepartmentName() == "MainigB")
                    .count();
        }
        //Задания
        //a
        System.out.println("\nMin Wage: " + tmpWageMin.get().wage);
        //b
        System.out.println("Max Wage: " + tmpWageMax.get().wage);
        System.out.println();

        //c
        System.out.println("Sorted Ages which are MORE than (50) and who has a cat:\n\nAge\tName\tCat\n");
        for (int i = 0;i<tmpAgeSort.size();i++)
        {
            System.out.println(tmpAgeSort.get(i).age + "\t"+ tmpAgeSort.get(i).name
                    + "\t" + tmpAgeSort.get(i).catName + "\t\t");
        }
        System.out.println();

        //d
        System.out.println("Sorted Ages which are LESS than (50) and who has a cat:" +
                "\n\nAge\tName\tCat\n");
        for (int i = 0;i<tmpAgeSortReverse.size();i++)
        {
            System.out.println(tmpAgeSortReverse.get(i).age + "\t"+ tmpAgeSortReverse.get(i).name
                    + "\t" + tmpAgeSortReverse.get(i).catName + "\t\t");
        }
        System.out.println();

        //e
        System.out.println("Selection by department and increase in premium:" +
                "\n\nDep\t\tName\tmeritPay\tmeritPayX2\n");
        for (int i = 0;i<sampleByDep.size();i++)
        {
            System.out.println(sampleByDep.get(i).departmentName + "\t"+ sampleByDep.get(i).name
                    + "\t" + sampleByDep.get(i).meritPay + "\t\t" + sampleByDep.get(i).meritPay * 2 + "\t\t");
        }
        System.out.println();

        //f
        System.out.println("Работники с суммой зарплаты и премии больше или равно 170 000:" +
                "\n\nName\tSum wage and meritPay\tComment\n");
        for (int i = 0;i<bestWorker.size();i++)
        {
            if(bestWorker.get(i).getBestWorker() >= 170000)
            {
                System.out.println(bestWorker.get(i).name + "\t" +
                        bestWorker.get(i).getBestWorker()+ "\t\t\t\t\tgood" + "\t\t");
            }
            else
            {
                System.out.println(bestWorker.get(i).name + "\t" +
                        bestWorker.get(i).getBestWorker()+ "\t\t\t\t\tbad" + "\t\t");
            }
        }
        System.out.println();

        //g
        System.out.println("Number of employees in the department:" +
                "\n\n" + "Memlogy" + "\t\t"+ "JavaGDv" + "\t\t" + "CyberSp" + "\t\t" + "MainigB" + "\n");

        System.out.println(quantityEmployees + "\t\t\t" + quantityEmployees1 + "\t\t\t" +
                quantityEmployees2 + "\t\t\t" + quantityEmployees3);
    }
}
