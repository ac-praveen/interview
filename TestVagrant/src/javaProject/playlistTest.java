package javaProject;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class playlistTest {

    @Test
    public void testPlaySong() {
        playlist rps = new playlist(3);
        
        // test for a new user
        assertEquals(List.of("song1"), rps.playSong("user1", "song1"));
        assertEquals(List.of("song2", "song1"), rps.playSong("user1", "song2"));
        assertEquals(List.of("song3", "song2", "song1"), rps.playSong("user1", "song3"));
        
        // test for an existing user
        assertEquals(List.of("song1", "song3", "song2"), rps.playSong("user1", "song1"));
        
        // test for a new user with capacity less than the playlist capacity
        assertEquals(List.of("song4"), rps.playSong("user2", "song4"));
        
        // test for an existing user with full playlist capacity
        assertEquals(List.of("song4", "song1", "song3"), rps.playSong("user1", "song4"));
        assertEquals(List.of("song5", "song4", "song1"), rps.playSong("user1", "song5"));
    }
}
