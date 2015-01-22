
#include <Servo.h> 
 
Servo myservo;  // create servo object to control a servo 
                // twelve servo objects can be created on most boards
int izqA = 5; 
int izqB = 6; 
int derA = 3; 
int derB = 11; 
int foco = 12;
int vel = 180; // Velocidad de los motores (0-255)
int laser = 4 ;
int laserM=7;
void setup()  { 
  Serial.begin(9600);
   myservo.attach(8);
  pinMode(derA, OUTPUT);
  pinMode(derB, OUTPUT);
  pinMode(izqA, OUTPUT);
  pinMode(izqB, OUTPUT);
   pinMode(foco, OUTPUT);
   pinMode(laser, OUTPUT);
    pinMode(laserM, OUTPUT);


 
 } 
 
void loop()  { 
    /*analogWrite(derB, 0);  // Detiene los Motores
    analogWrite(izqB, 0); 
    delay (500);
    analogWrite(derA, vel);  // Frente 2 segundos
    analogWrite(izqA, vel); 
    delay (2000);
   
    analogWrite(derA, vel);  // Derecha 0,5 segundos
    analogWrite(izqA, 0); 
    delay (500);
    
    analogWrite(derA, 0);    // Izquierda 0,5 segundos
    analogWrite(izqA, vel); 
    delay (500);
     
    analogWrite(derA, 0);    // Detiene los Motores
    analogWrite(izqA, 0);
    delay (500);
    analogWrite(derB, vel);  // Reversa 2 segundos
    analogWrite(izqB, vel); 
    delay (2000);  */
    if(Serial.available()){
     
     char op = Serial.read(); 
     
      
      if(op=='1'){
         analogWrite(derA, vel);  // Frente 2 segundos
    analogWrite(izqA, vel); 
    delay(500);
      }
      
      if(op=='2'){
         analogWrite(derB, vel);  // Frente 2 segundos
    analogWrite(izqB, vel); 
    delay(500);
      }
      if(op=='3'){
        analogWrite(derA, 140);  // Derecha 0,5 segundos
  
    analogWrite(izqB, 140); 
    delay(500);
      }
      
       if(op=='4'){
        digitalWrite(foco,HIGH);
      }
      if(op=='5'){
        digitalWrite(foco,LOW  );
        digitalWrite(laser,LOW  );
      }
      if(op=='6'){
        digitalWrite(laser,HIGH  );
      }
      if(op=='l'){
        digitalWrite(laserM,HIGH  );
        delay(5000);
         digitalWrite(laserM,LOW  );
      }
      if(op=='0'){
        analogWrite(derA, 0);  // Detiene los Motores6
    analogWrite(izqA, 0); 
    analogWrite(derB, 0);    // Detiene los Motores
    analogWrite(izqB, 0);
    delay(500);
      }
      
      if(op=='a'){
        myservo.write(60);
      }
      if(op=='s'){
        myservo.write(90);
      }
      if(op=='d'){
       myservo.write(130);
      }
     
    }
    
}
