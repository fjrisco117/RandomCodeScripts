import javax.microedition.midlet.MIDlet;

public class BasicMIDletShell extends MIDlet {
  public void startApp() {
    System.out.println(getAppProperty("Model-Version"));
  }

  public void pauseApp() {
  }

  public void destroyApp(boolean unconditional) {
  }
}