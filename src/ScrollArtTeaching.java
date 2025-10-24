import java.util.Random;

public class ScrollArtTeaching {
    static final int WIDTH = getTerminalWidth() - 1;
    static final int TEACHING_WIDTH = 12;
    static final int TEACHING_HEIGHT = 10;
    static final Random rand = new Random();

    public static void main(String[] args) throws InterruptedException {
        char[][] nextRows = new char[TEACHING_HEIGHT][WIDTH];
        for (int i = 0; i < nextRows.length; i++) {
            nextRows[i] = emptyRow();
        }
char[][] img = getTeaching();
        while (true) {
            for (int x = 0; x < WIDTH - TEACHING_WIDTH; x++) {
                if (rand.nextDouble() < 0.003) {
                    if (rand.nextDouble() < 0.5)
                        img = getTeaching();
                    else {
                    
                    }
                    for (int iy = 0; iy < TEACHING_HEIGHT; iy++) {
                        for (int ix = 0; ix < TEACHING_WIDTH; ix++) {
                            nextRows[iy][x + ix] = img[iy][ix];
                        }
                    }
                }
            }
            System.out.println(new String(nextRows[0]));
            shiftRowsUp(nextRows);
            Thread.sleep(50);
        }
    }

    static void shiftRowsUp(char[][] nextRows) {
        for (int i = 1; i < nextRows.length; i++) {
            nextRows[i - 1] = nextRows[i];
        }
        nextRows[nextRows.length - 1] = emptyRow();
    }

    static char[] emptyRow() {
        char[] row = new char[WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            row[i] = ' ';
        }
        return row;
    }

    static char[][] getTeaching() {
        char[][] img = new char[TEACHING_HEIGHT][TEACHING_WIDTH];
        for (int y = 0; y < TEACHING_HEIGHT; y++) {
            for (int x = 0; x < TEACHING_WIDTH; x++) {
                img[y][x] = ' ';
            }
        }
     
        img[1][0] = '_';
        img[1][1] = '_';
        img[1][2] = '_';
        img[1][3] = '_';
        img[1][4] = '_';
        img[1][5] = '_';
        img[1][6] = '_';
        img[1][7] = '_';
        img[1][8] = '_';
        img[1][9] = '_';
        img[1][10]= '_';
        img[1][11]= '_';
        img[2][0] = '|';
        img[2][5] = '_';
        img[2][6] = 'a';
        img[2][7] = 'b';
        img[2][11] = '|';
        img[3][0] = '|';
        img[3][11] = '|';
        img[3][4] = '{';
        img[3][6] = '}';
        img[3][7] = 'c';
        img[3][8] = 'd';
        img[4][0] = '|';
        img[4][1] = '_';
        img[4][2] = '_';
        img[4][3] = '_';
        img[4][4] = '_';
        img[4][5] = 'I';
        img[4][6] = '_';
        img[4][7] = '/';
        img[4][8] = '_';
        img[4][9] = '_';
        img[4][10] = '_';
        img[4][11] = '|';
        img[5][0] = '_';
        img[5][1] = '_';
        img[5][2] = '_';
        img[5][3] = '/';
        img[5][4] = '_';
        img[5][5] = '|';
        img[5][6] = '_';
        img[5][7] = '_';
        img[5][8] = '_';
        img[5][9] = '_';
        img[5][10] = '_';
        img[5][11] = '_';
        img[6][0] = '|';
        img[6][11] = '|';
        img[7][0] = '|';
        img[7][11] = '|';
        img[8][0] = '|';
        img[8][1] = '_';
        img[8][2] = '_';
        img[8][3] = '_';
        img[8][4] = '_';
        img[8][5] = '_';
        img[8][6] = '_';
        img[8][7] = '_';
        img[8][8] = '_';
        img[8][9] = '_';
        img[8][10] = '_';
        img[8][11] = '|';
        img[9][7] = 'G';
        img[9][8] = 'r';
        img[9][9] = 'a';
        img[9][10] = 'c';
        img[9][11] = 'e';


        return img;
    }


    public static int getTerminalWidth() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            return getUnixTerminalWidth();
        } else {
            return 80;
        }
    }

    private static int getUnixTerminalWidth() {
        try {
            String columns = System.getenv("COLUMNS");
            if (columns != null && !columns.isEmpty()) {
                return Integer.parseInt(columns);
            }

            ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "stty size </dev/tty");
            pb.redirectErrorStream(true);
            Process process = pb.start();
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            if (output != null && !output.isEmpty()) {
                String[] parts = output.trim().split(" ");
                return Integer.parseInt(parts[1]);
            }
        } catch (Exception ignored) {
        }
        return 80;
    }

}