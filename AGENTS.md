# App Organize Torneios - Guia para Agentes IA (AGENTS.md)

Este documento contém o contexto, arquitetura, stack tecnológico e diretrizes para agentes de Inteligência Artificial trabalhando no projeto **Organize Torneios**.

## 1. Sobre o Projeto
**Organize Torneios** é um aplicativo Android focado em auxiliar na criação e gestão prática de torneios esportivos. O aplicativo permite gerenciar torneios que possuem fases de grupos e eliminatórias (mata-mata), permitindo o cadastro de equipes, jogadores, registros de resultados, controle de artilharia, cartões, melhores ataques e defesas.

## 2. Stack Tecnológico
O projeto é baseado no framework tradicional do Android:
- **Linguagem Principal:** Java (todo o código-fonte está em Java).
- **Interface Gráfica (UI):** Android Views Clássicas (XML Layouts).
- **Componentes Visuais:** `RecyclerView`, Material Design Components, AppCompat, ConstraintLayout e janelas modais via `FancyAlertDialog-Android`.
- **Navegação:** AndroidX Navigation (`navigation-fragment`, `navigation-ui`).
- **Banco de Dados Local:** SQLite Nativo, utilizando a classe `SQLiteOpenHelper` e cursores manuais (sem bibliotecas ORM como Room).
- **Monetização:** Google AdMob (`play-services-ads`).

## 3. Arquitetura do Projeto
O aplicativo segue um padrão arquitetural semelhante ao MVC estruturado nos seguintes pacotes dentro de `com.innovatesolutions.organizetorneios`:

- **`model/`**: Contém as classes POJO/Entidades de domínio do aplicativo (ex: `User.java`, `Equipe.java`, `Grupo.java`, `Jogador.java`, `Torneio.java`).
- **`datamodel/`**: Contém a estrutura das tabelas e esquemas para o SQLite (ex: `EquipeDataModel.java` contém nomes de colunas, queries de criação de tabela).
- **`api/`**: Responsável por utilitários e a gestão do banco de dados (ex: `AppDataBase.java` e `AppUtil.java`).
- **`controller/`**: Classes encarregadas da regra de negócio intermediária, abstraindo o CRUD do banco de dados (`AppDataBase.java`) e fornecendo os dados e operações para as views (ex: `EquipeController.java`).
- **`view/`**: Contém as classes relativas à UI, no caso as `Activities` (ex: `Dashboard.java`, `MataMata.java`, `Classificacao.java`).
- **`fragment/`**: Classes correspondentes aos `Fragments` das telas principais e BottomSheets.
- **`adapter/`**: Classes de adaptadores para popular listas no `RecyclerView` (ex: `EquipesAdapter.java`).

## 4. Diretrizes para Agentes de Código

Ao sugerir ou implementar código, siga rigidamente as seguintes regras:
1. **Mantenha-se no Java:** O projeto não utiliza Kotlin. Todo código implementado ou refatorado deve ser feito na linguagem **Java**.
2. **Respeite a Arquitetura (Sem novas bibliotecas arquiteturais):** Não adicione dependências de arquiteturas modernas (como Hilt/Dagger, Retrofit, Room, Jetpack Compose, LiveData/ViewModel ou RxJava) a menos que explicitamente solicitado pelo desenvolvedor.
3. **Padrão de Banco de Dados:** O acesso aos dados deve ser feito atualizando a `AppDataBase.java` e os arquivos `.java` no pacote `datamodel/`. Manipulações aos dados devem passar pelos respectivos `Controllers`.
4. **Padrão de UI:** Atualizações de tela devem ocorrer por meio do `findViewById` (ou DataBinding/ViewBinding, se introduzido de maneira isolada) utilizando XMLs localizados em `res/layout`.
5. **Estilo de Código:** Respeite o padrão de nomenclatura (Classes PascalCase, métodos/variáveis camelCase) e as estruturas clássicas Android (verificações de nulo, lifecycle padrão das Activities/Fragments).
6. **Permissões:** O App requer armazenamento de dados (para a funcionalidade de `.view.Backup.java`), então, atenção especial caso precise mexer na API de Storage devido ao Scoped Storage (a partir do SDK 29+).

## 5. Estrutura e Funcionalidades Core
Algumas funcionalidades centrais de interesse:
- **Gestão de Grupos e Torneios:** `CadastrarGrupos.java`, `Equipes.java`, `EscolherTorneio.java`.
- **Ciclo de Partidas:** `JogosPrimeiraFase.java` e módulos de fases finais `MataMata.java`, `Final.java`.
- **Estatísticas:** `Artilharia.java`, `MelhorDefesa.java`, `MelhorAtaque.java`, `Classificacao.java`.

*Sempre verifique esses arquivos primeiro caso sua tarefa envolva funcionalidades de gestão do campeonato.*
