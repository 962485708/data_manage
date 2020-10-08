package network.response;
/* Created By DiaoSu
   Date  2020/10/8
   Mail  diaosu@diaosudev.cn */


public class BaseResponse<T> {
    public int code;
    public T data;
    public String message;

    public BaseResponse(ResponseCode code, T data) {
        this.code = code.getCode();
        this.data = data;
        this.message = code.getMessage();
    }

    public BaseResponse() {
        super();
    }

}
