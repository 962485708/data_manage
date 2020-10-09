package jwt;
/* Created By DiaoSu
   Date  2020/10/9
   Mail  diaosu@diaosudev.cn */


import java.util.UUID;

public class Constant {
    public static final String JWT_ID = UUID.randomUUID().toString();

    /**
     * 加密密文
     */
    public static final String JWT_SECRET = "data-manage";
    public static final int JWT_TTL = 60*60*1000;  //millisecond
}
