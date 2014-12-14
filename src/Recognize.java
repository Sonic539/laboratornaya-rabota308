import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Recognize {





    static char[][] table;
    static int[][] table1;
    static int w_tot = 0, h_tot = 0;
    static int h = -1, w = -1;


    public static void main(String[] args) throws IOException {
    String file = args[0];
    READ(file);
    for (int y = 0; y < h_tot; y++) {
        boolean withnull = false;
        for (int x = 0; x < w_tot; x++) {
            if (table[y][x] == '0')
                withnull = true;
        }
        if (withnull == false)
            h++;
    }
    for (int x = 0; x < w_tot; x++) {
        boolean withnull = false;
        for (int y = 0; y < h_tot; y++) {
                if (table[y][x] == '0') withnull = true;
        }if (withnull ==false){
            w++;
        }}

    table1 = new int[h][w];
    getmarked();





        for (int i = 0; i < h; i++) {
            String s = "";
            for (int j = 0; j < w; j++) {
                s += table1[i][j];
            }System.out.println("0x" + Integer.toHexString(Integer.parseInt(s, 2)));
        }
    }




    static void getmarked() {
        int cell_w = ((w_tot - 1) / w) - 1, cell_h = ((h_tot - 1) / h) - 1;
        for (int y = 0; y < h; y++) {
        for (int x = 0; x < w; x++) {
        for (int cell_y = 0; cell_y < cell_h; cell_y++) {
        for (int cell_x = 0; cell_x < cell_w; cell_x++) {
                        int l = cell_y + 1 + (1 + cell_h) * (y);
                        int c = cell_x + 1 + (1 + cell_w) * (x);

                        if (table[l][c] == '1') table1[y][x] = 1;
        }}}}
    }



    static void READ(String file) throws IOException {
        String line;
        int i = 0;
        BufferedReader rdr = new BufferedReader(new InputStreamReader((new FileInputStream(file)), Charset.forName("UTF-8")));
        while ((line = rdr.readLine()) != null) {
            if (i == 1) {
                h_tot = Integer.parseInt(line.split(" ")[0]);
                w_tot = Integer.parseInt(line.split(" ")[1]);
                table = new char[h_tot][w_tot];
            } else if (i > 1) {
                table[i - 2] = line.toCharArray();
            }
            i++;
        }
        rdr.close();
    }

}
