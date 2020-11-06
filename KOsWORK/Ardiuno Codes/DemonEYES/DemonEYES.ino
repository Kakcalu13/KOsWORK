int led = 9;
int brightness = 0;
int fadeAmount = 5;
int speak=255;
const int sampleWindow = 50;
unsigned int sample;

void setup()  { 
  pinMode(led, OUTPUT);
  Serial.begin(9600);
} 

void loop()  {
  unsigned long startMillis= millis();
  unsigned int peakToPeak = 0;
  unsigned int signalMax = 0;
  unsigned int signalMin = 1024;
  
  analogWrite(led, brightness);
  brightness = brightness + fadeAmount;
  if (brightness == 0 || brightness == 200) {
    fadeAmount = -fadeAmount ; 
  }
  
   while (millis() - startMillis < sampleWindow)
   {
    sample = analogRead(5);
    if (sample < 1024)  // toss out spurious readings
    {
       if (sample > signalMax)
       {
         signalMax = sample;  // save just the max levels
       }
       else if (sample < signalMin)
       {
         signalMin = sample;  // save just the min levels
       }
     }
   }
     
   peakToPeak = signalMax - signalMin;
   double volts = peakToPeak;
   Serial.println(volts);
   
   if (volts > 130)
     digitalWrite(led,HIGH);

    delay(30);    
}
