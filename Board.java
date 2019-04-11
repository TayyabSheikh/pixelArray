public class Board extends Thread {
    int rows;
    int columns;
    char[][] pixels;

    public Board() {
        this.rows = 1;
        this.columns =1;
    }

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    void intialize(){
        pixels = new char[rows][columns];
        for (int i = 0 ; i < rows ; i++ )
            for (int z = 0; z < columns; z++) {
                pixels[i][z] = '-';
            }
    }
    void draw(){
        for (int i = 0 ; i < rows ; i++ ) {
            for (int z = 0; z < columns; z++) {
                System.out.print(pixels[i][z]);
            }
            System.out.println();
        }
    }
    void begin(){
        intialize();
        draw();
        start();

    }
    void animate(){
        for (int i = 0 ; i < rows ; i++ )
            for (int z = 0; z < columns; z++) {
                pixels[i][z] = '0';
                if(z!=0)
                    pixels[i][z-1] = '-';
                else if(i != 0 && z == 0)
                    pixels[i-1][columns-1] = '-';
                draw();
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
    @Override
    public void run() {
        animate();
        
    }


}
