package Stellaris;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import static Stellaris.Utilities.main_Progress_Bar;
import static Stellaris.XML_Node.processSfe_arraylist;

public class Main extends Application {

    //prevent multiple copies of application
    boolean allowapp = lockInstance(java.lang.System.getProperty("java.io.tmpdir") + "\\steallarislocker.tmp");

    //TODO:configure log4j
    //public static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("Log");

    public static SaveFileElement[] sfe_arraylist;
    public static int sfe_arraylist_size = 0;
    public static Country[] countries;
    public static StellarObject[] stellarobjects;

    public static final Comparator<SaveFileElement> name_comparator = Comparator.comparing(SaveFileElement::getNodeName);

    //private ListView<String> systems_objects = new ListView<>();
    //private ObservableList<String> systems_items = FXCollections.observableArrayList("");
    //private ListView<String> TopNodeElements = new ListView<>();

    Path current_relative_path = Paths.get("");
    String current_absolute_path = current_relative_path.toAbsolutePath().toString();

    //TODO: CLEAR ARRAY AND GUI ON NEW FILE OPEN

    public Main() throws IllegalAccessException, ClassNotFoundException {
        if (!allowapp) {
            java.lang.System.exit(0);
        }
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Stellaris Save Game Editor");

        VBox componentLayout = new VBox();
        //componentLayout.setPadding(new Insets(10, 10, 10, 10));
        Path this_path = Paths.get((current_absolute_path +"\\Art\\").toString());
        Path this_path_string = this_path.resolve("clusters_2_ritter.jpg");
        componentLayout.setStyle("-fx-background-image: url('" + this_path_string.toUri() + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: no-repeat;");

        MenuBar menuBar = getMenuBar(primaryStage, componentLayout);

        //put the vbox in the top area of the BorderPane
        componentLayout.getChildren().add(menuBar);
        //VBox vbox = new VBox();

        //componentLayout.getChildren().add(vbox);

        //Add the BorderPane to the Scene
        Scene appScene = new Scene(componentLayout, 1280, 768);

        //Add the Scene to the Stage
        primaryStage.setScene(appScene);
        primaryStage.show();
    }

    private void processSaveFile(Stage s) {

        File result_file;
        List<String> level_list = new ArrayList<String>();
        List<String> parentList = new ArrayList<String>();

        try {
            result_file = FileProcessor.openSaveFile(s);
            FileProcessor.backupFile(result_file);
            FileProcessor.unZipIt(result_file.getPath(), result_file.getPath().replace(result_file.getName(), ""));
            FileProcessor.createXmlFileAndDb(result_file);
            //TODO: SPECIFY FILE LOCATIONS

            int rows = 0;
            try {

                //filter and get distinct elements for top observable list
//                List<SaveFileElement> zero_level = sfe_arraylist.stream().filter(p -> p.nodelevel == 1).filter(p -> p.openorclose == "open").sorted(name_comparator).filter(new Predicate<SaveFileElement>() {
//                    SaveFileElement previous;
//
//                    public boolean test(SaveFileElement p) {
//                        if (previous != null && name_comparator.compare(previous, p) == 0)
//                            return false;
//                        previous = p;
//                        return true;
//                    }
//                }).collect(Collectors.toList());

                JProgressBar progressbar = main_Progress_Bar(0, rows, "Filling GUI");
//                for (int i = 0; i < zero_level.size(); i++) {
//                    parentList.add(i, zero_level.get(i).nodename);
//                    progressbar.setValue(i);
//                    progressbar.setString(zero_level.get(i).nodename);
//                }

                progressbar.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        processSfe_arraylist();
        FileProcessor.createTempFileofArray(); //603688,603695); //"nodename","name");
    }

//    private void getCountries() {
//        //get the country node
//        List<SaveFileElement> countriesnodes = Main.sfe_arraylist.parallelStream()
//                .filter(p -> p.nodeparent.equals("country"))
//                .filter(p -> p.openorclose.equals("open"))
//                .collect(Collectors.toList());
//
//        List<SaveFileElement> country = new ArrayList<SaveFileElement>();
//        for (int i = 0 ; i < countriesnodes.size() ; i++) {
//            System.out.println("c: " + countriesnodes.get(i).nodename);
//            country = countriesnodes.get(i).getChildren();
////            countries.add(new Country());
////            countries.get(i).setCountry(countriesnodes.get(i).getLineNumber(),country.get(country.size()-1).getLineNumber());
////            countries.get(i).setId(countriesnodes.get(i).originalnodename);
//        }
//    }

//    private void getStellarObjects() {
//        //get the country node
//        List<SaveFileElement> stellarobjectsnodes = Main.sfe_arraylist.parallelStream()
//                .filter(p -> p.nodeparent.equals("galactic_object"))
//                .filter(p -> p.openorclose.equals("open"))
//                .collect(Collectors.toList());
//
//        List<SaveFileElement> stellarobject = new ArrayList<SaveFileElement>();
//        for (int i = 0 ; i < stellarobjectsnodes.size() ; i++) {
//            System.out.println("so: " + stellarobjectsnodes.get(i).nodename);
//            stellarobject = stellarobjectsnodes.get(i).getChildren();
//            stellarobjects.add(new StellarObject());
////            stellarobjects.get(i).setStellarObject(stellarobjectsnodes.get(i).getLineNumber(),stellarobject.get(stellarobject.size()-1).getLineNumber());
////            stellarobjects.get(i).setId(stellarobjectsnodes.get(i).originalnodename);
//        }
//    }

//    private List<String> getCountryNames() {
//
//        String[] countryList = new String[];
//
//        //strip off equal sign and quotes
//        countryList.addAll(countries.parallelStream().map(countries -> countries.getName()).collect(Collectors.toList()));
//        return countryList;
//    }

    private MenuBar getMenuBar(Stage primaryStage, VBox componentLayout){
        final Menu fileMenu = new Menu("File");
        MenuItem openMenuItem = new MenuItem("Open");

        MenuItem saveMenuItem = new MenuItem("Save");

        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(actionEvent -> shutdown());

        fileMenu.getItems().addAll(openMenuItem, saveMenuItem, new SeparatorMenuItem(), exitMenuItem);
        final Menu optionsMenu = new Menu("Options");

        openMenuItem.setOnAction((event) -> {
            //TODO: fix error when x-ing out of file menu without selecting file
            processSaveFile(primaryStage);
            componentLayout.getChildren().add(EditorDisplay.creatTable());
        });
        //todo:why is this failing
        //stellar_menu_item.setDisable(true);

        final Menu aboutMenu = new Menu("Help");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, optionsMenu, aboutMenu);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        return menuBar;
    }

    private static boolean lockInstance(final String lockFile) {
        try {
            final File file = new File(lockFile);
            final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            final FileLock fileLock = randomAccessFile.getChannel().tryLock();
            if (fileLock != null) {
                Runtime.getRuntime().addShutdownHook(new Thread() {
                    public void run() {
                        try {
                            fileLock.release();
                            randomAccessFile.close();
                            file.delete();
                        } catch (Exception e) {
                            e.printStackTrace();
                            //logger.error("Unable to remove lock file: " + lockFile, e);
                        }
                    }
                });
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //logger.error("Unable to create and/or lock file: " + lockFile, e);
        }
        return false;
    }



    private void shutdown() {
        Platform.exit();
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
