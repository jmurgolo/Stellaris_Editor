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

/**
 * Created by jmm on 7/1/2016.
 */
public  class  EditorDisplay {

    private static TableView table = new TableView();

    public static VBox creatTable() {

        getCountries();
        getStellarObjects();

        List<String> countryList = new ArrayList<String>(); //getCountryNames();
        ObservableList<String> options = FXCollections.observableArrayList(countryList);

        Label label1 = new Label("Name:   ");

        final ComboBox<String> comboBox = new ComboBox<String>(options);
        comboBox.setMinWidth(200);
        // Handle ComboBox event.

        HBox hb = new HBox();
        hb.getChildren().addAll(label1, comboBox);
        hb.setPadding(new Insets(0,0,10,0));
        hb.setAlignment(Pos.CENTER_LEFT);

        final Label label = new Label("Empire Scope");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);
        table.setPrefWidth(Double.MAX_VALUE);
        table.setPrefHeight(Double.MAX_VALUE);
        table.setMinSize(400,400);

        TableColumn nameCol = new TableColumn("Name");
        TableColumn habitabilityCol = new TableColumn("Habitability");
        TableColumn sizeCol = new TableColumn("Size");

        table.getColumns().addAll(nameCol, habitabilityCol, sizeCol);

        comboBox.setOnAction((event) -> {
            String selectedCountry = comboBox.getSelectionModel().getSelectedItem();

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

        //get the country id index
        List<SaveFileElement> countrieslist = new ArrayList<>();
        for(int i = 0 ; i < Main.sfe_arraylist.length ; i ++){
            if(Main.sfe_arraylist[i].nodeparent.trim().equals("country")) {
                if (Main.sfe_arraylist[i].openorclose.equals("open")) {
                    countrieslist.add(Main.sfe_arraylist[i]);
                }
            }
        }

        System.out.println(countrieslist.toString());

        //get the countries nodes
        for(int i = 0 ; i < countrieslist.size() ; i ++){
            countries.add(new Country());
            countries.get(i).setCountryNodes(countrieslist.get(i).getChildren());
            }
        //System.out.println(countries.toString());
//        }

//        List<SaveFileElement> country = new ArrayList<SaveFileElement>();
//        for (int i = 0 ; i < countriesnodes.size() ; i++) {
//            country = countriesnodes.get(i).getChildren();
//            countries.add(new Country());
//            countries.get(i).setCountry(countriesnodes.get(i).getLineNumber(),country.get(country.size()-1).getLineNumber());
//            countries.get(i).setId(countriesnodes.get(i).originalnodename);
//        }
    }

    private static void getStellarObjects() {
//        //get the country node
//        List<SaveFileElement> stellarobjectsnodes = Main.sfe_arraylist.parallelStream()
//                .filter(p -> p.nodeparent.equals("galactic_object"))
//                .filter(p -> p.openorclose.equals("open"))
//                .collect(Collectors.toList());
//
//        List<SaveFileElement> stellarobject = new ArrayList<SaveFileElement>();
//        for (int i = 0 ; i < stellarobjectsnodes.size() ; i++) {
//            System.out.println("so: " + stellarobjectsnodes.get(i).originalnodename);
//            stellarobject = stellarobjectsnodes.get(i).getChildren();
//            Main.stellarobjects.add(new StellarObject());
////            stellarobjects.get(i).setStellarObject(stellarobjectsnodes.get(i).getLineNumber(),stellarobject.get(stellarobject.size()-1).getLineNumber());
////            stellarobjects.get(i).setId(stellarobjectsnodes.get(i).originalnodename);
//        }
    }

//    private static List<String> getCountryNames() {
//
//        List<String> countryList = new ArrayList<>();
//
//        //strip off equal sign and quotes
//        countryList.addAll(Main.countries.parallelStream().map(countries -> countries.getName()).collect(Collectors.toList()));
//        return countryList;
//    }
}


