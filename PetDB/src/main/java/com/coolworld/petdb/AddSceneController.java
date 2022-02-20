package com.coolworld.petdb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.lang.reflect.Field;

public class AddSceneController
{
    @FXML
    private TextField nameAdd;

    @FXML
    private TextField ageAdd;

    @FXML
    private TextField birthDateAdd;

    @FXML
    private TextField vacDateAdd;

    @FXML
    private TextField vacTypeAdd;

    @FXML
    private TextField vacNameAdd;

    @FXML
    private Button addButton;

    @FXML
    protected void AddNewPet()
    {
        if (((((
                (!nameAdd.getText().isEmpty())&&
                        (!ageAdd.getText().isEmpty())&&
                            (!birthDateAdd.getText().isEmpty()))&&
                (!vacDateAdd.getText().isEmpty()&&
                        (!vacTypeAdd.getText().isEmpty()&&
                                (!vacNameAdd.getText().isEmpty()
                )))))))
        {
            Vaccine newVac = new Vaccine(
                    Vaccine.vaccines.size()+1,
                    vacDateAdd.getText(),
                    vacTypeAdd.getText(),
                    vacNameAdd.getText());

            ObservableList<Vaccine> newVacList = FXCollections.observableArrayList(newVac);

            Pet newPet = new Pet(
                    nameAdd.getText(),
                    Integer.parseInt(ageAdd.getText()),
                    birthDateAdd.getText(),
                    newVacList);

            Pet.namesList.add(newPet.getName().toString());
            Pet.petList.add(newPet);
        }
    }

    @FXML
    protected void HideButton()
    {
        addButton.setDisable(true);
    }
}
