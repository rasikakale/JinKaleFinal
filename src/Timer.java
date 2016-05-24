import java.util.Date;

import processing.core.PApplet;

public class Timer extends PApplet {
 long t0, t1;
    double dt;

public void setup() {
 
 t0 = new Date().getTime();

     }

     public double startTimer() {
 t1 = new Date().getTime();

 dt = t1 - t0;

 return dt / 1000; // divide by 1000 to get seconds instead of milliseconds 

}
     
     

}


