
# 1 - Execução do projeto.
   * 1.1 Para executar o projeto é necessário ter instalado JDK 8+.
   * 1.2  Instale o Apache Maven.
   * 1.3. Entre no diretorio raiz do projeto e use o comando "mvn clean install".
   * 1.4. Ainda no diretorio raiz use o comando  mvn exec:java -Dexec.mainClass="com.br.itidigital.BackendApplication" para rodar a aplicação.
   * 1.5. Acesse o endereço http://localhost:8081/swagger-ui.html, a porta de acesso pode ser configurada no arquivo application.properties.
   * 1.6. Acessando o endereço http://localhost:8081/swagger-ui.html, será exibido uma documentação e o mesmo tempo uma interface para consumir o serviço utilizando swagger.
   * 1.7. caso queira acessar diretamente o serviço execute um CURL ex:
   curl --location --request POST 'localhost:8081/validate' \
--header 'Content-Type: application/json' \
--data-raw '{"password":"AbTp9!fo"}'
   

# 2 - Solução
   * 2.1 Para o desenvolvimento do projeto, foi utilizado o framework spring boot, devido a facilidade de criar serviços RESTfull.
   * 2.2 Para a implementação da validação, utilizei Regex para reconhecer os padrões permitidos para aceitação da senha, pois ao meu ver é a melhor solução para ser aplicado a este tipo de problema.
   * 2.3 Para requisição http utilizei o método POST, pois o problema proposto é similar ao envio de informações para um formulário, cenário onde a melhor prática é utilizar o método POST por questões de segurança e padrão.

