import java.util.HashMap;

public class Article {
    private int id;
    private String title;
    private String content;
    private String date;
    private HashMap<Integer, String> comments; // 게시물 ID를 키로, 댓글 내용을 값으로 사용

    public Article(int id, String title, String content, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.comments = new HashMap<>();
    }

    // 게시물에 댓글 추가
    public void addComment(int commentId, String comment) {
        comments.put(commentId, comment);
    }

    // 특정 댓글 조회
    public String getComment(int commentId) {
        return comments.get(commentId);
    }

    // 게시물의 정보 출력
    public void displayArticle() {
        System.out.println("========" + id + "번 게시물========");
        System.out.println("번호: " + id);
        System.out.println("제목: " + title);
        System.out.println("내용: " + content);
        System.out.println("등록날짜: " + date);
        System.out.println("댓글 수: " + comments.size());
        System.out.println("==================
