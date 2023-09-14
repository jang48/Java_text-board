import java.text.SimpleDateFormat;
import java.util.*;

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
                article.setHit(article.getHit()+1);

                System.out.println("========" + targetId + "번 게시물========");
                System.out.println("번호 : " + targetId);
                System.out.println("제목 : " + article.getTitle());
                System.out.println("내용 : " + article.getContent());
                System.out.println("등록날짜 : " + article.getDate());
                System.out.println("조회수 : " + article.getHit());
                System.out.println("========================");

                if(!plus.isEmpty()){
                    for (Plus plus1 : plus) {
                        if(plus1.getId() == targetId){
                            System.out.printf("댓글 내용 : %s\n", plus1.getWrite());
                            System.out.printf("댓글 작성일 : %s\n",plus1.getDate());
                            System.out.println("===================");
                        }
                    }

                }

                System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
                int function = sc.nextInt();

                if(function == 1){
                    sc.nextLine();
                    System.out.print("댓글 내용 : ");
                    String comment = sc.nextLine();
                    Plus newplus = new Plus(targetId, comment, formatedNow);
                    plus.add(newplus);
                    System.out.print("댓글이 성공적으로 등록되었습니다\n");
                }else if(function == 5){
                    sc.nextLine();  // nextLine이 없으면  System.out.print("명령어 : ");
                                    //                    String command = sc.nextLine().trim();
                                    //                    이 작동될때  next가 있으면 버퍼에서 내가 작성한걸 뺀다.
                                     //                   nextline하고 엔터치면 엔터까지 가져간다. 그래서 5를 친 경우 "명령어"가 나오고 다음 command에는 변수 command에 아무것도 없는 상태여서 다시 while문이 돌고 명령어가 나온다.
                    System.out.println("상세보기 화면을 빠져나갑니다.\n");
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
                        System.out.print("없는 게시물 번호입니다.\n");
                    }
            } else if (command.equals("signup")) {
                System.out.println("==== 회원 가입을 진행합니다 ====");
                System.out.print("아이디를 입력해주세요 : ");
                String joinid = sc.nextLine();
                System.out.print("비밀번호를  입력해주세요 : ");
                String joinpw = sc.nextLine();
                System.out.print("닉네임을 입력해주세요 : ");
                String joinname = sc.nextLine();
                System.out.print("==== 회원가입이 완료되었습니다. ====\n");


                Article joinArticle = new Article(joinid, joinpw, joinname);
                articles.add(joinArticle);
            } else if (command.equals("login")) {
                System.out.print("아이디 : ");
                String joinid = sc.nextLine();
                System.out.print("비밀번호 : ");
                String joinpw = sc.nextLine();

                boolean join = false;
                for(int i = 0; i < articles.size(); i++){
                    Article article = articles.get(i);
                    if(article.getJoinid().equals(joinid)){
                        if(article.getJoinpw().equals(joinpw)){
                            join = true;
                        }
                    }else if(!Objects.equals(article.getJoinid(), joinid) || !join){
                        System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
                    }
                }


            } else if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}

