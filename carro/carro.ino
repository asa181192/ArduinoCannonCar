/*
@autor Alfredo Santiago 
Programa para el manejo Protopo apaga incendios . 

--17/12/14--
ultima actualizacion : 1/03/15
--Cambios--
Agregado direccion de posicionamiento para servo --26/02/15. 
Agregado Cambio de iF a switch statment --1/03/15
Agregado Direccion Izquierda , en un principio solo se movia a la Derecha --1/03/15
Agregado cambio en la programacion se remplazaron los case por if-else ya que interrumpian con el disparo de la bomba colapsando el carro --03/03/15
*/
 #include <Servo.h>  
Servo myservo;  
int izqA = 5; 
int izqB = 6; 
int derA = 3; 
int derB = 11; 
int servo=10;
int bomba = 9;
int vel=190;
int contador =90;
int laser = 4;
void setup()  { 
  Serial.begin(9600);
  // pinMode (IN8, OUTPUT); // Input4 conectada al pin 4
   //pinMode (IN7, OUTPUT); // Input3 conectada al pin 5
  pinMode(derA, OUTPUT);
  pinMode(derB, OUTPUT);
  pinMode(izqA, OUTPUT);
  pinMode(izqB, OUTPUT);
  pinMode(bomba,OUTPUT);
  pinMode(laser,OUTPUT);
  myservo.attach(servo);
 
  myservo.write(90);
  
  delay (15);

 
 } 
 
void loop()  { 
  
    if   (Serial.available()){
     
     byte op = Serial.read(); 
       
     
       if(op==101){ 
             analogWrite(derB, vel);  // Reversa 
             analogWrite(izqB, vel); 
             delay(15);
       }
      else if(op==102){
             analogWrite(derA, 140);  // Derecha 
             analogWrite(izqB, 140); 
             delay(15);
       }
      else if(op==103){
             analogWrite(derA, vel);  // Adelante
             analogWrite(izqA, vel); 
             delay(15);
       }
       else if(op==104){
             analogWrite(derB, 140);  // Izquierda 
             analogWrite(izqA, 140);  
             delay(15);
       }
      else if(op==107){
             digitalWrite(bomba,HIGH);//Activa el disparo por bomba de agua 
             delay(15);
       }            
     else if(op==108){
              digitalWrite(laser,HIGH);//Activa el laser 
      }
     else if(op==109){
              digitalWrite(laser,LOW);//Desactiva el laser 
      }  
         
     else if(op==100){ //Apaga todo excepto laser 
             digitalWrite(bomba,LOW);
             analogWrite(derA, 0);  // Detiene los Motores6
             analogWrite(izqA, 0); 
             analogWrite(derB, 0);    // Detiene los Motores
             analogWrite(izqB, 0);
      }
    
       else  {  myservo.write(map(op,0,90,50,90));} //Toma la posicion del servomotor para apuntar la mirilla 
      
  
    }//FIN AVAILABLE 
   
             
    
}//FIN LOOP
