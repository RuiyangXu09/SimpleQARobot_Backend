package module;

public class Request {
    private String key = "free";
    private String appid = "0";
    private String msg = null;

    //构造无参构造函数
    public Request(){

    }
    //构造有参构造函数
    public Request(String message){
        this.msg = message;
    }

    public String getApiKey() {
        return this.key;
    }

    public void setApiKey(String apiKey) {
        this.key = apiKey;
    }

    public String getAppid() {
        return this.appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMessage() {
        return this.msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }
}
