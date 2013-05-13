/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author Zdenek
 */
public class Game {

    private char[][] field;
    private int a;
    private char player1 = 'O';
    private char player2 = 'X';

    public Game(int size) {

        field = new char[size][size];
        this.a = size;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                field[i][j] = '.';

            }

        }

    }

    int doMove(int x, int y, int play) {

        if (x >= 0 && x < this.a && y >= 0 && y < this.a && field[x][y] == '.') {
            if (play == 1) {
                field[x][y] = player1;
                return 1;
            } else {
                field[x][y] = player2;
                return 1;
            }
        } else {
            return 0;
        }
    }

    char[][] getField() {
        return field;
    }

    int winnerCheck(int a) {
        int follow;
        char symbol;
        if (a == 1) {
            symbol = player1;
        } else {
            symbol = player2;
        }


        for (int i = 0; i < this.a; i++) {
            follow = 0;
            for (int j = 0; j < this.a; j++) {
                if (field[i][j] == symbol) {
                    follow++;
                } else {
                    follow = 0;
                }
                if (follow == 5) {
                    field[i][j] = 'w';
                    field[i][j - 1] = 'w';
                    field[i][j - 2] = 'w';
                    field[i][j - 3] = 'w';
                    field[i][j - 4] = 'w';
                    return a;
                }
            }
        }

        for (int i = 0; i < this.a; i++) {
            follow = 0;
            for (int j = 0; j < this.a; j++) {
                if (field[j][i] == symbol) {
                    follow++;
                } else {
                    follow = 0;
                }
                if (follow == 5) {
                    field[j][i] = 'w';
                    field[j - 1][i] = 'w';
                    field[j - 2][i] = 'w';
                    field[j - 3][i] = 'w';
                    field[j - 4][i] = 'w';
                    return a;
                }
            }
        }
        follow = 0;


        for (int i = 2; i < this.a - 2; i++) {
            for (int j = 2; j < this.a - 2; j++) {
                if (field[i][j] == field[i + 1][j + 1] && field[i][j] == field[i + 2][j + 2] && field[i][j] == field[i - 1][j - 1] && field[i][j] == field[i - 2][j - 2] && field[i][j] == symbol) {
                    field[i][j] = 'w';
                    field[i + 1][j + 1] = 'w';
                    field[i + 2][j + 2] = 'w';
                    field[i - 1][j - 1] = 'w';
                    field[i - 2][j - 2] = 'w';
                    return a;
                }
                if (field[i][j] == field[i + 1][j - 1] && field[i][j] == field[i + 2][j - 2] && field[i][j] == field[i - 1][j + 1] && field[i][j] == field[i - 2][j + 2] && field[i][j] == symbol) {
                    field[i][j] = 'w';
                    field[i + 1][j - 1] = 'w';
                    field[i + 2][j - 2] = 'w';
                    field[i - 1][j + 1] = 'w';
                    field[i - 2][j + 2] = 'w';
                    return a;
                }
            }
        }


        for (int i = 0; i < this.a; i++) {
            for (int j = 0; j < this.a; j++) {
                if (field[i][j] != '.') {
                    follow++;
                } else {
                    return 0;
                }
                if (follow == this.a * this.a) {
                    return 3;
                }
            }
        }



        return 0;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void restart() {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                field[i][j] = '.';

            }

        }
    }

    public void setField(char[][] field) {
        this.field = field;
    }

}
