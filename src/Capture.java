import java.util.Random;

public class Capture {

    static int[][] table;
    static boolean[][] table1;
    static int h = 0, w = 0;
    static int cell_h = 1,cell_w = 1, w_total, h_total;

    public static void main(String[] args) {
        cell_h = Integer.parseInt(args[0]);
        cell_w = Integer.parseInt(args[1]);

        h = Integer.parseInt(args[2]);
        w = Integer.parseInt(args[3]);

    table1 = new boolean[h][w];

    for (int y = 0; y < h; y++) {
        String p = Integer.toBinaryString(Integer.parseInt(args[4 + y].replace("0x", ""), 16));
        int pos = p.length();
        table1[y][w - pos] = true;
    }


    Table();



    System.out.println("P1");
        System.out.println(w_total + " " + h_total);
        for (int[] y : table) {
            for (int x : y) {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    static final Random r = new Random();
    private static void Table() {
   w_total = w * (cell_w + 1) + 1;
   h_total = h * (cell_h + 1) + 1;
   table = new int[h_total][w_total];

   for (int i = 0; i < w_total; i++) {
       for (int i1 = 0; i1 < h_total; i1++) {
           table[i1][i] = 1;
            }
        }


for (int y = 0; y < h; y++) {

for (int x = 0; x < w; x++) {


    int[][] cell = new int[cell_h][cell_w];



    if (table1[y][x]) {
        int a = cell_w * cell_h; int s = r.nextInt(a - 1);
        cell[s / cell_w][s % cell_h] = 1;
    }

    for (int cell_y = 0; cell_y < cell_h; cell_y++) {
        for (int cell_x = 0; cell_x < cell_w; cell_x++) {
        int var = cell[cell_y][cell_x];

        int l = cell_y + 1 + (1 + cell_h) * (y);
        int c = cell_x + 1 + (1 + cell_w) * (x);

        table[l][c] = var;
                    }
                }
            }
        }}}