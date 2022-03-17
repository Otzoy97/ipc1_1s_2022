import random


class Totito:
    def __init__(self):
        prob = random.randint(1, 100)
        self.tablero = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
        if prob < 50:
            self.humano = 1
            self.maquina = 2
            print("La figura asignada es X")
        else:
            self.humano = 2
            self.maquina = 1
            print("La figura asignada es O")

    def determinarGanador(self, figura):
        # Verifica filas
        for fila in self.tablero:
            if all(posicion == figura for posicion in fila):
                return True
        # Verifica columnas
        for columna in range(len(self.tablero)):
            if self.tablero[0][columna] == figura and self.tablero[1][columna] == figura and self.tablero[2][columna] == figura:
                return True
        # Verifica diagonales
        if all(posicion == figura for posicion in [self.tablero[0][0], self.tablero[1][1], self.tablero[2][2]]):
            return True
        if all(posicion == figura for posicion in [self.tablero[0][2], self.tablero[1][1], self.tablero[2][0]]):
            return True
        return False

    def traducirEntrada(self, str):
        str = str.strip()
        parOrdenado = str.split(",")
        try:
            posX = int(parOrdenado[0])
            posY = int(parOrdenado[1])
            if self.contarEspaciosVacios() > 0:
                if self.esVacio(posX, posY):
                    self.colocarFigura(self.humano, posX, posY)
                else:
                    print("Esa posición ya está tomada")
                    return False
            else:
                print("No hay espacios vacíos")
                return False
        except:
            print("La entrada del usuario no es válida")
            return False
        return True

    def colocarFigura(self, figura, posX, posY):
        self.tablero[posX][posY] = figura

    def asignarFigura(self):
        prob = random.randint(1, 100)
        if prob < 50:
            self.humano = 1
            self.maquina = 2
            print("La figura asignada es X")
        else:
            self.humano = 2
            self.maquina = 1
            print("La figura asignada es O")

    def moverPc(self):
        probX = random.randint(0, 2)
        probY = random.randint(0, 2)
        while not self.esVacio(probX, probY):
            probX = random.randint(0, 2)
            probY = random.randint(0, 2)
        self.colocarFigura(self.maquina, probX, probY)

    def esVacio(self, posX, posY):
        return self.tablero[posX][posY] == 0

    def contarEspaciosVacios(self):
        contador = 0
        # for i in range(len(tablero)):
        for fila in self.tablero:
            for posicion in fila:
                if posicion == 0:
                    contador += 1
        return contador

    def imprimir(self):
        for fila in self.tablero:
            for posicion in fila:
                if posicion == 1:
                    print(" X ", end="")
                elif posicion == 2:
                    print(" O ", end="")
                else:
                    print("   ", end="")
            print("")
        print("---------------")


totito = Totito()
totito.imprimir()
totito.asignarFigura()
while(totito.contarEspaciosVacios() > 0):
    entrada_usuario = input("Indique la posición: ")
    if(totito.traducirEntrada(entrada_usuario)):
        totito.imprimir()
        if (totito.determinarGanador(totito.humano)):
            print("Humano ha ganado")
            break
        if (totito.contarEspaciosVacios() > 0):
            totito.moverPc()
            input() # hará que el programa espere por un Enter para continuar
            totito.imprimir()
            if(totito.determinarGanador(totito.maquina)):
                print("Maquina ha ganadop")
                break
