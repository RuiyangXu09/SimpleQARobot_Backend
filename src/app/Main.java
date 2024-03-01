package app;

import module.Response;
import service.QykQARobotServiceImpl;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {
    //调用QA机器人问答类，初始化一个对象robotService
    private static final QykQARobotServiceImpl robotService = new QykQARobotServiceImpl();
    //Main
    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("name");
        String name = keyboard.nextLine();
        System.out.println("你的名字是" + name);
        while (true){
            System.out.println("Please input your question.");
            String input = keyboard.nextLine();
            if (input.equalsIgnoreCase("end")){
                System.out.println("QA Robot Service is over.");
                break;
            }else {
                //调用qaService方法，传入用户输入的数据，作为参数msg传入qaService方法
                Response result = robotService.qaService(input);
                //如果result返回不为空，即输出结果
                if (result != null && result.getCode() == 0){
                    //转码
                    System.out.println("Your answer is: " + new String(result.getContent().getBytes(), "UTF-8"));
                }else {
                    System.out.println("Do not understand, Please check your question and ask me again.");
                }
            }
        }
        keyboard.close();
    }
}
