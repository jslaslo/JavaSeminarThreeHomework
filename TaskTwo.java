import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.*;

public class TaskTwo {
    public static void main(String[] args) {
        int[] arr = {9, 4, 8, 3, 1};
        sort(arr);
    }
    public static void sort(int[] arr) {
        try (FileWriter writer = new FileWriter("log.txt")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String times;
            for (int i = arr.length - 1; i > 0; i--){
                for (int j = 0; j < i; j++){
                    if(arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
                times = sdf.format(new Date());
                writer.write(times + " " + Arrays.toString(arr) + System.lineSeparator());
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}


