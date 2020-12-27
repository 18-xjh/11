import java.io.File;
import java.util.Scanner;

public class Test {
    public static  void main(String[] args){
        System.out.println("请输入用户名: ");
        Scanner sc=new Scanner(System.in);
        String username=sc.next();
        System.out.println("刚刚输入的用户名: "+username);
        System.out.println("请输入密码:");

        String password=sc.next();
        System.out.println("刚刚输入的密码: "+password);

        /*
        开始读文件
         */
        File file=new File("\u202AC:\\Users\\dell\\Desktop\\users.xlsx");
        ReadExcel readExcel=new ReadExcel();//创建对象
        User users[]=readExcel.readExcel(file);
        System.out.println(users.length);
        for(User user:users){
            System.out.print(user.getUsername());
            System.out.println("\t"+user.getPassword());
        }

    }
}
