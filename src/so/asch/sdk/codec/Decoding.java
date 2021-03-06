package so.asch.sdk.codec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * 解码辅助类
 * @author eagle.asch
 *
 */
public class Decoding {

    public static byte[] hex(String hexString) throws DecodingException{
        try {
            return Hex.decodeHex(hexString.toCharArray());
        }
        catch (Exception ex){
            throw new DecodingException("decode hex failed",ex);
        }
    }

    public static byte[] utf8(String utf8String)throws DecodingException{
        try{
            return utf8String.getBytes("UTF-8");
        }
        catch (Exception ex){
            throw new DecodingException("decode utf8 failed",ex);
        }
    }

    public static byte[] base64(String base64String){
        return Base64.decodeBase64(base64String);
    }
}
