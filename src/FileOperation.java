import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 17.09.2018
 */

public class FileOperation {
    public static void main(String[] args) throws IOException {
        File file = new File("file1.txt");
        newfile(file);

        File renameFile = new File("renamedFile.txt");
        rename(file, renameFile);

        File copyFile = new File("C:\\Users\\Nail\\IdeaProjects\\HomeWork15\\src\\renamedFile.txt");
        copy(renameFile, copyFile);

        File dir = new File("C:\\Users\\Nail\\IdeaProjects\\HomeWork15\\NewDir");
        makedir(dir);

        delete(renameFile.getPath());
        delete(copyFile.getPath());
        delete(dir);
    }

    private static void delete(File toDelete) {
        if (toDelete.isDirectory()) {
            File[] files = toDelete.listFiles();
            for (File file : files) {
                delete(file);
            }
        }
        toDelete.delete();
        System.out.println(toDelete.getName() + " deleted!");
    }

    private static void delete(String path) {
        File fileForDelete = new File(path);

        fileForDelete.delete();
        System.out.println(fileForDelete.getName() + " deleted!");

    }

    private static void makedir(File dir) throws IOException {
        File file;
        if(dir.mkdir()) {
            for(int i = 0; i < 3; i++ ) {
                file = new File("C:\\Users\\Nail\\IdeaProjects\\HomeWork15\\NewDir\\file" + i);
                newfile(file);
            }
            System.out.println("Directory created!");
        }
    }

    private static void copy(File renameFile, File copyFile) throws IOException {
        Files.copy(renameFile.toPath(), copyFile.toPath());
        System.out.println("Copied!");
    }

    private static void rename(File oldName, File newName) {
        if(oldName.renameTo(newName)) System.out.println("Renamed!");
    }

    private static void newfile(File file) throws IOException {
        if(file.createNewFile()) {
            System.out.println("File created");
        }

    }
}
