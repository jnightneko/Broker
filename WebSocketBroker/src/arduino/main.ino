void setup() {
  pinMode(13, OUTPUT);  
  pinMode(12, OUTPUT);  
  Serial.begin(9600);

  digitalWrite(13, LOW);  
  digitalWrite(12, LOW);
}

void loop() {
  if (Serial.available()) {
    String comando = Serial.readStringUntil('\n');
    comando.trim();

    Serial.print("Comando recibido: ");
    Serial.println(comando);

    if (comando == "VALIDA") {
      digitalWrite(13, HIGH);
      Serial.println("✅ LED 13 encendido por 1 segundo");
      delay(1000);
      digitalWrite(13, LOW);
    } else if (comando == "RECHAZADA") {
      digitalWrite(12, HIGH);
      Serial.println("✅ LED 12 encendido por 1 segundo");
      delay(1000);
      digitalWrite(12, LOW);
    } else {
      Serial.println("❌ Comando no reconocido");
    }
  }
}
