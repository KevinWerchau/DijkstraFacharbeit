import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Stadt implements Comparable<Stadt>
{   
    private String Name;
    private List<Straße> aStraßen;
    private int Distanz;
    private boolean Besucht;
    private Stadt VorherigeStadt;

    public Stadt(String n)
    {
        aStraßen = new ArrayList<Straße>(); 
        Name = n;
        VorherigeStadt = null;
        Distanz = Integer.MAX_VALUE;
        Besucht = false;

    }
    
    public void Straßespeichern(Straße St){
    aStraßen.add(St);
    }
    @Override
  public int compareTo(Stadt st) {
    if (this.gibDistanz() == st.gibDistanz()) {
      return 0;
    }
    if(this.gibDistanz() < st.gibDistanz()){
    return -1;
}
if(this.gibDistanz() > st.gibDistanz()){
    return 1;
}
else return 0;
}
    
    public void setzeVorherigeStadt(Stadt std){
    VorherigeStadt = std;
    }
    public Stadt gibVorherigeStadt(){
    return VorherigeStadt;
    }
    public void StraßenSortieren(){
    Collections.sort(aStraßen);
    }
    public boolean gibBesucht(){
    return Besucht;}
    public void setzeBesucht(boolean b){
    Besucht = b;}
    public void setzeNamen(String n){
    Name = n;}
    public String gibNamen(){
    return Name;}
    public boolean istLeer(){
    return aStraßen.isEmpty();}
    
    public Stadt SucheStadt2(int i){
    return aStraßen.get(i).gibStadt2();}
    
    public int gibAnzahlStraßen(){
    return aStraßen.size();}
    public Straße gibStraße(int i){
    return aStraßen.get(i);}
    
    public void setzeDistanz(int d){
    Distanz = d;}
    
    public int gibDistanz(){
    return Distanz;}
}
