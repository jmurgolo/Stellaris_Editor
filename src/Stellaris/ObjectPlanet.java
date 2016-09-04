package Stellaris;

import javafx.beans.property.*;

import java.util.*;

import static Stellaris.Main.speciesarray;

/**
 * Created by jmm on 6/25/2016.
 */
public class ObjectPlanet {

    private StringProperty star = new SimpleStringProperty();
    private StringProperty starname = new SimpleStringProperty();
    private StringProperty id = new SimpleStringProperty();
    private IntegerProperty idnumber = new SimpleIntegerProperty();
    private IntegerProperty size = new SimpleIntegerProperty();

    private LongProperty orbitaldeposittileinteger = new SimpleLongProperty();
    private StringProperty orbitaldeposittile = new SimpleStringProperty();
    private StringProperty orbitaldeposittiletypeone = new SimpleStringProperty();
    private StringProperty orbitaldeposittiletypetwo = new SimpleStringProperty();
    private StringProperty orbitaldeposittiletypethree = new SimpleStringProperty();
    private StringProperty orbitaldeposittilevalueone = new SimpleStringProperty();
    private StringProperty orbitaldeposittilevaluetwo = new SimpleStringProperty();
    private StringProperty orbitaldeposittilevaluethree = new SimpleStringProperty();

    private IntegerProperty overallcolonizationdepositvalue = new SimpleIntegerProperty();
    private IntegerProperty foodvalue = new SimpleIntegerProperty();
    private IntegerProperty orevalue = new SimpleIntegerProperty();
    private IntegerProperty energyvalue = new SimpleIntegerProperty();
    private IntegerProperty biologyvalue = new SimpleIntegerProperty();
    private IntegerProperty engineeringvalue = new SimpleIntegerProperty();
    private IntegerProperty physicsvalue = new SimpleIntegerProperty();

    private StringProperty objectname = new SimpleStringProperty();
    private StringProperty objectclass = new SimpleStringProperty();
    private StringProperty objecttype = new SimpleStringProperty();
    private StringProperty owner = new SimpleStringProperty();
    private StringProperty ownername = new SimpleStringProperty();
    private StringProperty controller = new SimpleStringProperty();
    private StringProperty controllerName = new SimpleStringProperty();
    private StringProperty orbitals = new SimpleStringProperty();
    private StringProperty entity = new SimpleStringProperty();
    private StringProperty prevent_anomaly = new SimpleStringProperty();
    private StringProperty spaceport = new SimpleStringProperty();
    private StringProperty popsstringprop = new SimpleStringProperty();
    private StringProperty popsnamesstringprop = new SimpleStringProperty();


    public SaveFileElement[] objectnodes;
    public ObjectTile[] planettiles;
    //private ObjectPopulation[] pops = new ObjectPopulation[0];


    public ObjectPlanet() {
        setstar("");
        setid("");
        setsize(0);
        setorbitaldeposittile("");
        setobjectname("");
        setobjectclass("");
        setobjecttype("");
        setowner("");
        setcontroller("");
        setfoodvalue(0);
        setorevalue(0);
        setenergyvalue(0);
        setbiologyvalue(0);
        setengineeringvalue(0);
        setphysicsvalue(0);
        //setpop                 ("");
        //setorbitals            ("");
        //setentity              ("");
        //setprevent_anomaly     ("");
        //setspaceport           ("");
    }

    public String getstar() {
        return star.get();
    }

    public void setstar(String i) {
        star.set(i);
    }

    public StringProperty starProperty() {
        return star;
    }

    public String getstarname() {
        return starname.get();
    }

    public void setstarname(String i) {
        starname.set(i);
    }

    public StringProperty starnameProperty() {
        return starname;
    }

    public String getid() {
        return id.get();
    }

    public void setid(String i) {
        id.set(i);
    }

    public StringProperty idProperty() {
        return id;
    }

    public Integer getidnumber() {
        return idnumber.get();
    }

    public void setidnumber(Integer i) {
        idnumber.set(i);
    }

    public IntegerProperty idnumberProperty() {
        return idnumber;
    }

    public Long getorbitaldeposittileinteger() {
        return orbitaldeposittileinteger.get();
    }

    public void setorbitaldeposittileinteger(Long i) {
        orbitaldeposittileinteger.set(i);
    }

    public LongProperty orbitaldeposittileintegerProperty() {
        return orbitaldeposittileinteger;
    }

    public Integer getsize() {
        return size.get();
    }

    public void setsize(Integer i) {
        size.set(i);
    }

    public IntegerProperty sizeProperty() {
        return size;
    }

    public String getobjectname() {
        return objectname.get();
    }

    public void setobjectname(String s) {
        objectname.set(s);
    }

    public StringProperty objectnameProperty() {
        return objectname;
    }

    public String getobjectclass() {
        return objectclass.get();
    }

    public void setobjectclass(String s) {
        objectclass.set(s);
    }

    public StringProperty objectclassProperty() {
        return objectclass;
    }

    public String getobjecttype() {
        return objecttype.get();
    }

    public void setobjecttype(String s) {
        objecttype.set(s);
    }

    public StringProperty objecttypeProperty() {
        return objecttype;
    }

    public String getorbitaldeposittile() {
        return orbitaldeposittile.get();
    }

    public void setorbitaldeposittile(String i) {
        orbitaldeposittile.set(i);
    }

    public StringProperty orbitaldeposittileProperty() {
        return orbitaldeposittile;
    }

    public String getowner() {
        return owner.get();
    }

    public void setowner(String s) {
        owner.set(s);
    }

    public StringProperty ownerProperty() {
        return owner;
    }

    public String getownername() {
        return ownername.get();
    }

    public void setownername(String s) {
        ownername.set(s);
    }

    public StringProperty ownernameProperty() {
        return ownername;
    }

    public String getcontroller() {
        return controller.get();
    }

    public void setcontroller(String s) {
        controller.set(s);
    }

    public StringProperty controllerProperty() {
        return controller;
    }

    public String getcontrollerName() {
        return controllerName.get();
    }

    public void setcontrollerName(String s) {
        controllerName.set(s);
    }

    public StringProperty controllerNameProperty() {
        return controllerName;
    }

    public String getorbitaldeposittiletypeone() {
        return orbitaldeposittiletypeone.get();
    }

    public void setorbitaldeposittiletypeone(String s) {
        orbitaldeposittiletypeone.set(s);
    }

    public StringProperty orbitaldeposittiletypeoneProperty() {
        return orbitaldeposittiletypeone;
    }

    public String getorbitaldeposittiletypetwo() {
        return orbitaldeposittiletypetwo.get();
    }

    public void setorbitaldeposittiletypetwo(String s) {
        orbitaldeposittiletypetwo.set(s);
    }

    public StringProperty orbitaldeposittiletypetwoProperty() {
        return orbitaldeposittiletypetwo;
    }

    public String getorbitaldeposittiletypethree() {
        return orbitaldeposittiletypethree.get();
    }

    public void setorbitaldeposittiletypethree(String s) {
        orbitaldeposittiletypethree.set(s);
    }

    public StringProperty orbitaldeposittiletypethreeProperty() {
        return orbitaldeposittiletypethree;
    }

    public String getorbitaldeposittilevalueone() {
        return orbitaldeposittilevalueone.get();
    }

    public void setorbitaldeposittilevalueone(String s) {
        orbitaldeposittilevalueone.set(s);
    }

    public StringProperty orbitaldeposittilevalueoneProperty() {
        return orbitaldeposittilevalueone;
    }

    public String getorbitaldeposittilevaluetwo() {
        return orbitaldeposittilevaluetwo.get();
    }

    public void setorbitaldeposittilevaluetwo(String s) {
        orbitaldeposittilevaluetwo.set(s);
    }

    public StringProperty orbitaldeposittilevaluetwoProperty() {
        return orbitaldeposittilevaluetwo;
    }

    public String getorbitaldeposittilevaluethree() {
        return orbitaldeposittilevaluethree.get();
    }

    public void setorbitaldeposittilevaluethree(String s) {
        orbitaldeposittilevaluethree.set(s);
    }

    public StringProperty orbitaldeposittilevaluethreeProperty() {
        return orbitaldeposittilevaluethree;
    }

    public Integer getoverallcolonizationdepositvalue() {
        return overallcolonizationdepositvalue.get();
    }

    public void setoverallcolonizationdepositvalue(Integer s) {
        overallcolonizationdepositvalue.set(s);
    }

    public IntegerProperty overallcolonizationdepositvalueProperty() {
        return overallcolonizationdepositvalue;
    }

    public Integer getfoodvalue() {
        return foodvalue.get();
    }

    public void setfoodvalue(Integer s) {
        foodvalue.set(s);
    }

    public IntegerProperty foodvalueProperty() {
        return foodvalue;
    }

    public Integer getorevalue() {
        return orevalue.get();
    }

    public void setorevalue(Integer s) {
        orevalue.set(s);
    }

    public IntegerProperty orevalueProperty() {
        return orevalue;
    }

    public Integer getenergyvalue() {
        return energyvalue.get();
    }

    public void setenergyvalue(Integer s) {
        energyvalue.set(s);
    }

    public IntegerProperty energyvalueProperty() {
        return energyvalue;
    }

    public Integer getbiologyvalue() {
        return biologyvalue.get();
    }

    public void setbiologyvalue(Integer s) {
        biologyvalue.set(s);
    }

    public IntegerProperty biologyvalueProperty() {
        return biologyvalue;
    }

    public Integer getengineeringvalue() {
        return engineeringvalue.get();
    }

    public void setengineeringvalue(Integer s) {
        engineeringvalue.set(s);
    }

    public IntegerProperty engineeringvalueProperty() {
        return engineeringvalue;
    }

    public Integer getphysicsvalue() {
        return physicsvalue.get();
    }

    public void setphysicsvalue(Integer s) {
        physicsvalue.set(s);
    }

    public IntegerProperty physicsvalueProperty() {
        return physicsvalue;
    }

    public String getpopsstringprop() {
        return popsstringprop.get();
    }

    public void setpopsstringprop(String s) {
        popsstringprop.set(s);
    }

    public StringProperty popsstringpropProperty() {
        return popsstringprop;
    }

    public String getpopsnamesstringprop() {
        return popsnamesstringprop.get();
    }

    public void setpopsnamesstringprop(String s) {
        popsnamesstringprop.set(s);
    }

    public StringProperty popsnamesstringpropProperty() {
        return popsnamesstringprop;
    }

    public void setStellarObjectNodes(SaveFileElement[] list) {

        objectnodes = list;
        findId();
        findSize();
        findName();
        findType();
        findObjectClass();
        findOwner();
        findController();
        findOrbitalDepositTile();
        findTiles();
        findOrbitalResources();
        findFoodValue();
        findEnergyValue();
        findMineralValue();
        findBiologyValue();
        findEngineeringValue();
        findPhysicsValue();
        findOverallColonizationDepositValues();
        findcontrollername();
        findownername();
        //System.out.println(Arrays.toString(this.objectnodes));
    }

    public void findpopsstringprop() {
        List temparray = new ArrayList();
        if (planettiles.length > 0) {
            for (int i = 0; i < planettiles.length; i++) {
                if (!(planettiles[i].getpop().equals(""))) {
                    temparray.add(planettiles[i].getpop());
                }
            }
            //in the event of multiple species on same planet
            if (temparray.size() > 0) {
                Set<String> uniquepops = new HashSet<String>(temparray);
                setpopsstringprop(Arrays.toString(uniquepops.toArray()));
                //get names from id's
                findpopsnamesstringprop();
            }
        }
    }

    public void findpopsnamesstringprop() {
        //get names from id's
        if (!(getpopsstringprop() == null)) {
            String[] tempList = getpopsstringprop().replaceAll("\\[", "").replaceAll("]", "").split(",");
            for (int i = 0; i < tempList.length; i++) {
                for (int j = 0; j < speciesarray.length; j++) {
                    if (tempList[i].trim().equals(speciesarray[j].getid().trim())) {
                        setpopsnamesstringprop(getpopsnamesstringprop() + ", " + speciesarray[j].getname());
                    }
                }
            }
            setpopsnamesstringprop(getpopsnamesstringprop().replaceAll("null,", ""));
        }
    }

    public void findcontrollername() {
        //get names from id's
        if (!(getcontroller() == null)) {
            String temp = getcontroller().replaceAll("\\[", "").replaceAll("]", "");
                for (int j = 0; j < speciesarray.length; j++) {
                        if (temp.trim().equals(speciesarray[j].getid().trim())) {
                            setcontrollerName(speciesarray[j].getname());
                            //System.out.println(speciesarray[j].getid().trim() + " | " + getcontrollername());
                        }
            }
        }
    }

    public void findownername() {
        //get names from id's
        if (!(getowner() == null)) {
            String temp = getowner().replaceAll("\\[", "").replaceAll("]", "");
            for (int j = 0; j < speciesarray.length; j++) {
                if (temp.trim().equals(speciesarray[j].getid().trim())) {
                    setownername(speciesarray[j].getname());
                }
            }
        }
    }

    private void findId() {

        String temp = "";
        int counter = 0;

        try {
            while (!(objectnodes[counter].openorclose.equals("open") && objectnodes[counter].nodelevel == 2) && (objectnodes[counter].nodeparent.trim().equals("galactic_object") || objectnodes[counter].nodeparent.trim().equals("planet"))) {
                if (objectnodes.length - 1 == counter) {
                    Utilities.print("break");
                    break;
                }
                counter++;
            }
            if (objectnodes[counter].openorclose.equals("open") && objectnodes[counter].nodelevel == 2 && (objectnodes[counter].nodeparent.trim().equals("galactic_object") || objectnodes[counter].nodeparent.trim().equals("planet"))) {
                temp = objectnodes[counter].getNodeName().trim();
            }
            setidnumber(Integer.parseInt(temp));
            setid(temp);
        } catch (Exception e) {
            System.out.println("Error: ObjectPlanet 1: " + this.toString());
            e.printStackTrace();
        }
    }

    private void findName() {

        String temp = "";
        int counter = 0;

        //System.out.println("---------------------------------------" + Arrays.toString(objectnodes));
        while (!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("name") && objectnodes[counter].nodelevel == 2)) {
            if (objectnodes.length - 1 == counter) {
                break;
            }
            counter++;
        }
        if (objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("name") && objectnodes[counter].nodelevel == 2) {
            temp = objectnodes[counter].getNodeValue();
        }
        setobjectname(temp.replaceAll("\"", "").replaceAll("=", ""));
    }

    private void findOwner() {

        String temp = "";
        int counter = 0;

        while (!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("owner") && objectnodes[counter].nodelevel == 2)) {
            if (objectnodes.length - 1 == counter) {
                break;
            }
            counter++;
        }
        if (objectnodes.length > counter && objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("owner") && objectnodes[counter].nodelevel == 2) {
            temp = objectnodes[counter].getNodeValue();
        }
        setowner(temp.replaceAll("\"", "").replaceAll("=", ""));
    }

    private void findController() {

        String temp = "";
        int counter = 0;

        while (!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("controller") && objectnodes[counter].nodelevel == 2)) {
            if (objectnodes.length - 1 == counter) {
                break;
            }
            counter++;
        }
        if (objectnodes.length > counter && objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("controller") && objectnodes[counter].nodelevel == 2) {
            temp = objectnodes[counter].getNodeValue();
        }
        //System.out.println(temp);
        setcontroller(temp.replaceAll("\"", "").replaceAll("=", ""));
    }

    private void findObjectClass() {

        String temp = "";
        int counter = 0;

        while (!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && (objectnodes[counter].nodename.trim().equals("star_class") || objectnodes[counter].nodename.trim().equals("planet_class")))) {
            if (objectnodes.length - 1 == counter) {
                break;
            }
            counter++;
        }
        if (objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && (objectnodes[counter].nodename.trim().equals("star_class") || objectnodes[counter].nodename.trim().equals("planet_class"))) {
            temp = objectnodes[counter].getNodeValue();
        }
        setobjectclass(temp.replaceAll("\"", "").replaceAll("=", ""));
    }

    private void findSize() {

        Integer temp = 0;
        int counter = 0;

        while (!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && objectnodes[counter].nodename.trim().equals("planet_size"))) {
            if (objectnodes.length - 1 == counter) {
                break;
            }
            counter++;
        }
        if (objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && objectnodes[counter].nodename.trim().equals("planet_size")) {
            temp = Integer.valueOf(objectnodes[counter].getNodeValue().trim().replace("=", ""));
        }
        setsize(temp);
    }

    private void findType() {

        String temp = "";
        int counter = 0;

        while (!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && (objectnodes[counter].nodename.trim().equals("type") || objectnodes[counter].nodename.trim().equals("planet_class")))) {
            if (objectnodes.length - 1 == counter) {
                break;
            }
            counter++;
        }
        if (objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && (objectnodes[counter].nodename.trim().equals("type") || objectnodes[counter].nodename.trim().equals("planet_class"))) {
            temp = objectnodes[counter].getNodeValue();
        }
        setobjecttype(temp.replaceAll("\"", "").replaceAll("=", ""));
    }

    private void findOrbitalDepositTile() {
        String temp = "";
        int counter = 0;

        while (!(objectnodes[counter].nodename.trim().equals("orbital_deposit_tile"))) {
            if (objectnodes.length - 1 == counter) {
                System.out.println("Error: ObjectPlanet 214: " + this.toString());
                break;
            }
            counter++;
        }
        if (objectnodes[counter].nodename.trim().equals("orbital_deposit_tile")) {
            temp = objectnodes[counter].getNodeValue();
        }
        setorbitaldeposittile(temp.replaceAll("\"", "").replaceAll("=", "").replaceAll("}", ""));
        setorbitaldeposittileinteger(Long.parseLong(temp.replaceAll("\"", "").replaceAll("=", "").replaceAll("}", "").trim()));
    }

    private void findTiles() {

        List<SaveFileElement> tilelist = new ArrayList<>();
        for (int i = 0; i < objectnodes.length; i++) {
            if (objectnodes[i].nodeparent.trim().equals("tiles")) {
                if (objectnodes[i].openorclose.equals("open")) {
                    tilelist.add(objectnodes[i]);
                }
            }
        }

        ObjectTile planettilestemp[] = new ObjectTile[tilelist.size()];

        for (int i = 0; i < tilelist.size(); i++) {
            planettilestemp[i] = new ObjectTile();
            planettilestemp[i].setTileObjectNode(tilelist.get(i).getChildren(), getid());
        }

        if (planettilestemp.length > 0) {
            planettiles = new ObjectTile[Integer.parseInt(planettilestemp[planettilestemp.length - 1].getid()) + 1];
            for (int i = 0; i < planettiles.length; i++) {
                planettiles[i] = new ObjectTile();
                planettiles[i].setid(Integer.toString(i));
            }
            for (int i = 0; i < planettilestemp.length; i++) {
                planettiles[Integer.parseInt(planettilestemp[i].getid())] = planettilestemp[i];
            }
        } else {
            planettiles = planettilestemp;
        }
    }

    private void findOrbitalResources() {
        Long stepL = 0L;
        Long baseL = 0L;
        Long totalL = 0L;
        for (int i = 0; i < planettiles.length; i++) {
            if (planettiles[i].getglobaltileidtotal().trim().equals(getorbitaldeposittile().trim())) {
                setorbitaldeposittiletypeone(planettiles[i].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[i].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[i].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[i].getresourcequantity(1));
                setorbitaldeposittiletypethree(planettiles[i].getresourcetype(2));
                setorbitaldeposittilevaluethree(planettiles[i].getresourcequantity(2));
                break;
            }
        }
    }

    private void findFoodValue() {
        Integer[] temp = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < planettiles.length; i++) {
            for (int j = 0; j < planettiles[i].getresourcetype().length; j++) {
                if (!(planettiles[i].getresourcetype(j) == null) && planettiles[i].getresourcetype(j).equals("food")) {
                    setfoodvalue(getfoodvalue() + Integer.parseInt(planettiles[i].getresourcequantity(j).replaceAll(".000", "")));
                    //System.out.println(planettiles[i].getresourcetype(j) + " " + getfoodvalue());
                }
            }
        }
    }

    private void findEnergyValue() {
        Integer[] temp = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < planettiles.length; i++) {
            for (int j = 0; j < planettiles[i].getresourcetype().length; j++) {
                if (!(planettiles[i].getresourcetype(j) == null) && planettiles[i].getresourcetype(j).equals("energy")) {
                    setenergyvalue(getenergyvalue() + Integer.parseInt(planettiles[i].getresourcequantity(j).replaceAll(".000", "")));
                    //System.out.println(planettiles[i].getresourcetype(j) + " " + getenergyvalue());
                }
            }
        }
    }

    private void findMineralValue() {
        Integer[] temp = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < planettiles.length; i++) {
            for (int j = 0; j < planettiles[i].getresourcetype().length; j++) {
                if (!(planettiles[i].getresourcetype(j) == null) && planettiles[i].getresourcetype(j).equals("minerals")) {
                    setorevalue(getorevalue() + Integer.parseInt(planettiles[i].getresourcequantity(j).replaceAll(".000", "")));
                    //System.out.println(planettiles[i].getresourcetype(j) + " " + getorevalue());
                }
            }
        }
    }

    private void findBiologyValue() {
        Integer[] temp = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < planettiles.length; i++) {
            for (int j = 0; j < planettiles[i].getresourcetype().length; j++) {
                if (!(planettiles[i].getresourcetype(j) == null) && planettiles[i].getresourcetype(j).equals("society_research")) {
                    setbiologyvalue(getbiologyvalue() + Integer.parseInt(planettiles[i].getresourcequantity(j).replaceAll(".000", "")));
                    //System.out.println(planettiles[i].getresourcetype(j) + " " + getbiologyvalue());
                }
            }
        }
    }

    private void findEngineeringValue() {
        Integer[] temp = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < planettiles.length; i++) {
            for (int j = 0; j < planettiles[i].getresourcetype().length; j++) {
                if (!(planettiles[i].getresourcetype(j) == null) && planettiles[i].getresourcetype(j).equals("engineering_research")) {
                    setengineeringvalue(getengineeringvalue() + Integer.parseInt(planettiles[i].getresourcequantity(j).replaceAll(".000", "")));
                    //System.out.println(planettiles[i].getresourcetype(j) + " " + getengineeringvalue());
                }
            }
        }
    }

    private void findPhysicsValue() {
        Integer[] temp = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < planettiles.length; i++) {
            for (int j = 0; j < planettiles[i].getresourcetype().length; j++) {
//                if(!(planettiles[i].getresourcetype(j)==null)) {
//                    System.out.println(planettiles[i].getresourcetype(j));
//                }
                if (!(planettiles[i].getresourcetype(j) == null) && planettiles[i].getresourcetype(j).equals("physics_research")) {
                    setphysicsvalue(getphysicsvalue() + Integer.parseInt(planettiles[i].getresourcequantity(j).replaceAll(".000", "")));
                    //System.out.println(planettiles[i].getresourcetype(j) + " " + getphysicsvalue());
                }
            }
        }
    }

    private void findOverallColonizationDepositValues() {
       int overallvalue =  getbiologyvalue() + getenergyvalue() + getfoodvalue() + getphysicsvalue() + getengineeringvalue() + getorevalue();
        setoverallcolonizationdepositvalue(overallvalue);
    }

    @Override
    public String toString() {
        return "id" + " = " + getid() + " \t | "
                + "size" + " =  " + getsize() + " \t | "
                + "orbitaldeposittile" + " =  " + getorbitaldeposittile() + " \t | "
                + "name" + " =  " + getobjectname() + " | "
                + "objectclass" + " =  " + getobjectclass() + " | "
                + "objecttype" + " =  " + getobjecttype() + " | "
                + "owner" + " =  " + getowner() + " | "
                + "objectnodes = " + Arrays.toString(objectnodes)
                + "\r\n";
    }
}