package Stellaris;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Stellaris.Main.countries;
import static Stellaris.Main.stellarobjects;

/**
 * Created by jmm on 7/1/2016.
 */
public class EditorDisplay {

    private static TableView<StellarObject> table = new TableView<StellarObject>();
    private static String[] countrynames;
    private static List<StellarObject> countriesobjects = new ArrayList<>();

    public static VBox creatTable() {

        getCountries();
        getStellarObjects();

        ObservableList<String> options = FXCollections.observableArrayList(countrynames);

        Label label1 = new Label("Name:   ");

        final ComboBox<String> comboBox = new ComboBox<String>(options);
        comboBox.setMinWidth(200);
        // Handle ComboBox event.

        HBox hb = new HBox();
        hb.getChildren().addAll(label1, comboBox);
        hb.setPadding(new Insets(0, 0, 10, 0));
        hb.setAlignment(Pos.CENTER_LEFT);

        final Label label = new Label("Empire Scope");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);
        table.setPrefWidth(Double.MAX_VALUE);
        table.setPrefHeight(Double.MAX_VALUE);
        table.setMinSize(400, 400);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn idCol = new TableColumn("Id");
        idCol.setMaxWidth(450);
        idCol.setCellValueFactory(new PropertyValueFactory<StellarObject, Integer>("id"));

        TableColumn sizeCol = new TableColumn("Size");
        sizeCol.setMaxWidth(400);
        sizeCol.setCellValueFactory(new PropertyValueFactory<StellarObject, Integer>("size"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<StellarObject, String>("name"));

        TableColumn typeCol = new TableColumn("Type");
        typeCol.setCellValueFactory(new PropertyValueFactory<StellarObject, String>("objecttype"));

        TableColumn classCol = new TableColumn("Class");
        classCol.setCellValueFactory(new PropertyValueFactory<StellarObject, String>("objectclass"));

        comboBox.setOnAction((event) -> {
            table.getColumns().clear();
            String selectedCountry = comboBox.getSelectionModel().getSelectedItem();
            getSelectedCountryStellarObjects(selectedCountry);
            ObservableList<StellarObject> data = FXCollections.observableArrayList(countriesobjects);
            table.setItems(data);
            table.getColumns().addAll(idCol, sizeCol, nameCol, typeCol, classCol);
            System.out.println(table.getItems().size());
        });

        VBox vbox = new VBox();
        //vbox.setSpacing(5);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setStyle("-fx-background-color: #336699;");
        //vbox.setPrefSize(1000,500);
        vbox.getChildren().addAll(label, hb, table);

        return vbox;
    }

    private static void getCountries() {

        //get the country id index node
        List<SaveFileElement> countrieslist = new ArrayList<>();
        for (int i = 0; i < Main.sfe_arraylist.length; i++) {
            if (Main.sfe_arraylist[i].nodeparent.trim().equals("country")) {
                if (Main.sfe_arraylist[i].openorclose.equals("open")) {
                    countrieslist.add(Main.sfe_arraylist[i]);
                }
            }
        }

        countries = new Country[countrieslist.size()];

        //get all the countries' nodes
        for (int i = 0; i < countrieslist.size(); i++) {
            countries[i] = new Country();
            countries[i].setCountryNodes(countrieslist.get(i).getChildren());
        }
        countrynames = new String[countries.length];
        for (int i = 0; i < countries.length; i++) {
            countrynames[i] = countries[i].returnName();
        }

    }

    private static void getStellarObjects() {

        List<SaveFileElement> stellarobjectslist = new ArrayList<>();
        for (int i = 0; i < Main.sfe_arraylist.length; i++) {
            if (Main.sfe_arraylist[i].nodeparent.trim().equals("galactic_object")) {
                if (Main.sfe_arraylist[i].openorclose.equals("open")) {
                    stellarobjectslist.add(Main.sfe_arraylist[i]);
                }
            }
        }

        for (int i = 0; i < Main.sfe_arraylist.length; i++) {
            if (Main.sfe_arraylist[i].nodeparent.trim().equals("planet")) {
                if (Main.sfe_arraylist[i].openorclose.equals("open")) {
                    stellarobjectslist.add(Main.sfe_arraylist[i]);
                }
            }
        }

        stellarobjects = new StellarObject[stellarobjectslist.size()];

        //get all the countries' nodes
        for (int i = 0; i < stellarobjectslist.size(); i++) {
            stellarobjects[i] = new StellarObject();
            stellarobjects[i].setStellarObjectNodes(stellarobjectslist.get(i).getChildren());
        }
    }

    private static void getSelectedCountryStellarObjects(String countryname) {
        int i = 0;
        for (i = 0; i < countries.length; i++) {
            if (countries[i].returnName().equals(countryname)) {
                break;
            }
        }
//todo: split up stars and planets searches and combine them later so index function works


        String[] surveyed = countries[i].returnSurveyed();

        for (int j = 0; j < surveyed.length; j++) {
            for(int k = 0 ; k < stellarobjects.length ; k++) {
                if(stellarobjects[k].getid() == Integer.valueOf(surveyed[j].trim())) {
                    //System.out.println(k + " = " + stellarobjects[k].getid() + " | " + Integer.valueOf(surveyed[j].trim()) + " | " + countriesobjects.size());
                    countriesobjects.add(j, stellarobjects[k]);
                }
            }
        }
    }

}// end class




