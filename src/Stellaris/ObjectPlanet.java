package Stellaris;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jmm on 6/25/2016.
 */
public class ObjectPlanet {

    private StringProperty star = new SimpleStringProperty();
    private StringProperty id = new SimpleStringProperty();
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
    private StringProperty pop = new SimpleStringProperty();
    private StringProperty orbitals = new SimpleStringProperty();
    private StringProperty entity = new SimpleStringProperty();
    private StringProperty prevent_anomaly = new SimpleStringProperty();
    private StringProperty spaceport = new SimpleStringProperty();

    public SaveFileElement[] objectnodes;
    private ObjectTile[] planettiles;

    public ObjectPlanet() {
        setstar("");
        setid("");
        setsize(0);
        setorbitaldeposittile("");
        setobjectname("");
        setobjectclass("");
        setobjecttype("");
        setowner("");
        setcontroller          ("");
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
        //System.out.println(this.getid() + " | " + this.getorbitaldeposittile() + " | " +  Arrays.toString(planettiles));
        //figureoutorbitaldeposittile();
        //System.out.println(Arrays.toString(this.objectnodes));

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

//        System.out.println(orbitaldeposittile);
//        System.out.println("tilelist: " + tilelist.size());
//        System.out.println("planettilestemp: " +  planettilestemp.length);
//        System.out.println("highid: " + planettilestemp[planettilestemp.length - 1].getid());
//        System.out.println("planettiles: " + planettiles.length  );
//        System.out.println(Arrays.toString(planettiles)+ "\r\n");

    }

    private void findOrbitalResources() {
        //try {
            if (getid().trim().equals(getorbitaldeposittile().trim())) {
                setorbitaldeposittiletypeone(planettiles[0].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[0].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[0].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[0].getresourcequantity(1));

            } else if (getorbitaldeposittile().startsWith("281474")) {
                setorbitaldeposittiletypeone(planettiles[1].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[1].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[6].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[6].getresourcequantity(1));
            } else if (getorbitaldeposittile().startsWith("281479")) {
                setorbitaldeposittiletypeone(planettiles[6].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[6].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[6].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[6].getresourcequantity(1));
            } else if (getorbitaldeposittile().startsWith("281435") || getorbitaldeposittile().startsWith("281483") ) {
                setorbitaldeposittiletypeone(planettiles[11].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[11].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[11].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[11].getresourcequantity(1));
            } else if (getorbitaldeposittile().startsWith("281487")) {
                setorbitaldeposittiletypeone(planettiles[16].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[16].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[16].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[16].getresourcequantity(1));
            } else if (getorbitaldeposittile().startsWith("281492")) {
                setorbitaldeposittiletypeone(planettiles[21].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[21].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[21].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[21].getresourcequantity(1));

            } else if (getorbitaldeposittile().startsWith("562949")) {
                setorbitaldeposittiletypeone(planettiles[2].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[2].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[2].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[2].getresourcequantity(1));
            } else if (getorbitaldeposittile().startsWith("562954")) {
                setorbitaldeposittiletypeone(planettiles[7].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[7].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[7].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[7].getresourcequantity(1));
            } else if (getorbitaldeposittile().startsWith("562958")) {
                setorbitaldeposittiletypeone(planettiles[12].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[12].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[12].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[12].getresourcequantity(1));
            } else if (getorbitaldeposittile().startsWith("562962")) {
                setorbitaldeposittiletypeone(planettiles[17].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[17].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[17].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[17].getresourcequantity(1));
            } else if (getorbitaldeposittile().startsWith("562967")) {
                setorbitaldeposittiletypeone(planettiles[22].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[22].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[22].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[22].getresourcequantity(1));

            } else if (getorbitaldeposittile().startsWith("844424")) {
                setorbitaldeposittiletypeone(planettiles[3].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[3].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[3].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[3].getresourcequantity(1));
            } else if (getorbitaldeposittile().startsWith("844429")) {
                setorbitaldeposittiletypeone(planettiles[8].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[8].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[8].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[8].getresourcequantity(1));
            } else if (getorbitaldeposittile().startsWith("844433")) {
                setorbitaldeposittiletypeone(planettiles[13].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[13].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[13].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[13].getresourcequantity(1));
            } else if (getorbitaldeposittile().startsWith("844437")) {
                setorbitaldeposittiletypeone(planettiles[18].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[18].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[18].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[18].getresourcequantity(1));
            } else if (getorbitaldeposittile().startsWith("844442")) {
                setorbitaldeposittiletypeone(planettiles[23].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[23].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[23].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[23].getresourcequantity(1));

            } else if (getorbitaldeposittile().trim().startsWith("1125899")) {
                setorbitaldeposittiletypeone(planettiles[4].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[4].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[4].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[4].getresourcequantity(1));
            } else if (getorbitaldeposittile().trim().startsWith("1125904")) {
                setorbitaldeposittiletypeone(planettiles[9].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[9].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[9].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[9].getresourcequantity(1));
            } else if (getorbitaldeposittile().trim().startsWith("1125908")) {
                setorbitaldeposittiletypeone(planettiles[14].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[14].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[14].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[14].getresourcequantity(1));
            } else if (getorbitaldeposittile().trim().startsWith("1125912")) {
                setorbitaldeposittiletypeone(planettiles[19].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[19].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[19].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[19].getresourcequantity(1));
            } else if (getorbitaldeposittile().trim().startsWith("1125917")) {
                setorbitaldeposittiletypeone(planettiles[24].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[24].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[24].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[24].getresourcequantity(1));

            } else if (getorbitaldeposittile().trim().startsWith("42949")) {
                setorbitaldeposittiletypeone(planettiles[5].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[5].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[5].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[5].getresourcequantity(1));
            } else if (getorbitaldeposittile().trim().startsWith("85899")) {
                setorbitaldeposittiletypeone(planettiles[10].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[10].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[10].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[10].getresourcequantity(1));
            } else if (getorbitaldeposittile().trim().startsWith("128") || getorbitaldeposittile().trim().startsWith("129")) {
                setorbitaldeposittiletypeone(planettiles[15].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[15].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[15].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[15].getresourcequantity(1));
            } else if (getorbitaldeposittile().trim().startsWith("171")) {
                setorbitaldeposittiletypeone(planettiles[20].getresourcetype(0));
                setorbitaldeposittilevalueone(planettiles[20].getresourcequantity(0));
                setorbitaldeposittiletypetwo(planettiles[20].getresourcetype(1));
                setorbitaldeposittilevaluetwo(planettiles[20].getresourcequantity(1));

            } else {
                System.out.println("not in list: " + getorbitaldeposittile());
                System.out.println(Arrays.toString(planettiles)+ "\r\n");
            }
//        } catch (Exception e) {
//            System.out.println("Error: " + getorbitaldeposittile() + e);
//        }
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

//    public void figureoutorbitaldeposittile() {
//        System.out.println(  "\r\n"
//                + " " + getid() + " | "
//                + " " + getobjectclass() + " | "
//                + " " + getobjecttype() + " | "
//                + " " + getsize() + " | "
//                + " " + getTileInfo() + " | "
//                + " " + getorbitaldeposittile()
//        );
//    }
