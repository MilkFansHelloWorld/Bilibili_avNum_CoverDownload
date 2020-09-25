package com.tools;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ImgUrl {
	public String getCoverUrl(String URL) throws IOException {
			Document document=Jsoup.connect(URL).get();
			Element linkElement=document.select("meta").get(9);
			String linkString=linkElement.attr("content");
			return linkString;
	}
}
