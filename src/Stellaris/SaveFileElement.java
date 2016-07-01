package Stellaris;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public String originalnodename;
    public String originalnodevalue;
    public int nodepath;
    public String nodedepth;

    private int nodedepthlength;

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

    public int[] getNodeDepthAsIntegerArray() {

        String[] temp = nodedepth.substring(1, getNodeDepth().length() - 1).split(",");
        int[] numberList = new int[0];
        int counter = 0;
        if (temp.length > 0) {
            for (int z = 0; z < temp.length; z++) {
                if (StringUtils.isNumeric(temp[z].trim())) {
                    numberList = addCapacity(numberList, 1);
                    numberList[counter] = Integer.parseInt(temp[z].trim());
                }
            }
        }
        return numberList;
    }

    public List getChildParents() {
        List<SaveFileElement> depth_length_corrected = Main.sfe_arraylist.parallelStream()
                .filter(p -> (
                        p.getNodeDepth().substring(0, p.nodedepth.length() - 1).length()
                                >=
                                nodedepth.length())
                )
                .collect(Collectors.toList());

        List<SaveFileElement> child_parents = depth_length_corrected.parallelStream()
                .filter(p -> (
                        p.getNodeDepth().substring(0, nodedepth.length() - 1))
                        .equals(
                                nodedepth.substring(0, nodedepth.length() - 1)
                        )
                )
                .collect(Collectors.toList());

        //System.out.println(child_parents);
        return child_parents;
    }

    public List getChildren() {

        int parentelement = getNodeDepthAsIntegerList().get(getNodeDepthAsIntegerList().size() - 2);
        int childelement = getNodeDepthAsIntegerList().get(getNodeDepthAsIntegerList().size() - 1);
        SaveFileElement[] children = new SaveFileElement[100000];

        SaveFileElement[] sfe_array = new SaveFileElement[Main.sfe_arraylist.size()];
        sfe_array = Main.sfe_arraylist.toArray(sfe_array);
        int counter = 0;
        for (int i = 0; i < sfe_array.length; i++) {
            if (sfe_array[i].nodelevel >= nodelevel) {
                int s = sfe_array[i].getNodeDepthAsIntegerList().get(getNodeDepthAsIntegerArray().length - 1);
                if(s==childelement) {
                    if (counter == children.length) {
                        children = addCapacity(children, 10000);
                        System.out.println("counter " + counter);
                    }
                    children[counter] = sfe_array[i];
                    counter++;
                }
            }
        }

//        SaveFileElement[] sublist1 = Main.sfe_arraylist.parallelStream()
//                .filter(p -> (
//                        p.nodelevel >= nodelevel)
//                )
//                .collect(Collectors.toList());
//
//        List<SaveFileElement> sublist2 = sublist1.parallelStream()
//                .filter(p -> (
//                        p.getNodeDepthAsIntegerList().get(getNodeDepthAsIntegerList().size() - 2).equals(parentelement))
//                )
//                .collect(Collectors.toList());
//
//                children = sublist2;

//        List<SaveFileElement> children = Main.sfe_arraylist.parallelStream()
//                .filter(p -> (
//                        p.nodelevel >= nodelevel)
//                )
//                .filter(p -> (
//                        p.getNodeDepthAsIntegerList().get(getNodeDepthAsIntegerList().size() - 2) == parentelement)
//                )
//                .filter(p -> {
//                        //System.out.println(p.getNodeDepthAsIntegerList().toString());
//                        return p.getNodeDepthAsIntegerList().get(getNodeDepthAsIntegerList().size() - 1) == childelement;
//                }
//                )
//                .collect(Collectors.toList());

        //System.out.println(children.get(0).originalnodename.toString());
        return new ArrayList<SaveFileElement>(Arrays.asList(children));
    }

    //TODO: this
    public List getChildSingles() {
        List<SaveFileElement> depth_length_corrected = Main.sfe_arraylist.parallelStream()
                .filter(p -> (
                        p.getNodeDepth().substring(0, p.nodedepth.length() - 1).length()
                                >=
                                nodedepth.length())
                )
                .collect(Collectors.toList());

        List<SaveFileElement> child_singles = depth_length_corrected.parallelStream()
                .filter(p -> (
                        p.getNodeDepth().substring(0, nodedepth.length() - 1))
                        .equals(
                                nodedepth.substring(0, nodedepth.length() - 1)
                        )
                )
                .filter(p -> (
                        p.getOpenOrClose()).equals("none"))
                .collect(Collectors.toList());

        //System.out.println(child_singles);
        return child_singles;
    }

    public static SaveFileElement[] addCapacity(SaveFileElement[] list, int amount) {
        SaveFileElement[] arr1 = new SaveFileElement[(int) (list.length + amount)];
        return arr1;
    }

    public static int[] addCapacity(int[] list, int amount) {
        int[] arr1 = new int[(int) (list.length + amount)];
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
        return "linenumber" + " = " + linenumber + " | "
                + "nodelevel" + " =  " + nodelevel + " | "
                + "nodename" + " =  " + nodename + " | "
                + "nodevalue" + " =  " + nodevalue + " | "
                + "nodeparent" + " =  " + nodeparent + " | "
                + "openorclose" + " =  " + openorclose + " | "
                + "originalnodename" + " =  " + originalnodename + " | "
                + "originalnodevalue" + " =  " + originalnodevalue + " | "
                + "nodepath" + " =  " + nodepath + " | "
                + "nodedepth" + " =  " + nodedepth + "\r\n";
    }
}