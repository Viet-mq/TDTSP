import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReadFile {
    private final String fileInput;
    private final double[][] a = new double[9][2];
    private int cnt = 0;

    public ReadFile(String file){
        this.fileInput = file;
    }

    public void inputData() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(fileInput);
        Scanner inp = new Scanner(inputStream, StandardCharsets.UTF_8);
        while (inp.hasNextLine()) {
            String temp = inp.nextLine();
            String[] item = temp.split(" ");
            for (int i = 0; i < item.length; i++) {
                //System.out.println(item[i] + " ");
                double tmp = Double.parseDouble(item[i]);
                a[cnt][i] = tmp;
            }
            cnt++;
        }
        inp.close();
    }

    public double[][] getA() {
        return a;
    }

    public String getFileInput() {
        return fileInput;
    }

    public static void main(String[] args) throws FileNotFoundException {
        double[][] b = new double[9][2];
        ReadFile rft = new ReadFile("data.txt");
        rft.inputData();
        b = rft.getA();
        //System.out.println(b.length);
        for (int i = 0; i < b.length; i++){
            System.out.print(b[i][0] + " ");
            System.out.println(b[i][1]);
        }
    }
}
