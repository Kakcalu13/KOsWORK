const int PWM_A   = 3,DIR_A   = 12, BRAKE_A = 9, eye=A2,PWM_B=11, DIR_B=13, BRAKE_B=8;
int total2;

void setup() {
  // Configure the A output
  pinMode(BRAKE_A, OUTPUT);
  pinMode(DIR_A, OUTPUT);
  pinMode(DIR_B, OUTPUT);
  pinMode(BRAKE_B,OUTPUT);
    Serial.begin(9600);
}

void loop() {
  Serial.println(analogRead(eye));
  total2=analogRead(eye);
  if (total2 > 350)
  {
    digitalWrite(BRAKE_A, HIGH); 
    digitalWrite(DIR_A, LOW); 
    analogWrite(PWM_A, 255);
    digitalWrite(BRAKE_B, HIGH);
    digitalWrite(DIR_B, LOW); 
    analogWrite(PWM_B, 255);
    delay(1000);
    digitalWrite(BRAKE_A, LOW);
    analogWrite(PWM_A, 255); 
    digitalWrite(DIR_A, LOW);
    delay(2000);
    digitalWrite(BRAKE_A, HIGH);
      Serial.println(analogRead(eye));
      total2=analogRead(eye);
          if (total2 > 350)
         {
             digitalWrite(BRAKE_B, LOW);
             analogWrite(PWM_A, 255); 
             digitalWrite(DIR_B, LOW);
             delay(2000);
             digitalWrite(BRAKE_B, HIGH); 
         } 
  }
  analogWrite(PWM_A, 255);
  analogWrite(PWM_B, 255);
  digitalWrite(BRAKE_A, LOW); 
  digitalWrite(DIR_A, HIGH);
  digitalWrite(BRAKE_B, LOW); 
  digitalWrite(DIR_B, HIGH);
}

