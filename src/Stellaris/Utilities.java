package Stellaris;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static JProgressBar main_Progress_Bar(int start, int end, String title) {
        JProgressBar progressBar = new JProgressBar(start, end);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        javax.swing.border.Border border = BorderFactory.createTitledBorder("Reading...");
        progressBar.setBorder(border);
        JFrame frame = new JFrame(title);
        Container content = frame.getContentPane();
        content.add(progressBar, BorderLayout.NORTH);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 100);
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

}
