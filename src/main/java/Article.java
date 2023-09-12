public class Article {
    // 제목
    private String title;
    // 내용
    private String content;
    // 현재 날짜
    private String date;

    // 조회수
    private int click = 1;

    public  Article(String title, String content){
        this.title = title;
        this.content = content;
    }

    public  Article(String title, String content, String date){
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public  Article(String title, String content, String date, int click){
        this.title = title;
        this.content = content;
        this.date = date;
        this.click = click;
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

    public String getDate() {
        return date;
    }

    public int getClick() {
        return click++;
    }
}
