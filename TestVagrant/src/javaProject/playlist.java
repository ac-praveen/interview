package javaProject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class playlist {
	//Declare a map to store UserId as String and a LinkedList of songs that corresponds to the user
	//Declare the initial in memory capacity
    private Map<String, LinkedList<String>> recentlyPlayed;
    private int capacity;
  
    /*
     *                    Overload the Constructor for play-list 
     * argument: initial-capacity
     * create a reference to User Map and capacity, so that they are available at the time of instantiation.
     */
    public playlist(int capacity) {
        recentlyPlayed = new HashMap<String, LinkedList<String>>();
        this.capacity = capacity;
    }

    /*
     *                     Method playSong
     * arguments: userId and song
     * return: List of Songs that have been played recently
     */
    public List<String> playSong(String userId, String song) {
    	
        LinkedList<String> userSongs = recentlyPlayed.get(userId);
        
        if (userSongs == null) {
            userSongs = new LinkedList<String>();
            recentlyPlayed.put(userId, userSongs);
        }
        
        if (userSongs.contains(song)) {
            userSongs.remove(song);
        } else if (userSongs.size() == capacity) {
            userSongs.removeLast();
        }
        userSongs.addFirst(song);

        return userSongs;
    }

    public static void main(String[] args) {
    	
        playlist rps = new playlist(3);
       
        System.out.println(rps.playSong("user1", "song1")); 
        System.out.println(rps.playSong("user1", "song2")); 
        System.out.println(rps.playSong("user1", "song3")); 
        System.out.println(rps.playSong("user1", "song1")); 
        System.out.println(rps.playSong("user2", "song4")); 
        System.out.println(rps.playSong("user1", "song4")); 
        System.out.println(rps.playSong("user1", "song5")); 
    }
}

