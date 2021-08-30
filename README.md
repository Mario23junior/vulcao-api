# API de Vulcaos ativos no mundo 

api de gestão de vendas e gerenciamento de produtos cliente e vendas

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

Consulte **Implantação** para saber como implantar o projeto.

### 📋 Pré-requisitos

### 🔧 Instalação

De que coisas você precisa para instalar o software e como instalá-lo?

baixe o projeto e descompacte a pasta e cesse a pasta descompactada

Baixe as dependências do projeto 
```
mvn clean install
```
Em seguida execute a aplicação

```
mvn spring-boot:run
```

## 🛠️ Construído com

Mencione as ferramentas que você usou para criar seu projeto

* [SpringBoot](https://spring.io/projects/spring-boot) - O framework web usado
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [Travis-CI](https://travis-ci.org/) - Usando a integração contínua
* [Swagger](https://swagger.io/tools/swagger-ui/) - descrição de interface para descrever APIs RESTfull


## Para obter mais detalhes da documentação acesso o swagger
```
http://localhost:8080/swagger-ui.html
```

## Uso

## Resultado dos dados da API

```
[
    {
        "nome": "Sakurajima",
        "ativo": true,
        "formadoPor": "terras altas, areia branca",
        "ultimaErupcao": "2019-09-20",
        "descricao": "Sakurajima, também romanizado como Sakurashima, é um estratovulcão ativo e antigamente era uma pequena ilha com o mesmo nome que agora está ligada com a ilha de Kyūshū, uma das quatro grandes ilhas do Japão e localiza-se na Província de Kagoshima no sul do país.",
        "regiao": [
            {
                "tipoMontanha": "Monte",
                "alcanceMatriz": "estrombolianas",
                "regiaoGeografica": "Kagoshima",
                "pico": "1.117"
            }
        ],
        "localizacao": [
            {
                "continente": "Japão",
                "pais": "string",
                "metros": 1.117,
                "pes": 3665.0,
                "cooordenadas": "31° 35′ N, 130° 39′ L"
            }
        ],
        "estrutura": [
            {
                "tipoLava": "estratovulcão",
                "formatoPercorencia": "ínfimas e efêmeras",
                "formacaoPerfil": "cinzas vulcânicas"
            }
        ]
    }
]

```
## Contribuindo
Solicitações pull são bem-vindas. Para mudanças importantes, abra um problema primeiro para discutir o que você gostaria de mudar.

Certifique-se de atualizar os testes conforme apropriado.

## License
[MIT](https://choosealicense.com/licenses/mit/)
