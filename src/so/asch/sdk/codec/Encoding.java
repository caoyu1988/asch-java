package so.asch.sdk.codec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * 编码辅助类
 * @author eagle.asch
 *
 */
public class Encoding {

    public static String hex(byte[] buffer){
        return new String(Hex.encodeHex(buffer));
    }

    public static String base58(byte[] buffer) {
        return Base58.encode(buffer);
    }

    public static String base64(byte[] buffer){
        return new String(Base64.encodeBase64(buffer));
    }

}
