package com.coolworld.petdb;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.concurrent.ThreadLocalRandom;

public class Vaccine
{
    private static final String[] vacDates = {"04-05-2020","06-02-2021","10-11-2022",
            "10-11-2017", "10-11-2018","10-11-2023"};
    private static final String[] vacTypes = {"1", "2", "3","4","5","6"};
    private static final String[] vacNames ={"A", "B", "C","D","E","F","G"};

    private SimpleIntegerProperty vacId;
    private SimpleStringProperty vacDate;
    private SimpleStringProperty  vacType;

    private SimpleStringProperty  vacName;

    public static ObservableList<Vaccine> vaccines = FXCollections.observableArrayList();

    //getters
    public int getVacId()
    {
        return vacId.get();
    }
    public String getVacDate()
    {
        return vacDate.get();
    }
    public String getVacType()
    {
        return vacType.get();
    }
    public String getVacName()
    {
        return vacName.get();
    }

    //setters
    public void setVacId(int vacId)
    {
        this.vacId.set(vacId);
    }
    public void setVacDate(String vacDate)
    {
        this.vacDate.set(vacDate);
    }
    public void setVacType(String vacType)
    {
        this.vacType.set(vacType);
    }
    public void setVacName(String vacName)
    {
        this.vacName.set(vacName);
    }

    public Vaccine(int vacId, String vacDate, String vacType, String vacName)
    {
        this.vacId = new SimpleIntegerProperty(vacId);
        this.vacDate = new SimpleStringProperty(vacDate);
        this.vacType = new SimpleStringProperty(vacType);
        this.vacName = new SimpleStringProperty(vacName);
    }

    public static void Vaccination()
    {
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(1,vacDates.length); i++)
        {
            Vaccine vaccine = new Vaccine(
                    i+1,
                    vacDates[ThreadLocalRandom.current().nextInt(0,vacDates.length)],
                    vacTypes[ThreadLocalRandom.current().nextInt(0,vacTypes.length)],
                    vacNames[ThreadLocalRandom.current().nextInt(0,vacNames.length)]);
            vaccines.add(vaccine);
        }
    }
}
