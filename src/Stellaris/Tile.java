package Stellaris;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by jmm on 7/16/2016.
 */
public class Tile {

    private StringProperty id = new SimpleStringProperty();
    private StringProperty active = new SimpleStringProperty();
    private StringProperty[] resources;// = new SimpleStringProperty();
    private StringProperty blocker = new SimpleStringProperty();
    private StringProperty deposit = new SimpleStringProperty();
    private StringProperty pop = new SimpleStringProperty();
    private StringProperty building = new SimpleStringProperty();
    private StringProperty prevbuilding = new SimpleStringProperty();

    public String getid(){
        return id.get();
    }
    public void setid(String s){ id.set(s); }
    public StringProperty idProperty() { return id; }

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

}
