package com.tools;

import java.io.File;
import java.io.IOException;

public class CoverDownload {
	public String download(int nb) throws IOException {
		Download d = new Download();
		ImgUrl imgUrl = new ImgUrl();
		String urlString = imgUrl.getCoverUrl("http://www.bilibili.com/video/av" + nb);
		System.out.println("URL: " + urlString);
		if (urlString.equals(null)) {
			return null;
		} else {
			File file = new File(nb + ".jpg");
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println(e);
				}
				String retString = d.downloadFromUrl(urlString, "", file.getName());
				if (retString.equals("���������������磬��av�ŵ���Ч��")) {
					file.delete();
					return "���������������磬��av�ŵ���Ч��";
				}
			}
			/*
			 * System.out.println(file.getName());
			 */ return file.getName();
		}
	}
}
