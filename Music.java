/* Music.java
 * Julia Zhao and Tasha Xiao
 * Music class for the 12U final project
 * June 12 2018
 */

//imports
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Music 
{
  static File soundFile = null;
  static AudioInputStream sound = null;
  static DataLine.Info info = null;
  static Clip clip = null;
  
  /* Starts playing the music clip
   */
  public static void play ()
  {
    try
    {
    // specify the sound to play
    soundFile = new File("bgm.wav"); //name of the file
    sound = AudioSystem.getAudioInputStream(soundFile);
    
    // load the sound into memory
    info = new DataLine.Info(Clip.class, sound.getFormat());
    clip = (Clip) AudioSystem.getLine(info);
    clip.open(sound);
    
    // loop the sound clip
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    catch (Exception e)
    {
     System.out.println ("Error: " + e);
    }
  }
} //end of class