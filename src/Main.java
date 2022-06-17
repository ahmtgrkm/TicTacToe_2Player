import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TicTacToe game =new TicTacToe();

    }
}
    class TicTacToe {
    public static final int X= 1, O= -1; // players
     public static final int EMPTY= 0; // empty// cell
     private int board[ ][ ] = new int[3][3]; // game board//
     private int player; // current player/** Constructor */
        Scanner input =new Scanner(System.in);
     public TicTacToe( ) {
         System.out.println( "| 1 | 2 | 3 | \n| 4 | 5 | 6 | \n| 7 | 8 | 9 |");
         clearBoard( );
         putMark();
     } /** Clears the board */
     public void clearBoard( ) {
         for(int i= 0; i< 3; i++)
         for(int j= 0; j< 3; j++)
             board[i][j] = EMPTY; // every cell should be empty
            player= X; // the first player is 'X’
          }

         /** Puts an X or O mark at position i,j. */
         public void putMark( ) throws IllegalArgumentException {
             int i=0;
             int j=0;

             for (int f =0; f<9 ; f++){
                 System.out.print("Please enter the area's number - ");
                 int oneD= input.nextInt();
                 for (int a =0 ; a<3 ; a++){
                     if (oneD<=3){
                         i = a;
                         break;
                     }
                     oneD-=3;
                 }
                 for (int a=0 ; a<3 ; a++){
                     if (oneD>3){
                     j=oneD%3;}
                     else {j=oneD-1;}
                 }

             if((i< 0) || (i> 2) || (j< 0) || (j> 2)) throw new IllegalArgumentException("Invalid board position");

       if(board[i][j] != EMPTY) throw new IllegalArgumentException("Board position occupied");


                 board[i][j] = player; // place the mark for the current player
                 if (isWin(player)== true){
                     System.out.println(winner());
                     break;
                 }
                 player= -player;
                 System.out.println(this.toString());
                 System.out.println("Player "+ player +"'s turn.");


             }
       }

        public boolean isWin(int mark) {
    return((board[0][0] + board[0][1] + board[0][2] == mark*3)
            || (board[1][0] + board[1][1] + board[1][2] == mark*3)
            || (board[2][0] + board[2][1] + board[2][2] == mark*3)
            || (board[0][0] + board[1][0] + board[2][0] == mark*3)
            || (board[0][1] + board[1][1] + board[2][1] == mark*3)
            || (board[0][2] + board[1][2] + board[2][2] == mark*3)
            || (board[0][0] + board[1][1] + board[2][2] == mark*3)
            || (board[2][0] + board[1][1] + board[0][2] == mark*3));
}
/** Returns the winning player's code, or 0 to indicate a tie (or unfinished game).*/
public String winner( ) {
    if(isWin(X))return("Congratulations , Player X Wins.");
    else if(isWin(O))return("Congratulations , Player O Wins.");
    else return("Tie.");}

    public String toString( ) {
    StringBuilder sb= new StringBuilder( );
    for(int i=0; i<3; i++) {
        for(int j=0; j<3; j++) {
            switch(board[i][j]) {
                case X: sb.append("X");
                break;
                case O: sb.append("O");
                break;
                case EMPTY: sb.append(" "); break;
            } if(j< 2) sb.append("|"); }
        if(i< 2) sb.append("\n-----\n"); }
    return sb.toString( );} }