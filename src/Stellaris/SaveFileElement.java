package Stellaris;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Stellaris.Utilities.addArrayCapacity;

/**
 * Created by jmm on 6/16/2016.
 */
public class SaveFileElement {

    public int linenumber;
    public int nodelevel;
    public String nodename;
    public String nodevalue;
    public String nodeparent;
    public String openorclose;
    public String originalnodevalue;
    public int nodepath;
    public String nodedepth;

    private int nodedepthlength;

    public SaveFileElement() {
    }

    public String getNodeName() {
        return nodename;
    }

    public String getNodeDepth() {
        return nodedepth;
    }

    public String getOpenOrClose() {
        return openorclose;
    }

    public String getNodeValue() {
        return nodevalue;
    }

    public String getOriginalNodeValue() {
        return originalnodevalue;
    }

    public int getLineNumber() {
        return linenumber;
    }

    public int getNodeDepthLength() {
        return getNodeDepthAsIntegerList().size();
    }

    public List<Integer> getNodeDepthSublist(int s, int e) {
        return getNodeDepthAsIntegerList().subList(s, e);
    }

    public List<Integer> getNodeDepthAsIntegerList() {
        String[] temp = nodedepth.substring(1, getNodeDepth().length() - 1).split(",");
        List<Integer> numberList = new ArrayList<Integer>();
        if (temp.length > 0) {
            for (int z = 0; z < temp.length; z++) {
                if (StringUtils.isNumeric(temp[z].trim())) {
                    numberList.add(Integer.parseInt(temp[z].trim()));
                }
            }
        }
        return numberList;
    }

    public Integer[] getNodeDepthAsIntegerArray() {

        String[] temp = nodedepth.substring(1, getNodeDepth().length() - 1).split(",");
        Integer[] numberList = new Integer[0];
        int counter = 0;
        if (temp.length > 0) {
            for (int z = 0; z < temp.length; z++) {
                if (StringUtils.isNumeric(temp[z].trim())) {
                    numberList = addArrayCapacity(numberList, 1);
                    numberList[counter] = Integer.parseInt(temp[z].trim());
                }
            }
        }
        return numberList;
    }

    public List getChildren() {

        int parentelement = getNodeDepthAsIntegerList().get(getNodeDepthAsIntegerList().size() - 2);
        int childelement = getNodeDepthAsIntegerList().get(getNodeDepthAsIntegerList().size() - 1);
        SaveFileElement[] children = new SaveFileElement[100000];

        int counter = 0;
        for (int i = 0; i < Main.sfe_arraylist.length; i++) {
            if (Main.sfe_arraylist[i].nodelevel >= nodelevel) {
                int s = Main.sfe_arraylist[i].getNodeDepthAsIntegerList().get(getNodeDepthAsIntegerArray().length - 1);
                if (s == childelement) {
                    if (counter == children.length) {
                        children = addCapacity(children, 10000);
                        System.out.println("counter " + counter);
                    }
                    children[counter] = Main.sfe_arraylist[i];
                    counter++;
                }
            }
        }
        return new ArrayList<SaveFileElement>(Arrays.asList(children));
    }

    public static SaveFileElement[] addCapacity(SaveFileElement[] list, int amount) {
        SaveFileElement[] arr1 = new SaveFileElement[(int) (list.length + amount)];
        return arr1;
    }

    public String getElement(String s) {
        String return_value = "!!!no match!!!";
        if (s.equals("nodename")) {
            return_value = nodename;
        }
        return return_value;
    }

    @Override
    public String toString() {
        return "linenumber" + " = " + linenumber + " \t | "
                + "nodelevel" + " =  " + nodelevel + " \t | "
                + "nodename" + " =  " + nodename + " \t | "
                + "nodevalue" + " =  " + nodevalue + " | "
                + "nodeparent" + " =  " + nodeparent + " | "
                + "openorclose" + " =  " + openorclose + " | "
                + "originalnodevalue" + " =  " + originalnodevalue + " | "
                + "nodepath" + " =  " + nodepath + " | "
                + "nodedepth" + " =  " + nodedepth + "\r\n";
    }
}