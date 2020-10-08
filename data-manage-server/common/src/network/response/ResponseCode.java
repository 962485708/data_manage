package network.response;
/* Created By DiaoSu
   Date  2020/10/8
   Mail  diaosu@diaosudev.cn */


public enum ResponseCode {
    //这里是可以自己定义的，方便与前端交互即可
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(200,"成功"),
    SERVER_ERROR(500,"服务器内部错误"),
    DUPLICATE(400,"重复的数据"),
    PARAM_ERROR(401,"请求数据格式错误"),
    NO_ERROR(404,"查询没有结果");

    private Integer code;
    private String message;

    ResponseCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
