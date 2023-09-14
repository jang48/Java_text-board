import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Article> articles = new ArrayList<>();
        ArrayList<Plus> plus = new ArrayList<>();

        String loggedInUserId = null; // 로그인한 사용자의 아이디를 기억하는 변수
        String loggedInUserNickname = null; // 로그인한 사용자의 닉네임을 기억하는 변수

        int lastId =1;

        while (true) {
            if (loggedInUserId != null && loggedInUserNickname != null) {
                System.out.printf("명령어를 입력해주세요[%s(%s)] : ", loggedInUserId, loggedInUserNickname);
            } else {
                System.out.print("명령어 : ");
            }
            String command = sc.nextLine().trim();
            Date now = new Date();
            SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd");
            String formatedNow = date.format(now);


            if(articles.isEmpty())
            {
            Article a1 = new Article(1,"안녕하세요 반갑습니다. 자바 공부중이에요.","자바 너무 재밌어요!!",formatedNow);
            Article a2 = new Article(2,"자바 질문좀 할게요~","자바 너무 재밌어요!!",formatedNow);
            Article a3 = new Article(3,"정처기 따야되나요?","자바 너무 재밌어요!!",formatedNow);

            articles.add(a1);
            articles.add(a2);
            articles.add(a3);
            }

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

                articleList(article);

                if(!plus.isEmpty()){
                    for (Plus plus1 : plus) {
                        if(plus1.getId() == targetId){
                            System.out.printf("댓글 내용 : %s\n", plus1.getWrite());
                            System.out.printf("댓글 작성일 : %s\n",plus1.getDate());
                            System.out.println("===================");
                        }
                    }

                }

                System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
                int function = sc.nextInt();

                if(function == 1){
                    sc.nextLine();
                    System.out.print("댓글 내용 : ");
                    String comment = sc.nextLine();
                    Plus newplus = new Plus(targetId, comment, formatedNow);
                    plus.add(newplus);
                    System.out.print("댓글이 성공적으로 등록되었습니다\n");
                }else if(function == 3){
                        sc.nextLine();
                        System.out.print("제목 : ");
                        String retitle = sc.nextLine();
                        System.out.print("내용 : ");
                        String recontent = sc.nextLine();
                        Article article2 = new Article(targetId, retitle, recontent, formatedNow, loggedInUserId);
                        articles.set(targetId-1, article2);
                        articleList(article2);
                }else if(function == 4){
                    System.out.print("정말 게시물을 삭제하시겠습니까? (Y / N) : ");
                    sc.nextLine();
                    String answer = sc.nextLine();
                    if(answer.equals("Y")){
                        articles.remove(targetId - 1);
                        System.out.printf("%s님이 %d번 게시물을 삭제했습니다.\n", loggedInUserNickname, targetId);

                    }

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

                boolean loggedIn  = false;
                for(int i = 0; i < articles.size(); i++){
                    Article article = articles.get(i);
                    if(article.getJoinid().equals(joinid) || article.getJoinpw().equals(joinpw)) {
                        loggedIn = true;
                        loggedInUserId = article.getJoinid(); // 사용자의 아이디 저장
                        loggedInUserNickname = article.getJoinname(); // 사용자의 닉네임 저장
                        System.out.printf("%s님 환영합니다!\n", loggedInUserNickname);
                        break; // 로그인 성공 시 루프를 종료합니다.
                    }
                }
                if(!loggedIn){
                    System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
                }


            } else if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
    public static void articleList(Article article){

        int targetId =  article.getId();
        if(!Objects.equals(article.getJoinid(), "")){
            System.out.println("========" + targetId + "번 게시물========");
            System.out.println("번호 : " + targetId);
            System.out.println("제목 : " + article.getTitle());
            System.out.println("내용 : " + article.getContent());
            System.out.println("등록날짜 : " + article.getDate());
            System.out.println("작성자 : " + article.getJoinid());
            System.out.println("=========================");
        }else{
            System.out.println("========" + targetId + "번 게시물========");
            System.out.println("번호 : " + targetId);
            System.out.println("제목 : " + article.getTitle());
            System.out.println("내용 : " + article.getContent());
            System.out.println("등록날짜 : " + article.getDate());
            System.out.println("=========================");
        }

    }
}

