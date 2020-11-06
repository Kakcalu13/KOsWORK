int UD = 0;
int LR = 0;

void setup() {
  Serial.begin(9600);
}

void loop() {
  UD = analogRead(A0);
  LR = analogRead(A1);
  Serial.print("UD = ");
  Serial.print(UD, DEC);
  Serial.print(", LR = ");
  Serial.println(LR, DEC);   
  delay(200);
}
