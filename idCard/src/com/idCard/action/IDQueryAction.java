package com.idCard.action;

import java.net.URLEncoder;

import com.idCard.utils.Base64Util;
import com.idCard.utils.FileUtil;
import com.idCard.utils.HttpUtil;

/**
 * 
 * ���֤ʶ�𹤾���
 * 
 * @author cjx
 * 
 *
 */

public class IDQueryAction {

	/**
	 * ���֤ʶ��
	 */

	public static String getIDInfo(String filePath) {

		// ���֤ʶ��url
		String idcardIdentificate = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
		String result = null;
		// ����ͼƬ·��
		// String filePath = "D:\\360Downloads\\ID\\images\\idc.jpg";
		try {
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
			// ʶ�����֤����id_card_side=front;ʶ�����֤����id_card_side=back;
			String params = "id_card_side=front&" + URLEncoder.encode("image", "UTF-8") + "="
					+ URLEncoder.encode(imgStr, "UTF-8");
			/**
			 * ���ϻ���access_token�й���ʱ�䣬 �ͻ��˿����л��棬���ں����»�ȡ��
			 */
			String accessToken = AccessTokenAction.getAuth();
			result = HttpUtil.post(idcardIdentificate, accessToken, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ��Ҫ��ʾ���������蹤���� FileUtil,Base64Util,HttpUtil,GsonUtils���
	 * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	 * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	 * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	 * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3 ����
	 */
	public static void main(String[] args) {
		// ���֤ʶ��url
		String idcardIdentificate = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
		// ����ͼƬ·��
		String filePath = "D:\\360Downloads\\ID\\images\\idc.jpg";
		try {
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
			// ʶ�����֤����id_card_side=front;ʶ�����֤����id_card_side=back;
			String params = "id_card_side=front&" + URLEncoder.encode("image", "UTF-8") + "="
					+ URLEncoder.encode(imgStr, "UTF-8");
			/**
			 * ���ϻ���access_token�й���ʱ�䣬 �ͻ��˿����л��棬���ں����»�ȡ��
			 */
			String accessToken = AccessTokenAction.getAuth();
			String result = HttpUtil.post(idcardIdentificate, accessToken, params);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
