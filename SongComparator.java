package cmsc256;

import java.util.Comparator;
import bridges.data_src_dependent.Song;

public class SongComparator implements Comparator<Song> {
	
	@Override
	/*
	 * Comparison method, first compare by album
	 * then compare by song title
	 */
	public int compare(Song song1, Song song2) {
		int albumTitleCompare = song1.getAlbumTitle().compareTo(song2.getAlbumTitle());
		int songTitleCompare = song1.getSongTitle().compareTo(song2.getSongTitle());
		
		if(albumTitleCompare == 0) {
			return ((songTitleCompare == 0) ? albumTitleCompare : songTitleCompare);
		}else {return albumTitleCompare;}
	}

}
