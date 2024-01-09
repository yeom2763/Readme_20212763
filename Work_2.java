import java.util.Scanner;
import java.util.Random;

// "Work_2.java" ...

// Bear, Fish
// col - 20, row - 10
// bear 는 asdf로 이동
// fish는 5번중 2번은 랜덤하게 이동해야함
// move() 객체의 모양을 정의하는 getShape(), 추상 메소드로 가진 추상 클래스 GameObject를 상속받는 bear, fish

public abstract class gameObject{
    protected int distance; // 한번 이동 거리 fish를 위해 있는 듯
    protected int x, y; // 현재 위치
    public gameObject(int startX, int startY, int distance){
        this.x = startX;
        this.y = startY;
        this.distance = distance;
    }
    public int get(){return x;}
    public int getY(){return y;}
    public boolean collid(gameObject p){
        if(this.x == p.getX() && this.y == p.getY())
            return true;
        else
            return false;

    }
    protected abstract void move(); // 이동한 후의 새로운 위치로 x, y 변경
    // protected abstract char getShape(); // 객체의 모양을 나타내는 문자 리턴 (없어도 될 듯)
}

public class Bear extends gameObject{
    public Bear(){
        super.gameObject(0, 0, 0);
    }
}

public class Fish extends gameObject{
    public int[] randXY(boolean isFalse){
        int[] arr = new int[2];
        arr[0] = 0;
        arr[1] = 0;

        if(isFalse)
            return arr;

        Random randX, randY;
        randX = new Random();
        randY = new Random();

        int x, y;
        x = randX.nextInt(1);
        y = randY.nextInt(1);

        if(x^y == 1){
            arr[1] = x;
            arr[2] = y;
        }

        return arr;
    } 

    public Fish(){
        super.gameObject();
    }
}


public class Work_2{
    public static void main(String[] args){
        
        Bear objectBear = new objectBear();
        Fish objectFish = new objectFish();
        
        System.out.println("** Bear의 Fish 먹기 게임을 시작합니다. **");
        
        do{
            for(int i = 0; i < 20; i++){
                for(int j = 0; j < 10; j++){
                    if(objectBear.getX != i && objectBear.getY != j && objectFish.getX != i && objectFish.getY != j)
                        System.out.print("-"); // bear와 fish의 위치가 모두 아니면 "-" 출력 ...
                    else if(objectBear.getX == i && objectBear.getY == j)
                        System.out.print("B"); // bear의 위치일 때 "B" 출력 ...
                    else
                        System.out.print("@"); // fish의 위치일 때 "@" 출력 ...
                }
                System.out.print("\n");
            }

            System.out.println("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >> ");
        } while(!Fish.collid(Bear));
        
        System.out.println("Bear Wins!!");
        
    }
}