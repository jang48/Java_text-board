import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherMain {

    static ArrayList<Article> articles = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        ArrayList<String> titles = new ArrayList<>();
//        ArrayList<String> contents = new ArrayList<>();
//        ArrayList<Article> articles = new ArrayList<>();

        int lastId = 1;

        while (true) {
            System.out.print("명령어 : ");
            String command = sc.nextLine().trim();

            if (command.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = sc.nextLine();
                // titles.add(title);
                // titles.add( sc.nextLine());
                System.out.print("게시물 내용을 입력해주세요 : ");
                String content = sc.nextLine();
                //contents.add(sc.nextLine());

                Article article = new Article(lastId,title,content);
                articles.add(article);
                lastId++;
                System.out.println("게시물이 등록되었습니다.");

            } else if (command.equals("list")) {
                System.out.println("===================");

                for(int i = 0; i < articles.size(); i++){
                    Article article = articles.get(i);

//                    System.out.printf("번호 : %d\n", i + 1);
                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n",article.getTitle());
                    // System.out.printf("내용 : %s\n", contents.get(i));
                    System.out.println("===================");
                }
            } else if (command.equals("update")) {
                System.out.print("수정할 게시물 번호 : ");
                int targetid = sc.nextInt();

                sc.nextLine(); // nextInt를 사용하게되면 nextLine()를 써줘야 다음 글과 겹쳐서 안나와
                boolean isExist = false;
                for(int i = 0; i < articles.size(); i++){
                    Article article = articles.get(i);

                    if(targetid == article.getId()) {
                        System.out.print("새로운 제목 : ");
                        String newtitle = sc.nextLine();
                        System.out.print("새로운 내용 : ");
                        String newcontent = sc.nextLine();

                        Article newArticle = new Article(targetid,newtitle, newcontent);
                        articles.set(i, newArticle);

                        System.out.println("수정이 완료되었습니다.");
                        isExist = true;
                    }

                }
                if(!isExist){
                System.out.println("없는 게시물입니다.");}

//                if(0 <= target && target <= articles.size()) {
//                System.out.print("새로운 제목 : ");
//                String newtitle = sc.nextLine();
//                System.out.print("새로운 내용 : ");
//                String newcontent = sc.nextLine();
//
//                Article newArticle = new Article(newtitle, newcontent);
//
//                articles.set(target-1, newArticle);

//                System.out.println("수정이 완료되었습니다.");
//                }
//                else {
//                    System.out.println("없는 게시물입니다.");
//                }

//                titles.set(target-1, newtitle);
//                contents.set(target-1, newcontent);

            } else if (command.equals("detail")) {
                 // 중복 -> 2번이상 > 함수를 만들어서 중복을 최소화 하자.
                System.out.println("상세보기 할 게시물 번호를 입력해주세요.");
                int targetId = sc.nextInt();
                Article article = findById(targetId);

                if(article == null){
                    System.out.println("존재하지 않는 게시물입니다.");
                } else {
                    System.out.println("====================");
                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.printf("내용 : %s\n", article.getContent());
                    System.out.println("====================");
                }

            } else if (command.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int targetid = sc.nextInt();

                sc.nextLine();

                boolean isExist = false;
                for(int i = 0; i < articles.size(); i++){
                    Article article = articles.get(i);

                    if(targetid == article.getId()) {
                        articles.remove(i);
                        System.out.printf("%d번 게시물이 삭제되었습니다.\n",targetid);
                        isExist = true;
                    }

                }
                if(!isExist){
                    System.out.println("없는 게시물입니다.");}


                // index -> 0 부터 시작하기 때문에 0보다 작으면 안됨
                // 내가 가지고 있는 데이터의 개수 -1보다 크면 안됨
//                if(0 <= target && target <= articles.size()) {
//                    articles.remove(target - 1);
//                    System.out.printf("%d번 게시물이 삭제되었습니다.\n",target);
//                }
//                else{
//                    System.out.printf("없는 게시물 번호입니다.\n");
//                }
            } else if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    public static Article findById(int id) {

        Article target = null;

        for(int i = 0 ; i < articles.size(); i++){
            Article article = articles.get(i);
            if(id == article.getId()){
                target = article;
            }
        }

        return target;

    }
}
