class Database():
    '''Esta clase manejará todos los datos que usará la API. Estos datos
    se perderán cada vez que el servidor se reinicie.'''
    def __init__(self):
        self.__cuiClients = []
        self.__clients = []
        self.__accounts = []
        self.__transfers = []

    def addClient(self, client):
        '''Añade un registro de un un nuevo cliente a la lista de clientes. Verificará que el CUI no este duplicado'''
        if not(client.getCui() in self.__cuiClients):
            self.__clients.append(client)
            self.__cuiClients.append(client.getCui())
            print(self.__clients)
            return True
        return False

    def getClient(self, cuiClient):
        '''Busca un cliente usando el cuidClient como referencia. Si no encuentra alguna coincidencia el resultado es None'''
        if int(cuiClient) in self.__cuiClients:
            for client in self.__clients:
                if client.getCui() == int(cuiClient):
                    return client
        return None
    
    def addAccount(self, account):
        '''Añade una cuenta a la lista de cuentas'''
        self.__accounts.append(account)
        return True
    
    def getAccount(self, uuidAccount):
        '''Recupera una cuenta de la lista de cuenta usando como referencia el identificador único de la cuenta'''
        for account in self.__accounts:
            if str(account.getUuid()) == uuidAccount:
                return account
        return None

    def addTransfer(self, transfer):
        '''Añade un registro de transferencia a la lista de transferencias'''
        self.__transfers.append(transfer)
        return True
    
    def getTransfers(self, uuidAccount):
        '''Recupera todas las transferencia que se han realizado desde y hacia una cuenta en específico'''
        transfersData = []
        for transfer in self.__transfers:
            if transfer.getToAccount() == uuidAccount or transfer.getFromAccount() == uuidAccount:
                transfersData.append(transfer)
        return transfersData

bankDatabase = Database()