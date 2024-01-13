import java.util.*;

public class bearEatFish{
    public static class component{
    static Random randomInt = new Random();

    public static int[] randomMove(){
        // 5번 중 2번만 이동해야함        
        int[] arr = new int[5];
        Random r = new Random();

        while(true){
            for(int i = 0; i < 5; i++)
                arr[i] = r.nextInt(1); // arr에 0 또는 1 랜덤 삽입
            
            int count = 0;
            for(int i = 0; i < 5; i++){
                if(arr[i] == 1)
                    count++;
            }
            if(count == 2)
                return arr; // arr[i]에 1이 들어있으면 count에 1을 더한 후 count가 2가 되면, break
            else
                count = 0;
        }
    }
}

public static abstract class gameObject{
    protected int distance; // 한번 이동 거리 fish를 위해 있는 듯
    protected int x, y; // 현재 위치
    public gameObject(int startX, int startY, int distance){
        this.x = startX;
        this.y = startY;
        this.distance = distance;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public boolean collid(gameObject p){
        if(this.x == p.getX() && this.y == p.getY())
            return true;
        else
            return false;

    }
}

public static class bear extends gameObject{

    int bearMoveCount = 0;

    public bear(){
       super(0, 0, 0);
    }
    
    public void moveBear(char val){
        if(val == 'w'){ // x + 1
            if(this.x + 1 < 20)
                this.x++;
        }
        else if(val == 'a'){ // y - 1
            if(this.y - 1 > -1)
                this.y--;
        }
        else if(val == 's'){ // x - 1
            if(this.x - 1 > -1)
                this.x--;
        }
        else if(val == 'd'){ //  y + 1
            if(this.y + 1 < 10)
                this.y++;
        }
        else
            System.out.println("Error!");
    }
}

public static class fish extends gameObject{
    component comFish = new component();
    int turnInt = 0; // 0 ~ 4
    int[] turn = comFish.randomMove();

    public fish(){
        super(component.randomInt.nextInt(19), component.randomInt.nextInt(9), 0);
    }

    public void fishMove(){
        if(turnInt == 4)
            turn = comFish.randomMove(); // 다섯 턴이 지나면 Fish가 움직이는 턴 재배열
        
        if(turn[turnInt++]==1){
            int moveX = 0;
            int moveY = 0;
            do{
                moveX = component.randomInt.nextInt(1);
                moveY = component.randomInt.nextInt(1);
            } while((moveX^moveY) != 0);
            
            if(this.x + moveX < 20)
                this.x += moveX;
            if(this.y + moveY < 10)
                this.y += moveY;
        }
    }
}

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        bear b = new bear();
        fish f = new fish();

        System.out.println("** Bear의 Fish 먹기 게임을 시작합니다.**");

        while(!f.collid(b)){
            for(int i = 0; i < 20; i++){
                for(int j = 0; j < 10; j++){
                    if(b.getX() == i && b.getY() == j)
                        System.out.print("B");
                    else if(f.getX() == i && f.getY() == j)
                        System.out.print("@");
                    else
                        System.out.print("-");
                }
                System.out.print("\n");
            }
            
            System.out.println("왼쪽(A), 오른쪽(D), 위(W), 아래(S)");
            b.moveBear(scan.next().charAt(0));
        }

        System.out.println("Bear Wins!!");
    }
}
