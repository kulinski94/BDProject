package com.dealers.service;

import java.io.IOException;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.dealers.dao.Album;
import com.dealers.dao.Photo;
import com.dealers.dao.PhotosDao;
import com.dealers.utilities.ImageReaderWithTitle;

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

