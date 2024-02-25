package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import com.kodnest.tunehub.entity.Song;

public interface SongService {

	public String addSong(Song song);
	
	public List<Song> fetchAllSongs();
	
	public boolean songExists(String name);
}
