public class Plus {

    //게시물 번호
    private int id;
    //댓글
    private String write;
    private String date;

    public Plus( int id, String write, String date){
        this.id = id;
        this.write = write;
        this.date = date;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
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
}
