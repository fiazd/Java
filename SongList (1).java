package cmsc256;
/*
 * Daanish Fiaz
 * CMSC 256 PROJECT 3
 * Fall 2019
 * The purpose of this program is to retrieve songs by an inputted artist
 * and organize them by album then by song title alphabetically.
 * 
 */
//Import Statements
import bridges.connect.Bridges;
import bridges.connect.DataSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Song Data import
import bridges.connect.DataFormatter;
import bridges.data_src_dependent.Song;

public class SongList extends SongComparator{
	public static void main(String[] args) {
		//songlist object
		SongList projectObj = new SongList();
		
		//Make a list for song data
		List<Song> songData = null;
		
		//Retreive artist name from command line if not then prompt user
		String artistName = projectObj.checkArgs(args);
		
		List<Song> songInfo;
		songInfo = projectObj.getSongsByArtist(artistName);
		
		//Call collections sort then print it out		
		Collections.sort(songInfo, new SongComparator());
		
		//Print statement
		for(Song data : songInfo) {
			System.out.println("Title: " +data.getSongTitle() + " Artist: " + data.getArtist() + " Album: " + data.getAlbumTitle());
		}
	}
	//Method that returns a formatted list of all the songs by that artist
	public List<Song> getSongsByArtist(String artist){
		//Song list object
		SongList projectObj = new SongList();
		
		//Bridges object and ds
		Bridges bridges = new Bridges(5, "fiazd", "380059964306");
		DataSource ds = bridges.getDataSource();
		
		//arraylists to contain data
		List<Song> songData2 = null;
		List<Song> songInfo = new ArrayList();
		
		//try catch block
		try {songData2 = ds.getSongData();}
		catch(Exception e) {System.out.println("Error populating songData2.");}
		
		//Retrieve all the song info with that artistName
		for(Song data : songData2) {
			//System.out.println(data.getArtist());
			if(data.getArtist().equals(artist)) {
				songInfo.add(data);	
			}
		} 
		return songInfo;
	}
	
	//Retrieves artist name from the command line, if it isn't there prompt for it.
	public String checkArgs(String[] argv) {
		String artistName = null;
		SongList projectObj = new SongList();
		
		if(0 < argv.length) {
			artistName = argv[0] + " " + argv[1];
		}
		else {artistName = projectObj.promptForArtistName();}
		return artistName;
	}
	//promptForSongName
	public String promptForArtistName() {
		String artistName = null;
		Scanner in = new Scanner(System.in);
		System.out.print("Input artist name: ");
		String firstName = in.next();
		String lastName = in.next();
		
		artistName = firstName + " " + lastName;
		return artistName;
	}
	
	
	
	
	
}
