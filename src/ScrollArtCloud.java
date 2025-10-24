import java.util.Random;

public class ScrollArtCloud {
    static final int WIDTH = getTerminalWidth() - 1;
    static final int Cloud_WIDTH = 12;
    static final int Cloud_HEIGHT = 13;
    static final Random rand = new Random();

    public static void main(String[] args) throws InterruptedException {
        char[][] nextRows = new char[Cloud_HEIGHT][WIDTH]; 
        for (int i = 0; i < nextRows.length; i++) {
            nextRows[i] = emptyRow();
        }
char[][] img = getCloud();
        while (true) {
            for (int x = 0; x < WIDTH - Cloud_WIDTH; x++) {
                if (rand.nextDouble() < 0.001) {
                    if (rand.nextDouble() < 0.5)
                        img = getCloud();
                    
                    
                    for (int iy = 0; iy < Cloud_HEIGHT; iy++) {
                        for (int ix = 0; ix < Cloud_WIDTH; ix++) {
                            nextRows[iy][x + ix] = img[iy][ix];
                        }
                    }
                }
            }
            
            System.out.println(new String(nextRows[0]));
            shiftRowsUp(nextRows);
            Thread.sleep(40); 
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

    static char[][] getCloud() {
        char[][] img = new char[Cloud_HEIGHT][Cloud_WIDTH];
        for (int y = 0; y < Cloud_HEIGHT; y++) {
            for (int x = 0; x < Cloud_WIDTH; x++) {
                img[y][x] = ' ';
            }
        }
     
        img[0][4] = '_';
        img[0][5] = '_';
        img[0][6] = '_';
        img[1][1] = '_';
        img[1][2] = '/';
        img[1][3] = '*';
        img[1][6] = '"';
        img[1][7] = ')';
        img[1][8] = '_';
        img[1][9] = '_';
        img[2][0] = '(';
        img[2][1] = '_';
        img[2][2] = '_';
        img[2][3] = '_';
        img[2][4] = '=';
        img[2][5] = '_';
        img[2][6] = '_';
        img[2][7] = '_';
        img[2][8] = '_';
        img[2][9] = '_';
        img[2][10] = ')';
        img[2][11] = ')';
        img[3][2] = ',';
        img[3][4] = ',';
        img[3][6] = ',';
        img[3][8] = ',';
        img[3][9] = ',';
        img[4][1] = ',';
        img[4][3] = ',';
        img[4][5] = ',';
        img[4][7] = ',';
        img[4][9] = ',';
        img[6][1] = '_';
        img[6][2] = '_';
        img[6][3] = '_';
        img[6][4] = '_';
        img[6][5] = '_';
        img[6][6] = '_';
        img[6][7] = '_';
        img[6][8] = '_';
        img[6][9] = '_';
        img[6][10] = '_';
        img[7][0] = '/';
        img[7][1] = '_';
        img[7][2] = '_';
        img[7][3] = '_';
        img[7][4] = '_';
        img[7][5] = '_';
        img[7][6] = '_';
        img[7][7] = '_';
        img[7][8] = '_';
        img[7][9] = '_';
        img[7][10] = '_';
        img[7][11] = '\\';
        img[8][0] = '|';
        img[8][11] = '|';
        img[9][0] = '|';
        img[9][1] = '{';
        img[9][2] = '}';
        img[9][4] = '{';
        img[9][5] = '}';
        img[9][7] = '{';
        img[9][8] = '}';
        img[9][10] = '{';
        img[9][11] = '}';
        img[10][0] = '|';
        img[10][5] = '_';
        img[10][11] = '|';
        img[11][0] = '|';
        img[11][1] = '_';
        img[11][2] = '_';
        img[11][3] = '_';
        img[11][4] = '|';
        img[11][5] = '_';
        img[11][6] = '|';
        img[11][7] = '_';
        img[11][8] = '_';
        img[11][9] = '_';
        img[11][10] = '_';
        img[11][11] = '|';
        img[12][7] = 'G';
        img[12][8] = 'r';
        img[12][9] = 'a';
        img[12][10] = 'c';
        img[12][11] = 'e';

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