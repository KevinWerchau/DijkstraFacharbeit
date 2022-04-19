import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class SuMApplet extends Applet
{
    public SuMApplet()
    {
        Routenplaner hatRoutenplaner = new Routenplaner();
        hatRoutenplaner.fuehreAus();
    }

}
