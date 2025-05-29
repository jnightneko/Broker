import asyncio
import websockets
import serial

arduino = serial.Serial('COM3', 9600)
print(" Arduino conectado en COM3")

async def escuchar():
    uri = "ws://64.23.169.22:9090/ws/arduino" 
    async with websockets.connect(uri) as websocket:
        print("Conectado a Spring WebSocket")
        async for mensaje in websocket:
            print(f"Comando recibido: {mensaje}")
            arduino.write((mensaje + '\n').encode())

asyncio.run(escuchar())
