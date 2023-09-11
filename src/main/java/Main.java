import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> boards = new ArrayList<>();
        int boardcnt = 0;

        while (true) {
            System.out.print("메뉴 입력 : ");
            Scanner sc = new Scanner(System.in);

            String func = sc.nextLine().trim();

            if (func.equals("a")) {
                System.out.println("기능1");
            } else if (func.equals("b")) {
                System.out.println("기능2");
            } else if (func.equals("도움말")) {
                System.out.println("a : 기능1");
                System.out.println("b : 기능1");
            } else if (func.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = sc.nextLine();
                System.out.print("게시물 내용을 입력해주세요 : ");
                String story = sc.nextLine();
                System.out.println("게시물이 등록되었습니다.");
                boardcnt++;
                String board = "==================\n" + " 제목: " + title + "\n" + " 내용: " + story + "\n";
                boards.add(board); // 게시물을 리스트에 추가
            } else if (func.equals("list")) {
                for (String board : boards) {
                    System.out.println(board);
                }
            } else if (func.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
