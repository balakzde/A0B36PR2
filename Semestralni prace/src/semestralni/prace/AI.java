/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author Zdenek
 */
public class AI extends Player {

    public AI(String name, int number, Window w) {
        super(name, number, w);
    }


    int lvl = 5;


    @Override
    void makeMove() {
        int a = w.g.getA();
        char[][] helper = w.g.getField();
        Button[][] buttonField = w.bf.getField();
        int[][] markedField = new int[a][a];
        int[] numbers = new int[a * a * 2];
        int counter = 0;
        int x = 0;
        int y = 0;
        int max = 0;
        int helper2 = 0;
        char my;
        char his;

        if (w.getWhoseTurn() == 1) {
            my = 'O';
            his = 'X';
        } else {
            my = 'X';
            his = 'O';
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                markedField[i][j] = 0;
            }
        }






        char symbol = his;

        for (int k = 0; k < 2; k++) {

            if (symbol == his) {
                symbol = my;
            } else {
                symbol = his;
            }



            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a - 1; j++) {
                    if (helper[i][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j]++;

                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 1; j < a; j++) {
                    if (helper[i][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j]++;
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a - 1; j++) {
                    if (helper[j + 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i]++;
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 1; j < a; j++) {
                    if (helper[j - 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i]++;
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 1; j < a - 1; j++) {
                    if (helper[i][j - 1] == symbol && helper[i][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 1));

                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 1; j < a - 1; j++) {
                    if (helper[i][j + 1] == symbol && helper[i][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 1));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 1; j < a - 1; j++) {
                    if (helper[j - 1][i] == symbol && helper[j + 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 1));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 1; j < a - 1; j++) {
                    if (helper[j + 1][i] == symbol && helper[j - 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 1));
                    }
                }
            }


            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a - 2; j++) {
                    if (helper[i][j + 2] == symbol && helper[i][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 1));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 2; j < a; j++) {
                    if (helper[i][j - 2] == symbol && helper[i][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 1));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a - 2; j++) {
                    if (helper[j + 2][i] == symbol && helper[j + 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 1));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 2; j < a; j++) {
                    if (helper[j - 2][i] == symbol && helper[j - 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 1));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 1; j < a - 2; j++) {
                    if (helper[i][j - 1] == symbol && helper[i][j + 2] == symbol && helper[i][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 2; j < a - 1; j++) {
                    if (helper[i][j + 1] == symbol && helper[i][j - 2] == symbol && helper[i][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 1; j < a - 2; j++) {
                    if (helper[j - 1][i] == symbol && helper[j + 2][i] == symbol && helper[j + 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 2; j < a - 1; j++) {
                    if (helper[j + 1][i] == symbol && helper[j - 2][i] == symbol && helper[j - 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 2));
                    }
                }
            }


            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a - 3; j++) {
                    if (helper[i][j + 3] == symbol && helper[i][j + 2] == symbol && helper[i][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 3; j < a; j++) {
                    if (helper[i][j - 3] == symbol && helper[i][j - 2] == symbol && helper[i][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a - 3; j++) {
                    if (helper[j + 3][i] == symbol && helper[j + 2][i] == symbol && helper[j + 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 3; j < a; j++) {
                    if (helper[j - 3][i] == symbol && helper[j - 2][i] == symbol && helper[j - 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 1; j < a - 4; j++) {
                    if (helper[i][j - 1] == '.' && helper[i][j + 4] == '.' && helper[i][j + 3] == symbol && helper[i][j + 2] == symbol && helper[i][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 4; j < a - 1; j++) {
                    if (helper[i][j + 1] == '.' && helper[i][j - 4] == '.' && helper[i][j - 3] == symbol && helper[i][j - 2] == symbol && helper[i][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 1; j < a - 4; j++) {
                    if (helper[j - 1][i] == '.' && helper[j + 4][i] == '.' && helper[j + 3][i] == symbol && helper[j + 2][i] == symbol && helper[j + 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 4; j < a - 1; j++) {
                    if (helper[j + 1][i] == '.' && helper[j - 4][i] == '.' && helper[j - 3][i] == symbol && helper[j - 2][i] == symbol && helper[j - 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 2));
                    }
                }
            }



            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a - 4; j++) {
                    if (helper[i][j + 4] == symbol && helper[i][j + 3] == symbol && helper[i][j + 2] == symbol && helper[i][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 4; j < a; j++) {
                    if (helper[i][j - 4] == symbol && helper[i][j - 3] == symbol && helper[i][j - 2] == symbol && helper[i][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a - 4; j++) {
                    if (helper[j + 4][i] == symbol && helper[j + 3][i] == symbol && helper[j + 2][i] == symbol && helper[j + 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 4; j < a; j++) {
                    if (helper[j - 4][i] == symbol && helper[j - 3][i] == symbol && helper[j - 2][i] == symbol && helper[j - 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 3));
                    }
                }
            }





            for (int i = 0; i < a - 1; i++) {
                for (int j = 0; j < a - 1; j++) {
                    if (helper[i + 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j]++;
                    }
                }
            }

            for (int i = 1; i < a; i++) {
                for (int j = 1; j < a; j++) {
                    if (helper[i - 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j]++;
                    }
                }
            }

            for (int i = 1; i < a; i++) {
                for (int j = 0; j < a - 1; j++) {
                    if (helper[i - 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j]++;
                    }
                }
            }

            for (int i = 0; i < a - 1; i++) {
                for (int j = 1; j < a; j++) {
                    if (helper[i + 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j]++;
                    }
                }
            }


            for (int i = 1; i < a - 1; i++) {
                for (int j = 1; j < a - 1; j++) {
                    if (helper[i - 1][j - 1] == symbol && helper[i + 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 1));
                    }
                }
            }

            for (int i = 1; i < a - 1; i++) {
                for (int j = 1; j < a - 1; j++) {
                    if (helper[i + 1][j + 1] == symbol && helper[i - 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 1));
                    }
                }
            }

            for (int i = 1; i < a - 1; i++) {
                for (int j = 1; j < a - 1; j++) {
                    if (helper[i + 1][j - 1] == symbol && helper[i - 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 1));
                    }
                }
            }

            for (int i = 1; i < a - 1; i++) {
                for (int j = 1; j < a - 1; j++) {
                    if (helper[i - 1][j + 1] == symbol && helper[i + 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 1));
                    }
                }
            }


            for (int i = 0; i < a - 2; i++) {
                for (int j = 0; j < a - 2; j++) {
                    if (helper[i + 2][j + 2] == symbol && helper[i + 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 1));
                    }
                }
            }

            for (int i = 2; i < a; i++) {
                for (int j = 2; j < a; j++) {
                    if (helper[i - 2][j - 2] == symbol && helper[i - 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 1));
                    }
                }
            }

            for (int i = 2; i < a; i++) {
                for (int j = 0; j < a - 2; j++) {
                    if (helper[i - 2][j + 2] == symbol && helper[i - 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 1));
                    }
                }
            }

            for (int i = 0; i < a - 2; i++) {
                for (int j = 2; j < a; j++) {
                    if (helper[i + 2][j - 2] == symbol && helper[i + 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 1));
                    }
                }
            }

            for (int i = 1; i < a - 2; i++) {
                for (int j = 1; j < a - 2; j++) {
                    if (helper[i - 1][j - 1] == symbol && helper[i + 2][j + 2] == symbol && helper[i + 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 2; i < a - 1; i++) {
                for (int j = 2; j < a - 1; j++) {
                    if (helper[i + 1][j + 1] == symbol && helper[i - 2][j - 2] == symbol && helper[i - 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 2; i < a - 1; i++) {
                for (int j = 1; j < a - 2; j++) {
                    if (helper[i + 1][j - 1] == symbol && helper[i - 2][j + 2] == symbol && helper[i - 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 1; i < a - 2; i++) {
                for (int j = 2; j < a - 1; j++) {
                    if (helper[i - 1][j + 1] == symbol && helper[i + 2][j - 2] == symbol && helper[i + 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }


            for (int i = 0; i < a - 3; i++) {
                for (int j = 0; j < a - 3; j++) {
                    if (helper[i + 3][j + 3] == symbol && helper[i + 2][j + 2] == symbol && helper[i + 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 3; i < a; i++) {
                for (int j = 3; j < a; j++) {
                    if (helper[i - 3][j - 3] == symbol && helper[i - 2][j - 2] == symbol && helper[i - 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 3; i < a; i++) {
                for (int j = 0; j < a - 3; j++) {
                    if (helper[i - 3][j + 3] == symbol && helper[i - 2][j + 2] == symbol && helper[i - 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 0; i < a - 3; i++) {
                for (int j = 3; j < a; j++) {
                    if (helper[i + 3][j - 3] == symbol && helper[i + 2][j - 2] == symbol && helper[i + 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 1; i < a - 4; i++) {
                for (int j = 1; j < a - 4; j++) {
                    if (helper[i - 1][j - 1] == '.' && helper[i + 4][j + 4] == '.' && helper[i + 3][j + 3] == symbol && helper[i + 2][j + 2] == symbol && helper[i + 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 4; i < a - 1; i++) {
                for (int j = 4; j < a - 1; j++) {
                    if (helper[i + 1][j + 1] == '.' && helper[i - 4][j - 4] == '.' && helper[i - 3][j - 3] == symbol && helper[i - 2][j - 2] == symbol && helper[i - 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 4; i < a - 1; i++) {
                for (int j = 1; j < a - 4; j++) {
                    if (helper[i + 1][j - 1] == '.' && helper[i - 4][j + 4] == '.' && helper[i - 3][j + 3] == symbol && helper[i - 2][j + 2] == symbol && helper[i - 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }

            for (int i = 1; i < a - 4; i++) {
                for (int j = 4; j < a - 1; j++) {
                    if (helper[i - 1][j + 1] == '.' && helper[i + 4][j - 4] == '.' && helper[i + 3][j - 3] == symbol && helper[i + 2][j - 2] == symbol && helper[i + 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 2));
                    }
                }
            }



            for (int i = 0; i < a - 4; i++) {
                for (int j = 0; j < a - 4; j++) {
                    if (helper[i + 4][j + 4] == symbol && helper[i + 3][j + 3] == symbol && helper[i + 2][j + 2] == symbol && helper[i + 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 4; i < a; i++) {
                for (int j = 4; j < a; j++) {
                    if (helper[i - 4][j - 4] == symbol && helper[i - 3][j - 3] == symbol && helper[i - 2][j - 2] == symbol && helper[i - 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 4; i < a; i++) {
                for (int j = 0; j < a - 4; j++) {
                    if (helper[i - 4][j + 4] == symbol && helper[i - 3][j + 3] == symbol && helper[i - 2][j + 2] == symbol && helper[i - 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 0; i < a - 4; i++) {
                for (int j = 4; j < a; j++) {
                    if (helper[i + 4][j - 4] == symbol && helper[i + 3][j - 3] == symbol && helper[i + 2][j - 2] == symbol && helper[i + 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }


            for (int i = 0; i < a; i++) {
                for (int j = 2; j < a - 2; j++) {
                    if (helper[i][j + 2] == symbol && helper[i][j + 1] == symbol && helper[i][j - 2] == symbol && helper[i][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 2; j < a - 2; j++) {
                    if (helper[j - 2][i] == symbol && helper[j - 1][i] == symbol && helper[j + 2][i] == symbol && helper[j + 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 3));
                    }
                }
            }


            for (int i = 2; i < a - 2; i++) {
                for (int j = 2; j < a - 2; j++) {
                    if (helper[i + 2][j + 2] == symbol && helper[i + 1][j + 1] == symbol && helper[i - 2][j - 2] == symbol && helper[i - 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 2; i < a - 2; i++) {
                for (int j = 2; j < a - 2; j++) {
                    if (helper[i + 2][j - 2] == symbol && helper[i + 1][j - 1] == symbol && helper[i - 2][j + 2] == symbol && helper[i - 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 1; j < a - 3; j++) {
                    if (helper[i][j - 1] == symbol && helper[i][j + 3] == symbol && helper[i][j + 2] == symbol && helper[i][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 3; j < a - 1; j++) {
                    if (helper[i][j + 1] == symbol && helper[i][j - 3] == symbol && helper[i][j - 2] == symbol && helper[i][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 1; j < a - 3; j++) {
                    if (helper[j - 1][i] == symbol && helper[j + 3][i] == symbol && helper[j + 2][i] == symbol && helper[j + 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 3; j < a - 1; j++) {
                    if (helper[j + 1][i] == symbol && helper[j - 3][i] == symbol && helper[j - 2][i] == symbol && helper[j - 1][i] == symbol && helper[j][i] == '.') {
                        markedField[j][i] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 1; i < a - 3; i++) {
                for (int j = 1; j < a - 3; j++) {
                    if (helper[i - 1][j - 1] == symbol && helper[i + 3][j + 3] == symbol && helper[i + 2][j + 2] == symbol && helper[i + 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 3; i < a - 1; i++) {
                for (int j = 3; j < a - 1; j++) {
                    if (helper[i + 1][j + 1] == symbol && helper[i - 3][j - 3] == symbol && helper[i - 2][j - 2] == symbol && helper[i - 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 3; i < a - 1; i++) {
                for (int j = 1; j < a - 3; j++) {
                    if (helper[i + 1][j - 1] == symbol && helper[i - 3][j + 3] == symbol && helper[i - 2][j + 2] == symbol && helper[i - 1][j + 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }

            for (int i = 1; i < a - 3; i++) {
                for (int j = 3; j < a - 1; j++) {
                    if (helper[i - 1][j + 1] == symbol && helper[i + 3][j - 3] == symbol && helper[i + 2][j - 2] == symbol && helper[i + 1][j - 1] == symbol && helper[i][j] == '.') {
                        markedField[i][j] += ((int) Math.pow(lvl, 3));
                    }
                }
            }



        }


        for (int i = 0; i < a - 4; i++) {
            for (int j = 0; j < a - 4; j++) {
                if (helper[i + 4][j + 4] == my && helper[i + 3][j + 3] == my && helper[i + 2][j + 2] == my && helper[i + 1][j + 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 4; i < a; i++) {
            for (int j = 4; j < a; j++) {
                if (helper[i - 4][j - 4] == my && helper[i - 3][j - 3] == my && helper[i - 2][j - 2] == my && helper[i - 1][j - 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 4; i < a; i++) {
            for (int j = 0; j < a - 4; j++) {
                if (helper[i - 4][j + 4] == my && helper[i - 3][j + 3] == my && helper[i - 2][j + 2] == my && helper[i - 1][j + 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 0; i < a - 4; i++) {
            for (int j = 4; j < a; j++) {
                if (helper[i + 4][j - 4] == my && helper[i + 3][j - 3] == my && helper[i + 2][j - 2] == my && helper[i + 1][j - 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }





        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a - 4; j++) {
                if (helper[i][j + 4] == my && helper[i][j + 3] == my && helper[i][j + 2] == my && helper[i][j + 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 4; j < a; j++) {
                if (helper[i][j - 4] == my && helper[i][j - 3] == my && helper[i][j - 2] == my && helper[i][j - 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a - 4; j++) {
                if (helper[j + 4][i] == my && helper[j + 3][i] == my && helper[j + 2][i] == my && helper[j + 1][i] == my && helper[j][i] == '.') {
                    markedField[j][i] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 4; j < a; j++) {
                if (helper[j - 4][i] == my && helper[j - 3][i] == my && helper[j - 2][i] == my && helper[j - 1][i] == my && helper[j][i] == '.') {
                    markedField[j][i] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 2; j < a - 2; j++) {
                if (helper[i][j + 2] == my && helper[i][j + 1] == my && helper[i][j - 2] == my && helper[i][j - 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 2; j < a - 2; j++) {
                if (helper[j - 2][i] == my && helper[j - 1][i] == my && helper[j + 2][i] == my && helper[j + 1][i] == my && helper[j][i] == '.') {
                    markedField[j][i] += ((int) Math.pow(lvl, 5));
                }
            }
        }


        for (int i = 2; i < a - 2; i++) {
            for (int j = 2; j < a - 2; j++) {
                if (helper[i + 2][j + 2] == my && helper[i + 1][j + 1] == my && helper[i - 2][j - 2] == my && helper[i - 1][j - 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 2; i < a - 2; i++) {
            for (int j = 2; j < a - 2; j++) {
                if (helper[i + 2][j - 2] == my && helper[i + 1][j - 1] == my && helper[i - 2][j + 2] == my && helper[i - 1][j + 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 1; j < a - 3; j++) {
                if (helper[i][j - 1] == my && helper[i][j + 3] == my && helper[i][j + 2] == my && helper[i][j + 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 3; j < a - 1; j++) {
                if (helper[i][j + 1] == my && helper[i][j - 3] == my && helper[i][j - 2] == my && helper[i][j - 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 1; j < a - 3; j++) {
                if (helper[j - 1][i] == my && helper[j + 3][i] == my && helper[j + 2][i] == my && helper[j + 1][i] == my && helper[j][i] == '.') {
                    markedField[j][i] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 3; j < a - 1; j++) {
                if (helper[j + 1][i] == my && helper[j - 3][i] == my && helper[j - 2][i] == my && helper[j - 1][i] == my && helper[j][i] == '.') {
                    markedField[j][i] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 1; i < a - 3; i++) {
            for (int j = 1; j < a - 3; j++) {
                if (helper[i - 1][j - 1] == my && helper[i + 3][j + 3] == my && helper[i + 2][j + 2] == my && helper[i + 1][j + 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 3; i < a - 1; i++) {
            for (int j = 3; j < a - 1; j++) {
                if (helper[i + 1][j + 1] == my && helper[i - 3][j - 3] == my && helper[i - 2][j - 2] == my && helper[i - 1][j - 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 3; i < a - 1; i++) {
            for (int j = 1; j < a - 3; j++) {
                if (helper[i + 1][j - 1] == my && helper[i - 3][j + 3] == my && helper[i - 2][j + 2] == my && helper[i - 1][j + 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }

        for (int i = 1; i < a - 3; i++) {
            for (int j = 3; j < a - 1; j++) {
                if (helper[i - 1][j + 1] == my && helper[i + 3][j - 3] == my && helper[i + 2][j - 2] == my && helper[i + 1][j - 1] == my && helper[i][j] == '.') {
                    markedField[i][j] += ((int) Math.pow(lvl, 5));
                }
            }
        }



        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (markedField[i][j] > max) {
                    max = markedField[i][j];

                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (markedField[i][j] != 0 && markedField[i][j] == max) {
                    numbers[counter] = i;
                    counter++;
                    numbers[counter] = j;
                    counter++;
                }
            }
        }

        if (max != 0) {
            while (helper2 != 1) {
                int random;
                random = (int) (Math.random() * (counter - 1));
                if (random % 2 != 0) {
                    random -= 1;
                }
                helper2 = w.g.doMove(numbers[random], numbers[random + 1], w.getWhoseTurn());
                x = numbers[random];
                y = numbers[random + 1];
            }
        } else {
            x = 14;
            y = 14;
            w.g.doMove(x, y, w.getWhoseTurn());

        }

        buttonField[x][y].changeField();

        w.bf.setField(buttonField);



    }
}
