
import java.io.FileWriter;
import java.io.IOException;

public class NewClass {

    private FileWriter out;

    public NewClass() {
        try {
            out = new FileWriter("LPT1");

            out.write("----------------------------------------");
            out.write(13);
            out.write(10);
            out.write("TES PRINT");

            out.write(13);

            out.write(10);
            out.write("----------------------------------------");
            out.write(13);

            out.write(10);

            out.close();
        } catch (IOException e) {
        }

    }

}
