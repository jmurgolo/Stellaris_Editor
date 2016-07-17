package Stellaris;

import javafx.beans.property.*;

import java.util.Arrays;

/**
 * Created by jmm on 6/25/2016.
 */
public class Planet {

    private IntegerProperty id = new SimpleIntegerProperty();
    private IntegerProperty size = new SimpleIntegerProperty();
    private IntegerProperty orbitaldeposittile = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty objectclass = new SimpleStringProperty();
    private StringProperty objecttype = new SimpleStringProperty();
    private StringProperty owner = new SimpleStringProperty();
    private StringProperty controller = new SimpleStringProperty();
    private StringProperty pop = new SimpleStringProperty();
    private StringProperty orbitals = new SimpleStringProperty();
    private StringProperty entity = new SimpleStringProperty();
    private StringProperty prevent_anomaly = new SimpleStringProperty();
    private StringProperty spaceport = new SimpleStringProperty();

    private SaveFileElement[] objectnodes;
    private Tile[] planettiles;

    public Integer getid(){ return id.get(); }
    public void setid(Integer i){ id.set(i); }
    public IntegerProperty idProperty() { return id; }

    public Integer getsize(){ return size.get(); }
    public void setsize(Integer i){ size.set(i); }
    public IntegerProperty sizeProperty() { return size; }

    public String getname(){
        return name.get();
    }
    public void setname(String s){ name.set(s); }
    public StringProperty nameProperty() { return name; }

    public String getobjectclass(){
        return objectclass.get();
    }
    public void setobjectclass(String s){ objectclass.set(s); }
    public StringProperty objectclassProperty() { return objectclass; }

    public String getobjecttype(){ return objecttype.get(); }
    public void setobjecttype(String s){ objecttype.set(s); }
    public StringProperty objecttypeProperty() { return objecttype; }

    public Integer getorbitaldeposittile(){ return orbitaldeposittile.get(); }
    public void setorbitaldeposittile(Integer i){ orbitaldeposittile.set(i); }
    public IntegerProperty orbitaldeposittileProperty() { return orbitaldeposittile; }

    public String getowner(){ return owner.get(); }
    public void setowner(String s){ owner.set(s); }
    public StringProperty ownerProperty() { return owner; }

    public void setStellarObjectNodes(SaveFileElement[] list) {

        objectnodes = list;
        findId();
        findSize();
        findName();
        findType();
        findObjectClass();
        findOwner();
        findOrbitalDepositTile();

    }

    private void findId() {

        Integer temp = null;
        int counter = 0;

        while (!(objectnodes[counter].openorclose.equals("open") && objectnodes[counter].nodelevel == 2) && (objectnodes[counter].nodeparent.trim().equals("galactic_object") || objectnodes[counter].nodeparent.trim().equals("planet"))) {
            if (objectnodes.length - 1 == counter) {
                Utilities.print("break");
                break;
            }
            counter++;
        }
        if (objectnodes[counter].openorclose.equals("open") && objectnodes[counter].nodelevel == 2 && (objectnodes[counter].nodeparent.trim().equals("galactic_object") || objectnodes[counter].nodeparent.trim().equals("planet"))) {
            temp = Integer.valueOf(objectnodes[counter].getNodeName().trim());
        }
        setid(temp);
    }

    private void findName() {

        String temp = "";
        int counter = 0;

        while(!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("name") && objectnodes[counter].nodelevel == 2)){
            if(objectnodes.length-1 == counter) {
                break;
            }
            counter++;
        }
        if(objectnodes.length > counter && objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("name") && objectnodes[counter].nodelevel == 2) {
            temp = objectnodes[counter].getNodeValue();
        }
        setname(temp.replaceAll("\"","").replaceAll("=",""));
    }

    private void findOwner() {

        String temp = "";
        int counter = 0;

        while(!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("owner") && objectnodes[counter].nodelevel == 2)){
            if(objectnodes.length-1 == counter) {
                break;
            }
            counter++;
        }
        if(objectnodes.length > counter && objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("owner") && objectnodes[counter].nodelevel == 2) {
            temp = objectnodes[counter].getNodeValue();
        }
        setname(temp.replaceAll("\"","").replaceAll("=",""));
    }

    private void findObjectClass() {

        String temp = "";
        int counter = 0;

        while(!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && (objectnodes[counter].nodename.trim().equals("star_class") || objectnodes[counter].nodename.trim().equals("planet_class")))){
            if(objectnodes.length-1 == counter) {
                break;
            }
            counter++;
        }
        if(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && (objectnodes[counter].nodename.trim().equals("star_class") || objectnodes[counter].nodename.trim().equals("planet_class"))) {
            temp = objectnodes[counter].getNodeValue();
        }
        setobjectclass(temp.replaceAll("\"","").replaceAll("=",""));
    }

    private void findSize() {

        Integer temp = null;
        int counter = 0;

        while(!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && objectnodes[counter].nodename.trim().equals("planet_size"))){
                        if(objectnodes.length-1 == counter) {
                break;
            }
            //System.out.println(objectnodes[counter].openorclose + " " + objectnodes[counter].nodelevel + " " + objectnodes[counter].nodename.trim());

            counter++;
        }
        if(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && objectnodes[counter].nodename.trim().equals("planet_size")) {
            temp = Integer.valueOf(objectnodes[counter].getNodeValue().trim().replace("=",""));
        }
        setsize(temp);
    }

    private void findType() {

        String temp = "";
        int counter = 0;

        while(!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && (objectnodes[counter].nodename.trim().equals("type") || objectnodes[counter].nodename.trim().equals("planet_class")))){
            if(objectnodes.length-1 == counter) {
                break;
            }
            counter++;
        }
        if(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && (objectnodes[counter].nodename.trim().equals("type") || objectnodes[counter].nodename.trim().equals("planet_class"))) {
            temp = objectnodes[counter].getNodeValue();
        }
        setobjecttype(temp.replaceAll("\"","").replaceAll("=",""));
    }

    private void findOrbitalDepositTile() {

        Integer temp = null;
        int counter = 0;

        while(!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && objectnodes[counter].nodename.trim().equals("orbital_deposit_tile"))){
            if(objectnodes.length-1 == counter) {
                break;
            }
            counter++;
        }
        if(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && objectnodes[counter].nodename.trim().equals("orbital_deposit_tile")) {
            temp = Integer.valueOf(objectnodes[counter].getNodeValue().trim().replace("=",""));
        }
        setorbitaldeposittile(temp);
    }

    public String toString() {
        return "name" + " = " + name + " | "
                + "id" + " =  " + id + " | "
                + "name" + " =  " + name + " | "
                + "objecttype" + " =  " + objecttype + " | "
                + "objectclass" + " =  " + objectclass + " | "
                //+ "objectnodes" + " =  " + Arrays.toString(objectnodes) + " | "
                + "\r\n";
    }
}
