import java.io.File;
//import java.io.*;
//import java.util.Scanner; 

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
//import javax.sound.sampled.LineEvent;
//import javax.sound.sampled.LineListener;

public class Music 
{
  static File soundFile = null;
  static AudioInputStream sound = null;
  static DataLine.Info info = null;
  static Clip clip = null;
  
  /*method to play the music
   * @param bgmName - name of the music file
   */
  public static void play ()
  {
    try
    {
    // specify the sound to play
    soundFile = new File("bgm.wav");
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
  
  //method to stop the music
  public static void stop ()
  {
    clip.stop();
  }
  
///*method to play sound effects
//   * @param effectName - name of the sound effect file
//   */
//  public static void effect (String effectName)
//  {
//    try
//    {
//    // specify the sound to play
//    soundFile = new File(effectName);
//    sound = AudioSystem.getAudioInputStream(soundFile);
//    
//    // load the sound into memory
//    info = new DataLine.Info(Clip.class, sound.getFormat());
//    clip = (Clip) AudioSystem.getLine(info);
//    clip.open(sound);
//    
//    // loop the sound clip
//    clip.start();
//    }
//    catch (Exception e)
//    {
//     System.out.println ("Error: " + e);
//    }
//  }
} //end of class