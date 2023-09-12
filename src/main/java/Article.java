public class Article {
    // 제목
    private String title;
    // 내용
    private String content;
    public  Article(String title, String content){
        this.title = title;
        this.content = content;
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

}
