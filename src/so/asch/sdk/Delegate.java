package so.asch.sdk;

import com.alibaba.fastjson.JSONObject;

/**
 * Asch受托人接口
 * @author eagle.asch
 * 参见 https://github.com/AschPlatform/asch-docs/blob/master/asch_http_interface.md#24-%E5%8F%97%E6%89%98%E4%BA%BAdelegates
 */
public interface Delegate extends AschInterface {

    //接口地址：/api/delegates/count
    //请求方式：get
    //支持格式：无
    //请求参数说明：无
    //返回参数说明：
    //success	boole	是否成功获得response数据
    //count	integer	受托人总个数
    JSONObject getCount();

    //接口地址：/api/delegates/voters
    //请求方式：get
    //支持格式：urlencoded
    //请求参数说明：
    //publicKey	string	Y	受托人公钥
    //返回参数说明：
    //success	boole	是否成功获得response数据
    //accounts	Array	账户json串组成的数组
    JSONObject getVoters();

    //接口地址： /api/delegates/get/
    //请求方式：get
    //支持格式：urlencoded
    //接口备注：通过公钥或者用户名获取受托人信息
    //请求参数说明：
    //publickey	string	二选一	受托人公钥
    //username	string	二选一	受托人用户名
    //返回参数说明：
    //success	boole	是否成功获得response数据
    //delegate	json	委托人详情
    JSONObject getDelegate(String publicKey, String userName);

    //接口地址：/api/delegates
    //请求方式：get
    //支持格式：urlencoded
    //接口说明：如果不加参数则会返回全网受托人列表
    //请求参数说明：
    //address	string	N	受托人地址
    //limit	int	N	限制返回结果数据集的个数
    //offset	integer	N	偏移量，最小值：0
    //orderBy	string	N	排序字段:排序规则，如:desc
    //返回参数说明：
    //success	boole	是否成功获得response数据
    //delegates	Array	受托人详情列表
    JSONObject getDelegates(String address, int limit, int offset, String orderBy);

    //接口地址：/api/delegates/fee
    //请求方式：get
    //支持格式：urlencoded
    //请求参数说明：
    //publicKey	string	Y	受托人公钥
    //返回参数说明：
    //success	boole	是否成功获得response数据
    //fee	integer	转账费
    JSONObject getDelegateFee(String publicKey);

    //接口地址：/api/delegates/forging/getForgedByAccount
    //请求方式：get
    //支持格式：urlencoded
    //请求参数说明：
    //generatorPublicKey	string	Y	区块生成者公钥
    //返回参数说明：
    //success	boole	是否成功获得response数据
    //fees	integer	收取的手续费
    //rewards	integer	已获得奖励
    //forged	integer	锻造获得的总奖励
    JSONObject getForging(String publicKey);

    //接口地址：/api/delegates
    //请求方式：put
    //支持格式：urlencoded
    //请求参数说明：
    //secret	string	Y	asch账户密码
    //publicKey	string	N	公钥
    //secondSecret	string	N	asch账户二级密码，最小长度：1，最大长度：100
    //username	string	N	受托人名字
    //返回参数说明：
    //success	boole	是否成功获得response数据
    //transaction	json	注册受托人交易详情
    JSONObject registerDelegate(String secret, String publicKey, String secondSecret, String userName);

    //接口地址：/api/delegates/forging/enable
    //请求方式：post
    //支持格式：urlencoded //url必须是受托人所在服务器
    //请求参数说明：
    //secret	string	Y	asch账户密码
    //publicKey	string	N	公钥
    //返回参数说明：
    //success	boole	是否成功获得response数据
    //address	string	受托人地址
    JSONObject enableForge(String secret, String publicKey);

    //接口地址：/api/delegates/forging/disable
    //请求方式：post
    //支持格式：urlencoded //url必须是受托人所在服务器
    //请求参数说明：
    //secret	string	Y	asch账户密码
    //publicKey	string	N	公钥
    //返回参数说明：
    //success	boole	是否成功获得response数据
    //address	string	受托人地址
    JSONObject disableForge(String secret, String publicKey);

    //接口地址：/api/delegates/forging/status
    //请求方式：get
    //支持格式：urlencoded
    //请求参数说明：
    //publicKey	string	Y	公钥
    //返回参数说明：
    //success	boole	是否成功获得response数据
    //enabled	string	锻造是否开启
    JSONObject getForgingStatus(String publicKey);

}
