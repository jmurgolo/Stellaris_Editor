package Stellaris;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

import static Stellaris.Main.*;

/**
 * Created by jmm on 7/1/2016.
 */
public class DisplayEditor {

    private static final TableView<ObjectPlanet> table = new TableView<>();
    private static String[] countrynames;
    private static final List<ObjectPlanet> countriesobjects = new ArrayList<>();

    public static BorderPane creatTable() {

        getCountries();
        getSpecies();
        getPlanets();

        //must come last
        getPops();

        for(int i = 0 ; i < planetarray.length ; i++){
            planetarray[i].findpopsstringprop();
        }

        ObservableList<String> options = FXCollections.observableArrayList(countrynames);

        Label label1 = new Label("Name:   ");

        final ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.setMinWidth(200);
        // Handle ComboBox event.

        HBox hb = new HBox();
        hb.getChildren().addAll(label1, comboBox);
        hb.setPadding(new Insets(0, 0, 10, 0));
        hb.setAlignment(Pos.CENTER_LEFT);

        final Label label = new Label("Empire Scope");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //table.getSelectionModel().setCellSelectionEnabled( true );
        table.getSelectionModel().setSelectionMode( SelectionMode.MULTIPLE );
        UtilitiesTable.installCopyPasteHandler(table);

        TableColumn idCol = new TableColumn("Id");
        idCol.setMaxWidth(450);
        idCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, Integer>("idnumber"));

        TableColumn sizeCol = new TableColumn("Size");
        sizeCol.setMaxWidth(400);
        sizeCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, Integer>("size"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("objectname"));

        TableColumn classCol = new TableColumn("Class");
        classCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("objectclass"));

//        TableColumn restileCol = new TableColumn("Orbital Resource Tile");
//        restileCol.setEditable(true);
//        restileCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, Long>("orbitaldeposittileinteger"));

        TableColumn ownerCol = new TableColumn("Owner");
        ownerCol.setEditable(true);
        ownerCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("ownername"));

        TableColumn controllerCol = new TableColumn("Controller");
        controllerCol.setEditable(true);
        controllerCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("controllerName"));

        TableColumn resonetileCol = new TableColumn("Res 1");
        resonetileCol.setEditable(true);
        resonetileCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, Long>("orbitaldeposittiletypeone"));

        TableColumn resvalonetileCol = new TableColumn("Res 1");
        resvalonetileCol.setEditable(true);
        resvalonetileCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, Long>("orbitaldeposittilevalueone"));

        TableColumn restwotileCol = new TableColumn("Res 2");
        restwotileCol.setEditable(true);
        restwotileCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, Long>("orbitaldeposittiletypetwo"));

        TableColumn resvaltwotileCol = new TableColumn("Res 2");
        resvaltwotileCol.setEditable(true);
        resvaltwotileCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("orbitaldeposittilevaluetwo"));

        TableColumn resthreetileCol = new TableColumn("Res 3");
        resthreetileCol.setEditable(true);
        resthreetileCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("orbitaldeposittiletypethree"));

        TableColumn resvalthreetileCol = new TableColumn("Res 3");
        resvalthreetileCol.setEditable(true);
        resvalthreetileCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("orbitaldeposittilevaluethree"));

        TableColumn popsstringpropCol = new TableColumn("Pops");
        popsstringpropCol.setEditable(true);
        popsstringpropCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("popsnamesstringprop"));

        TableColumn foodsstringpropCol = new TableColumn("Food");
        foodsstringpropCol.setEditable(true);
        foodsstringpropCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("foodvalue"));

        TableColumn energystringpropCol = new TableColumn("Energy");
        energystringpropCol.setEditable(true);
        energystringpropCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("energyvalue"));

        TableColumn mineralstringpropCol = new TableColumn("Ore");
        mineralstringpropCol.setEditable(true);
        mineralstringpropCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("orevalue"));

        TableColumn biostringpropCol = new TableColumn("Bio");
        biostringpropCol.setEditable(true);
        biostringpropCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("biologyvalue"));

        TableColumn engsstringpropCol = new TableColumn("Eng");
        engsstringpropCol.setEditable(true);
        engsstringpropCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("engineeringvalue"));

        TableColumn phystringpropCol = new TableColumn("Phy");
        phystringpropCol.setEditable(true);
        phystringpropCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("physicsvalue"));

        TableColumn allstringpropCol = new TableColumn("All");
        allstringpropCol.setEditable(true);
        allstringpropCol.setCellValueFactory(new PropertyValueFactory<ObjectPlanet, String>("overallcolonizationdepositvalue"));

        comboBox.setOnAction((event) -> {
            table.getColumns().clear();
            countriesobjects.clear();
            String selectedCountry = comboBox.getSelectionModel().getSelectedItem();
            getSelectedCountryStellarObjects(selectedCountry);
            ObservableList<ObjectPlanet> data = FXCollections.observableArrayList(countriesobjects);
            table.setItems(data);
            table.getColumns().addAll(idCol, sizeCol, nameCol, classCol, ownerCol, controllerCol, resonetileCol, resvalonetileCol, restwotileCol, resvaltwotileCol, resthreetileCol, resvalthreetileCol, popsstringpropCol,allstringpropCol,foodsstringpropCol,energystringpropCol,mineralstringpropCol,biostringpropCol,engsstringpropCol,phystringpropCol);
        });

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.prefWidthProperty().bind(componentLayout.prefWidthProperty());
        vbox.prefHeightProperty().bind(componentLayout.prefHeightProperty());
        table.setMinSize(400, vbox.getPrefHeight());
        BorderPane bpane = new BorderPane();
        bpane.setStyle("-fx-background-color: #336699;");
        bpane.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, hb);
        bpane.setTop(vbox);
        bpane.setCenter(table);

        return bpane;
    }

    private static void getCountries() {
        int i=0;
        try {
            //get the country id index node
            List<SaveFileElement> countrieslist = new ArrayList<>();
            for (i = 0; i < sfe_arraylist.length; i++) {
                if (sfe_arraylist[i].nodeparent.trim().equals("country")) {
                    if (sfe_arraylist[i].openorclose.equals("open")) {
                        countrieslist.add(sfe_arraylist[i]);
                    }
                }
            }

            countries = new ObjectCountry[countrieslist.size()];

            //get all the countries' nodes
            for (i = 0; i < countrieslist.size(); i++) {
                countries[i] = new ObjectCountry();
                countries[i].setCountryNodes(countrieslist.get(i).getChildren());
            }

            countrynames = new String[countries.length];
            for (i = 0; i < countries.length; i++) {
                countrynames[i] = countries[i].returnName();
            }
        }catch(Exception e){
            System.out.println("Error: DisplayEditor 1: " + sfe_arraylist[i].toString());
            e.printStackTrace();
        }
    }

    private static void getPlanets() {

        List<SaveFileElement> planetlist = new ArrayList<>();
        for (int i = 0; i < sfe_arraylist.length; i++) {
            if (sfe_arraylist[i].nodeparent.trim().equals("planet")) {
                if (sfe_arraylist[i].openorclose.equals("open")) {
                    planetlist.add(sfe_arraylist[i]);
                }
            }
        }

        planetarray = new ObjectPlanet[planetlist.size()];

        for (int i = 0; i < planetlist.size(); i++) {
            planetarray[i] = new ObjectPlanet();
            planetarray[i].setStellarObjectNodes(planetlist.get(i).getChildren());
            //System.out.println("Start ------------------- " + Arrays.toString(planetarray[i].objectnodes));
        }
    }

    private static void getPops(){
        List<SaveFileElement> poplist = new ArrayList<>();
        for (int i = 0; i < sfe_arraylist.length; i++) {
            if (sfe_arraylist[i].nodeparent.trim().equals("pop")) {
                if (sfe_arraylist[i].openorclose.equals("open")) {
                    poplist.add(sfe_arraylist[i]);
                }
            }
        }

        ObjectPopulation[] poparray = new ObjectPopulation[poplist.size()];

        for (int i = 0; i < poplist.size(); i++) {
            poparray[i] = new ObjectPopulation();
            poparray[i].setStellarObjectNodes(poplist.get(i).getChildren());
            //System.out.println("Start ------------------- " + Arrays.toString(planetarray[i].objectnodes));
        }
    }

    private static void getSelectedCountryStellarObjects(String countryname) {
        int i = 0;
        for (i = 0 ; i < countries.length; i++) {
            if (countries[i].returnName().equals(countryname)) {
                break;
            }
        }

        //todo: split up stars and planets searches and combine them later so index function works

        String[] surveyed = countries[i].returnSurveyed();
        System.out.println(surveyed.length);
        if(surveyed != null && surveyed.length > 0) {
            for (int j = 0; j < surveyed.length; j++) {
                countriesobjects.add(j, planetarray[Integer.valueOf(surveyed[j].trim())]);
            }
        }
    }

    private static void getSpecies() {
        List<SaveFileElement> specieslist = new ArrayList<>();
        for (int i = 0; i < sfe_arraylist.length; i++) {
            if (sfe_arraylist[i].nodeparent.trim().equals("species")) {
                if (sfe_arraylist[i].openorclose.equals("open")) {
                    specieslist.add(sfe_arraylist[i]);
                }
            }
        }

        speciesarray = new ObjectSpecies[specieslist.size()];

        for (int i = 0; i < specieslist.size(); i++) {
            speciesarray[i] = new ObjectSpecies();
            speciesarray[i].setSpeciesObjectNode(specieslist.get(i).getChildren(),i);
            //System.out.println("Start ------------------- " + Arrays.toString(speciesarray[i].getObjectnodes()));
        }
    }

}// end class


//    private static void getStars() {
//
//        List<SaveFileElement> starlist = new ArrayList<>();
//        for (int i = 0; i < sfe_arraylist.length; i++) {
//            if (sfe_arraylist[i].nodeparent.trim().equals("galactic_object")) {
//                if (sfe_arraylist[i].openorclose.equals("open")) {
//                    starlist.add(sfe_arraylist[i]);
//                }
//            }
//        }
//
//        stararray = new ObjectStar[starlist.size()];
//
//        //get all the stars' nodes
//        for (int i = 0; i < starlist.size(); i++) {
//            stararray[i] = new ObjectStar();
//            stararray[i].setStellarObjectNodes(starlist.get(i).getChildren());
//        }
//    }




