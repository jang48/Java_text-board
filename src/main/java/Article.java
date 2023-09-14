public class Article {
    // 게시물 번호
    private int id;
    // 제목
    private String title;
    // 내용
    private String content;
    // 조회수
    private int hit;
    // 현재 날짜
    private String date;
    // 아이디
    private String joinid;
    // 비밀번호
    private String joinpw;
    // 닉네임
    private String joinname;


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

    public  Article(int id, String title, String content, String date, String joinid){
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.joinid = joinid;
    }
    public  Article(String joinid, String joinpw, String joinname){
        this.joinid = joinid != null ? joinid : "";
        this.joinpw = joinpw != null ? joinpw :"";
        this.joinname = joinname;
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

    public void setDate(String date) {
        this.date = date;
    }
    public String getJoinid() {
        return joinid != null ? joinid : "";
    }

    public void setJoinid(String joinid) {
        this.joinid = String.valueOf(joinid);
    }

    public String getJoinpw() {
        return joinpw != null ? joinpw : "";
    }

    public void setJoinpw(String joinpw) {
        this.joinpw = joinpw;
    }

    public String getJoinname() {
        return joinname;
    }

    public void setJoinname(String joinname) {
        this.joinname = joinname;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    /*
    public void increaseHit(){  >> 비지니스 로직이 즉 setter이나 getter이 있는 데이터만 저장하고 표현하는 class 에서는 데이터를 처리하는 행위를 지양해야한다.
        // 게시물 기능의 일부 -> 비지니스 로직, 서비스 로직
        this.hit++;
    }
     */
}