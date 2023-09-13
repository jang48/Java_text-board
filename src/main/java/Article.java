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


    // 조회수
    private int click = 1;

    public  Article(int id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
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

}
