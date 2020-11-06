int red = 13, green=12,Eye=A5;

void setup() 
  {                
  pinMode(red, OUTPUT);
  pinMode (green, OUTPUT);
  Serial.begin(9600);  
  }

void loop()  
  {
    Serial.println(analogRead(Eye));
    int distance= (analogRead(Eye));
    if (distance > 200)
    {
      digitalWrite(green,LOW);
      digitalWrite(red, HIGH);
    }
    else
    {
      digitalWrite(red, LOW);
      digitalWrite(green, HIGH);
    }
  }
