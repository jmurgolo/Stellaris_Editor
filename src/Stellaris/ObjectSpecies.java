package Stellaris;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

import static Stellaris.Utilities.addArrayCapacity;

/**
 * Created by jmm on 8/6/2016.
 */
public class ObjectSpecies {

        private StringProperty id = new SimpleStringProperty();
        private StringProperty name = new SimpleStringProperty();

        private SaveFileElement[] objectnodes;

        public ObjectSpecies() {
            setid("");
            setname("");
        }

        public String getid() {
            return id.get();
        }

        public void setid(String s) {
            id.set(s);
        }

        public StringProperty idProperty() {
            return id;
        }

        public String getname() {
            return name.get();
        }

        public void setname(String s) {
            name.set(s);
        }

        public StringProperty nameProperty() {
            return name;
        }

        public void setSpeciesObjectNode(SaveFileElement[] list, int index) {
            objectnodes = list;
            setid(Integer.toString(index));
            //findId();
            findName();
            System.out.println(this.toString());
        }

        public SaveFileElement[] getTileObjectNode() {
            return objectnodes;
        }

//        private void findId() {
//
//            String temp = "";
//            int counter = 0;
//            if (objectnodes.length > counter) {
//                while (!(objectnodes[counter].openorclose.equals("open") && objectnodes[counter].nodelevel == 4 && objectnodes[counter].nodeparent.trim().equals("tiles"))) {
//                    if (objectnodes.length - 1 == counter) {
//                        //Utilities.print("break");
//                        break;
//                    }
//                    counter++;
//                }
//                if (objectnodes[counter].openorclose.equals("open") && objectnodes[counter].nodelevel == 4 && objectnodes[counter].nodeparent.trim().equals("tiles")) {
//                    temp = objectnodes[counter].getNodeName().trim().replace("=", "");
//                }
//                setid(temp);
//            } else {
//                System.out.println("no id: " + this.toString());
//            }
//        }

        private void findName() {

            String temp = "";
            int counter = 0;
            if (objectnodes.length > counter) {
                while (!(objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && objectnodes[counter].nodename.trim().equals("name"))) {
                    if (objectnodes.length - 1 == counter) {
                        //Utilities.print("break");
                        break;
                    }
                    counter++;
                }
                if (objectnodes[counter].openorclose.equals("none") && objectnodes[counter].nodelevel == 2 && objectnodes[counter].nodename.trim().equals("name")) {
                    temp = objectnodes[counter].getNodeValue().trim().replace("=", "");
                }
                setname(temp);
            } else {
                System.out.println("no id: " + this.toString());
            }
        }

        @Override
        public String toString() {
            return "id" + " = " + getid() + " | "
                    + "name" + " =  " + getname();// + " | "
                    //+ "objectnodes" + " =  " + Arrays.toString(objectnodes)
                    //+ "\r\n"
            }
    }

