import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Article> articles = new HashMap<>();
        int lastId = 1;

        while (true) {
            System.out.print("명령어 : ");
            String command = sc.nextLine().trim();

            if (command.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = sc.nextLine();
                System.out.print("게시물 내용을 입력해주세요 : ");
                String content = sc.nextLine();

                Article article = new Article(lastId, title, content, "게시물 작성 날짜");
                articles.put(lastId, article);
                lastId++;

                System.out.println("게시물이 등록되었습니다.");
            } else if (command.equals("list")) {
                System.out.println("===================");

                for (Article article : articles.values()) {
                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.println("===================");
                }
            } else if (command.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
                int targetId = sc.nextInt();
                sc.nextLine();

                Article article = articles.get(targetId);
                if (article != null) {
                    article.displayArticle();

                    System.out.println("=======댓글=======");
                    HashMap<Integer, String> comments = article.getComments();
                    for (Integer commentId : comments.keySet()) {
                        System.out.printf("댓글 내용 : %s\n", comments.get(commentId));
                        System.out.println("================");
                    }

                    System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
                    String function = sc.nextLine();
                    if (function.trim().equals("1")) {
                        System.out.print("댓글 내용 : ");
                        String commentText = sc.nextLine();
                        int commentId = article.getLastCommentId() + 1;
                        article.addComment(commentId, commentText);

                        System.out.println("댓글이 성공적으로 등록되었습니다.");
                    }
                } else {
                    System.out.println("존재하지 않는 게시물 번호입니다.");
                }
            } else if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
