public class Article {
    // 제목
    private String title;
    // 내용
    private String content;
    // 현재 날짜
    private String date;

    public  Article(String title, String content){
        this.title = title;
        this.content = content;
    }

    public  Article(String title, String content, String date){
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

    public String getDate() {
        return date;
    }


}
