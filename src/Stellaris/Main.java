package Stellaris;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
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

import static Stellaris.XML_Node.processSfe_arraylist;

public class Main extends Application {

    //prevent multiple copies of application
    boolean allowapp = lockInstance(java.lang.System.getProperty("java.io.tmpdir") + "\\steallarislocker.tmp");

    //TODO:configure log4j
    //public static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("Log");

    public static SaveFileElement[] sfe_arraylist;
    //public static int sfe_arraylist_size = 0];
    public static ObjectCountry[] countries;
    public static ObjectStar[] stararray;
    public static ObjectPlanet[] planetarray;
    public static ObjectSpecies[] speciesarray;
    public static File savefile;
    public static final BorderPane componentLayout = new BorderPane();
    public static Stage pstage;
    public static final Comparator<SaveFileElement> name_comparator = Comparator.comparing(SaveFileElement::getNodeName);

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

        //VBox componentLayout = new VBox();
        //componentLayout.setPadding(new Insets(10, 10, 10, 10));
        Path this_path = Paths.get((current_absolute_path +"\\Art\\").toString());
        Path this_path_string = this_path.resolve("clusters_2_ritter.jpg");
        componentLayout.setStyle("-fx-background-image: url('" + this_path_string.toUri() + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: no-repeat;");

        MenuBar menuBar = getMenuBar(primaryStage,componentLayout);

        //put the vbox in the top area of the BorderPane
        componentLayout.setTop(menuBar);

        //Add the BorderPane to the Scene
        Scene appScene = new Scene(componentLayout, 1280, 768);

        //Add the Scene to the Stage
        primaryStage.setScene(appScene);
        primaryStage.show();
        pstage = primaryStage;

    }

    private void processSaveFile(Stage s) {

        File result_file;
        List<String> level_list = new ArrayList<String>();
        List<String> parentList = new ArrayList<String>();

        try {
            savefile = FileProcessor.openSaveFile(s);
            if(!(savefile == null)) {
                FileProcessor.backupFile(savefile);
                FileProcessor.unZipIt(savefile.getPath(), savefile.getPath().replace(savefile.getName(), ""));
                File filetoprocess = new File(savefile.getPath().replace(savefile.getName(), "") + File.separator + "temp" + File.separator + "gamestate");
                FileProcessor.createXmlFileAndDb(filetoprocess);
                processSfe_arraylist();
                FileProcessor.createTempFileofArray(1,10000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MenuBar getMenuBar(Stage primaryStage, BorderPane componentLayout){
        final Menu fileMenu = new Menu("File");
        MenuItem openMenuItem = new MenuItem("Open");

        //MenuItem saveMenuItem = new MenuItem("Save");

        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(actionEvent -> shutdown());

        fileMenu.getItems().addAll(openMenuItem, new SeparatorMenuItem(), exitMenuItem);
        final Menu optionsMenu = new Menu("Options");

        openMenuItem.setOnAction((event) -> {

                processSaveFile(primaryStage);
            if(!(savefile==null)) {
                componentLayout.setCenter(DisplayEditor.creatTable());
            }
        });

//        saveMenuItem.setOnAction((event) -> {
//            FileProcessor.zipIt(savefile);
//            //componentLayout.getChildren().add(EditorDisplay.creatTable());
//        });

        final Menu aboutMenu = new Menu("Help");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, optionsMenu, aboutMenu);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        return menuBar;
    }

    //only one instance of program at a time
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
            System.out.println("lock file error");
            e.printStackTrace();
            //logger.error("Unable to create and/or lock file: " + lockFile, e);
        }
        return false;
    }



    private void shutdown() {
        Platform.exit();
    }

//    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
//        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
//        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
//    }
}
