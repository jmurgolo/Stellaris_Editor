/**
 * Created by jmm on 5/25/2016.
 */

package Stellaris;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class XML_Node {

    //static String node;
    static String xmlarized_original_text;
    static int level = 0;
    static String line_text;
    static int level_depth_array_place = 0;

    private static String node_name;
    private static String node_content;
    private static String action;
    private static String level_name[] = new String[35];
    private static String original_node_name = null;
    private static String original_node_value = null;
    private static int root_node_tracker = 0;
    private static String temp_text;
    private static List<Integer> leveldepthlist = new ArrayList<Integer>();
    private static List<Integer> previousleveldepthlist = new ArrayList<Integer>();

    XML_Node(int line, int lvl, String lt) {
        leveldepthlist.add(0);
        xmlarize(line, lvl, lt);
    }

    void xmlarize(int line, int lvl, String lt) {
       /*
       remove text in quotes.  not handling odd numbered quotes on line since doesn't seem to happen
       not handling where there will be a { or } inside and outside "" since it doesn't seem to happen
       if(valuesInQuote.indexOf("{") >= 0) {
       //System.out.println(thisLine + " " + valuesInQuote);
       }*/

        String parent = null;
        line_text = lt;
        temp_text = lt.replaceAll("'", "''");
        int level_holder = 0;

        //so I only have one insert statement but need to do a shift for the {} at condition 0
        int level_adjuster = 0;

        int check;
        //if { and } on same line
        if (notBetweenQuotes("{", temp_text) > 0 && notBetweenQuotes("}", temp_text) > 0) {
            check = 0;
        } else if (notBetweenQuotes("{", temp_text) > 0) {
            check = 1;
        } else if (notBetweenQuotes("}", temp_text) > 0) {
            check = 2;
        } else {
            check = 3;
        }

        switch (check) {
            case 0:
                getNodeInfo(temp_text);
                if (level == 0) {
                    parent = "none";
                    root_node_tracker = root_node_tracker + 1;
                    level_holder = root_node_tracker;
                } else {
                    parent = level_name[level - 1];
                }
                setTreeLimb(0);
                level_adjuster = +1;
                action = "open and close";
                //node = "<" + standardizeNodeName(node_name) + ">"
                //        + standardizeNodeName(node_content)
                //        + "</" + standardizeNodeName(node_name) + ">";
                break;
            case 1:
                getNodeInfo(temp_text);
                if (level == 0) {
                    parent = "none";
                    root_node_tracker = root_node_tracker + 1;
                    level_holder = root_node_tracker;
                } else {
                    parent = level_name[level - 1];
                    level_holder = root_node_tracker;
                }
                setTreeLimb(1);
                action = "open";
                level = level + 1;
                //node = "<" + node_name + ">";
                break;
            case 2:
                getNodeInfo(temp_text);
                parent = level_name[level - 1];
                action = "close";
                level = level - 1;
                level_holder = level;
                //node = "</" + standardizeNodeName(level_name[level]) + ">";
                setTreeLimb(-1);
                break;
            case 3:
                getNodeInfo(temp_text);
                if(level == 0) {
                    parent = "none";
                }else{
                    parent = level_name[level-1];
                }
                action = "none";
                //node = "<" + node_name + ">"
                //        + node_content
                //        + "</" + node_name + ">";
                break;
        }

        //        System.out.println(
//                " a| " + (line) + "\t"
//                        + " b| " + level_depth_array_place + "\t"
//                        + " c| " + leveldepthlist.size() + "\t"
//                        + " d| " + root_node_tracker + "\t"
//                        + " e| " + check + "\t"
//                        //+ " f| " + leveldepthlist.subList(0,level_depth_array_place+2).toString() + "\t"
//                        + " f| " + leveldepthlist.toString() + "\t"
//
//        );

        Main.sfe_arraylist.add(new SaveFileElement());
        Main.sfe_arraylist.get(Main.sfe_arraylist.size()-1).linenumber = line;
        Main.sfe_arraylist.get(Main.sfe_arraylist.size()-1).nodelevel = level + level_adjuster;
        Main.sfe_arraylist.get(Main.sfe_arraylist.size()-1).nodename = ((node_name == null) ? "" : node_name);
        Main.sfe_arraylist.get(Main.sfe_arraylist.size()-1).nodevalue = node_content;
        Main.sfe_arraylist.get(Main.sfe_arraylist.size()-1).nodeparent = parent;
        Main.sfe_arraylist.get(Main.sfe_arraylist.size()-1).openorclose = action;
        Main.sfe_arraylist.get(Main.sfe_arraylist.size()-1).originalnodename = ((original_node_name == null) ? "" : original_node_name);
        Main.sfe_arraylist.get(Main.sfe_arraylist.size()-1).originalnodevalue = original_node_value;
        Main.sfe_arraylist.get(Main.sfe_arraylist.size()-1).nodepath = level_holder;
        Main.sfe_arraylist.get(Main.sfe_arraylist.size()-1).nodedepth = leveldepthlist.toString();

//        System.out.println(
//                " a| " + (line) + "\t"
//                        + " b| " + sfe_arraylist.get(sfe_arraylist.size()-1).nodelevel + "\t"
//                        + " c| " + sfe_arraylist.get(sfe_arraylist.size()-1).nodename + "\t"
//                        + " d| " + sfe_arraylist.get(sfe_arraylist.size()-1).nodevalue + "\t"
//                        + " e| " + sfe_arraylist.get(sfe_arraylist.size()-1).nodeparent + "\t"
//                        + " f| " + sfe_arraylist.get(sfe_arraylist.size()-1).openorclose + "\t"
//        );
    }

    private static void getNodeInfo(String nn) {

        node_name="";
        node_content="";
        original_node_name="";
        original_node_value="";

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

    private static void setTreeLimb(int place) {
        int old_level_depth_array_place = level_depth_array_place;
        previousleveldepthlist = Main.sfe_arraylist.get(Main.sfe_arraylist.size()-1).getNodeDepthAsIntegerList();
        //we don't want to adjust the place permanently since it ends and begins on the same line, we just want to increment it up one here
        if (place == 0) {
            try {
                leveldepthlist.get(level_depth_array_place + 1);
            } catch (IndexOutOfBoundsException e) {
                leveldepthlist.add(0);
            }
            leveldepthlist.set(level_depth_array_place + 1, leveldepthlist.get(level_depth_array_place + 1) + 1);
        }
        else if (place == 1) {
            level_depth_array_place++;
            try {
                leveldepthlist.get(level_depth_array_place);
            } catch (IndexOutOfBoundsException e) {
                leveldepthlist.add(0);
            }
            leveldepthlist.set(level_depth_array_place, leveldepthlist.get(level_depth_array_place) + 1);
        }
        else {
            level_depth_array_place--;
            if (level_depth_array_place == 0) {
                leveldepthlist = leveldepthlist.subList(0,2);
            }
        }

        if (previousleveldepthlist.size() > level_depth_array_place && !leveldepthlist.get(level_depth_array_place).equals(previousleveldepthlist.get(level_depth_array_place))){
            for(int i = leveldepthlist.size()-1 ; i > level_depth_array_place ; i--) {
                leveldepthlist.remove(leveldepthlist.size() - 1);
            }
        }
    }

//    private static String standardizeNodeName(String nn) {
//        nn = StringUtils.replaceEach(nn, new String[]
//                        {
//                                "/"
//                                , " "
//                                , "#"
//                                , "|"
//                                , "'"
//                                , "\""
//                                , "("
//                                , ")"
//                                , "<"
//                                , ">"
//                                , "="
//                                , "{"
//                                , "}"
//                                , "\\"
//                                , "["
//                                , "]"
//                                , "\u0011"
//                        }
//                , new String[]
//                        {
//                                "_..forwardslash.._"
//                                , "_..space.._"
//                                , "_..pound.._"
//                                , "_..pipe.._"
//                                , "_..singlequote.._"
//                                , "_..doublequote.._"
//                                , "_..leftparenthesis.._"
//                                , "_..rightparenthesis.._"
//                                , "_..leftanglebracket.._"
//                                , "_..rightanglebracket.._"
//                                , "_..equalsign.._"
//                                , "_..leftsquiggle.._"
//                                , "_..rightsquiggle.._"
//                                , "_..backslash.._"
//                                , "_..leftsquarebrace.._"
//                                , "_..rightsquarebrace.._"
//                                , "_..controlcharacter.._"
//                        }
//        );
//
//        return nn;
//    }

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