import java.io.*;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.*;
import javax.microedition.media.control.*;

public class VoiceRecordMidlet extends MIDlet {
      private Display display;

      public void startApp() {
            display = Display.getDisplay(this);
            display.setCurrent(new VoiceRecordForm());
      }

      public void pauseApp() {
      }

      public void destroyApp(boolean unconditional) {
            notifyDestroyed();
      }
}

class VoiceRecordForm extends Form implements CommandListener {
      private StringItem message;
      private StringItem errormessage;
      private final Command record, play;
      private Player player;
      private byte[] recordedAudioArray = null;
      public VoiceRecordForm() {
            super("Recording Audio");
            message = new StringItem("", "Select Record to start recording.");
            this.append(message);
            errormessage = new StringItem("", "");
            this.append(errormessage);
            record = new Command("Record", Command.OK, 0);
            this.addCommand(record);
            play = new Command("Play", Command.BACK, 0);
            this.addCommand(play);
            this.setCommandListener(this);
      }
      public void commandAction(Command comm, Displayable disp) {
            if (comm == record) {
                  Thread t = new Thread() {
                        public void run() {
                              try {
                                    player = Manager.createPlayer("capture://audio?encoding=pcm");
                                    player.realize();
                                    RecordControl rc = (RecordControl) player.getControl("RecordControl");
                                    ByteArrayOutputStream output = new ByteArrayOutputStream();
                                    rc.setRecordStream(output);
                                    rc.startRecord();
                                    player.start();
                                    message.setText("Recording...");
                                    Thread.sleep(5000);
                                    message.setText("Recording Done!");
                                    rc.commit();
                                    recordedAudioArray = output.toByteArray();
                                    player.close();
                              } catch (Exception e) {
                                    errormessage.setLabel("Error");
                                    errormessage.setText(e.toString());
                              }
                        }
                  };
                  t.start();

            }
            else if (comm == play) {
                  try {
                        ByteArrayInputStream recordedInputStream = new ByteArrayInputStream(recordedAudioArray);
                        Player p2 = Manager.createPlayer(recordedInputStream, "audio/basic");
                        p2.prefetch();
                        p2.start();
                  } catch (Exception e) {
                        errormessage.setLabel("Error");
                        errormessage.setText(e.toString());
                  }
            }
      }
}