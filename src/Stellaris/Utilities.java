package Stellaris;

import javafx.beans.property.StringProperty;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Arrays;

import static Stellaris.Main.sfe_arraylist;

/**
 * Created by jmm on 6/30/2016.
 */
public class Utilities {

    public static void printArray(int[] anArray) {
        for (int i = 0; i < anArray.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(anArray[i]);
        }
        System.out.println("\r\n");
    }

    public static void printArray(String[] anArray) {
        for (int i = 0; i < anArray.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(anArray[i]);
        }
        System.out.println("\r\n");
    }

    public static int notBetween(String inme, String findme) {
        int findinmematches = 0;
        if (inme.contains(findme)) {
            findinmematches = StringUtils.countMatches(inme, findme);
            String[] valuesInQuotes = StringUtils.substringsBetween(inme, "\"", "\"");
            if (valuesInQuotes != null) {
                for (int i = 0; i < valuesInQuotes.length; i++) {
                    findinmematches = findinmematches - (int) StringUtils.countMatches(valuesInQuotes[i], findme);
                }
            }
        }
        return findinmematches;
    }

    public static void fillSfeArrayList() {
        for (int i = 0 ; i < sfe_arraylist.length ; i ++) {
            sfe_arraylist[i] = new SaveFileElement();
        }
    }

    public static Integer[] addArrayCapacity(Integer[] list, int amount) {
        Integer[] arr1 = new Integer[(int) (list.length + amount)];
        for (int i = 0; i < list.length; i++) {
            arr1[i] = list[i];
        }
        return arr1;
    }

    public static SaveFileElement[] addArrayCapacity(SaveFileElement[] list, int amount) {
        SaveFileElement[] arr1 = new SaveFileElement[(int) (list.length + amount)];
        for (int i = 0; i < list.length; i++) {
            arr1[i] = list[i];
        }
//        arr1[arr1.length-1] = new SaveFileElement();
        return arr1;
    }

    public static ObjectPlanet[] addArrayCapacity(ObjectPlanet[] list, int amount) {
        ObjectPlanet[] arr1 = new ObjectPlanet[(int) (list.length + amount)];
        for (int i = 0; i < list.length; i++) {
            arr1[i] = list[i];
        }
        return arr1;
    }

    static SaveFileElement[] addElement(SaveFileElement[] originalarray, SaveFileElement elementcontents, int e) {
        SaveFileElement[] a  = Arrays.copyOf(originalarray, originalarray.length + 1);
        int i = 0;
        for (i = 0 ; i < e; i++){
            a[i] = originalarray[i];
        }

        a[i] = elementcontents;

        for (i = i ; i < originalarray.length; i++){
            a[i+1] = originalarray[i];
        }
        return a;
    }

    public static void addArrayCapacity(int amount) {
        SaveFileElement[] arr1 = new SaveFileElement[(int) (sfe_arraylist.length + amount)];
        for(int i = sfe_arraylist.length ; i < arr1.length ; i ++){
            arr1[i] = new SaveFileElement();
        }
        System.arraycopy(sfe_arraylist, 0, arr1, 0, sfe_arraylist.length);
        sfe_arraylist = arr1;
    }

    public static Integer[] removeArrayCapacity(Integer[] original, int element) {
        Integer[] n = new Integer[original.length - 1];
        System.arraycopy(original, 0, n, 0, element);
        System.arraycopy(original, element + 1, n, element, original.length - element - 1);
        return n;
    }

    public static String[] removeArrayCapacity(String[] original, int element) {
        String[] n = new String[original.length - 1];
        System.arraycopy(original, 0, n, 0, element);
        System.arraycopy(original, element + 1, n, element, original.length - element - 1);
        return n;
    }

    public static StringProperty[] addArrayCapacity(StringProperty[] list, int amount) {
        StringProperty[] arr1 = new StringProperty[(int) (list.length + amount)];
        for (int i = 0; i < list.length; i++) {
            arr1[i] = list[i];
        }
        return arr1;
    }

    public static JProgressBar main_Progress_Bar(int start, int end, String title, Stage stage) {
        JProgressBar progressBar = new JProgressBar(start, end);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        javax.swing.border.Border border = BorderFactory.createTitledBorder("Reading...");
        progressBar.setBorder(border);
        JFrame frame = new JFrame(title);
        Container content = frame.getContentPane();

        frame.setSize(600, 100);
        Double xpos = ((stage.getX() + stage.getWidth() / 2) - frame.getWidth() / 2);
        Double ypos = ((stage.getY() + stage.getHeight() / 2) - frame.getHeight() / 2);

        frame.setLocation(xpos.intValue(),ypos.intValue());

        content.add(progressBar, BorderLayout.NORTH);
        //frame.setLocationRelativeTo(null);


        frame.setVisible(true);
        progressBar.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            public void componentHidden(ComponentEvent e) {
                frame.dispose();
            }
        });
        return progressBar;
    }


    public static void print(String s ){
        System.out.println(s);
    }

}
