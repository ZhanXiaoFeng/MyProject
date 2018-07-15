package com.zrf.io.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testDemo02 {
	public static void main(String[] args) {
		testDemo02 webCrawlerDemo = new testDemo02();
		webCrawlerDemo.myPrint("http://www.sohu.com/");
	}

	public void myPrint(String baseUrl) {
		Map<String, Boolean> oldMap = new LinkedHashMap<String, Boolean>(); // �洢����-�Ƿ񱻱���
		// ��ֵ��
		String oldLinkHost = ""; // host
		Pattern p = Pattern.compile("(https?://)?[^/\\s]*"); // ���磺http://www.zifangsky.cn
		Matcher m = p.matcher(baseUrl);
		if (m.find()) {
			oldLinkHost = m.group();
		}

		oldMap.put(baseUrl, false);
		oldMap = crawlLinks(oldLinkHost, oldMap);
		for (Map.Entry<String, Boolean> mapping : oldMap.entrySet()) {
			System.out.println("���ӣ�" + mapping.getKey());
		}

	}

	/**
	 * ץȡһ����վ���п���ץȡ����ҳ���ӣ���˼·��ʹ���˹�������㷨 ��δ�������������Ӳ��Ϸ���GET����һֱ���������������϶�û�ܷ����µ�����
	 * ���ʾ���ܷ����µ������ˣ��������
	 * 
	 * @param oldLinkHost
	 *            �������磺http://www.zifangsky.cn
	 * @param oldMap
	 *            �����������Ӽ���
	 * 
	 * @return ��������ץȡ�������Ӽ���
	 */
	private Map<String, Boolean> crawlLinks(String oldLinkHost, Map<String, Boolean> oldMap) {
		Map<String, Boolean> newMap = new LinkedHashMap<String, Boolean>();
		String oldLink = "";

		for (Map.Entry<String, Boolean> mapping : oldMap.entrySet()) {
			System.out.println("link:" + mapping.getKey() + "--------check:" + mapping.getValue());
			// ���û�б�������
			if (!mapping.getValue()) {
				oldLink = mapping.getKey();
				// ����GET����
				try {
					URL url = new URL(oldLink);
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(2000);
					connection.setReadTimeout(2000);

					if (connection.getResponseCode() == 200) {
						InputStream inputStream = connection.getInputStream();
						BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
						String line = "";
						Pattern pattern = Pattern.compile("<a.*?href=[\"']?((https?://)?/?[^\"']+)[\"']?.*?>(.+)</a>");
						Matcher matcher = null;
						while ((line = reader.readLine()) != null) {
							matcher = pattern.matcher(line);
							if (matcher.find()) {
								String newLink = matcher.group(1).trim(); // ����
								// String title = matcher.group(3).trim(); //����
								// �жϻ�ȡ���������Ƿ���http��ͷ
								if (!newLink.startsWith("http")) {
									if (newLink.startsWith("/"))
										newLink = oldLinkHost + newLink;
									else
										newLink = oldLinkHost + "/" + newLink;
								}
								// ȥ������ĩβ�� /
								if (newLink.endsWith("/"))
									newLink = newLink.substring(0, newLink.length() - 1);
								// ȥ�أ����Ҷ���������վ������
								if (!oldMap.containsKey(newLink) && !newMap.containsKey(newLink)
										&& newLink.startsWith(oldLinkHost)) {
									// System.out.println("temp2: " + newLink);
									newMap.put(newLink, false);
								}
							}
						}
					}
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				oldMap.replace(oldLink, false, true);
			}
		}
		// �������ӣ���������
		if (!newMap.isEmpty()) {
			oldMap.putAll(newMap);
			oldMap.putAll(crawlLinks(oldLinkHost, oldMap)); // ����Map�����ԣ����ᵼ�³����ظ��ļ�ֵ��
		}
		return oldMap;
	}
}