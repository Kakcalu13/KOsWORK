const int ranger = A1;
int total2=0; 
 
void setup() 
{ 
  Serial.begin(9600);   
} 
 
 
void loop() 
{ 
  Serial.println(analogRead(ranger));
  total2=analogRead(ranger);//this is for sharp eyes 
}

