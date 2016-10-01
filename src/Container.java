import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by HOME on 29.09.2016.
 */

@SaveTo(path = "c:\\file.txt")
public class Container {

    String text = "Hello from task 1";

    @Saver
    public void Save(){
        Class<?> container = Container.class;
        SaveTo saveTo = container.getAnnotation(SaveTo.class);
        TextContainer textContainer = new TextContainer();
        textContainer.setSomeString(text);
        String path = saveTo.path();

        FileWriter writeFile = null;
        try {
            File logFile = new File(path);
            writeFile = new FileWriter(logFile);
            writeFile.write(textContainer.getSomeString());
            System.out.println("File wrote sucessfully");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writeFile != null) {
                try {
                    writeFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
