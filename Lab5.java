package cmsc256;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.ActorMovieIMDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lab5 {
	public static void main(String[]args) {
		Bridges bridges = new Bridges(5, "fiazd", "380059964306");
		DataSource ds = bridges.getDataSource();
		
		List<ActorMovieIMDB> movieData = null;
		try {movieData = ds.getActorMovieIMDBData();}
		catch(Exception e) {System.out.println("Unable to connect to Bridges.");}
		
		for(int i = 0; i < 5; i++) {
			ActorMovieIMDB entry = movieData.get(i);
			//System.out.println("" + i + ". " + entry.getActor() + 
				//	" was in " + entry.getMovie());
		}
		
		//Enhanced for loop
		//Get all actors who appeared in "Being_John_Malkovich_(1999)"
		List<ActorMovieIMDB> movieData2 = null;
		List<ActorMovieIMDB> actors = new ArrayList();
		
		try {movieData2 = ds.getActorMovieIMDBData();} 
		catch(Exception e) {System.out.println("Error");}
		System.out.println("The following actors appeared in the movie, Being John Malkovich:");
		for(ActorMovieIMDB data : movieData2) {
			//System.out.println(actor.getMovie());
			if(data.getMovie().equals("Being_John_Malkovich_(1999)")) {
				//System.out.println(data.getActor());
				actors.add(data);
				
			}
			
		}
		
		Collections.sort(actors, new Comparator<ActorMovieIMDB>() {
		
		public int compare(ActorMovieIMDB o1, ActorMovieIMDB o2) {
			return o1.getActor().compareTo(o2.getActor());
		}
		});
		
		for(ActorMovieIMDB data : actors) {
			System.out.println(data.getActor());
		}
		
		
		
	}

}
