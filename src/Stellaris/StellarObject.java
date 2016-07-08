package Stellaris;

/**
 * Created by jmm on 6/25/2016.
 */
public class StellarObject {

    private int arraystart;
    private int arrayend;

    private String id;
    private String name = "";
    private String objectclass = "";
    private String objecttype = "";
    private int planet_size = 0;
    private SaveFileElement[] objectnodes;

    public void setStellarObjectNodes(SaveFileElement[] list) {

        objectnodes = list;
        getId();
        getName();
        getType();
        getObjectClass();
    }

    private void getId() {

        String temp = "none";
        int counter = 0;

        while (!(objectnodes[counter].openorclose.equals("open") && objectnodes[counter].nodeparent.trim().equals("galactic_object") && objectnodes[counter].nodelevel == 3)) {
            if (objectnodes.length - 1 == counter) {
                Utilities.print("break");
                break;
            }
            counter++;
        }
        if (objectnodes.length > counter && objectnodes[counter].openorclose.equals("open") && objectnodes[counter].nodeparent.trim().equals("galactic_object") && objectnodes[counter].nodelevel == 3) {
            temp = objectnodes[counter].getNodeName();
        }
        id = temp;
        System.out.println("id: " + id);
    }

    public void getName() {

        String temp = "none";
        int counter = 0;

        while(!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("name") && objectnodes[counter].nodelevel == 3)){
            if(objectnodes.length-1 == counter) {
                break;
            }
            counter++;
        }
        if(objectnodes.length > counter && objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("name") && objectnodes[counter].nodelevel == 3) {
            temp = objectnodes[counter].getNodeValue();
        }
        name = temp.replaceAll("\"","").replaceAll("=","");
        System.out.println("name: " + name);
    }

    public void getObjectClass() {

        String temp = "none";
        int counter = 0;

        while(!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("star_class") && objectnodes[counter].nodelevel == 3)){
            if(objectnodes.length-1 == counter) {
                break;
            }
            counter++;
        }
        if(objectnodes.length > counter && objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("star_class") && objectnodes[counter].nodelevel == 3) {
            temp = objectnodes[counter].getNodeValue();
        }
        objectclass = temp.replaceAll("\"","").replaceAll("=","");
        System.out.println("class: " + objectclass);
    }

    public void getType() {

        String temp = "none";
        int counter = 0;

        while(!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("type") && objectnodes[counter].nodelevel == 3)){
            if(objectnodes.length-1 == counter) {
                break;
            }
            counter++;
        }
        if(objectnodes.length > counter && objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodename.trim().equals("type") && objectnodes[counter].nodelevel == 3) {
            temp = objectnodes[counter].getNodeValue();
        }
        objecttype = temp.replaceAll("\"","").replaceAll("=","");
        System.out.println("Type: " + objecttype);
    }

    public String toString() {
        return "name" + " = " + name + " | "
                + "id" + " =  " + id + " | "
                + "name" + " =  " + name + " | "
                + "objectclass" + " =  " + objectclass + " | "
                + "objectnodes" + " =  " + objectnodes.toString() + " | "
                + "\r\n";
    }
}
