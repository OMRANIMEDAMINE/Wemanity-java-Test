/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technique;

/**
 *
 * @author O
 */
import java.util.ArrayList;
import java.util.Calendar;


public class Horloge implements Observable{
    Thread monThread;
  //On récupère l'instance d'un calendrier 
  //Elle va nous permettre de récupérer l'heure actuelle
  private static Calendar cal;
  private static String hour = "";
  //Notre collection d'observateurs
  private static ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();
	
  public void go() {
    monThread = new Thread(new Traitement());
    monThread.start();
  }

  //Ajoute un observateur à la liste
  public void addObservateur(Observateur obs) {
    listObservateur.add(obs);
  }
  //Retire tous les observateurs de la liste
  public void delObservateur() {
    listObservateur = new ArrayList<Observateur>();
  }
  //Avertit les observateurs que l'objet observable a changé 
  //et invoque la méthode update() de chaque observateur
  public void updateObservateur() {
    for(Observateur obs : listObservateur )
      obs.update(this.hour);
  }
  
  public class Traitement implements Runnable{
    
    @Override
    public void run() {
    while(true){
      cal = Calendar.getInstance();
      hour =  //Les heures
        cal.get(Calendar.HOUR_OF_DAY) + " : " 
        + 
        (      //Les minutes
          cal.get(Calendar.MINUTE) < 10
          ? "0" + cal.get(Calendar.MINUTE)
          : cal.get(Calendar.MINUTE)
        )
        + " : " 
        +
        (      //Les secondes
          (cal.get(Calendar.SECOND)< 10) 
          ? "0"+cal.get(Calendar.SECOND) 
          : cal.get(Calendar.SECOND)
        );
      //On avertit les observateurs que l'heure a été mise à jour
      updateObservateur();
			
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      //System.out.println("yes");
    }
  }}
}