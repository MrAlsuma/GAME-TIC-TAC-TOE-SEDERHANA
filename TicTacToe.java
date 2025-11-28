import java.util.Scanner;
public class TicTacToe {
    // static variabel supaya bisa diakses semua method
    static Scanner sc = new Scanner(System.in);
    static int turnCount = 1;
    static char[][] cell = new char[3][3];
    static boolean change = true;
    static boolean done = false;
    public static void main(String[] args) {
        for(int i = 0;i<3;i++){
            for(int j =0;j<3;j++){
                cell[i][j] = ' ';
            }
        }
        do {
            board();            // tampilkan papan di awal
            if(change){         // memakai boolean untuk giliran
                xturn();
            }else{
                oturn();
            }
            checkBoard();       // cek setiap selesai input
        } while (!done);
        
    }
    // papan permaiann
    static void board(){
        System.out.println("\n-------------");
        System.out.printf("| %s | %s | %s |\n",cell[0][0], cell[0][1],cell[0][2]);
        System.out.println("-------------");
        System.out.printf("| %s | %s | %s |\n",cell[1][0], cell[1][1],cell[1][2]);
        System.out.println("-------------");
        System.out.printf("| %s | %s | %s |\n",cell[2][0], cell[2][1],cell[2][2]);
        System.out.println("-------------");
    }

    // giliran
    static void xturn(){
        System.out.print("Enter a row (0, 1 or 2) for player X: ");
        int x = sc.nextInt();
        System.out.print("Enter a column (0, 1 or 2) for player X: ");
        int y = sc.nextInt();
        if(isValid(x, y)){
            cell[x][y] = 'X';
            change = false;
        } else{
            System.out.println("the cell is already occupied or the selection is invalid");
            xturn();
        }
    }
    static void oturn(){
        System.out.print("Enter a row (0, 1 or 2) for player O: ");
        int x = sc.nextInt();
        System.out.print("Enter a column (0, 1 or 2) for player O: ");
        int y = sc.nextInt();
        if(isValid(x, y)){
            cell[x][y] = 'O';
            change = true;
        } else{
            System.out.println("the cell is already occupied or the selection is invalid");
            oturn();
        }
    }
    // cek langkah valid
    static boolean isValid(int x, int y){
        if(x<0 || x>2 || y<0 || y>2){
            return false;
        }
        return cell[x][y] == ' ';
    }

    // cek siapa yang menang atau seri
    static void checkBoard(){
        for(int i = 0;i<3;i++){
            // cek horizontal
            if(cell[i][0] == cell[i][1] && cell[i][1] == cell[i][2] && cell[i][2] != ' '){
                result(cell[i][0]);
                return;
            }
            // cek vertikal
            if(cell[0][i] == cell[1][i] && cell[1][i] == cell[2][i] && cell[2][i] != ' '){
                result(cell[0][i]);
                return;
            }
        }
        // cek diagonal
        if(cell[0][0] == cell[1][1] && cell[1][1] == cell[2][2] && cell[2][2] != ' '){
            result(cell[1][1]);
            return;
        }
        if(cell[0][2] == cell[1][1] && cell[1][1] == cell[2][0] && cell[2][0] != ' '){
            result(cell[1][1]);
            return;
        }

        // kondisi draw
        if(turnCount == 9){     // papan sudah terisi semua
            result('=');     // "sama dengan" untuk hasil yang sama
        }
        turnCount++;
    }

    // menampilkan hasil permainan
    static void result(char a) {
        board();
        if(a == '='){
            System.out.println("Draw");
        }else{
            System.out.println(a + " player won");
        }
        done = true;
    }
    
}
