import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 이름 짓는 규칙
        // 변수, 클래스 -> 명사
        // 함수 -> 동사
        // 단어 조합시 단어 의미가 바뀔 때마다 대문자 표현  - > 카멜표기법
        // 클래스 이름 지을 때는 첫글자 무조건 대문자
        // 누가 봐도 추측 가능한.
        // 파파고나 구글 번역기, 챗 gpt 켜서 이름 짓기
        // 이름 짓는 건 너무너무너무너무 중요함

        // 코드 정렬
        // Alt + Ctrl + L  ( 자동 줄맞춤)

        Scanner sc = new Scanner(System.in);
        List<String> boards = new ArrayList<>();
        int boardcnt = 0;

        while (true) {
            System.out.print("명령어 : ");
            String func = sc.nextLine().trim();

            if (func.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = sc.nextLine();
                System.out.print("게시물 내용을 입력해주세요 : ");
                String story = sc.nextLine();
                System.out.println("게시물이 등록되었습니다.");

                boardcnt++;

                String board = "==================\n" + " 번호 : " + boardcnt + "\n"+" 제목: " + title ;
                boards.add(boardcnt-1,board);
            } else if (func.equals("list")) {
                int index = 1;
                for (String board : boards) {
                    index++;
                    System.out.println(board);
                }
            } else if (func.equals("update")) {
                System.out.print("수정할 게시물 번호 : ");
                int postNumber = Integer.parseInt(sc.nextLine()) - 1;
                if(postNumber >= 0 && postNumber < boards.size()) {
                    System.out.print("제목 : ");
                    String updatedTitle = sc.nextLine();
                    System.out.print("내용 : ");
                    String updatedStory = sc.nextLine();
                    System.out.println((postNumber + 1) + " 번 게시물이 수정되었습니다.");

                    String updatedBoard = "==================\n" + " 번호 : " + (postNumber + 1) +"\n" + " 제목: " + updatedTitle;
                    boards.set(postNumber, updatedBoard);
                } else {
                    System.out.println("없는 게시물 번호입니다.");
                }
            } else if (func.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
