import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Article> articles = new ArrayList<>();
        ArrayList<Plus> plus = new ArrayList<>();

        int lastId =1;

        while (true) {
            System.out.print("명령어 : ");
            String command = sc.nextLine().trim();
            Date now = new Date();
            SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            String formatedNow = date.format(now);

            if (command.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = sc.nextLine();
                System.out.print("게시물 내용을 입력해주세요 : ");
                String content = sc.nextLine();

                Article article = new Article(lastId,title,content,formatedNow);
                articles.add(article);

                System.out.println("게시물이 등록되었습니다.");

            } else if (command.equals("list")) {
                System.out.println("===================");

                if(articles.size() == 0)
                {
                    String title;
                    String content;
                    title = "안녕하세요 반갑습니다. 자바 공부중이에요.";
                    content = "자바 너무 재밌어요!!";

                    Article article = new Article(lastId,title,content,formatedNow);
                    articles.add(article);

                    title = "자바 질문좀 할게요~";
                    content = "자바 너무 재밌어요!!";
                    Article article2 = new Article(lastId,title,content,formatedNow);
                    articles.add(article2);

                    title = "정처기 따야되나요?";
                    content = "자바 너무 재밌어요!!";
                    Article article3 = new Article(lastId,title,content,formatedNow);
                    articles.add(article3);
                }

                for(int i = 0; i < articles.size(); i++){
                    Article article = articles.get(i);
                    System.out.printf("번호 : %d\n", i + 1);
                    System.out.printf("제목 : %s\n",article.getTitle());
                    System.out.println("===================");
                }
            } else if (command.equals("update")) {
                System.out.print("수정할 게시물 번호 : ");
                int target = sc.nextInt();

                sc.nextLine(); // nextInt를 사용하게되면 nextLine()를 써줘야 다음 글과 겹쳐서 안나와

                System.out.print("새로운 제목 : ");
                String newtitle = sc.nextLine();
                System.out.print("새로운 내용 : ");
                String newcontent = sc.nextLine();

                Article newArticle = new Article(target, newtitle, newcontent);
                articles.set(target-1, newArticle);

                System.out.println("수정이 완료되었습니다.");

            } else if (command.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
                int targetId = sc.nextInt();

                sc.nextLine();

                Article article = articles.get(targetId-1);
                System.out.println("========" + targetId + "번 게시물========");
                System.out.println("번호 : " + targetId);
                System.out.println("제목 : " + article.getTitle());
                System.out.println("내용 : " + article.getContent());
                System.out.println("등록날짜 : " + article.getDate());
                System.out.println("조회수 : " + article.getClick());
                System.out.println("========================");

                for(int i = 0; i < plus.size(); i++){
                    Plus plus1 = plus.get(i);
                    if(plus1.getId() == targetId){
                    System.out.printf("번호 : %d\n", i + 1);
                    System.out.printf("제목 : %s\n",article.getTitle());
                    System.out.println("===================");}
                }

                System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
                int function = sc.nextInt();
                sc.nextLine();
                if(function == 1){
                    System.out.print("댓글 내용 : ");
                    String comment = sc.nextLine();
                    Plus newplus = new Plus(targetId, comment, formatedNow);
                    plus.set(targetId, newplus);
                    System.out.print("댓글이 성공적으로 등록되었습니다\n");
                }



            } else if (command.equals("search")) {
                System.out.print("검색 키워드를 입력해주세요 :");
                String keyword = sc.nextLine();
                boolean check = false;

                System.out.println("===================");
                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);
                    if (article.getTitle().contains(keyword)) {
                        System.out.printf("번호 : %d\n", i + 1);
                        System.out.printf("제목 : %s\n", article.getTitle());
                        System.out.println("===================");
                        check = true;
                    }
                }
                if (!check) {
                    System.out.println("검색 결과가 없습니다.");
                    System.out.println("===================");
                }
            } else if (command.equals("delete")) {
                    System.out.print("삭제할 게시물 번호 : ");
                    int target = sc.nextInt();

                    sc.nextLine();
                    if(0 <= target && target <= articles.size()) {
                        articles.remove(target - 1);
                        System.out.printf("%d번 게시물이 삭제되었습니다.\n",target);
                    }
                    else{
                        System.out.printf("없는 게시물 번호입니다.\n");
                    }
            } else if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}

