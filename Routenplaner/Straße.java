public class Straße implements Comparable<Straße>
{
    private int laenge;
    private Stadt Stadt1;
    private Stadt Stadt2;


    public Straße(Stadt Std1, Stadt Std2,int l) 
    {
     laenge = l;
     Stadt1= Std1;
     Stadt2 = Std2;
    }
   
    @Override
  public int compareTo(Straße s) {
    if (this.gibLaenge() == s.gibLaenge()) {
      return 0;
    }
    if(this.gibLaenge() < s.gibLaenge()){
    return -1;
}
if(this.gibLaenge() > s.gibLaenge()){
    return 1;
}
else return 0;
}
  
    public int gibLaenge(){
    return laenge;}
    
    public void setzeLaenge(int l){
    laenge = l;}
    
    public Stadt gibStadt1(){
    return Stadt1;}
    
    public Stadt gibStadt2(){
    return Stadt2;}
    
    public void setzeStadt1(Stadt std){
    Stadt1 = std;}
    
    public void setzeStadt2(Stadt std){
    Stadt2 = std;}
   
    
}
