import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> contents = new ArrayList<>();

        while (true) {
            System.out.print("명령어 : ");
            String command = sc.nextLine().trim();

            if (command.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = sc.nextLine();
                titles.add(title);
                // titles.add( sc.nextLine());
                System.out.print("게시물 내용을 입력해주세요 : ");
                contents.add(sc.nextLine());
                System.out.println("게시물이 등록되었습니다.");

            } else if (command.equals("list")) {
                System.out.println("===================");
                for(int i = 0; i < titles.size(); i++){
                    System.out.printf("제목 : %s\n", titles.get(i));
                    System.out.printf("내용 : %s\n", contents.get(i));
                    System.out.println("===================");
                }
            } else if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
