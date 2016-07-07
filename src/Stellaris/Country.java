package Stellaris;

import java.util.Arrays;

/**
 * Created by jmm on 6/26/2016.
 */
public class Country {

    private String id;
    private String name;
    private SaveFileElement[] countrynodes;
    private String[] surveyedobjects;

    public void Country(SaveFileElement[] list){

        countrynodes = list;
    }

    public void setId(String s){

        id = s;
    }

    public void setCountryNodes(SaveFileElement[] list) {

        countrynodes = list;
        getName();
        getSurveyed();
    }

    public String returnName() {
        return name;
    }

    private void getName() {

        String temp = "none";
        int counter = 0;

        while(!(countrynodes[counter].openorclose.equals("none") && countrynodes[counter].nodename.trim().equals("name") && countrynodes[counter].nodelevel == 3)){
            if(countrynodes.length-1 == counter) {
                break;
            }
            counter++;
        }
        if(countrynodes.length > counter && countrynodes[counter].openorclose.equals("none") && countrynodes[counter].nodename.trim().equals("name") && countrynodes[counter].nodelevel == 3) {
            temp = countrynodes[counter].getNodeValue();
        }
        name = temp.replaceAll("\"","").replaceAll("=","");
        //System.out.println("name: " + name);
    }

    private void getSurveyed() {

        String[] temp = null;
        int counter = 0;

        while(!(countrynodes[counter].openorclose.equals("open") && countrynodes[counter].nodename.trim().equals("surveyed") && countrynodes[counter].nodelevel == 4)){
            if(countrynodes.length-1 == counter) {
                break;
            }
            counter++;
        }
        if(countrynodes.length > counter && countrynodes[counter].openorclose.equals("open") && countrynodes[counter].nodename.trim().equals("surveyed") && countrynodes[counter].nodelevel == 4) {
            temp = countrynodes[counter+1].getNodeValue().split(" ");
        }
        surveyedobjects = temp;
        //System.out.println("surveyed: " + Arrays.toString(surveyedobjects));
    }

    @Override
    public String toString() {
        return "id" + " = " + id + " | "
                + "countrynodes" + " =  " + Arrays.toString(countrynodes) + " | "
                + "\r\n";
    }

    private void print(String s ){
        System.out.println(s);
    }

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
