/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Random;

/**
 *
 * @author Alexa
 */
public class Logic {

    private Player player;
    private Player ai;
    private boolean endOfGame = false;
    private int[] board = new int[9];
    Random random = new Random();

    public Logic() {
    }

    public Logic(Player player, Player ai, boolean endOfGame, int[] board) {
        this.player = player;
        this.ai = ai;
        this.endOfGame = endOfGame;
        this.board = board;
    }

    public void makeStep() {
        if (endOfGame != true) {
            //если игрок Х - ходит первым, если O - ходит вторым
            if (!player.isMadeStep() && player.getFigure() == 'X') {
                return;
            }
            if (player.isMadeStep() && (ai.getFigure() == 'X' || ai.getFigure() == 'O')) {

                //1)поиск ячейки между фигурами противника и вставка туда
                if (board[0] == 1 && board[1] == 0 && board[2] == 1) {
                    board[1] = -1;
                    ai.setMadeStep(false);
                    checkWin(board);
                    return;
                }
                if (board[3] == 1 && board[4] == 0 && board[5] == 1) {
                    board[4] = -1;
                    ai.setMadeStep(false);
                    checkWin(board);
                    return;
                }
                if (board[6] == 1 && board[7] == 0 && board[8] == 1) {
                    board[7] = -1;
                    ai.setMadeStep(false);
                    checkWin(board);
                    return;
                }
                if (board[0] == 1 && board[1] == 0 && board[2] == 1) {
                    board[1] = -1;
                    ai.setMadeStep(false);
                    checkWin(board);
                    return;
                }
                //**********
                if (board[0] == 1 && board[3] == 0 && board[6] == 1) {
                    board[3] = -1;
                    ai.setMadeStep(false);
                    checkWin(board);
                    return;
                }
                if (board[1] == 1 && board[4] == 0 && board[7] == 1) {
                    board[4] = -1;
                    ai.setMadeStep(false);
                    checkWin(board);
                    return;
                }
                if (board[2] == 1 && board[5] == 0 && board[8] == 1) {
                    board[5] = -1;
                    ai.setMadeStep(false);
                    checkWin(board);
                    return;
                }
                //**********
                if (board[0] == 1 && board[4] == 0 && board[2] == 1 || board[6] == 1 && board[4] == 0 && board[8] == 0) {
                    board[4] = -1;
                    ai.setMadeStep(false);
                    checkWin(board);
                    return;
                }

                //2)случайный выбор клетки
                int cnt = 0;
                for (int i = 0; i < board.length; i++) {
                    if (board[i] == 0) {
                        cnt++;
                    }
                }
                if (cnt == 0) {
                    endOfGame = true;
                    return;
                }
                int index = 0;
                while (board[index] != 0) {
                    index = random.nextInt(9);
                }
                setBoardValue(board, index, -1);
                ai.setMadeStep(false);
                checkWin(board);
            }
        }
    }

    //0-ничья, 1-игрок, -1-противник, 2-игра
    public int checkWin(int[] board) {
        if ((board[0] == 1 && board[1] == 1 && board[2] == 1)
                || (board[3] == 1 && board[4] == 1 && board[5] == 1)
                || (board[6] == 1 && board[7] == 1 && board[8] == 1)
                || (board[0] == 1 && board[4] == 1 && board[8] == 1)
                || (board[6] == 1 && board[4] == 1 && board[2] == 1)
                || (board[0] == 1 && board[3] == 1 && board[6] == 1)
                || (board[1] == 1 && board[4] == 1 && board[7] == 1)
                || (board[2] == 1 && board[5] == 1 && board[8] == 1)) {
            System.out.println("You win!");
            endOfGame = true;
            return 1;
        }
        if ((board[0] == -1 && board[1] == -1 && board[2] == -1)
                || (board[3] == -1 && board[4] == -1 && board[5] == -1)
                || (board[6] == -1 && board[7] == -1 && board[8] == -1)
                || (board[0] == -1 && board[4] == -1 && board[8] == -1)
                || (board[6] == -1 && board[4] == -1 && board[2] == -1)
                || (board[0] == -1 && board[3] == -1 && board[6] == -1)
                || (board[1] == -1 && board[4] == -1 && board[7] == -1)
                || (board[2] == -1 && board[5] == -1 && board[8] == -1)) {
            System.out.println("Ai wins!");
            endOfGame = true;
            return -1;
        }

        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i] == 0) {
                cnt++;
            }
        }
        if (cnt == 0) {
            System.out.println("Draw!");
            endOfGame = true;
            return 0;
        }

        System.out.println("Game continues!");
        endOfGame = false;
        return 2;
    }

    public boolean checkBoardPosition(int[] board, int index) {
        if (board[index] == 0) {
            return true;
        }
        return false;
    }

    public void setBoardValue(int[] board, int index, int value) {
        board[index] = value;
        printBoard(board);
    }

    public void printBoard(int[] board) {
        System.out.println(" ");
        for (int i : board) {
            System.out.print(i + " ");
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getAi() {
        return ai;
    }

    public void setAi(Player ai) {
        this.ai = ai;
    }

    public boolean isEndOfGame() {
        return endOfGame;
    }

    public void setEndOfGame(boolean endOfGame) {
        this.endOfGame = endOfGame;
    }

    public int[] getBoard() {
        return board;
    }

    public void setBoard(int[] board) {
        this.board = board;
    }

}
