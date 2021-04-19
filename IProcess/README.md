
# Compiladores - Trabalho 4
Repositório criado para realizar as entregas do trabalho da disciplina de compiladores do curso de Ciência da Computação da UFSCar

#### Isaac Willian Mariotto Marques
### RA: 754755


## Instalações necessárias
Primeiramente, as seguintes instalações devem ser feitas:

1.OpenJdk 11.0.10
Para instala-lo pode se usar o comando `$sudo apt install openjdk-11-jdk`em um ambiente Linux.

2.Apache Maven 3.6.3

3.Apache Netbeans IDE ou Intellij IDEA 

## Para compilar o compilador
Clone este repositório em sua maquina.

Execute no terminal dentro do repositório o comando:
`mvn package`

## Para compilar o código IProcess

Após esse comando o arquivo .jar  pode ser executado com o seguinte comando:
` java -jar LOCAL_DO_REPOSITORIO/target/IProcess-1.0-SNAPSHOT-jar-with-dependencies.jar <arquivo_de_entrada> saidas/<arquivo_de_saida>`

Após a execução desse comando a saída **(código em python)** pode ser encontrado na pasta **/saidas**.

## Utilização da linguagem IProcess

### Vídeo explicativo: 
https://user-images.githubusercontent.com/32374149/115233289-15014f00-a0ee-11eb-99dd-b7b750c4f34f.mp4


A linguagem IProcess foi pensando para ser uma linguagem que possibilita a aplicação de filtros em um grupo definido
de imagens. Sendo assim é possível declarar uma imagem ou um grupo de imagens e declarar filtros que serão utlizados nelas.
Ao final é possivel declarar o modo que se deseja exibir as imagens resultantes.

**O resultado final é um código em Python** que pode ser executado no Google Colab ou em um
interpretador Python a sua escolha e que possua os seguintes pacotes:
- matplotlib
- numpy
- scikit-image

Os pacotes podem se instaladas utilizando o gerenciador de pacotes pip, com o comando :
`pip install <nome do pacote>`


### Descrição da estrutura e dos comandos
A linguagem IProcess possui a seguinte estrutura:

```
LOAD: 
<declaração dos grupos ou imagens>

PROCESS:
<declaração dos processos>

SHOW:
<declaração da exibição>
``` 
Os comandos possíveis na linguagem IProcess serão demonstrados a seguir, porém alguns exemplos podem ser encontrados na pasta **ExemplosGerador**.

**Obs.** Os exemplos foram construidos para a saída ser executada no Google Colab.
```
LOAD: 

    // Declara um grupo de imagens com seus respectivos caminhos 
    GROUP <identificador> : (<caminho da image>), (<caminho da image>) , ...
    
    // Declara uma imagem com seu caminho
    ONE <identificador> : (<caminho da image>) 

PROCESS:

    //Aplicação de filtro em grupo ou imagem, o tamanho do filtro é opcional, porém o padrão é 3.
    filter < mean | median | tophat | gaussian > size <numero inteiro>(opcional) in <identificador>
    
    //Aplicação de filtro morfológico em grupo ou imagem, o tamanho do filtro é opcional e o padrão é 3,  esqueletização 
    //e erosão não possuem
    morphfilter < erosion  |  dilation  |  skeletonization > size  <numero inteiro>(opcional) in <identificador>

    //Aplicação de limiarização em grupo ou imagem
    threshold in <identificador> < above | below > <numero inteiro>
    
SHOW:

    //Mostra as imagens em um grid, numero de linhas e colunas são opcionais, porém o padrão é 3.
    show in grid <numero inteiro> rows(opcional) <numero inteiro> cols(opcional) <identificador>
    
    //Mostra a imagem
    show <identificador>
    
//comentário
    
``` 







