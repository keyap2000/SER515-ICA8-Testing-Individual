import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;

class urinalsTest {

    @Test
    void main() throws FileNotFoundException {
        urinals u = new urinals();
        ReadInput r = new ReadInput();
        CountUrinals cu = new CountUrinals("10010");
        System.out.println("before calling");
        int actual = cu.countUrinals();
        int expected = 0;
        System.out.println("actual : " + actual);
        System.out.println("expected : " + expected);
        Assert.assertEquals(expected, actual);
    }
}