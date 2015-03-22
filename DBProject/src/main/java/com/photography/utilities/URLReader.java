package com.photography.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLReader {
	public static void main(String[] args) throws Exception {
		// getImagesFromLink("https://www.flickr.com/photos/99058885@N05/sets/72157649545777835/page2/");
		System.out
				.println(matchesFlickerAlbumLink("flickr.com/photos/99058885@N05/sets/72157649545777835/page2/"));
	}

	public static List<String> getImagesFromLink(String link)
			throws IOException {
		URL flicker = new URL(link);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				flicker.openStream()));

		String inputLine;
		Pattern p = Pattern
				.compile("(src=\"https?:\\/\\/)([\\da-z\\.-]+)([a-z\\.]{2,6})([\\/\\w \\.-]*)(\\.jpg)");
		Matcher m;
		StringBuilder sb = new StringBuilder();
		List<String> images = new ArrayList<String>();
		while ((inputLine = in.readLine()) != null) {
			m = p.matcher(inputLine);
			if (m.find()) {
				images.add(m.group().substring(5));
			}
		}
		in.close();
		images.remove(0);
		for (String string : images) {
			System.out.println(string);
		}
		System.out.println(images.size());
		return images;
	}

	public static boolean matchesFlickerAlbumLink(String link) {
		Pattern p = Pattern
				.compile("(https?:\\/\\/www.){0,1}(flickr.com)([\\/\\w \\.-]*)");
		Matcher m = p.matcher(link);
		return m.find();
	}
}
