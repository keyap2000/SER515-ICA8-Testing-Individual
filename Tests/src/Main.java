import org.testng.annotations.Test;
import org.junit.Assert;
import java.io.FileNotFoundException;

public class Main {

    @Test
    public void firstTest() {
        Assert.assertTrue(true);
    }

    public static void main(String[] args) throws FileNotFoundException {
        urinals u = new urinals();
        ReadInput r = new ReadInput();
    }
}