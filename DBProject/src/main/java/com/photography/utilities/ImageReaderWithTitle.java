package com.photography.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.photography.dao.Photo;

public class ImageReaderWithTitle {
	public static void main(String[] args) throws Exception {

		URL oracle = new URL(
				"https://www.flickr.com/photos/99058885@N05/sets/72157649940563481/");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				oracle.openStream()));

		Pattern titlePattern = Pattern
				.compile("(title=\")([\\/\\w \\.-]*)(\")");
		Matcher matchTitle;

		Pattern urlPattern = Pattern
				.compile("(src=\"https?:\\/\\/)([\\da-z\\.-]+)([a-z\\.]{2,6})([\\/\\w \\.-]*)(\\.jpg)");
		Matcher matchUrl;

		Pattern containerPattern = Pattern.compile("(photo_container pc_ju)");
		Matcher matchContainer;

		String inputLine;
		List<Photo> photos = new ArrayList<Photo>();

		boolean isContainer = false;
		boolean isUrl = false;
		boolean isTitle = false;
		Photo photo = new Photo();
		while ((inputLine = in.readLine()) != null) {
			if (!isContainer) {
				matchContainer = containerPattern.matcher(inputLine);
				isContainer = matchContainer.find();
			}

			if (isContainer && !isUrl) {
				System.out.println("in container");
				matchUrl = urlPattern.matcher(inputLine);
				if (matchUrl.find()) {
					System.out.println(matchUrl.group());
					photo.setUrl(matchUrl.group().substring(5));
					isUrl = true;
				}
			}

			if (isContainer && isUrl && !isTitle) {
				matchTitle = titlePattern.matcher(inputLine);
				if (matchTitle.find()) {
					System.out.println(matchTitle.group());
					photo.setTitle(matchTitle.group().substring(7,
							matchTitle.group().length() - 1));
					isContainer = false;
					isUrl = false;
					System.out.println(photo);
					photos.add(photo);
					photo = new Photo();
				}
			}
		}
		in.close();
		System.out.println(photos.size());
		for (Photo photo1 : photos) {
			System.out.println(photo1);
		}
	}

	public static List<Photo> getPhotos(String link) throws IOException {
		URL oracle = new URL(link);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				oracle.openStream()));

		Pattern titlePattern = Pattern
				.compile("(title=\")([\\/\\w \\.-]*)(\")");
		Matcher matchTitle;

		Pattern urlPattern = Pattern
				.compile("(src=\"https?:\\/\\/)([\\da-z\\.-]+)([a-z\\.]{2,6})([\\/\\w \\.-]*)(\\.jpg)");
		Matcher matchUrl;

		Pattern containerPattern = Pattern.compile("(photo_container pc_ju)");
		Matcher matchContainer;

		String inputLine;
		List<Photo> photos = new ArrayList<Photo>();

		boolean isContainer = false;
		boolean isUrl = false;
		boolean isTitle = false;
		Photo photo = new Photo();
		while ((inputLine = in.readLine()) != null) {
			if (!isContainer) {
				matchContainer = containerPattern.matcher(inputLine);
				isContainer = matchContainer.find();
			}

			if (isContainer && !isUrl) {
				matchUrl = urlPattern.matcher(inputLine);
				if (matchUrl.find()) {
					photo.setUrl(matchUrl.group().substring(5));
					isUrl = true;
				}
			}

			if (isContainer && isUrl && !isTitle) {
				matchTitle = titlePattern.matcher(inputLine);
				if (matchTitle.find()) {
					photo.setTitle(matchTitle.group().substring(7,
							matchTitle.group().length() - 1));
					isContainer = false;
					isUrl = false;
					System.out.println(photo);
					photos.add(photo);
					photo = new Photo();
				}
			}
		}
		in.close();
		return photos;
	}
}
