# xy-inc
<b> Desafio LuizaLabs (xy-inc) </b>

A API foi desenvolvida utilizando o Framework Spring. Optei em desenvolver utilizando o Spring devido a minha familiaridade em comparação 
com as demais linguagens citadas no desafio. Consiste basicamente em cadastrar e listar os recursos cadastrados (POIs), sendo uma busca por proximidade, 
trazendo as localidades que estejam a uma distância menor ou igual ao parâmetro de referência. 

A aplicação possui em 3 serviços: <br>
- Serviço para cadastrar os POIs <br>
- Serviço para listar todos os POIs <br>
- Serviço para buscar os POIs por proximidade, passando 3 parâmetros: <br>
> x: valor da coordenada "x" <br>
> y: valor da coordenada "y" <br>
> d: distância máxima em metros "m"

<b> Iniciando a Aplicação: </b><br>
Método utilizado: POST <br>
URI: http://localhost:8080/poi <br>
Utilizando o serviço de cadastro de recurso, os seguintes POIs devem ser armazenados: 

    {
        "nome": "Lanchonete",
        "coordenadaX": 27,
        "coordenadaY": 12
    }
    
    {
        "nome": "Posto",
        "coordenadaX": 31,
        "coordenadaY": 18
    }
    
    {
        "nome": "Joalheria",
        "coordenadaX": 15,
        "coordenadaY": 12
    }
    
    {
        "nome": "Floricultura",
        "coordenadaX": 19,
        "coordenadaY": 21
    }
    
    {
        "nome": "Pub",
        "coordenadaX": 12,
        "coordenadaY": 8
    }
    
    {
        "nome": "Supermercado",
        "coordenadaX": 23,
        "coordenadaY": 6
    }
    
    {
        "nome": "Churrascaria",
        "coordenadaX": 28,
        "coordenadaY": 2
    }
	
<b> Listando todos os recursos cadastrados: </b><br>
Método utilizado: GET <br>
URI: http://localhost:8080/poi

<b> Listando os recursos por proximidade </b><br>
Método utilizado: GET <br>
URI: http://localhost:8080/poi/proximidade?x=20&y=10&d=10

<b> A aplicação utiliza o banco H2 em memória </b><br>
Console: http://localhost:8080/h2-console <br>
Username=sa <br>
Password=

<b> Setup </b><br>
$ mvn install <br>
$ java -jar target/xy-inc-api-1.0.0-SNAPSHOT.jar
