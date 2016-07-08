package Stellaris;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

import static Stellaris.Main.countries;
import static Stellaris.Main.stellarobjects;

/**
 * Created by jmm on 7/1/2016.
 */
public class EditorDisplay {

    private static TableView table = new TableView();
    private static String[] countrynames;

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

        TableColumn nameCol = new TableColumn("Name");
        TableColumn habitabilityCol = new TableColumn("Habitability");
        TableColumn sizeCol = new TableColumn("Size");

        table.getColumns().addAll(nameCol, habitabilityCol, sizeCol);

        comboBox.setOnAction((event) -> {
            String selectedCountry = comboBox.getSelectionModel().getSelectedItem();
            getSelectedCountryStellarObjects(selectedCountry);
            //            final ObservableList<Person> data = FXCollections.observableArrayList(
//                    new Person("Jacob", "Smith", "jacob.smith@example.com"),
//                    new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
//                    new Person("Ethan", "Williams", "ethan.williams@example.com"),
//                    new Person("Emma", "Jones", "emma.jones@example.com"),
//                    new Person("Michael", "Brown", "michael.brown@example.com")
//            );

//            List<Country> surveyednode = Main.countries.parallelStream()
//                    .filter(p ->
//                            p.getName().equals(selectedCountry)
//                    )
//                    .collect(Collectors.toList());
//            if(surveyednode.size() > 0) {
//                Utilities.printArray(surveyednode.get(0).getSurveyed());
//            }
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
            //System.out.println(i + " | " + countries.get(i).toString());
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

        stellarobjects = new StellarObject[stellarobjectslist.size()];

        //get all the countries' nodes
        for (int i = 0; i < stellarobjectslist.size(); i++) {
            stellarobjects[i] = new StellarObject();
            stellarobjects[i].setStellarObjectNodes(stellarobjectslist.get(i).getChildren());
            //System.out.println(i + " | " + stellarobjects.get(i).toString());
        }

    }

    private static void getSelectedCountryStellarObjects(String countryname) {
        int i = 0;
        for (i = 0; i < countries.length; i++) {
            if (countries[i].returnName().equals(countryname)) {
                break;
            }
        }
        List<StellarObject> countriesobjects = new ArrayList<>();
        String[] surveyed = countries[i].returnSurveyed();
        for (int j = 0; j < surveyed.length; j++) {
            //countriesobjects.get(j) = new StellarObject();
            countriesobjects.add(j,stellarobjects[j]);
            System.out.println(countriesobjects.toString());
        }

        System.out.println(countriesobjects.toString());
    }

}// end class




