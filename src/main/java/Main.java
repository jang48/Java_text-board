import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            System.out.print("메뉴 입력 : ");
            Scanner sc = new Scanner(System.in);

            String func = sc.nextLine();

            if(func.equals("a")){
                System.out.println("기능1");
            }else if (func.equals("b")){
                System.out.println("기능2");
            }else if (func.equals("도움말")){
                System.out.println("a : 기능1");
                System.out.println("b : 기능1");
            }else if (func.equals("exit")){
                break;
            }
        }




    }
}
