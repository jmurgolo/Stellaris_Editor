package Stellaris;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static Stellaris.Utilities.addArrayCapacity;

/**
 * Created by jmm on 6/16/2016.
 */
public class SaveFileElement {

    public int id;
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

    public SaveFileElement(){
        linenumber = 0;
        nodelevel = 0;
        nodename = "";
        nodevalue = "";
        nodeparent = "";
        openorclose = "";
        originalnodevalue = "";
        nodepath = 0;
        nodedepth = "";
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

        Integer[] numberList = new Integer[0];
        try {
            String[] temp = nodedepth.substring(1, getNodeDepth().length() - 1).split(",");
            int counter = 0;
            if (temp.length > 0) {
                for (int z = 0; z < temp.length; z++) {
                    if (StringUtils.isNumeric(temp[z].trim())) {
                        numberList = addArrayCapacity(numberList, 1);
                        numberList[counter] = Integer.parseInt(temp[z].trim());
                    }
                }
            }
        }catch(Exception e){
            System.out.println(this.toString());
            e.printStackTrace();
        }
            return numberList;
    }

    public SaveFileElement[] getChildren() {

        int indextracker = id-1;
        int counter = 0;

        while(!(Main.sfe_arraylist[indextracker].openorclose.equals("close") && Main.sfe_arraylist[indextracker].nodeparent.trim().equals(nodename.trim()) &&  Main.sfe_arraylist[indextracker].nodelevel == nodelevel)){
            counter++;
            indextracker++;
        }

//                if(Main.sfe_arraylist[indextracker].openorclose.equals("close") && Main.sfe_arraylist[indextracker].nodeparent.trim().equals(nodename.trim()) && Main.sfe_arraylist[indextracker].nodelevel == 1){
//                    System.out.println(Main.sfe_arraylist[indextracker].toString());
//                }

        //todo:error here !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //todo: NO . . . REALLY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        SaveFileElement[] children = new SaveFileElement[counter];
        System.arraycopy(Main.sfe_arraylist, linenumber-1, children, 0, counter);

        return children;
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
        return "id" + " = " + id + " \t | "
                + "linenumber" + " = " + linenumber + " \t | "
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