package Stellaris;

import javafx.beans.property.*;

import java.util.Arrays;

/**
 * Created by jmm on 6/25/2016.
 */
public class StellarObject {

    private int arraystart;
    private int arrayend;

    private IntegerProperty id = new SimpleIntegerProperty();
    private IntegerProperty size = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty objectclass = new SimpleStringProperty();
    private StringProperty objecttype = new SimpleStringProperty();
    private int planet_size = 0;
    private SaveFileElement[] objectnodes;

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

    public String getobjecttype(){
        return objecttype.get();
    }
    public void setobjecttype(String s){ objecttype.set(s); }
    public StringProperty objecttypeProperty() { return objecttype; }

    public void setStellarObjectNodes(SaveFileElement[] list) {

        objectnodes = list;
        findId();
        findSize();
        findName();
        findType();
        findObjectClass();
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

        String temp = "none";
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

    private void findObjectClass() {

        String temp = "none";
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

        Integer temp = 0;
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

        String temp = "none";
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
