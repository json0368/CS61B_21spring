package gh2;

import edu.princeton.cs.algs4.StdAudio;
import org.junit.Test;

public class TestPlayTwinkleTwinkle {
    // Define note durations (in milliseconds)
    private static final int WHOLE = 60000; // Whole note duration
    private static final int HALF = WHOLE / 2; // Half note duration
    private static final int QUARTER = HALF / 2; // Quarter note duration
    private static final int EIGHTH = QUARTER / 2; // Eighth note duration

    @Test
    public void TestPlayTwinkleTwinkle() {
        // Initialize GuitarString objects for each note frequency
        GuitarString C4 = new GuitarString(261.63); // C4
        GuitarString D4 = new GuitarString(293.66); // D4
        GuitarString E4 = new GuitarString(329.63); // E4
        GuitarString F4 = new GuitarString(349.23); // F4
        GuitarString G4 = new GuitarString(392.00); // G4
        GuitarString A4 = new GuitarString(440.00); // A4
        GuitarString B4 = new GuitarString(493.88); // B4

        // Play the melody of "Twinkle Twinkle Little Star"
        playNote(C4, QUARTER);
        playNote(C4, QUARTER);
        playNote(G4, QUARTER);
        playNote(G4, QUARTER);
        playNote(A4, QUARTER);
        playNote(A4, QUARTER);
        playNote(G4, HALF);

        playNote(F4, QUARTER);
        playNote(F4, QUARTER);
        playNote(E4, QUARTER);
        playNote(E4, QUARTER);
        playNote(D4, QUARTER);
        playNote(D4, QUARTER);
        playNote(C4, HALF);

        playNote(G4, QUARTER);
        playNote(G4, QUARTER);
        playNote(F4, QUARTER);
        playNote(F4, QUARTER);
        playNote(E4, QUARTER);
        playNote(E4, QUARTER);
        playNote(D4, HALF);

        playNote(G4, QUARTER);
        playNote(G4, QUARTER);
        playNote(F4, QUARTER);
        playNote(F4, QUARTER);
        playNote(E4, QUARTER);
        playNote(E4, QUARTER);
        playNote(D4, HALF);

        playNote(C4, QUARTER);
        playNote(C4, QUARTER);
        playNote(G4, QUARTER);
        playNote(G4, QUARTER);
        playNote(A4, QUARTER);
        playNote(A4, QUARTER);
        playNote(G4, HALF);

        playNote(F4, QUARTER);
        playNote(F4, QUARTER);
        playNote(E4, QUARTER);
        playNote(E4, QUARTER);
        playNote(D4, QUARTER);
        playNote(D4, QUARTER);
        playNote(C4, HALF);
    }

    /**
     * Helper method to play a note for a specified duration.
     *
     * @param string The GuitarString object representing the note.
     * @param duration The duration of the note in milliseconds.
     */
    public void playNote(GuitarString string, int duration) {
        string.pluck(); // Pluck the string to start the sound
        for (int i = 0; i < duration; i++) {
            StdAudio.play(string.sample()); // Play the current sample
            string.tic(); // Advance the simulation
        }
    }
}