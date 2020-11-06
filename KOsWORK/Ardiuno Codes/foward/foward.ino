const int
PWM_A   = 3,
DIR_A   = 12,
BRAKE_A = 9,
ranger=A2,
SNS_A   = A0;
int total2;


void setup() {
  pinMode(BRAKE_A, OUTPUT);  // Brake pin on channel A
  pinMode(DIR_A, OUTPUT);    // Direction pin on channel A
}

void loop() {

     digitalWrite(BRAKE_A, LOW);  // setting brake LOW disable motor brake
     //digitalWrite(DIR_A, HIGH);   // setting direction to HIGH the moor will spin forward
     analogWrite(PWM_A, 255);     // Set the speed of the motor, 255 is themaximum value
    //digitalWrite(BRAKE_A, HIGH);  // raise the brake

}
