package Stellaris;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Stellaris.Main.planetarray;

/**
 * Created by jmm on 7/9/2016.
 */
public class ObjectStar {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();

    private Integer[] planetsarray;

    private SaveFileElement[] objectnodes;

    public Integer getid(){ return id.get(); }
    public void setid(Integer i){ id.set(i); }
    public IntegerProperty idProperty() { return id; }

    public String getname(){
        return name.get();
    }
    public void setname(String s){ name.set(s); }
    public StringProperty nameProperty() { return name; }

    public void setStellarObjectNodes(SaveFileElement[] list) {
        objectnodes = list;
        findId();
        findName();
        findPlanets();
        setPlanetsStar();
        //System.out.println("Start ------------------- " + this.toString());
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

    private void findPlanets() {

        List<Integer> planetlist = new ArrayList<>();
        for (int i = 0; i < objectnodes.length; i++) {
            if (objectnodes[i].nodename.trim().equals("planet")) {
                if (objectnodes[i].openorclose.equals("none")) {
                    planetlist.add(Integer.parseInt(objectnodes[i].nodevalue.replace("=","").trim()));
                }
            }
        }

        planetsarray = new Integer[planetlist.size()];
        for (int i = 0; i < planetsarray.length; i++) {
            planetsarray[i] = planetlist.get(i);
        }
    }

    private void setPlanetsStar() {

        for(int i = 0 ; i < planetsarray.length ; i++) {
            planetarray[planetsarray[i]].setstar(Integer.toString(getid()));
            planetarray[planetsarray[i]].setstarname((getname()));

        }
    }

    public String toString() {
        return "id" + " =  " + id + " | "
                + "name" + " =  " + name + " | "
                + "planets = " + Arrays.toString(planetsarray)
                //+ "objectnodes" + " =  " + Arrays.toString(objectnodes) + " | "
                + "\r\n";
    }
}
