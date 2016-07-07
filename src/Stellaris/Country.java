package Stellaris;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmm on 6/26/2016.
 */
public class Country {

    private int arraystart;
    private int arrayend;

    private String id;
    private List<String> surveyed = new ArrayList<>();
    private String nodedepth;
    private List<SaveFileElement> countrynodes = new ArrayList<>();
    private List<StellarObject> surveyedobjects = new ArrayList<>();

    public void Country(List<SaveFileElement> list){
        countrynodes = list;
    }

    public void setCountry(int s, int e) {
        arraystart = s;
        arrayend = e;
    }

    public void setEnd(int e) {

        arrayend = e;
    }

    public void setId(String s){

        id = s;
    }

    public void setCountryNodes(List<SaveFileElement> list) {

        countrynodes = list;
    }

    @Override
    public String toString() {
        return "id" + " = " + id + " | "
                + "countrynodes" + " =  " + countrynodes.toString() + " | "
//                + "countrynodes" + " =  " + countrynodes.toString() + " | "
//                + "nodevalue" + " =  " + nodevalue + " | "
//                + "nodeparent" + " =  " + nodeparent + " | "
//                + "openorclose" + " =  " + openorclose + " | "
//                + "originalnodename" + " =  " + originalnodename + " | "
//                + "originalnodevalue" + " =  " + originalnodevalue + " | "
//                + "nodepath" + " =  " + nodepath + " | "
//                + "nodedepth" + " =  " + nodedepth
                + "\r\n";
    }











//    public String getName() {
//        List<SaveFileElement> countries_names = Main.sfe_arraylist.parallelStream()
//                .filter(p -> (
//                        p.getLineNumber() >= arraystart))
//                .filter(p -> (
//                        p.getLineNumber() <= arrayend))
//                .filter(p -> (
//                        p.nodename).equals("name")
//                ).filter(p -> (
//                        p.getOpenOrClose()).equals("none"))
//                .filter(p -> (
//                        p.nodelevel == 2))
//                .collect(Collectors.toList());
//
//        name = countries_names.get(0).getOriginalNodeValue().substring(2, countries_names.get(0).originalnodevalue.length() - 1);
//        return countries_names.get(0).getOriginalNodeValue().substring(2, countries_names.get(0).originalnodevalue.length() - 1);
//    }

//    public String[] getSurveyed() {
//        List<SaveFileElement> countries_names = Main.sfe_arraylist.parallelStream()
//                .filter(p -> (
//                        p.getLineNumber() >= arraystart))
//                .filter(p -> (
//                        p.getLineNumber() <= arrayend))
//                .filter(p -> (
//                        p.nodeparent).equals("surveyed")
//                ).filter(p -> (
//                        p.getOpenOrClose()).equals("none"))
//                .collect(Collectors.toList());
//        if (countries_names.size() > 0) {
//            //surveyed.addAll(Arrays.asList(countries_names.get(0).getOriginalNodeValue().split(" ")));
//            //System.out.println("stellarobjects array: ");
//            //printArray(countries_names.get(0).getOriginalNodeValue().split(" "));
//            Collections.addAll(surveyed, countries_names.get(0).getOriginalNodeValue().split(" "));
//            //getSurveyedObjects();
//            return countries_names.get(0).getOriginalNodeValue().split(" ");
//        } else {
//            return null;
//        }
//    }

//    public void getSurveyedObjects() {
//        List<SaveFileElement> object_names = Main.sfe_arraylist.parallelStream()
//                .filter(p -> (
//                        p.nodeparent).equals("galactic_object")
//                ).filter(p -> (
//                        p.getOpenOrClose()).equals("open"))
//                .collect(Collectors.toList());
//
//        for (int i = 0; i < object_names.size(); i++) {
//            if(surveyed.contains(surveyedobjects.get(i).getId())) {
//                surveyedobjects.add(new StellarObject());
//                surveyedobjects.get(i).setObject(object_names.get(i).getChildren());
//                System.out.println(surveyedobjects.get(i).getName());
//            }
//        }
//
//        if (surveyedobjects.size() > 0) {
//            //System.out.println(" surveyed objs: " + surveyedobjects.toString());
////            return surveyedobjects.toArray();
//        }
////        else{
////            return null;
////        }
//    }


}
