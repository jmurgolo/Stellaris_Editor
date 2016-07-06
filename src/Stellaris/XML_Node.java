/**
 * Created by jmm on 5/25/2016.
 */

package Stellaris;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Stellaris.Main.sfe_arraylist;
import static Stellaris.Utilities.*;

class XML_Node {

    //static String node;
    static String xmlarized_original_text;
    static int level = 0;
    static String line_text;

    private static int level_depth_array_place = 0;
    private static String node_name;
    private static String node_content;
    private static String action;
    private static String level_name[] = new String[35];
    private static String original_node_name = null;
    private static String original_node_value = null;
    private static int root_node_tracker = 0;
    private static String temp_text;
    private static Integer[] leveldepthlist = new Integer[0];
    private static Integer[] previousleveldepthlist = new Integer[leveldepthlist.length];

    XML_Node(int line, int lvl, String lt) {
        leveldepthlist = addArrayCapacity(leveldepthlist, 1);
        leveldepthlist[leveldepthlist.length - 1] = 0;
        xmlarize(line, lvl, lt);
    }

    void xmlarize(int line, int lvl, String lt) {
        sfe_arraylist = addArrayCapacity(sfe_arraylist,1);
        System.out.println(sfe_arraylist.length + " " + line);
        //System.out.println(Arrays.toString(sfe_arraylist));
        sfe_arraylist[sfe_arraylist.length - 1].linenumber = line;
        sfe_arraylist[sfe_arraylist.length - 1].originalnodevalue = lt;
    }

    public static void processSfe_arraylist() {

        JProgressBar progressbar = main_Progress_Bar(0, sfe_arraylist.length, "Proccessing Nodes");
        String parent = null;
        int level_holder = 0;

        //so I only have one insert statement but need to do a shift for the {} at condition 0
        int level_adjuster = 0;

        for (int i = 0; i < sfe_arraylist.length; i++) {
            String temp_text = sfe_arraylist[i].getOriginalNodeValue();
            if (notBetween(temp_text, "{") > 0 && notBetween(temp_text, "}") > 0) {
                getNodeInfo(temp_text);
                if (level == 0) {
                    parent = "none";
                    root_node_tracker = root_node_tracker + 1;
                    level_holder = root_node_tracker;
                } else {
                    parent = level_name[level - 1];
                }
                setTreeLimb(0, i);
                level_adjuster = +1;
                action = "open and close";
            } else if (notBetween(temp_text, "{") > 0) {
                getNodeInfo(temp_text);
                if (level == 0) {
                    parent = "none";
                    root_node_tracker = root_node_tracker + 1;
                    level_holder = root_node_tracker;
                } else {
                    parent = level_name[level - 1];
                    level_holder = root_node_tracker;
                }
                setTreeLimb(1, i);
                action = "open";
                level = level + 1;
            } else if (notBetween(temp_text, "}") > 0) {
                getNodeInfo(temp_text);
                parent = level_name[level - 1];
                action = "close";
                level = level - 1;
                level_holder = level;
                setTreeLimb(-1, i);
            } else {
                getNodeInfo(temp_text);
                if (level == 0) {
                    parent = "none";
                } else {
                    parent = level_name[level - 1];
                }
                action = "none";
            }

            Main.sfe_arraylist[i].nodelevel = level + level_adjuster;
            Main.sfe_arraylist[i].nodename = ((node_name == null) ? "" : node_name);
            Main.sfe_arraylist[i].nodevalue = node_content;
            Main.sfe_arraylist[i].nodeparent = parent;
            Main.sfe_arraylist[i].openorclose = action;
            Main.sfe_arraylist[i].nodepath = level_holder;
            Main.sfe_arraylist[i].nodedepth = Arrays.toString(leveldepthlist);

            progressbar.setValue(i);
            progressbar.setString(String.valueOf(i));

        }
        progressbar.setVisible(false);
        //System.out.println(Main.sfe_arraylist.toString());

    }


    private static void getNodeInfo(String nn) {

        node_name = "";
        node_content = "";
        original_node_name = "";
        original_node_value = "";

        //make sure empty value lines get the line content as the value
        if (!nn.contains("=")) {
            original_node_name = "";
            original_node_value = nn;
        } else {
            original_node_name = StringUtils.substring(nn, 0, nn.indexOf("="));
            node_name = original_node_name;
            original_node_value = StringUtils.substring(nn, nn.lastIndexOf("="), nn.length());
        }

        //add underscore to node name for xml compatibility
        if (nn.length() >= 1 && StringUtils.isNumeric(nn.substring(0, 1)) || nn.length() <= 0) {
            nn = "_" + nn;
        }

        //if { is to the left of equal sign then node name is left of the equal sign and value to the right
        if (nn.contains("=") && (nn.indexOf("{") > nn.indexOf("="))) {
            node_name = StringUtils.substring(nn, 0, nn.indexOf("="));
            node_content = StringUtils.substring(nn, nn.lastIndexOf("{", nn.length()));
            //node_name = standardizeNodeName(StringUtils.substring(nn, 0, nn.indexOf("=")));
            //node_content = standardizeNodeName(StringUtils.substring(nn, nn.lastIndexOf("{", nn.length())));
        }
        level_name[level] = node_name;
        //xmlarized_original_text = standardizeNodeName(nn);
    }

    private static void setTreeLimb(int place, int index) {
        int old_level_depth_array_place = level_depth_array_place;
        previousleveldepthlist = sfe_arraylist[index - 1].getNodeDepthAsIntegerArray();

        //we don't want to adjust the place permanently since it ends and begins on the same line, we just want to increment it up one here
        if (place == 0) {
            //leveldepthlist.get(level_depth_array_place + 1);
            if (leveldepthlist.length - 1 < level_depth_array_place + 1 ) {
                leveldepthlist = addArrayCapacity(leveldepthlist, 1);
                leveldepthlist[leveldepthlist.length - 1] = 0;
            }
            //leveldepthlist.set(level_depth_array_place + 1, leveldepthlist.get(level_depth_array_place + 1) + 1);
            //System.out.println("j " + Arrays.toString(leveldepthlist) + " | " + leveldepthlist[level_depth_array_place]);
            leveldepthlist[level_depth_array_place + 1] = leveldepthlist[level_depth_array_place + 1] + 1;
        } else if (place == 1) {
            level_depth_array_place++;
            //leveldepthlist.get(level_depth_array_place);
            if (leveldepthlist.length - 1 < level_depth_array_place) {
                leveldepthlist = addArrayCapacity(leveldepthlist, 1);
                leveldepthlist[leveldepthlist.length - 1] = 0;
            }
            //System.out.println("j " + Arrays.toString(leveldepthlist) + " | " + leveldepthlist[level_depth_array_place]);
            leveldepthlist[level_depth_array_place] = (leveldepthlist[level_depth_array_place] + 1);
        } else {
            level_depth_array_place--;
            if (level_depth_array_place == 0) {
                Integer[] tempintegerarray = new Integer[2];
                tempintegerarray[0] = leveldepthlist[0];
                tempintegerarray[1] = leveldepthlist[1];
                leveldepthlist = tempintegerarray;
                //leveldepthlist = leveldepthlist..subList(0, 2);
                //System.out.println("j " + Arrays.toString(leveldepthlist) + " | " + leveldepthlist[level_depth_array_place]);
            }
        }

        if (previousleveldepthlist.length > level_depth_array_place){ // && !leveldepthlist[level_depth_array_place].equals(previousleveldepthlist.get(level_depth_array_place))) {
            for (int i = leveldepthlist.length - 2; i > level_depth_array_place; i--) {
                leveldepthlist = removeArrayCapacity(leveldepthlist, leveldepthlist.length - 1);
            }
        }
    }


    private static int notBetweenQuotes(String findme, String inme) {
        int char_count = StringUtils.countMatches(inme, findme);
        Pattern p = Pattern.compile("/(,)(?=(?:[^\"]|\"[^\"]*\")*$)/");
        Matcher m = p.matcher(inme);
        while (m.find()) {
            char_count = char_count - 1;
        }
        return char_count;
    }
}