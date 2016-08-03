package Stellaris;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by jmm on 8/2/2016.
 */
public class ObjectPopulation {

    private StringProperty species_index = new SimpleStringProperty();
    private StringProperty growth_state = new SimpleStringProperty();
    private StringProperty tile = new SimpleStringProperty();
    private StringProperty pop_faction = new SimpleStringProperty();

    private StringProperty[] ethos;

    public SaveFileElement[] objectnodes;

}


//pop={
//        0={
//        species_index=0
//        growth_state=1
//        ethos={
//        ethic="ethic_fanatic_individualist"
//        ethic="ethic_fanatic_xenophile"
//        ethic="ethic_pacifist"
//        ethic="ethic_fanatic_materialist"
//        }
//        tile=562962838323203		pop_faction=0
//        required_growth={
//        type=food_surplus
//        value=25.000
//        }
//        }