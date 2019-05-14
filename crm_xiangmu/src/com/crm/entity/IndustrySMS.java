package com.crm.entity;

import com.crm.util.HttpUtil;




/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS{
	private static String operation = "/industrySMS/sendSMS";
	private static String accountSid = Config.ACCOUNT_SID;
	/*private static String smsContent = "【夕阳红服装店】您的验证码为{"+num+"}，请于{2}分钟内正确输入，如非本人操作，请忽略此短信。";*/
	/**
	 * 验证码通知短信
	 */
	
	
	//   用户输入的手机号和随机生成的验证码传过来
	public static String execute(String to,Integer code)
	{
		String url = Config.BASE_URL + operation;
		 String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + 
				 "【甜甜食品】您的验证码为{"+code+"}，请于{2}分钟内正确输入，如非本人操作，请忽略此短信。"+ HttpUtil.createCommonParam();
		// 提交请求
		String result = HttpUtil.post(url, body);
		return result;
	}

}
