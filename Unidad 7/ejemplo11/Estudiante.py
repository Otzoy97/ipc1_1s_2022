class Estudiante:
    def __init__(self, carnet, nombre, apellido):
        self.NoCarnet = carnet
        self.NombreEstudiante = nombre
        self.ApellidoEstudiante = apellido

    def comoMeLlamo(self):
        print(f'{self.ApellidoEstudiante}, {self.NombreEstudiante}')  

estudiante01 = Estudiante(201602782, "Sergio", "Otzoy")
estudiante01.NoCarnet = "202102782"
estudiante01.comoMeLlamo()
estudiante02 = Estudiante("201602782", 0, 1)
estudiante02.comoMeLlamo()