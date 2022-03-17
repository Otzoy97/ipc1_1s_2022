import random

tablero = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
humano = 0
maquina = 0


def determinarGanador(figura):
    '''
    Verifica cada fila, cada columna y las dos diagonales que se forman en el tablero de 3x3
    Si los elementos en todos esas posiciones son iguales, entonces hay un ganador
    '''
    # Verifica filas
    for fila in tablero:
        if all(posicion == figura for posicion in fila):
            return True
    # Verifica columnas
    for columna in range(len(tablero)):
        if tablero[0][columna] == figura and tablero[1][columna] == figura and tablero[2][columna] == figura:
            return True
    # Verifica diagonales
    if all(posicion == figura for posicion in [tablero[0][0], tablero[1][1], tablero[2][2]]):
        return True
    if all(posicion == figura for posicion in [tablero[0][2], tablero[1][1], tablero[2][0]]):
        return True
    return False


def traducirEntrada(str):
    str = str.strip()
    parOrdenado = str.split(",")
    try:
        posX = int(parOrdenado[0])
        posY = int(parOrdenado[1])
        if contarEspaciosVacios() > 0:
            if esVacio(posX, posY):
                colocarFigura(humano, posX, posY)
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


def colocarFigura(figura, posX, posY):
    tablero[posX][posY] = figura


def asignarFigura():
    # para MODIFICAR una variable global desde una función
    # es necesario indicarle a la función que dicha variable se encuentra
    # en un "nivel superior" con la palabra reservada "global"
    global humano
    global maquina
    prob = random.randint(1, 100)
    if prob < 50:
        humano = 1
        maquina = 2
        print("La figura asignada es X")
    else:
        humano = 2
        maquina = 1
        print("La figura asignada es O")


def moverPc():
    probX = random.randint(0, 2)
    probY = random.randint(0, 2)
    while not esVacio(probX, probY):
        probX = random.randint(0, 2)
        probY = random.randint(0, 2)
    colocarFigura(maquina, probX, probY)


def esVacio(posX, posY):
    return tablero[posX][posY] == 0


def contarEspaciosVacios():
    contador = 0
    # for i in range(len(tablero)):
    for fila in tablero:
        for posicion in fila:
            if posicion == 0:
                contador += 1
    return contador


def imprimir():
    for fila in tablero:
        for posicion in fila:
            if posicion == 1:
                print(" X ", end="")
            elif posicion == 2:
                print(" O ", end="")
            else:
                print("   ", end="")
        print("")
    print("---------------")


imprimir()
asignarFigura()
while(contarEspaciosVacios() > 0):
    entrada_usuario = input("Indique la posición: ")
    if(traducirEntrada(entrada_usuario)):
        imprimir()
        if(determinarGanador(humano)):
            print("Humano ha ganado")
            break
        if(contarEspaciosVacios() > 0):
            moverPc()
            input()  # hará que el programa espere por un Enter para continuar
            imprimir()
            if(determinarGanador(maquina)):
                print("Máquina ha ganado")
                break