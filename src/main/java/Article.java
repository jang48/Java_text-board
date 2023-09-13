import java.util.ArrayList;
import java.util.HashMap;

public class Article {
    // 게시물 번호
    private int id;
    // 제목
    private String title;
    // 내용
    private String content;
    // 현재 날짜
    private String date;

    private HashMap<Integer, String> comments; // 게시물 ID를 키로, 댓글 내용을 값으로 사용


    // 조회수
    private int click = 1;

    public  Article(int id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
        this.comments = new HashMap<>();
    }

    public  Article(int id, String title, String content, String date){
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public int getClick() {
        return click++;
    }

    // 게시물에 댓글 추가
    public void addComment(int commentId, String comment) {
        comments.put(commentId, comment);
    }

    // 특정 댓글 조회
    public String getComment(int commentId) {
        return comments.get(commentId);
    }

}
