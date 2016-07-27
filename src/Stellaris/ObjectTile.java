package Stellaris;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

import static Stellaris.Utilities.addArrayCapacity;

/**
 * Created by jmm on 7/16/2016.
 */
public class ObjectTile {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty active = new SimpleStringProperty();
    private StringProperty blocker = new SimpleStringProperty();
    private StringProperty deposit = new SimpleStringProperty();
    private StringProperty pop = new SimpleStringProperty();
    private StringProperty building = new SimpleStringProperty();
    private StringProperty prevbuilding = new SimpleStringProperty();

    private StringProperty[] resourcetype = new StringProperty[0];
    private StringProperty[] resourcequantity = new StringProperty[0];

    private StringProperty[] resources;

    private SaveFileElement[] objectnodes;

    public ObjectTile(){
        setid              (0);
        setactive          ("");
        setblocker         ("");
        setdeposit         ("");
        setpop             ("");
        setbuilding        ("");
        setprevbuilding    ("");
    }

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

    public String getresourcetype(int index){
        return resourcetype[index].get();
    }
    public void setresourcetype(String s, int index){ resourcetype[index].set(s); }
    public StringProperty[] resourcetypeProperty() { return resourcetype; }

    public String getresourcequantity(int index){
        return resourcequantity[index].get();
    }
    public void setresourcequantity(String s, int index){ resourcequantity[index].set(s); }
    public StringProperty[] resourcequantityProperty() { return resourcequantity; }

    public void setTileObjectNode(SaveFileElement[] list) {
        objectnodes = list;
        findId();
        findDeposit();
        findResources();
    }

    public SaveFileElement[] getTileObjectNode() {
        return objectnodes;
    }

    private void findId() {

        Integer temp = 0;
        int counter = 0;
        if(objectnodes.length > counter){
            while (!(objectnodes[counter].openorclose.equals("open") && objectnodes[counter].nodelevel == 4 && objectnodes[counter].nodeparent.trim().equals("tiles"))) {
                if (objectnodes.length - 1 == counter) {
                    //Utilities.print("break");
                    break;
                }
                counter++;
            }
            if (objectnodes[counter].openorclose.equals("open") && objectnodes[counter].nodelevel == 4 && objectnodes[counter].nodeparent.trim().equals("tiles")) {
                temp = Integer.valueOf(objectnodes[counter].getNodeName().trim().replace("=", ""));
            }
            setid(temp);
        } else {
            //System.out.println(this.toString());
        }
    }

    private void findDeposit() {

        String temp = "";
        int counter = 0;

        if (objectnodes.length > counter) {
            while (!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 4 && objectnodes[counter].getNodeName().trim().equals("deposit"))) {
                if (objectnodes.length - 1 == counter) {
                    //Utilities.print("break");
                    break;
                }
                counter++;
            }
            if (objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 4 && objectnodes[counter].getNodeName().trim().equals("deposit")) {
                temp = objectnodes[counter].nodevalue.trim().replace("=", "");
            }
            setdeposit(temp);
        } else {
            //System.out.println(this.toString());
        }
    }

    private void findResources(){
        int counter = 0;

        if (objectnodes.length > counter) {
            while (!(objectnodes[counter].nodeparent.trim().equals("resources"))) {
                //System.out.println(objectnodes[counter].nodeparent.trim());
                if (objectnodes.length - 1 == counter) {
                    //System.out.println("break");
                    break;
                }
                counter++;
            }
            if (objectnodes[counter].nodeparent.trim().equals("resources")) {
                //System.out.println(objectnodes[counter].nodeparent.trim());
                for(int i = 0 ; (i+counter) < objectnodes.length ; i++) {
                    resourcetype = addArrayCapacity(resourcetype,1);
                    resourcetype[i] = new SimpleStringProperty();
                    resourcetype[i].set(objectnodes[counter].nodename.trim().replace("=", "").replace("{", "").replace("}", ""));
                    resourcequantity = addArrayCapacity(resourcequantity,1);
                    resourcequantity[i] = new SimpleStringProperty();
                    if(objectnodes[counter].nodevalue.trim().replace("=", "").replace("{", "").replace("}", "").split(" ").length > 1){
                        resourcequantity[i].set(objectnodes[counter].nodevalue.trim().replace("=", "").replace("{", "").replace("}", "").split(" ")[1]);
                    }else{
                        resourcequantity[i].set(objectnodes[counter].nodevalue.trim().replace("=", "").replace("{", "").replace("}", ""));
                    }
                    //System.out.println(getresourcetype(i) + " | " + getresourcequantity(i));
                    counter++;
                    if(objectnodes[counter].nodeparent.trim().equals("resources") && objectnodes[counter].openorclose.equals("close")){
                        break;
                    }
                }
            }
        } else {
            System.out.println(this.toString());
        }
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
                + "resourcetype" + " =  " + Arrays.toString(resourcetype) + " | "
                + "resourcequantity" + " =  " + Arrays.toString(resourcequantity) + " | "
                //+ "objectnodes" + " =  " + Arrays.toString(objectnodes) + " | "
                + "\r\n";
    }
}
