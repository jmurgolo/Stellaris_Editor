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

    private StringProperty[] resourcetype = new StringProperty[0];
    private StringProperty[] resourcequantity = new StringProperty[0];

    private StringProperty[] resources;

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

    public String getresourcetype(int index){
        if(resourcetype.length <= index) {
            //System.out.println(resourcetype.length);
            return null;
        }else {
            //System.out.println(resourcetype.length);
            return resourcetype[index].get();
        }
    }
    public void setresourcetype(String s, int index){ resourcetype[index].set(s); }
    public StringProperty[] resourcetypeProperty() { return resourcetype; }

    public String getresourcequantity(int index){
        //System.out.println(this.toString());
        if(resourcequantity.length <= index) {
            //System.out.println(resourcequantity.length);
            return null;
        }else {
            //System.out.println(resourcetype.length);
            return resourcequantity[index].get();
        }
    }
    public void setresourcequantity(String s, int index){ resourcequantity[index].set(s); }
    public StringProperty[] resourcequantityProperty() { return resourcequantity; }

    public void setTileObjectNode(SaveFileElement[] list, String planetid) {
        objectnodes = list;
        findId();
        findDeposit();
        findResources();
        findglobaltileidbyplanet();
        findglobaltileidbase();
        findglobaltileidtotal();
    }

    public SaveFileElement[] getTileObjectNode() {
        return objectnodes;
    }

    private String findglobaltileidbyplanet(){
            //try {
            String temp = "";

        //todo: update function multiplying by two so it's simpler

            if (getid().trim().equals(getplanetid().trim())) {
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
        return temp;
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
