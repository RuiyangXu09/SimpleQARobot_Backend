package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 工具包类
 */
public class HttpUtils {
    //静态工具方法，经过json解析后返回一个字符串，接收外部传入的链接对象api，类型为String
    public static String request(String api){
        //初始化一个HttpURLConnection对象
        HttpURLConnection connection = null;
        //初始化一个responseCode对象，类型为int
        int responseCode = 0;

        try {
            //传入api地址
            URL url = new URL(api);
            //获取对应的链接对象
            connection = (HttpURLConnection) url.openConnection();
            //获取对应的responseCode，状态码
            responseCode = connection.getResponseCode();

            //判断状态码的类别
            if (200 <= responseCode && responseCode <= 299){
                //接收传入的对应状态码的解析后的json值
                try {
                    //获取传入的输入流
                    InputStream input =connection.getInputStream();
                    //创建字节输入流和字节输入缓冲流
                    InputStreamReader isr = new InputStreamReader(input);
                    BufferedReader bfr = new BufferedReader(isr);

                    //初始化一个字符串拼接对象，用于拼接获取的字符串
                    StringBuilder response = new StringBuilder();
                    String line = "";
                    while ((line = bfr.readLine()) != null){
                        response.append(line);
                    }

                    //将结果赋值给output对象
                    String output = response.toString();
                    bfr.close();
                    isr.close();

                    //返回output
                    return output;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error 404!";
    }
}
