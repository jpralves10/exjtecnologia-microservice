## Objetivo

#### Microservice Tecnologia que compõe a aplicação ExJ

### Actuator `localhost:8081/actuator`

* /auditevents lista eventos relacionados à auditoria de segurança, como login/logout do usuário. Além disso, podemos filtrar por principal ou tipo entre outros campos.
* /beans retorna todos os beans disponíveis em nossa BeanFactory. Ao contrário de /auditevents, ele não oferece suporte à filtragem.
* /conditions, anteriormente conhecido como /autoconfig, cria um relatório de condições em torno da autoconfiguração.
* /configprops nos permite buscar todos os beans @ConfigurationProperties.
* /env retorna as propriedades do ambiente atual. Além disso, podemos recuperar propriedades únicas.
* /flyway fornece detalhes sobre nossas migrações de banco de dados Flyway.
* /health resume o estado de saúde de nosso aplicativo.
* /heapdump constrói e retorna um dump de heap da JVM usado por nosso aplicativo.
* /info retorna informações gerais. Podem ser dados personalizados, informações de construção ou detalhes sobre o último commit.
* /liquibase se comporta como / flyway, mas para Liquibase.
* /logfile retorna logs de aplicativo comuns.
* /loggers nos permite consultar e modificar o nível de registro de nosso aplicativo.
* /metrics detalha as métricas de nosso aplicativo. Isso pode incluir métricas genéricas e personalizadas.
* /prometheus returns metrics like the previous one, but formatted to work with a Prometheus server.
* /scheduletasks fornece detalhes sobre cada tarefa agendada em nosso aplicativo.
* /sessões lista as sessões HTTP, uma vez que estamos usando Spring Session.
* /shutdown executa um desligamento normal do aplicativo.
* /threaddump despeja as informações de encadeamento da JVM subjacente.

### ActiveMQ

* https://activemq.apache.org/components/classic/download/
* Executar prompt no modo admin e executar
  C:\Program Files\apache-activemq-5.16.2\bin\win64\InstallService.bat
* EM service, Iniciar serviço ActiveMQ  
* http://localhost:8161/admin/queues.jsp
* user: admin / password: admin

### Observações:

* Entrypoint lida com HttpModel;
* Usecase lida com Entity;
* Dataprovider lida com entity e table/response;
* Feign lida com Request e Response;
* Repository lida com table;