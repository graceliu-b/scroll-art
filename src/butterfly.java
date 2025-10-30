import java.util.Random;

public class butterfly {
    static final Random rand = new Random();
    public static void main(String[] args) throws Exception {
        for (int m = 0; m < 5; m++){
        char[][] img = getButterfly();
        int num = rand.nextInt(80);
         for(int y=0; y< 15; y++ ){
            System.out.print(" ".repeat(num));
            for(int x=0;x < 15;x++){
                System.out.print(img[x][y]);;
            }
            System.out.println(' ');
        }
       Thread.sleep(1000);
    }

}
    static char[][] getButterfly() {
        char[][]img=new char [15][15];
        for(int y=0; y<15; y++ ){
            for(int x=0;x<15;x++){
                img[y][x]=' ';
            }
        }
        //left wing
        img[1][5]='♥';
        img[1][6]='♥';
        img[1][10]='♥';
        img[1][11]='♥';

        img[2][4]='♥';
        img[2][7]='♥';
        img[2][9]='♥';
        img[2][12]='♥';

        img[3][4]='♥';
        img[3][6]='o';
        img [3][10]='o';
        img[3][12]='♥';
        img[3][8]='♥';

        img [4][5]='♥';
        img[4][8]='-';
        img[4][11]='♥';

        img[5][6]='♥';
        img[5][10]='♥';

        img [6][7]='♥';
        img [6][9]='♥';

        img[7][8]='♥';

        //right wing

        img[14][5]='♥';
        img[14][6]='♥';
        img[14][10]='♥';
        img[14][11]='♥';

        img[13][4]='♥';
        img[13][7]='♥';
        img[13][9]='♥';
        img[13][12]='♥';

        img[12][4]='♥';
        img[12][6]='o';
        img [12][10]='o';
        img[12][12]='♥';
        img[12][8]='♥';

        img [11][5]='♥';
        img[11][8]='-';
        img[11][11]='♥';

        img[10][6]='♥';
        img[10][10]='♥';

        img [9][7]='♥';
        img [9][9]='♥';

        img[8][8]='♥';

        return img;
    }

}