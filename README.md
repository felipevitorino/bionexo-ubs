# Bionexo UBS

Esse serviço tem como objetivo forcener a geolocalização e informações especificas sobre uma UBS

## Getting Started

Para iniciar a aplicação é necessario instanciar um HSQLDB para que os dados sejam armazenados automaticamente quando rodar o servidor

### Pre requisitos

Iniciado o HSQLDB
 - Execute
```
java -cp ./lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:biobionexo-ubs --dbname.0 bionexo-ubs
```

Configurando o HSQLDB
 - Execute
```
java -cp  /lib/hsqldb.jar  org.hsqldb.util.DatabaseManager
```
 - Campo URL
```
jdbc:hsqldb:hsql://localhost/bionexo-ubs
```

### Instalação

Na inicilização do serviço os dados são inseridos sendo necessário a alteração do timeout do servidor para que o processo execute sem falhas.

## Autores

* **Felipe Vitorino**
