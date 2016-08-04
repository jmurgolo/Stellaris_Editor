package Stellaris;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Created by jmm on 8/2/2016.
 */
public class ObjectPopulation {

    private StringProperty species_index = new SimpleStringProperty();
    private StringProperty growth_state = new SimpleStringProperty();
    private StringProperty tile = new SimpleStringProperty();
    private StringProperty pop_faction = new SimpleStringProperty();
    private StringProperty planet_id = new SimpleStringProperty();
    private StringProperty planet_tile_id = new SimpleStringProperty();

    private StringProperty[] ethos;

    public SaveFileElement[] objectnodes;

    public String getspecies_index() {
        return species_index.get();
    }
    public void setspecies_index(String i) {
        species_index.set(i);
    }
    public StringProperty species_indexProperty() {
        return species_index;
    }

    public String gettile() {
        return tile.get();
    }
    public void settile(String i) {
        tile.set(i);
    }
    public StringProperty tileProperty() {
        return tile;
    }

    public String getplanet_id() {
        return planet_id.get();
    }
    public void setplanet_id(String i) {
        planet_id.set(i);
    }
    public StringProperty planet_idProperty() {
        return planet_id;
    }

    public String getplanet_tile_id() {
        return planet_tile_id.get();
    }
    public void setplanet_tile_id(String i) {
        planet_tile_id.set(i);
    }
    public StringProperty planet_tile_idProperty() {
        return planet_tile_id;
    }

    public void setStellarObjectNodes(SaveFileElement[] list) {

        objectnodes = list;
        findspecies_index();
        findTile();
        findPlanetInfo();
        //System.out.println(this.toString()); //Arrays.toString(this.objectnodes));

    }

    private void findspecies_index() {

        String temp = "";
        int counter = 0;
        if (objectnodes.length > counter) {
            while (!(objectnodes[counter].openorclose.equals("open") && objectnodes[counter].nodelevel == 2 && objectnodes[counter].nodeparent.trim().equals("pop"))) {
                if (objectnodes.length - 1 == counter) {
                    //Utilities.print("break");
                    break;
                }
                counter++;
            }
            if (objectnodes[counter].openorclose.equals("open") && objectnodes[counter].nodelevel == 2 && objectnodes[counter].nodeparent.trim().equals("pop")) {
                temp = objectnodes[counter].getNodeName().trim().replace("=", "");
            }
            setspecies_index(temp);
        } else {
            System.out.println("no id: " + this.toString());
        }
    }

    private void findTile(){
        String temp = "";
        int counter = 0;

        try {
            while (!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("tile"))) {
                if (objectnodes.length - 1 == counter) {
                    Utilities.print("break");
                    break;
                }
                counter++;
            }
            if (objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("tile")) {
                temp = objectnodes[counter].getNodeValue().trim();
            }
            settile(temp);
        } catch (Exception e) {
            System.out.println("Error: ObjectPopulation 1: " + this.toString());
            e.printStackTrace();
        }
    }

    private void findPlanetInfo(){
        if(gettile().length() <= 4){
            setplanet_id(gettile());
            setplanet_tile_id("0");
        }else {
            Long stepL = 0L;
            String stepH = "";
            stepL = Long.valueOf(gettile().replaceAll("\"", "").replaceAll("=", ""));
            stepH = Long.toHexString(stepL);
            stepH = stepH.replace(stepH.substring(stepH.length() - 4, stepH.length()), "0000");

            char primarytileid = gettile().charAt(0);
            Long baseL = 0L;
            String baseH = "";

            char primarytileid = gettile().charAt(0);

            System.out.println(gettile().replaceAll("\"", "").replaceAll("=", "") + " | " + stepH);
        }
//        Long stepL = 0L;
//        Long baseL = 0L;
//        Long totalL = 0L;
//        baseL = (Integer.parseInt(getid()) % 5) * 1000000000000L;
//        stepL = (Integer.parseInt(getid()) / 5) * 100000000L;
//        totalL = baseL + stepL;
//
//        Long ss = Long.parseLong(totalL.toString(), 16);
//        setglobaltileidtotal(String.valueOf(ss + Long.parseLong(getplanetid())));

    }

    @Override
    public String toString() {
        return "species_index" + " = " + getspecies_index() + " \t | "
                + "tile" + " =  " + gettile() + " \t | "
                //+ "objectnodes = " + Arrays.toString(objectnodes)
                + "\r\n";
    }
}


//pop={
//        0={
//        species_index=0
//        growth_state=1
//        ethos={
//        ethic="ethic_fanatic_individualist"
//        ethic="ethic_fanatic_xenophile"
//        ethic="ethic_pacifist"
//        ethic="ethic_fanatic_materialist"
//        }
//        tile=562962838323203		pop_faction=0
//        required_growth={
//        type=food_surplus
//        value=25.000
//        }
//        }