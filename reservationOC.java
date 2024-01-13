import java.util.Scanner;

// "Work_1.java"...

public class reservationOC{
        // 예약, 조회, 취소, 끝내기...

// S, A, B ... Each seat class have 10...
public static class seat{
    static String[][] counter;
    // seat 생성자...
    public seat(){
        counter = new String[3][10];
        for(int i=0; i<3; i++){
            for(int j=0; j<10; j++){
                counter[i][j] = "--- ";
            }
        }
    }
    // 예약 기능... 1
    public void reservation(String name, int number, int seatClass){
        counter[seatClass][number] = name.concat(" ");
    }
    // 조회 기능... 2
    public void search(){
        for(int i=0; i<3; i++){
            if(i == 0)
                System.out.print("S>> ");
            else if (i == 1)
                System.out.print("A>> ");
            else
                System.out.print("B>> ");   
            for(int j=0; j<10; j++){
                System.out.print(counter[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }
    public void search(int number){
        if(number == 1)
                System.out.print("S>> ");
        else if (number == 2)
            System.out.print("A>> ");
        else    
            System.out.print("B>> ");   
        for(int i=0; i<10; i++){
            System.out.print(counter[number][i]);
        }
        System.out.print("\n");
    }
    // 취소 기능... 3
    public String cancel(int number, String name){
        for(int i=0; i<10; i++){
            System.out.printf("0%s0%s0\n", counter[number][i], name.concat(" "));
            if(counter[number][i] == name.concat(" ")){
                counter[number][i] = "--- ";
                return "성공";
            }
        }
        return "실패";
    }
}

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        seat ans = new seat();

        int selectNumber = 0;
        
        System.out.println("명품콘서트홀 예약 시스템입니다.");

        String UserStringSelect = new String();
        int UserIntSelect = 0, UserIntSelectSec = 0;
        do{
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
                selectNumber = scan.nextInt();
            switch(selectNumber){
                case 1:
                    System.out.print("좌석구분 S(1), A(2), B(3)>>");
                    UserIntSelect = scan.nextInt();
                    ans.search(UserIntSelect);
                    System.out.print("이름>>");
                    UserStringSelect = scan.next();
                    System.out.print("번호>>");
                    UserIntSelectSec = scan.nextInt();
                    ans.reservation(UserStringSelect, UserIntSelectSec, UserIntSelect);
                    break;
                case 2:
                    ans.search();
                    break;
                case 3:
                    System.out.print("좌석 S:1, A:2, B:3>>");
                    UserIntSelect = scan.nextInt();
                    ans.search(UserIntSelect);
                    System.out.print("이름>>");
                    UserStringSelect = scan.next();
                    System.out.println(ans.cancel(UserIntSelect, UserStringSelect));
                    break;
            }

        }while(selectNumber != 4);
    }
}