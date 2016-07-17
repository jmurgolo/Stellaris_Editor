package Stellaris;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Created by jmm on 7/16/2016.
 */
public class Tile {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty active = new SimpleStringProperty();
    private StringProperty blocker = new SimpleStringProperty();
    private StringProperty deposit = new SimpleStringProperty();
    private StringProperty pop = new SimpleStringProperty();
    private StringProperty building = new SimpleStringProperty();
    private StringProperty prevbuilding = new SimpleStringProperty();

    private StringProperty[] resources;

    private SaveFileElement[] objectnodes;

    public Integer getid(){
        return id.get();
    }
    public void setid(Integer s){ id.set(s); }
    public IntegerProperty idProperty() { return id; }

    public String getactive(){
        return active.get();
    }
    public void setactive(String s){ active.set(s); }
    public StringProperty activeProperty() { return active; }

    public String getblocker(){
        return blocker.get();
    }
    public void setblocker(String s){ blocker.set(s); }
    public StringProperty blockerProperty() { return blocker; }

    public String getdeposit(){
        return deposit.get();
    }
    public void setdeposit(String s){ deposit.set(s); }
    public StringProperty depositProperty() { return deposit; }

    public String getpop(){
        return pop.get();
    }
    public void setpop(String s){ pop.set(s); }
    public StringProperty popProperty() { return pop; }

    public String getbuilding(){
        return building.get();
    }
    public void setbuilding(String s){ building.set(s); }
    public StringProperty buildingProperty() { return building; }

    public String getprevbuilding(){
        return prevbuilding.get();
    }
    public void setprevbuilding(String s){ prevbuilding.set(s); }
    public StringProperty prevbuildingProperty() { return prevbuilding; }

    public void setTileObjectNode(SaveFileElement[] list) {
        objectnodes = list;
        findId();
        findDeposit();
    }

    private void findId() {

        Integer temp = 0;
        int counter = 0;

        while (!(objectnodes[counter].openorclose.equals("open") && objectnodes[counter].nodelevel == 4 && objectnodes[counter].nodeparent.trim().equals("tiles"))) {
            if (objectnodes.length - 1 == counter) {
                //Utilities.print("break");
                break;
            }
            counter++;
        }
        if (objectnodes[counter].openorclose.equals("open") && objectnodes[counter].nodelevel == 4 && objectnodes[counter].nodeparent.trim().equals("tiles")) {
            temp = Integer.valueOf(objectnodes[counter].getNodeName().trim().replace("=",""));
        }
        setid(temp);
    }

    private void findDeposit() {

        String temp = "";
        int counter = 0;

        while (!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 4 && objectnodes[counter].getNodeName().trim().equals("deposit"))) {
            if (objectnodes.length - 1 == counter) {
                //Utilities.print("break");
                break;
            }
            counter++;
        }
        if (objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 4 && objectnodes[counter].getNodeName().trim().equals("deposit")) {
            temp = objectnodes[counter].nodevalue.trim().replace("=","");
        }
        setdeposit(temp);
    }

    public String toString() {
        return "\r\n" +
                "id" + " = " + getid() + " | "
                + "active" + " =  " + getactive() + " | "
                + "blocker" + " =  " + getblocker() + " | "
                + "deposit" + " =  " + getdeposit() + " | "
                + "pop" + " =  " + getpop() + " | "
                + "building" + " =  " + getbuilding() + " | "
                + "prevbuilding" + " =  " + getprevbuilding() + " | "
                //+ "objectnodes" + " =  " + Arrays.toString(objectnodes) + " | "
                //+ "pop" + " =  " + pop + " | "
                + "\r\n";
    }
}
