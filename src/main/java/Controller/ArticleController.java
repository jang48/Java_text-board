package Controller;

import java.util.Scanner;

public class ArticleController {

    Scanner sc = new Scanner(System.in);
    public void add(){
        System.out.print("제목을 입력해주세요.");
        String title = sc.nextLine();
        System.out.print("내용을 입력해주세요.");
        String content = sc.nextLine();


    }
}
