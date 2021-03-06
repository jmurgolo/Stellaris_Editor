package Stellaris;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static Stellaris.Main.pstage;
import static Stellaris.Main.sfe_arraylist;
import static Stellaris.Utilities.fillSfeArrayList;
import static Stellaris.Utilities.main_Progress_Bar;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Created by jmm on 6/1/2016.
 */
public class FileProcessor {

    public static File openSaveFile(Stage primaryStage) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File directorylocation = new File("C:\\Users\\jmm\\Documents\\Paradox Interactive\\Stellaris\\save games");
        if(!directorylocation.canRead()) {
            String currentDir = System.getProperty("user.home");
            fileChooser.setInitialDirectory(new File(currentDir));
        } else {
            fileChooser.setInitialDirectory(directorylocation);
        }
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        new FileChooser.ExtensionFilter("Text Files", "*.sav", "*.txt");
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        return selectedFile;
    }

    public static File backupFile(File f) {
        if (f != null) {
            Path copy_from_1 = Paths.get(f.getPath().replace(f.getName(), ""), f.getName());
            Path copy_to_1 = Paths.get(f.getPath().replace(f.getName(), ""), copy_from_1.getFileName().toString().replace(".sav", ".bak").replace(".txt", ".bak"));
            try {
                Files.copy(copy_from_1, copy_to_1, REPLACE_EXISTING, COPY_ATTRIBUTES, NOFOLLOW_LINKS);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return f;
        //TODO:get the unzipped files and choose the one I need
    }

    public static void createXmlFileAndDb(File file) {

        String f = file.getPath();
        long startTime = System.nanoTime();
        BufferedReader rd = null;
        //boolean last = false;
        int filelinecount = 0;
        int counter = 1;

        try {
            rd = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"), 1024);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            filelinecount = countLines(f);
            sfe_arraylist = new SaveFileElement[filelinecount];
            fillSfeArrayList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JProgressBar progressBar = main_Progress_Bar(0, filelinecount, "Processing Save File", pstage);

        try {
            if (rd != null) {
                String temp = "";
                XML_Node object_xmlnode = new XML_Node();
                while ((temp = rd.readLine()) != null) {
                    sfe_arraylist[counter-1].linenumber = counter;
                    sfe_arraylist[counter-1].originalnodevalue = temp;
                    progressBar.setValue(counter);
                    //progressBar.setString(object_xmlnode.line_text);
                    counter++;
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        progressBar.setVisible(false);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        //System.out.println("File Processed" + " Duration: " + (double) duration / 1000000000.0);
    }

    public static int countLines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }

    public static File createFile(String filename) {
        File f = null;
        boolean bool = false;
        try {
            // create new file
            f = new File(filename);
            // tries to create new file in the system
            bool = f.createNewFile();
            //System.out.println("File created: " + bool);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static void unZipIt(String zipFile, String outputFolder) throws IOException, ArchiveException {

        //create output directory is not exists
        File folder = new File(outputFolder + File.separator + "temp");
        if (!folder.exists()) {
            folder.mkdir();
        }

        List<File> archiveContents = new ArrayList<File>();
        FileInputStream fistream = new FileInputStream(zipFile);
        BufferedInputStream bistream = new BufferedInputStream(fistream);
        ArchiveInputStream ais = new ArchiveStreamFactory().createArchiveInputStream(bistream);

        ZipArchiveEntry entry = (ZipArchiveEntry) ais.getNextEntry();
        while (entry != null) {
            File tmpFile = null;
            File outputFile = new File(tmpFile, entry.getName());   // don't do this anonymously, need it for the list
            OutputStream os = new FileOutputStream(outputFolder + File.separator + "temp" + File.separator + outputFile);

            IOUtils.copy(ais, os);  // copy from the archiveinputstream to the output stream
            os.close();     // close the output stream

            archiveContents.add(outputFile);

            entry = (ZipArchiveEntry) ais.getNextEntry();
        }
        ais.close();
        fistream.close();
    }

    public static void zipIt(File zipFile) {

        try {
            OutputStream zipOutput = new FileOutputStream(new File(zipFile.getPath() + ".zip"));
            ZipArchiveOutputStream logicalZip = new ZipArchiveOutputStream(zipOutput);
            //logicalZip.setLevel(5);
            logicalZip.setMethod(ZipArchiveOutputStream.DEFLATED);
            logicalZip.setLevel(5);

            List<String> fileList;
            final String SOURCE_FOLDER = zipFile.getPath().replace(zipFile.getName(), "") + "temp" + File.separator;
            fileList = new ArrayList<String>();
            generateFileList(new File(SOURCE_FOLDER), fileList, SOURCE_FOLDER);

            for (String file : fileList) {
                System.out.println(SOURCE_FOLDER + file);
                logicalZip.putArchiveEntry(new ZipArchiveEntry(file));
                IOUtils.copy(new FileInputStream(new File(SOURCE_FOLDER + file)), logicalZip);
                logicalZip.closeArchiveEntry();
            }

            logicalZip.finish();
            zipOutput.close();
            logicalZip.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            //return null;
        }
    }

    /**
     * Traverse a directory and get all files,
     * and add the file into fileList
     *
     * @param node file or directory
     */
    public static void generateFileList(File node, List<String> fileList, String SOURCE_FOLDER) {

        //add file only
        if (node.isFile()) {
            fileList.add(generateZipEntry(node.getAbsoluteFile().toString(), SOURCE_FOLDER));
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename : subNote) {
                generateFileList(new File(node, filename), fileList, SOURCE_FOLDER);
            }
        }

    }

    /**
     * Format the file path for zip
     *
     * @param file file path
     * @return Formatted file path
     */
    private static String generateZipEntry(String file, String SOURCE_FOLDER) {
        return file.substring(SOURCE_FOLDER.length(), file.length());
    }

    public static void createTempFileofArray() {
        File tempfile = FileProcessor.createFile("temp.html");
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempfile), "utf-8"))) {
            writer.write("<table>");
            writer.write("<tr><td style='min-width:100px' >" + "linenumber"
                    + "</td><td style='min-width:100px'>" + "nodelevel"
                    + "</td><td style='min-width:100px'>" + "nodeparent"
                    + "</td><td style='min-width:100px'>" + "openorclose"
                    + "</td><td style='min-width:100px'>" + "nodename"
                    + "</td><td style='min-width:100px'>" + "nodevalue"
                    + "</td><td style='min-width:200px'>" + "originalnodevalue"
                    + "</td><td style='min-width:200px'>" + "nodedepth");
            for (int i = 0; i < sfe_arraylist.length; i++) {
                writer.write("<tr><td style='min-width:100px' >" + sfe_arraylist[i].linenumber
                        + "</td><td style='min-width:100px'>" + sfe_arraylist[i].nodelevel
                        + "</td><td style='min-width:100px'>" + sfe_arraylist[i].nodeparent
                        + "</td><td style='min-width:100px'>" + sfe_arraylist[i].openorclose
                        + "</td><td style='min-width:100px'>" + sfe_arraylist[i].nodename
                        + "</td><td style='min-width:100px'>" + sfe_arraylist[i].nodevalue
                        + "</td><td style='min-width:200px'>" + sfe_arraylist[i].originalnodevalue
                        + "</td><td style='min-width:200px'>" + sfe_arraylist[i].nodedepth + "</td></tr>");
            }
            writer.write("</table>");
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public static void createTempFileofArray(int startlinenumber, int endlinenumber) {
        File tempfile = FileProcessor.createFile("temp.html");
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempfile), "utf-8"))) {
            //ResultSet results = edb.selectRows("select * from main");
            writer.write("<table>");
            writer.write("<tr><td style='min-width:100px' >" + "linenumber"
                    + "</td><td style='min-width:100px'>" + "nodelevel"
                    + "</td><td style='min-width:100px'>" + "nodeparent"
                    + "</td><td style='min-width:100px'>" + "openorclose"
                    + "</td><td style='min-width:100px'>" + "nodename"
                    + "</td><td style='min-width:100px'>" + "nodevalue"
                    + "</td><td style='min-width:200px'>" + "originalnodevalue"
                    + "</td><td style='min-width:200px'>" + "nodedepth");
            for (int i = 0; i < sfe_arraylist.length; i++) {
                if (sfe_arraylist[i].getLineNumber() >= startlinenumber && sfe_arraylist[i].getLineNumber() <= endlinenumber) {
                    writer.write("<tr><td style='min-width:100px' >" + sfe_arraylist[i].linenumber
                            + "</td><td style='min-width:100px'>" + sfe_arraylist[i].nodelevel
                            + "</td><td style='min-width:100px'>" + sfe_arraylist[i].nodeparent
                            + "</td><td style='min-width:100px'>" + sfe_arraylist[i].openorclose
                            + "</td><td style='min-width:100px'>" + sfe_arraylist[i].nodename
                            + "</td><td style='min-width:100px'>" + sfe_arraylist[i].nodevalue
                            + "</td><td style='min-width:200px'>" + sfe_arraylist[i].originalnodevalue
                            + "</td><td style='min-width:200px'>" + sfe_arraylist[i].nodedepth + "</td></tr>");
                }
            }
            writer.write("</table>");
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }


    public boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }
}

//writer.write(object_xmlnode.node);
//writer.write("<original_text>" + object_xmlnode.xmlarized_original_text + "</original_text>" + java.lang.System.getProperty("line.separator"));

//try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\jmm\\Google Drive\\Stellaris_Manager\\savegamefiles\\2252.09.11\\filename.xml"), "utf-8"))) {
//writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//writer.write(java.lang.System.getProperty("line.separator") + "<savefile>" + java.lang.System.getProperty("line.separator"));

//writer.write("</savefile>");
//writer.close();

//java.lang.System.out.println(filelinecount);
//java.lang.System.out.println(counter);
//java.lang.System.out.println(last);

//} catch (IOException e) {
//    e.printStackTrace();
//}

// parse an XML document into a DOM tree
//        DocumentBuilder parser = null;
//        try {
//            parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }
//        Document document = null;
//        try {
//            document = parser.parse(new File("C:\\Users\\jmm\\Google Drive\\Stellaris_Manager\\savegamefiles\\2252.09.11\\filename.xml"));
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //THANKS!!! - http://stackoverflow.com/questions/7249316/creating-xml-schema-from-url-works-but-from-local-file-fails
//        // create a SchemaFactory capable of understanding WXS schemas
//        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//
//        // load a WXS schema, represented by a Schema instance
//        Source schemaFile = new StreamSource(new File("C:\\Users\\jmm\\Google Drive\\Stellaris_Manager\\savegamefiles\\2252.09.11\\XMLSchema.xsd"));
//        Schema schema = null;
//        try {
//            schema = factory.newSchema(schemaFile);
//        } catch (SAXException e) {
//            e.printStackTrace();
//        }
//
//        // create a Validator instance, which can be used to validate an instance document
//        Validator validator = schema.newValidator();
//
//        // validate the DOM tree
//        try {
//            try {
//                validator.validate(new DOMSource(document));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (SAXException e) {
//            // instance document is invalid!
//        }
//
//        try {
//            assert rd != null;
//            rd.close();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }