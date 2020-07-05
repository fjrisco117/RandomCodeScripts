import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 *
 * @author Fadi Z. Hania
 * <a title="Fadi Hania Blog" href="http://fadihania.com/" target="_blank">Fadi Hania Blog</a>
 * Follow Me On Twitter: http://twitter.com/fadihania
 *
 */

public class UserRegistrationMIDlet extends MIDlet implements CommandListener {
    private Display display;
    private Form registrationFrm;

    private Alert messageAlert;

    private TextField emailTxt;
    private TextField passwordTxt;
    private TextField nameTxt;
    private TextField mobileTxt;
    private TextField urlTxt;

    private Command okCmd;
    private Command exitCmd;

    public UserRegistrationMIDlet() {
        emailTxt = new TextField("Email:", "", 200, TextField.EMAILADDR);
        passwordTxt = new TextField("Password:", "", 50, TextField.PASSWORD);
        nameTxt = new TextField("Name:", "", 100, TextField.ANY);
        mobileTxt = new TextField("Mobile:", "", 15, TextField.PHONENUMBER);
        urlTxt = new TextField("Website:", "", 200, TextField.URL);

        registrationFrm = new Form("User Registration", new Item[] {emailTxt, passwordTxt, nameTxt, mobileTxt, urlTxt});

        messageAlert = new Alert("Registration Complete");
        messageAlert.setTimeout(5000);
        messageAlert.setType(AlertType.CONFIRMATION);

        okCmd = new Command("OK", Command.OK, 0);
        exitCmd = new Command("Exit", Command.EXIT, 1);

        registrationFrm.addCommand(okCmd);
        registrationFrm.addCommand(exitCmd);

        registrationFrm.setCommandListener(this);
    }

    protected void startApp() {
        display = Display.getDisplay(this);
        display.setCurrent(registrationFrm);
    }

    public void commandAction(Command c, Displayable d) {
        if (d == registrationFrm) {
            if (c == okCmd) {
                String messageContent;
                messageContent = "Thanks " + nameTxt.getString() + "\nRegistration Complete.";
                
                messageAlert.setString(messageContent);
                
                display.setCurrent(messageAlert, registrationFrm);
            } else if (c == exitCmd) {
                notifyDestroyed();
            }
        }
    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean unconditional) {
    }
}