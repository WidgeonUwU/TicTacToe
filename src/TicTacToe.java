import java.io.IOException;
import java.util.Scanner;

import static java.lang.Runtime.getRuntime;

public class TicTacToe {

    static char[][] ch = {{'?', '?', '?'}, {'?', '?', '?'}, {'?', '?', '?'}};
    static boolean krestikwin = false, nolikwin = false;
    static Scanner in = new Scanner(System.in);

    static void doska1() {
        System.out.println("-------------");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("-------------");
    }

    static void doska() {
        System.out.println("\n");
        System.out.println("-------------");
        System.out.println("| " + ch[0][0] + " | " + ch[0][1] + " | " + ch[0][2] + " |");
        System.out.println("| " + ch[1][0] + " | " + ch[1][1] + " | " + ch[1][2] + " |");
        System.out.println("| " + ch[2][0] + " | " + ch[2][1] + " | " + ch[2][2] + " |");
        System.out.println("-------------");
    }

    static int getmove() {
        return in.nextInt();
    }

    public static void main(String[] aa) {
        System.out.println("welcome to krestiki-noliki ! ! !");
        for (int i = 0; i < 9; i++) {
            doska1();
            doska();
            int move = getmove();
            if (move < 1 || move > 9) {
                System.out.println("U down or what?");
                continue;
            }
            if (ch[(move + 2) / 3 - 1][(move + 2) % 3] != '?') {
                System.out.println("Don't cheat stupid");
                continue;
            } else if (i % 2 == 0) {
                ch[(move + 2) / 3 - 1][(move + 2) % 3] = 'X';
            } else {
                ch[(move + 2) / 3 - 1][(move + 2) % 3] = '0';
            }
            for (int j = 0; j < 3; j++) {
                if (
                        ch[0][j] == 'X' && ch[1][j] == 'X' && ch[2][j] == 'X'
                                || ch[j][0] == 'X' && ch[j][1] == 'X' && ch[j][2] == 'X'
                                || ch[0][0] == 'X' && ch[1][1] == 'X' && ch[2][2] == 'X'
                                || ch[0][2] == 'X' && ch[1][1] == 'X' && ch[2][0] == 'X') {
                    krestikwin = true;
                }
                if (
                        ch[0][j] == '0' && ch[1][j] == '0' && ch[2][j] == '0'
                                || ch[j][0] == '0' && ch[j][1] == '0' && ch[j][2] == '0'
                                || ch[0][0] == '0' && ch[1][1] == '0' && ch[2][2] == '0'
                                || ch[0][2] == '0' && ch[1][1] == '0' && ch[2][0] == '0') {
                    nolikwin = true;
                }
            }
            if (krestikwin) {
                System.out.println("X win ! ! ! ");
                doska();
                break;
            }
            else if (nolikwin) {
                System.out.println("0 win ! ! ! ");
                doska();
                break;
            }
        }
        if(!nolikwin && !krestikwin){
            System.out.println("nich'ya");
            doska();
        }

    }

}
