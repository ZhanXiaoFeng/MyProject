package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091300505188";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDxiZHy4oaS14DX1jrAJL/Z6QiPb+2WBDl/jwr9Sx921vu8F0QYK2C63JN21S7rTLxDOcjkorxCSe8rVPu1w5ayP1y+ysqqfA00ylxZJgQ6Z2JgR86attu4bwKGBkdcyQW4BeSTWl7Zz7aZmrgl42Djw2iNQZMVAm13DNnRDeh/A+5sS6uhFKz2279ly0YJeoafCU3Oqtk2Lij9edzGnNeINeNWmJrFZ5QWPtCo4TUNJFEPzdnE3Nff5cLMd6cLK8L3XigAZfr6y+k5Hv2ut3aF2dnAkD1Vy/GD4L2MYiru4uixPueExLrP/m2k4QNxEyHiyh1sUl6Ko+ugJ1CfQEeBAgMBAAECggEBAILE8qnHjwiNeIpiyCgjPWOjUSkndkBURTUUouSD+aMDvgMVrZ5QTeydY5Fg1ig6wWq8LFHs8XQKR1z0g9ri7AHRYEtDy/oFc7jzHpB9jqh4NMDf37HP8qGmKH2bhKNtipUZS6mjsdrHJJuBMtYAhwKJV1+y8wja6Z0c7gjLOOcakoYTswbnwDwgYuVpjHi4blk6fWvL5epIDxfL28rdlvyJJD7b3pvJYSy+3ZRWeM3VL6jejsZKP6aMgjnz0IqZC+ZYz36QsNjGlVbKjluAm9eF0I6+BsllKyQ62U+QhRYjKly8tW8QUSCXVOpdD6B2uRsuW1Wr/xBJZJzIpnAPkokCgYEA+eRZuJZ0vRlI1qKVLoatS69mLmLTfM86LiFgn1vtQYNq0EmqEXM5VPZ8g5sGZXMuO5sQ8EOQttOzSYs11vHYwRBBFaiRip7U3vVZGY+nqqsVNSH5/gxVl5CnU/2Vcqchztt5d66Zo4NfAUS153b0qGctinxMsgRdZmEXs3oN22sCgYEA93DxO/6Vq0u2YoXo+sPF1Zyz6hYiAjbbyRtPFKWt+I8ss378CDvqXJMRUQcwEZZAu6xORD+P4K9L786np7xTqujavR/4dcY3UwKYGM3muCDFE0rcVh6BRVk+Tq+61ijmxg5XzDB1LCiHxsCERXsPyb4M732OEvIQK9LBfwocr8MCgYB31a3A+0XYOPvZEfaAbU1FckOKExJgU/AOlysCwM6yEBd08x5/Z8YinGFxqzISDH4rT118GqqXQkZECmIzRZ8wVl8fx8qjsy9aDEZCH8XD7m8pH7YGwlt5Z4EWohC8/rETxeQmJLDA3Qr+TLj+2ujQqUoJkzokVDuGESGQjAOBKQKBgQDzS6r2mYkiZ4yKbS66OnqwYacJeP+xe605nU9xdsKLToPebfJ0Si1THwv8xvt9n2ZA4dgHBRR8EQCyZ1iz9dmyh8hkAyZy7xYA2eEhKns7+oSsRoRFbTMgM/Kuvd0QrCDVBs9PJype4+80/qBQDQNmEyd259YlTLuXy1+UgSXZrwKBgD7SXGW8bJJj8fJyo7wnRJ20DQj7ULTPgqHBUr8Z+bS6uOL51m5hVLFZYOH2rnYSu3YRh7ceEgzE44lYIvA/gQ+tf3YMaSOrQfXzvkxQo+uYDLLPXKMS/gJaTC3+FQQlxGMACLlfgGnQgvdOtmSAoAYGgvk5CKbqlf4knR00O/xJ";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsbIbl0i4hpwkXvPbtIacse26+kO5DrrqtCfvcpSwYplK+WClfPRZU0qZgf44A6cfohQYhSZEnr6dR69PrTLtEvXOc8Qv00IlQqrJAnMtuNOvEIxkuNezSsyH4c3lNytMPAKXQ76wT02VlK037oOWbll4oxsNmlCL87AztLzFfYriQ9TiTACMQHHbEbGemZH5CrTjpU61LQa9urMwRrzdJrpqu8i1w3rzbI9KAm38L27Ca+BVRD+MtgZrIzFzoDLhvmoZ+Z/UhdqupKm7WJj2d4WQZDU4JfsWpfKOtv8yD6XbEj+/LCFPk9mRPBofNdGoUlouu7KWVg+LNFGQSUbV9QIDAQAB";

	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 * 
	 * @param sWord
	 *            要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
