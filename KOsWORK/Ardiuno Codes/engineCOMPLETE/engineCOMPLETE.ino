int motor1=12, motor2=13, PWM_A= 3, PWM_B=11,BRAKE_A = 9,BRAKE_B=8;

void setup() 
  {                
    pinMode(motor1,OUTPUT);
    pinMode(motor2,OUTPUT);
    pinMode(BRAKE_A, OUTPUT);
    pinMode(BRAKE_B,OUTPUT);
  }

void loop() 
  {
    digitalWrite(motor1,HIGH);
    digitalWrite(motor2,HIGH);
    digitalWrite(PWM_A,255);
    digitalWrite(PWM_B,255);
    delay(100); 
    digitalWrite(motor1,LOW);
    digitalWrite(motor2,LOW);
    digitalWrite(PWM_A,255);
    digitalWrite(PWM_B,255);
    delay(100);
  }
