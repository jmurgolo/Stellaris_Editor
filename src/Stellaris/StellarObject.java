package Stellaris;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jmm on 6/25/2016.
 */
public class StellarObject {

    private int arraystart;
    private int arrayend;

    private String id;
    private String name = "";
    private String planet_class = "";
    private int planet_size = 0;
    private List<SaveFileElement> objectnodes = new ArrayList<SaveFileElement>();

    public void setStellarObject(int s, int e) {
        arraystart = s;
        arrayend = e;
    }

    public void setEnd(int e) {
        arrayend = e;
    }

    public void setId(String s){
        id = s;
    }

    public String getName(){
        List<SaveFileElement> countries_names = objectnodes.parallelStream()
                .filter(p -> (
                        p.originalnodename).equals("name")
                ).filter(p -> (
                        p.getOpenOrClose()).equals("none"))
                .collect(Collectors.toList());
        name = countries_names.get(0).getOriginalNodeValue().substring(2, countries_names.get(0).originalnodevalue.length() - 1);
        return countries_names.get(0).getOriginalNodeValue().substring(2, countries_names.get(0).originalnodevalue.length() - 1);
    }

    public String toString() {
        return     "name" + " = " + name + " | "
                + "planet_class" + " =  " + planet_class + " | "
                + "objectnodes" + " =  " + objectnodes.toString() + " | "
//                + "nodevalue" + " =  " + nodevalue + " | "
//                + "nodeparent" + " =  " + nodeparent + " | "
//                + "openorclose" + " =  " + openorclose + " | "
//                + "originalnodename" + " =  " + originalnodename + " | "
//                + "originalnodevalue" + " =  " + originalnodevalue + " | "
//                + "nodepath" + " =  " + nodepath + " | "
//                + "nodedepth" + " =  " + nodedepth
                + "\r\n";
    }
}
