import asyncio
import serial
import websockets


arduino = serial.Serial('COM3', 9600)
print("✅ Arduino conectado en COM3")
async def manejar_conexion(websocket):
    async for mensaje in websocket:
        print(f"📩 Comando recibido: {mensaje}")
        arduino.write((mensaje + '\n').encode())

async def main():
    print("🚀 Iniciando WebSocket...")
    async with websockets.serve(manejar_conexion, "localhost", 8765):
        print("✅ WebSocket activo en ws://localhost:8765")
        await asyncio.Future()

if __name__ == "__main__":
    asyncio.run(main())
