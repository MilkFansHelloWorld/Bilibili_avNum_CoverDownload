package com.tools;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class Download {
	public String downloadFromUrl(String url, String dir, String fileNameString) {
		try {
			URL httpurl = new URL(url);
			String fileName = fileNameString;
			System.out.println(fileName);
			File f = new File(dir + fileName);
			FileUtils.copyURLToFile(httpurl, f);
		} catch (Exception e) {
			System.out.println(e);
			return "???????????????¿k??av?????ÈL??";
		}
		System.out.println("Successful");
		return "Successful!";
	}
}
