package Stellaris;

import javafx.beans.property.*;

import java.util.*;

/**
 * Created by jmm on 6/25/2016.
 */
public class ObjectPlanet {

    private StringProperty star = new SimpleStringProperty();
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
    private StringProperty objectname = new SimpleStringProperty();
    private StringProperty objectclass = new SimpleStringProperty();
    private StringProperty objecttype = new SimpleStringProperty();
    private StringProperty owner = new SimpleStringProperty();
    private StringProperty controller = new SimpleStringProperty();
    private StringProperty orbitals = new SimpleStringProperty();
    private StringProperty entity = new SimpleStringProperty();
    private StringProperty prevent_anomaly = new SimpleStringProperty();
    private StringProperty spaceport = new SimpleStringProperty();
    private StringProperty popsstringprop = new SimpleStringProperty();

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

    public String getcontroller() {
        return controller.get();
    }
    public void setcontroller(String s) {
        controller.set(s);
    }
    public StringProperty controllerProperty() {
        return controller;
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

    public String getpopsstringprop() {
        return popsstringprop.get();
    }

    public void setpopsstringprop(String s) {
        popsstringprop.set(s);
    }

    public StringProperty popsstringpropProperty() {
        return popsstringprop;
    }

//    public ObjectPopulation getpop(int index) {
//        if (pop.length <= index) {
//            return null;
//        } else {
//            return pop[index].get();
//        }
//    }
//
//    public void setpop(String s, int index) {pop[index].set(s);}
//
//    public StringProperty[] popProperty() {
//        return pop;
//    }

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
        //System.out.println(Arrays.toString(this.objectnodes));
    }

    public void findpopsstringprop(){
        List temparray = new ArrayList();
        if(planettiles.length > 0) {
            for (int i = 0; i < planettiles.length; i++) {
                if (!(planettiles[i].getpop().equals(""))) {
                    temparray.add(planettiles[i].getpop());
                    //System.out.println(Arrays.toString(planettiles));
                }
            }
            if (temparray.size() > 0) {
                Set<String> uniquepops = new HashSet<String>(temparray);
                //System.out.println(uniquepops.toString());
                setpopsstringprop(Arrays.toString(uniquepops.toArray()));
                //System.out.println(getpopsstringprop());
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
            planettilestemp[i].setTileObjectNode(tilelist.get(i).getChildren(),getid());
        }

        if (planettilestemp.length > 0) {
            planettiles = new ObjectTile[Integer.parseInt(planettilestemp[planettilestemp.length - 1].getid())+1];
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
        for(int i = 0; i < planettiles.length ; i++) {
            if(planettiles[i].getglobaltileidtotal().trim().equals(getorbitaldeposittile().trim())) {
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

    private String getTileInfo() {
        String temp = "";
        for (int i = 0; i < planettiles.length; i++) {
            temp = temp + planettiles[i].getid() + planettiles[i].getdeposit() + " | ";
        }
        return temp;
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