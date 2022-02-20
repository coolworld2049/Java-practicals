package com.coolworld.petdb;



import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller
{
    @FXML
    private TextField name;

    @FXML
    private TextField age;

    @FXML
    private TextField birthDate;

    @FXML
    private ListView<String> listView;

    @FXML
    private int listViewModelIndex;

    @FXML
    protected void PetListHandler()
    {
        Pet.CreatePet();
        listView.setItems(Pet.namesList);

        listView.setCellFactory(lv -> {

            ListCell<String> cell = new ListCell<>();

            ContextMenu contextMenu = new ContextMenu();
            MenuItem editItem = new MenuItem();
            editItem.textProperty().bind(Bindings.format("Open Vac table \"%s\"", cell.itemProperty()));
            editItem.setOnAction(event -> {
                //String item = cell.getItem();
                listViewModelIndex = cell.getListView().getSelectionModel().getSelectedIndex();
                tableVac.getItems().clear();
                tableVac.refresh();
                FillTable();
            });
            MenuItem deleteItem = new MenuItem();
            deleteItem.textProperty().bind(Bindings.format("Delete \"%s\"", cell.itemProperty()));
            deleteItem.setOnAction(event -> listView.getItems().remove(cell.getItem()));
            contextMenu.getItems().addAll(editItem, deleteItem);

            cell.textProperty().bind(cell.itemProperty());

            cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                if (isNowEmpty) {
                    cell.setContextMenu(null);
                } else {
                    cell.setContextMenu(contextMenu);
                }
            });
            return cell ;
        });
    }

    @FXML
    private Button showPets;

    @FXML
    protected void HideButton()
    {
        if (!showPets.isDisabled())
        {
            showPets.setDisable(true);
        }
    }


    @FXML
    protected void ShowPetList()
    {
        listView.getSelectionModel().selectionModeProperty().set(SelectionMode.SINGLE);
        //int selectedModelIndex = listView.getSelectionModel().getSelectedIndex();
        if (listView.getItems().size() != 0)
        {
            name.setText(Pet.petList.get(listViewModelIndex).getName().toString());
            age.setText(String.valueOf(Pet.petList.get(listViewModelIndex).getAge()));
            birthDate.setText(Pet.petList.get(listViewModelIndex).getBirthDate().toString());
        }
    }

    @FXML
    private TableView<Vaccine> tableVac;

    @FXML
    private TableColumn<Vaccine, String> idColumn;

    @FXML
    private TableColumn<Vaccine, String> dateColumn;

    @FXML
    private TableColumn<Vaccine, String> typeColumn;

    @FXML
    private TableColumn<Vaccine, String> nameColumn;


    @FXML
    protected void FillTable()
    {
        //определяем фабрику для столбца с привязкой к свойству
        idColumn.setCellValueFactory(new PropertyValueFactory<>("vacId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("vacDate"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("vacType"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("vacName"));

        dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        dateColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Vaccine, String> t) ->
                        (t.getTableView().getItems().get(t.getTablePosition().getRow()))
                                .setVacDate(t.getNewValue()));
        typeColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Vaccine, String> t) ->
                        (t.getTableView().getItems().get(t.getTablePosition().getRow()))
                                .setVacType(t.getNewValue()));
        nameColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Vaccine, String> t) ->
                        (t.getTableView().getItems().get(t.getTablePosition().getRow()))
                                .setVacName(t.getNewValue()));

        tableVac.getItems().setAll(Pet.petList.get(listViewModelIndex).getVacList());
    }

    @FXML
    private Button openAddScene;

    @FXML
    protected void OpenAddScene()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("AddScene.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Pet");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e)
        {
            e.getStackTrace();
        }
    }

    @FXML
    protected void DeletePet()
    {
        int itemId = listView.getSelectionModel().getSelectedIndex();
        if (itemId >= 0)
        {
            Pet.petList.remove(itemId);
            Pet.namesList.remove(itemId);
        }
    }

    @FXML
    protected void EditTable()
    {

    }

    @FXML
    private TextField vacDateAdd;

    @FXML
    private TextField vacTypeAdd;

    @FXML
    private TextField vacNameAdd;

    @FXML
    protected void AddNewVac()
    {
        if (((!vacDateAdd.getText().isEmpty()) &&
                (!vacTypeAdd.getText().isEmpty()) &&
                (!vacNameAdd.getText().isEmpty())) &&
                (showPets.isDisable()))
        {
            Vaccine newVac = new Vaccine(
                    Vaccine.vaccines.size() + 1,
                    vacDateAdd.getText(),
                    vacTypeAdd.getText(),
                    vacNameAdd.getText());

            Pet.petList.get(listViewModelIndex).getVacList().add(newVac);

            vacDateAdd.clear();
            vacTypeAdd.clear();
            vacNameAdd.clear();

            FillTable();
        }
    }
}
