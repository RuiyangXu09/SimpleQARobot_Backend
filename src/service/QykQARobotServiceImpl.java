package service;

import com.google.gson.Gson;
import module.Response;
import util.HttpUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *使用青云客智能问答机器人api，实现QARobotService接口，实现其中的方法qaService
 */
public class QykQARobotServiceImpl implements QARobotService{
    //传入路径样式为：http://api.qingyunke.com/api.php?key=free&appid=0&msg=%E4%BD%A0%E5%A5%BD，因此仅需替换msg后的内容即可
    private static final String apiTpl = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=%s";
    private static final Gson gson = new Gson();

    @Override
    public Response qaService(String msg) throws UnsupportedEncodingException {
        //使用format方法替换 apiTpl中的%s，替换为main函数中传入的用户输入的msg，需要传入中文，所以需要进行编码
        String api = String.format(apiTpl, URLEncoder.encode(msg, "UTF-8"));
        //调用工具类HttpUtils中的静态request方法，传入路径进行解析，初始化一个字符串类型接收，HttpUtils的工具类也需要传入字符串类型的对象进行解析
        String result = HttpUtils.request(api);
        //使用gson，传入json字符串，并解析为一个Response对象
        Response response = gson.fromJson(result, Response.class);

        return response;
    }
}
