int blue = 13, green=12, Eye=A5, RPI=A4;

void setup() 
  {                
  pinMode(blue, OUTPUT);
  pinMode (green, OUTPUT);
  Serial.begin(9600);  
  }

void loop()  
  {
    Serial.println(analogRead(Eye));
//    int distance= (analogRead(Eye));
      int flag=(analogRead(RPI));
//    Serial.print("RPI: ");
//    Serial.println(analogRead(RPI));
    int total=0, counter=0;
    while (flag < 640)
    {
      flag=(analogRead(RPI));
      if (flag > 640)
        break;
      Serial.println("flag passed");
      while (counter<=10)
      {
        int distance= (analogRead(Eye));
        flag=(analogRead(RPI));
        if (flag > 640)
          break;
        Serial.println("counter passed");
        if (distance > 300)
        {
          Serial.println("distance passed");
          digitalWrite(blue,LOW);
          digitalWrite(green, HIGH);
          delay(100);
          counter++;
          if (counter>10);
            break;
        }
        else
        {
          counter=0;
          digitalWrite(green, LOW);
          digitalWrite(blue, HIGH);
        }
      }
      digitalWrite(green,LOW);
      digitalWrite(blue, LOW);
    }
  }
