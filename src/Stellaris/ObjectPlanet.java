package Stellaris;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmm on 6/25/2016.
 */
public class ObjectPlanet {

    private IntegerProperty id = new SimpleIntegerProperty();
    private IntegerProperty size = new SimpleIntegerProperty();
    private StringProperty orbitaldeposittile = new SimpleStringProperty();
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
    private ObjectTile[] planettiles;

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

    public String getorbitaldeposittile(){ return orbitaldeposittile.get(); }
    public void setorbitaldeposittile(String i){ orbitaldeposittile.set(i); }
    public StringProperty orbitaldeposittileProperty() { return orbitaldeposittile; }

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
        getTiles();
        //figureoutorbitaldeposittile();

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
        //todo: need to handle two equal signs on same line
        String temp = "";
        int counter = 0;

        while(!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && objectnodes[counter].nodename.trim().equals("orbital_deposit_tile"))){
            if(objectnodes.length-1 == counter) {
                break;
            }
            counter++;
        }
        if(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && objectnodes[counter].nodename.trim().equals("orbital_deposit_tile")) {
            //System.out.println(id);
            //System.out.println(objectnodes[counter].getNodeValue());
            temp = objectnodes[counter].nodevalue.trim().replace("=","");
        }
        setorbitaldeposittile(temp);
    }

    private void getTiles() {

        List<SaveFileElement> tilelist = new ArrayList<>();
        for (int i = 0; i < objectnodes.length; i++) {
            if (objectnodes[i].nodeparent.trim().equals("tiles")) {
                if (objectnodes[i].openorclose.equals("open")) {
                    tilelist.add(objectnodes[i]);
                }
            }
        }

        planettiles = new ObjectTile[tilelist.size()];

        for (int i = 0; i < tilelist.size(); i++) {
            planettiles[i] = new ObjectTile();
            planettiles[i].setTileObjectNode(tilelist.get(i).getChildren());

        }
    }
    
    public void figureoutorbitaldeposittile() {
        System.out.println(  "\r\n"
                + " " + getid() + " | "
                + " " + getobjectclass() + " | "
                + " " + getobjecttype() + " | "
                + " " + getsize() + " | "
                + " " + getTileInfo() + " | "
                + " " + getorbitaldeposittile()
                );
    }

    private String getTileInfo(){
        String temp = "";
        for(int i = 0 ; i < planettiles.length ; i++){
            temp = temp + planettiles[i].getid() + planettiles[i].getdeposit() + " | ";
        }
        return temp;
    }

}
