package com.photography.service;

import java.io.IOException;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.photography.dao.Album;
import com.photography.dao.Photo;
import com.photography.dao.PhotosDao;
import com.photography.utilities.ImageReaderWithTitle;

@WebService
public class PhotosService {

	@Autowired
	private PhotosDao photosDao;
	
	
	public List<Photo> getPhotosByUser(String username) {
		return photosDao.getPhotos(username);
	}

	public void selectPhotos(List<Integer> selectedIds) {
		photosDao.selectPhotos(selectedIds);
	}

	public void uploadAlbum(Album album) throws IOException {
		photosDao.uploadPhotos(album.getUsername(),ImageReaderWithTitle.getPhotos(album.getLink()));
	}

}

