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
        getId();
        getName();
        getSurveyed();
    }

    public String returnName() {
        return name;
    }
    public String[] returnSurveyed() { return surveyedobjects; }

    private void getId() {

        String temp = "none";
        int counter = 0;

        while(!(countrynodes[counter].openorclose.equals("open") && countrynodes[counter].nodeparent.trim().equals("country") && countrynodes[counter].nodelevel == 2)){
            if(countrynodes.length-1 == counter) {
                break;
            }
            counter++;
        }
        if(countrynodes.length > counter && countrynodes[counter].openorclose.equals("open") && countrynodes[counter].nodeparent.trim().equals("country") && countrynodes[counter].nodelevel == 2) {
            temp = countrynodes[counter].getNodeName();
        }
        id = temp;
        //System.out.println("id: " + id);
    }

    private void getName() {

        String temp = "none";
        int counter = 0;

        while(!(countrynodes[counter].openorclose.equals("none") && countrynodes[counter].nodename.trim().equals("name") && countrynodes[counter].nodelevel == 2)){
            if(countrynodes.length-1 == counter) {
                break;
            }
            counter++;
        }
        if(countrynodes.length > counter && countrynodes[counter].openorclose.equals("none") && countrynodes[counter].nodename.trim().equals("name") && countrynodes[counter].nodelevel == 2) {
            temp = countrynodes[counter].getNodeValue();
        }
        name = temp.replaceAll("\"","").replaceAll("=","");
        //System.out.println("name: " + name);
    }

    private void getSurveyed() {

        String[] temp = null;
        int counter = 0;

        while(!(countrynodes[counter].openorclose.equals("open") && countrynodes[counter].nodename.trim().equals("surveyed") && countrynodes[counter].nodelevel == 3)){
            if(countrynodes.length-1 == counter) {
                break;
            }
            counter++;
        }
        if(countrynodes.length > counter && countrynodes[counter].openorclose.equals("open") && countrynodes[counter].nodename.trim().equals("surveyed") && countrynodes[counter].nodelevel == 3) {
            temp = countrynodes[counter+1].getNodeValue().trim().split(" ");
        }
        surveyedobjects = temp;
        //System.out.println("surveyed: " + Arrays.toString(surveyedobjects));
    }

    @Override
    public String toString() {
        return  "id" + " =  " + id + " | "
                + "name" + " =  " + name + " | "
                + "surveyedobjects" + " =  " + Arrays.toString(surveyedobjects) + " | "
                + "\r\n";
    }


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
//                surveyedobjects.add(new Planet());
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
