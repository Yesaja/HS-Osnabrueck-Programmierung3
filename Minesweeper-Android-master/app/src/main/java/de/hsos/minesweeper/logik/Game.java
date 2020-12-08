package de.hsos.minesweeper.logik;

public class Game {
    int[][] field;
    int fieldWidth = 16;
    int fieldHeight = 9;
    int amountOfBombs = 10;

    Game() {
        this.field = new int[fieldWidth][fieldHeight];
        initializeGame();
    }


    /*public void initialize() {
        this.bitmap = this.initBitmap();
        this.imageView = this.initImageview();
        this.canvas = new Canvas(this.bitmap);
        this.paint = new Paint();
    }

    private Bitmap initBitmap() {
        Display display = this.getWindowManager().getDefaultDisplay();
        Point ext = new Point();
        display.getSize(ext);

        return Bitmap.createBitmap(ext.x, ext.y, Bitmap.Config.ARGB_8888);
    }*/

    private void initializeGame() {
        initializeBombs();
        initializeField();
    }

    /**
     * Initialisation of the playing Field
     * Randomly distributes Bombs (Value = 9) on the field
     */
    private void initializeBombs() {
        for (int i = 0; i < amountOfBombs; i++) {
            int rdm_x = (int) Math.random() * fieldWidth; //
            int rdm_y = (int) Math.random() * fieldHeight; //

            //Initialisiere das Feld, sofern es leer ist (!=9)
            if (9 != field[rdm_x][rdm_y]) {
                field[rdm_x][rdm_y] = 9;
            }
        }
    }

    private void initializeField() {
        int radius = 1;
        int counter = 0;
        for (int i = 0; i < fieldWidth; i++) {
            for (int j = 0; j < fieldHeight; j++) {
                //Prüfen ob Feld Bombe oder nicht. Wenn es keine Bombe ist zähle Nachbarn
                if (field[i][j] != 9) {
                    for (int k = i - 1; k < i + radius; k++) {
                        for (int l = j - 1; l < i + radius; l++) {
                            if (field[k][l] == 9) {
                                counter++;
                            }
                        }
                    }
                }
            }
        }
    }


}
