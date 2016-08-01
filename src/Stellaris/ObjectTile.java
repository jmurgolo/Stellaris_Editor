package Stellaris;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.math.BigInteger;
import java.util.Arrays;

import static Stellaris.Utilities.addArrayCapacity;

/**
 * Created by jmm on 7/16/2016.
 */
public class ObjectTile {

    private StringProperty id = new SimpleStringProperty();
    private StringProperty planetid = new SimpleStringProperty();
    private StringProperty globaltileidbase = new SimpleStringProperty();
    private StringProperty globaltileidbyplanet = new SimpleStringProperty();
    private StringProperty globaltileidtotal = new SimpleStringProperty();
    private StringProperty active = new SimpleStringProperty();
    private StringProperty blocker = new SimpleStringProperty();
    private StringProperty deposit = new SimpleStringProperty();
    private StringProperty pop = new SimpleStringProperty();
    private StringProperty building = new SimpleStringProperty();
    private StringProperty prevbuilding = new SimpleStringProperty();
    private LongProperty tilebasevalue = new SimpleLongProperty();

    private StringProperty[] resourcetype = new StringProperty[0];
    private StringProperty[] resourcequantity = new StringProperty[0];

    private SaveFileElement[] objectnodes;

    public ObjectTile(){
        setid                   ("");
        setplanetid             ("");
        setglobaltileidbase     ("");
        setglobaltileidbyplanet ("");
        setglobaltileidtotal    ("");
        setactive               ("");
        setblocker              ("");
        setdeposit              ("");
        setpop                  ("");
        setbuilding             ("");
        setprevbuilding         ("");
    }

    public String getid(){
        return id.get();
    }
    public void setid(String s){ id.set(s); }
    public StringProperty idProperty() { return id; }

    public String getplanetid(){
        return planetid.get();
    }
    public void setplanetid(String s){ planetid.set(s); }
    public StringProperty planetidProperty() { return planetid; }

    public String getglobaltileidbase(){
        return globaltileidbase.get();
    }
    public void setglobaltileidbase(String s){ globaltileidbase.set(s); }
    public StringProperty globaltileidbaseProperty() { return globaltileidbase; }

    public String getglobaltileidbyplanet(){
        return globaltileidbyplanet.get();
    }
    public void setglobaltileidbyplanet(String s){ globaltileidbyplanet.set(s); }
    public StringProperty globaltileidbyplanetProperty() { return globaltileidbyplanet; }

    public String getglobaltileidtotal(){
        return globaltileidtotal.get();
    }
    public void setglobaltileidtotal(String s){ globaltileidtotal.set(s); }
    public StringProperty globaltileidtotalProperty() { return globaltileidtotal; }

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

    public void setresourcequantity(String s, int index){ resourcequantity[index].set(s); }
    public StringProperty[] resourcequantityProperty() { return resourcequantity; }
    public String getresourcequantity(int index){
        if(resourcequantity.length <= index) {
            return null;
        }else {
            return resourcequantity[index].get();
        }
    }

    public void setresourcetype(String s, int index){ resourcetype[index].set(s); }
    public StringProperty[] resourcetypeProperty() { return resourcetype; }
    public String getresourcetype(int index) {
        if (resourcetype.length <= index) {
            return null;
        } else {
            return resourcetype[index].get();
        }
    }

    public void settilebasevalues(Long s){tilebasevalue.set(s);}
    public LongProperty tilebasevaluesProperty() { return tilebasevalue; }
    public Long gettilebasevalues() {return tilebasevalue.get();}

    public void setTileObjectNode(SaveFileElement[] list, String vplanetid) {
        objectnodes = list;
        setplanetid(vplanetid);
        findId();
        findDeposit();
        findResources();
        findglobaltileidbase();
        findglobaltileidtotal();
        initiateBaseTileValue();
    }

    private void initiateBaseTileValue(){
        Long stepL = 0L;
        Long baseL = 0L;
        Long totalL = 0L;
        BigInteger bi = new BigInteger("0",16);
        Long ll = 0L;

        if(getid().equals("0")){
            setglobaltileidtotal(getplanetid());
        } else {
            baseL = (Integer.parseInt(getid()) % 5) * 1000000000000L;
            stepL = (Integer.parseInt(getid()) / 5) * 100000000L;
            totalL = baseL + stepL;
            Long ss = Long.parseLong(totalL.toString(),16);
            setglobaltileidtotal(String.valueOf(ss + Long.parseLong(getplanetid())));
            //System.out.println(getplanetid() + " | " + getid() + " | " +  (ss + Long.parseLong(getplanetid())) + " | " + getglobaltileidtotal());
        }
    }

    public SaveFileElement[] getTileObjectNode() {
        return objectnodes;
    }

    private String findglobaltileidbase(){
        String temp = "";
        return temp;
    }

    private String findglobaltileidtotal(){
        String temp = "";
        return temp;
    }

    private void findId() {

        String temp = "";
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
                temp = objectnodes[counter].getNodeName().trim().replace("=", "");
            }
            setid(temp);
        } else {
            System.out.println("no id: " + this.toString());
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

    @Override
    public String toString() {
        return  "id" + " = " + getid() + " | "
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
