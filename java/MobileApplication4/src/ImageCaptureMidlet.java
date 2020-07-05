package SampleImageCapture;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.*;
import javax.microedition.media.Control.*;
import javax.microedition.media.control.VideoControl;


public class ImageCaptureMidlet extends MIDlet {

      private Display display;
      ImageCaptureCanvas canvas;
      Player player;
      VideoControl videoControl;

      public void startApp() {
            display = Display.getDisplay(this);
            try {
                  player = Manager.createPlayer("capture://video");
                  player.realize();
                  videoControl = (VideoControl) player.getControl("VideoControl");
            } catch (Exception e) {
            }
            canvas = new ImageCaptureCanvas(this, videoControl);
            display.setCurrent(canvas);
      }

      public void pauseApp() {
      }

      public void destroyApp(boolean unconditional) {
            notifyDestroyed();
      }
}


package SampleImageCapture;

import javax.microedition.lcdui.*;
import javax.microedition.media.control.VideoControl;
import javax.microedition.media.*;

public class ImageCaptureCanvas extends Canvas {

      ImageCaptureMidlet midlet;
      VideoControl videoControl;
      int width = getWidth();
      int height = getHeight();
      Player player;
      SnapShotCanvas snap;
      private Display display;

      public ImageCaptureCanvas(ImageCaptureMidlet midlet, VideoControl videoControl) {
            this.midlet = midlet;
            this.videoControl = videoControl;
            this.display = Display.getDisplay(midlet);
            videoControl.initDisplayMode(VideoControl.USE_DIRECT_VIDEO, this);
            try {
                  videoControl.setDisplayLocation(2, 2);
                  videoControl.setDisplaySize(width - 4, height - 4);
            } catch (MediaException me) {
                  try {
                        videoControl.setDisplayFullScreen(true);
                  } catch (MediaException me2) {
                  }
            }
            videoControl.setVisible(true);
      }

      public void paint(Graphics g) {
      }

      protected void keyPressed(int keyCode) {
            switch (getGameAction(keyCode)) {
                  case FIRE:
                        Thread t = new Thread() {
                              public void run() {
                                    try {
                                          byte[] raw = videoControl.getSnapshot(null);
                                          Image image = Image.createImage(raw, 0, raw.length);
                                          snap = new SnapShotCanvas(image);
                                          display.setCurrent(snap);
                                    } catch (Exception e) {
                                    }
                              }
                        };
                        t.start();
            }
      }
}


package SampleImageCapture;

import javax.microedition.lcdui.*;

public class SnapShotCanvas extends Canvas {

      private Image image;
      public SnapShotCanvas(Image image) {
            this.image = image;
            setFullScreenMode(true);
      }

      public void paint(Graphics g) {
            g.drawImage(image, getWidth() / 2, getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);
      }
      
}