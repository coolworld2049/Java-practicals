package com.coolworld.petdb;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Pet
{
    private static final String[] names =  {"Af", "Ac", "Ax"};
    private static final Integer[] ages =  {3,6,9};
    private static final String[] birthDates = {"04-05-2015", "06-02-2016", "10-11-2017"};
    public static ObservableList<String> namesList =  FXCollections.observableArrayList();

    private SimpleStringProperty name;
    private SimpleIntegerProperty age;
    private SimpleStringProperty birthDate;
    private ObservableList<Vaccine> vacList;

    public static ObservableList<Pet> petList = FXCollections.observableArrayList();

    //getters
    public static ObservableList<String> getNamesList()
    {
        return namesList;
    }
    public String getName()
    {
        return name.get();
    }
    public int getAge()
    {
        return age.get();
    }
    public String getBirthDate()
    {
        return birthDate.get();
    }
    public ObservableList<Vaccine> getVacList()
    {
        return vacList;
    }
    public void setVacList(ObservableList<Vaccine> vacList)
    {
        this.vacList = vacList;
    }


    public Pet(String name, int age, String birthDate, ObservableList<Vaccine> vacList)
    {
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleIntegerProperty(age);
        this.birthDate = new SimpleStringProperty(birthDate);
        this.vacList = vacList;
    }

    public static void CreatePet()
    {
        Vaccine.Vaccination();
        for (int i = 0; i < names.length; i++)
        {
            namesList.add(names[i]);
            Pet pet = new Pet(names[i], ages[i], birthDates[i], Vaccine.vaccines);
            petList.add(pet);
        }
    }
}
