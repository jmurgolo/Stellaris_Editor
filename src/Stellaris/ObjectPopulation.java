package Stellaris;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static Stellaris.Main.planetarray;


//todo: change species index to species name or figure out why index is sequential.

/**
 * Created by jmm on 8/2/2016.
 */
public class ObjectPopulation {

    private StringProperty species_index = new SimpleStringProperty();
    private StringProperty species_name = new SimpleStringProperty();
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
        setTilePop();
        //System.out.println(this.toString()); //Arrays.toString(this.objectnodes));

    }

    private void findspecies_index() {

        String temp = "";
        int counter = 0;
        if (objectnodes.length > counter) {
            while (!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && objectnodes[counter].getNodeName().trim().equals("species_index"))) {
                if (objectnodes.length - 1 == counter) {
                    //Utilities.print("break");
                    break;
                }
                counter++;
            }
            if (objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && objectnodes[counter].getNodeName().trim().equals("species_index")) {
                temp = objectnodes[counter].getNodeValue().trim().replace("=", "");
            }
            setspecies_index(temp);
        } else {
            System.out.println("no id: " + this.toString());
        }
    }

    private void findTile() {
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

    private void findPlanetInfo() {
        /*
            Tiles ids are created using hex.  The initial value is tileid mod 5 + tileid/5 + planet id.
            So 0 tile is 0mod5 + 0/5(no remainder) + planet id for tile = planet id!
            Then hex 1000000000000 with a value of 281474976710656‬ + the tile id of 1/5 (no remainder) + planet id.
            Moving to, say, 7 we would have 7mod5 (2 = ‭2000000000000‬(hex) = ‭562949953421312(dec)‬) + 7/5 (‭1 =
            100000000‬(hex) = ‭4294967296‬(dec)) = ‭2000100000000‬(hex) = ‭562954248388608‬(dec) + planetid.
        */
        if (gettile().replaceAll("\"", "").replaceAll("=", "").trim().length() <= 4) {
            setplanet_id(gettile());
            setplanet_tile_id("0");
        } else {
            Long stepL = 0L;
            String stepH = "";
            String planetid = "";
            stepL = Long.valueOf(gettile().replaceAll("\"", "").replaceAll("=", ""));
            stepH = Long.toHexString(stepL);
            planetid = stepH.substring(stepH.length() - 4, stepH.length());
            stepH = stepH.replace(stepH.substring(stepH.length() - 4, stepH.length()), "0000");

            char primarytileid = stepH.charAt(0);
            char secondarytileid = stepH.charAt(4);

            setplanet_id(Long.valueOf(planetid, 16).toString());
            setplanet_tile_id(String.valueOf(Character.getNumericValue(primarytileid) + (5 * Character.getNumericValue(secondarytileid))));
            //System.out.println(getplanet_id() + " | " + getplanet_tile_id() + " | " + primarytileid + " | " + secondarytileid);
            //System.out.println(gettile().replaceAll("\"", "").replaceAll("=", "") + " | " + stepH);
        }
    }

    private void setTilePop() {
        planetarray[Integer.parseInt(getplanet_id().replaceAll("\"", "").replaceAll("=", ""))]
                .planettiles[Integer.parseInt(getplanet_tile_id().replaceAll("\"", "").replaceAll("=", ""))].setpop(getspecies_index());

//        System.out.println(Integer.parseInt(getplanet_id().replaceAll("\"", "").replaceAll("=", "")) + " | " + Integer.parseInt(getplanet_tile_id().replaceAll("\"", "").replaceAll("=", "")) + " | " + getspecies_index());

        //System.out.println(Integer.parseInt(getplanet_id().replaceAll("\"", "").replaceAll("=", "")) + " | " + Integer.parseInt(getplanet_tile_id().replaceAll("\"", "").replaceAll("=", "")) + " | " + getspecies_index());

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