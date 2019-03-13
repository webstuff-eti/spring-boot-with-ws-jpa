# spring-boot-with-ws-jpa
Irei desenvolver um projeto com Spring Boot e serviços Web Service SOAP com JPA, utilizando:

Passo 01: Acesse     -->   https://start.spring.io/   (crie seu projeto)


Passo 02: Acesse: http://localhost:8180/ws/customers.wsdl

Passo 03: testando com SOAP-UI
Com a ferramenta de software SOAP-UI, importe o arquivo (Customers-soapui-project) 
que encontra-se dentro do projeto no diretório
(spring-boot-with-ws-jpa\crm\files-xml), e teste o serviços (GetCustomerDetail) que é oque 
encontra-se finalizado (exceto a comunicação com o banco de dados em memória).

Importante!
Iremos implementar acesso ao banco de dados (Em memória) mais a frente.



# Criando Cliente WS


Passo 01: -->   https://start.spring.io/   (crie seu projeto) : cliente-crm

Passo 02: Suba seu serviço WS

Passo 03: entre no diretório do projeto e através do prompt (no caso de ser S.O Windowns) e insira o comando (wsimport -s src/main/java -p br.eti.webstuff.generated.stubs http://localhost:8180/ws/customers.wsdl) para que seja gerado as classes Stubs de maneira automática:

D:\PROJETO-WS\spring-boot-with-ws-jpa\cliente-crm>wsimport -s src/main/java -p br.eti.webstuff.generated.stubs http://localhost:8180/ws/customers.wsdl



