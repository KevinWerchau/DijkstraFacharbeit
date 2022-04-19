import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.ereignis.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
public class Routenplaner extends EBAnwendung
{
    // Objekte
    private Etikett hatEtikettNameDerStadt;
    private Textfeld hatTextfeldNameDerStadt;
    private Etikett StrasseVon1;
    private Textfeld EingabeVonStraße;
    private Etikett hatEtikettNach1;
    private Textfeld EingabeNachStraße;
    private Textfeld StraßenLaenge;
    private Etikett hatEtikettLaengeDerStrasse;
    private Knopf hatKnopfStadtSpeichern;
    private Zeilenbereich hatZeilenbereich1;
    private Etikett hatEtikettRoutePlanen;
    private Etikett hatEtikettVon2;
    private Textfeld StraßeVon2;
    private Etikett hatEtikettNach2;
    private Textfeld StraßeNach2;
    private Knopf hatKnopfStreckeBerechnen;
    private Textfeld ErgebnisFeld;
    private Etikett hatEtikettDieKuerzesteStreckeBetraegt;
    private Knopf hatKnopfStrasseSpeichern;
    private Etikett hatEtikettKarte;
    private Etikett hatEtikettFehlermeldung;
    private List<Stadt> StaedteVerzeichnis;
    private Knopf hatKnopfKarteZeichnen;
    protected boolean gedrueckt;
    private ArrayList<Stadt> DistanzListe;
    private double kuerzesterWeg;
    private LinkedList<Stadt> Zielstrecke;
    // Attribute

/**
 * Konstruktor
 */
    public Routenplaner()
    {
        //Initialisierung der Oberklasse
        super(1735, 1015);

        hatEtikettNameDerStadt = new Etikett(50, 150, 100, 25, "Name der Stadt:");
        // Ausrichtung
        hatEtikettNameDerStadt.setzeAusrichtung(Ausrichtung.MITTE);
        hatTextfeldNameDerStadt = new Textfeld(50, 185, 200, 25, "");
        // Ausrichtung
        hatTextfeldNameDerStadt.setzeAusrichtung(Ausrichtung.LINKS);
        StrasseVon1 = new Etikett(50, 220, 100, 25, "Straße von:");
        // Ausrichtung
       StrasseVon1.setzeAusrichtung(Ausrichtung.MITTE);
        EingabeVonStraße = new Textfeld(50, 255, 200, 25, "");
        // Ausrichtung
        EingabeVonStraße.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettNach1 = new Etikett(49, 290, 100, 25, "nach:");
        // Ausrichtung
        hatEtikettNach1.setzeAusrichtung(Ausrichtung.MITTE);
        EingabeNachStraße = new Textfeld(50, 325, 200, 25, "");
        // Ausrichtung
        EingabeNachStraße.setzeAusrichtung(Ausrichtung.LINKS);
        StraßenLaenge = new Textfeld(50, 394, 200, 25, "");
        // Ausrichtung
        StraßenLaenge.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettLaengeDerStrasse = new Etikett(50, 360, 100, 25, "Laenge der Straße:");
        // Ausrichtung
        hatEtikettLaengeDerStrasse.setzeAusrichtung(Ausrichtung.MITTE);
        hatKnopfStadtSpeichern = new Knopf(260, 185, 150, 25, "Stadt speichern");
        hatKnopfStadtSpeichern.setzeBearbeiterGeklickt("hatKnopfStadtSpeichernGeklickt");
        hatZeilenbereich1 = new Zeilenbereich(500, 185, 1116, 807, "");
        hatEtikettRoutePlanen = new Etikett(50, 460, 100, 25, "Route planen:");
        // Ausrichtung
        hatEtikettRoutePlanen.setzeAusrichtung(Ausrichtung.MITTE);
        hatEtikettVon2 = new Etikett(50, 495, 100, 25, "von:");
        // Ausrichtung
        hatEtikettVon2.setzeAusrichtung(Ausrichtung.MITTE);
        StraßeVon2 = new Textfeld(50, 530, 200, 25, "");
        // Ausrichtung
        StraßeVon2.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettNach2 = new Etikett(50, 565, 100, 25, "nach:");
        // Ausrichtung
        hatEtikettNach2.setzeAusrichtung(Ausrichtung.MITTE);
        StraßeNach2 = new Textfeld(50, 600, 200, 25, "");
        // Ausrichtung
        StraßeNach2.setzeAusrichtung(Ausrichtung.LINKS);
        hatKnopfStreckeBerechnen = new Knopf(50, 635, 150, 25, "Strecke berechnen");
        hatKnopfStreckeBerechnen.setzeBearbeiterGeklickt("hatKnopfStreckeBerechnenGeklickt");
        ErgebnisFeld = new Textfeld(51, 705, 200, 25, "");
        // Ausrichtung
        ErgebnisFeld.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettDieKuerzesteStreckeBetraegt = new Etikett(50, 670, 200, 25, "Die kuerzeste Strecke betraegt:");
        // Ausrichtung
        hatEtikettDieKuerzesteStreckeBetraegt.setzeAusrichtung(Ausrichtung.MITTE);
        hatKnopfStrasseSpeichern = new Knopf(260, 325, 150, 25, "Straße speichern");
        hatKnopfStrasseSpeichern.setzeBearbeiterGeklickt("hatKnopfStrasseSpeichernGeklickt");
        hatEtikettKarte = new Etikett(500, 150, 100, 25, "Karte:");
        hatEtikettFehlermeldung = new Etikett(500, 100, 00, 25, "");
        hatKnopfKarteZeichnen = new Knopf(650, 150, 100,25,"Zeichnen");
        hatKnopfKarteZeichnen.setzeBearbeiterGeklickt("hatKnopfKarteZeichnenGeklickt");
        // Ausrichtung
        hatEtikettKarte.setzeAusrichtung(Ausrichtung.MITTE);
        StaedteVerzeichnis = new ArrayList<Stadt>();
        gedrueckt = false;
        DistanzListe = new ArrayList<Stadt>();
        Zielstrecke = new LinkedList<Stadt>();
        kuerzesterWeg = 0;
        
    }

    public void hatKnopfStadtSpeichernGeklickt()
    {
     StaedteVerzeichnis.add(new Stadt(hatTextfeldNameDerStadt.inhaltAlsText()));
     hatTextfeldNameDerStadt.setzeInhalt("");
    }
  

    public void hatKnopfStreckeBerechnenGeklickt()
    {
        Stadt Stadt1 = null;
        Stadt Stadt2 = null;
        Stadt1 = this.Stadtzuordnen(Stadt1, StraßeVon2);
        Stadt2 = this.Stadtzuordnen(Stadt2, StraßeNach2);

    ErgebnisFeld.setzeInhalt("");
    StraßeVon2.setzeInhalt("");
    StraßeNach2.setzeInhalt("");
    this.Dijkstra(Stadt1, Stadt2);
    ErgebnisFeld.setzeInhalt("" + Zielstrecke.get(Zielstrecke.size() - 1).gibDistanz() + " km "+ "Zu fahrende Strecke: ");
    for(int j = 0;j < Zielstrecke.size();j++){
    ErgebnisFeld.haengeAn(" --> " + Zielstrecke.get(j).gibNamen());
}
    Zielstrecke.clear();
    for(int k = 0; k < StaedteVerzeichnis.size();k++){
    StaedteVerzeichnis.get(k).setzeDistanz(Integer.MAX_VALUE);
    }
    

    }
    
    public void Dijkstra(Stadt Str, Stadt Zl){
    Stadt Start = Str;
    Stadt Ziel = Zl;
    Stadt Aktuell = Str;
    boolean ende = false;
    Start.setzeDistanz(0);
    Start.setzeBesucht(true);
    DistanzListe.addAll(StaedteVerzeichnis);
         
    do{
       
        this.ListSort();
        Aktuell.StraßenSortieren();
        if(!StaedteVerzeichnis.isEmpty()){
        
        if(Aktuell == Start){
        for(int l = 0;l<Aktuell.gibAnzahlStraßen();l++){
        Aktuell.gibStraße(l).gibStadt2().setzeDistanz(Aktuell.gibDistanz() + Aktuell.gibStraße(l).gibLaenge());
        Aktuell.gibStraße(l).gibStadt2().setzeBesucht(true);
        Aktuell.gibStraße(l).gibStadt2().setzeVorherigeStadt(Aktuell);
        }
    }
        
        if(!(Aktuell == Start) && !(Aktuell == Ziel))
        {
            for(int m = 0;m < Aktuell.gibAnzahlStraßen();m++){
            if(Aktuell.gibStraße(m).gibStadt2().gibDistanz() > Aktuell.gibDistanz()+Aktuell.gibStraße(m).gibLaenge()){
            Aktuell.gibStraße(m).gibStadt2().setzeDistanz(Aktuell.gibDistanz()+ Aktuell.gibStraße(m).gibLaenge());
            Aktuell.gibStraße(m).gibStadt2().setzeVorherigeStadt(Aktuell);
            }
            
        }
        Aktuell.setzeBesucht(true);
        
        }
         
        if(Aktuell == Ziel){
        do{
            Zielstrecke.push(Aktuell);
            Aktuell = Aktuell.gibVorherigeStadt();
            
        }while(!(Aktuell == Start));
        ende = true;
        }    
        DistanzListe.remove(Aktuell);
        this.ListSort();
        Aktuell = DistanzListe.get(0); 
           
           
        }else ende = true;
        
                 
    }while(!ende);
    DistanzListe.clear();
    
    }


    public void hatKnopfStrasseSpeichernGeklickt()
    {
        
         this.StraßenZuorden();
         EingabeVonStraße.setzeInhalt("");
         EingabeNachStraße.setzeInhalt("");
         StraßenLaenge.setzeInhalt("");
         
}
    public void ListSort(){
    Collections.sort(DistanzListe);
    }
    public void StraßenZuorden(){
        Stadt Stadt1 = null;
        Stadt Stadt2 = null;
        Stadt1 = this.Stadtzuordnen(Stadt1, EingabeVonStraße);
        Stadt2 = this.Stadtzuordnen(Stadt2, EingabeNachStraße);
        try{
        if(StaedteVerzeichnis.contains(Stadt2)){
        StaedteVerzeichnis.get(StaedteVerzeichnis.indexOf(Stadt2)).Straßespeichern(new Straße(Stadt2,Stadt1,StraßenLaenge.inhaltAlsGanzeZahl()));
    }else{
        System.out.println("Stadt2 nicht vorhanden");
    }
        if(StaedteVerzeichnis.contains(Stadt1)){
           StaedteVerzeichnis.get(StaedteVerzeichnis.indexOf(Stadt1)).Straßespeichern(new Straße(Stadt1,Stadt2,StraßenLaenge.inhaltAlsGanzeZahl())); 
        }else{
            System.out.println("Stadt1 nicht vorhanden");
        }
    }catch(Exception e){
    e.printStackTrace();
    }
}
    public void hatKnopfKarteZeichnenGeklickt()
    {
    hatZeilenbereich1.setzeInhalt("");
    this.StaedteAusgeben();
    this.StraßenVerbindungen();
    }
    
    
    public void StaedteAusgeben(){
    int q = 0;
        do{ 
            hatZeilenbereich1.haengeAn(StaedteVerzeichnis.get(q).gibNamen());
             q++;
    }while(q < StaedteVerzeichnis.size()); 
    }
    public void StraßenVerbindungen(){
     int r = 0;
     int s = 0;
     
     do{ 
         s = 0;
         while(s < StaedteVerzeichnis.get(r).gibAnzahlStraßen() && StaedteVerzeichnis.get(r).gibAnzahlStraßen() > 0){
            hatZeilenbereich1.haengeAn("Straße Von " + StaedteVerzeichnis.get(r).gibStraße(s).gibStadt1().gibNamen() + " - " + "Nach " + StaedteVerzeichnis.get(r).gibStraße(s).gibStadt2().gibNamen() +
            " " + StaedteVerzeichnis.get(r).gibStraße(s).gibLaenge() + " km");
            s++;
            }
            r++;
    
    }while(r < StaedteVerzeichnis.size());
    
}

public Stadt Stadtzuordnen(Stadt s, Textfeld Tx){
        int i = 0;
        boolean gefunden = false;
        do{ 

             if(StaedteVerzeichnis.get(i).gibNamen().equals(Tx.inhaltAlsText())){
             s = StaedteVerzeichnis.get(i);
             gefunden = true;
                }
             
         
             i++;
    }while(i < StaedteVerzeichnis.size() && (!gefunden));
    gefunden = false;
    return s;
}
}

