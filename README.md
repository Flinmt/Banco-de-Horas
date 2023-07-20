# Banco-de-Horas
 Projeto de estudo, seu foco é estudar criação de documentação, modelagemm de dados e Api Spring Boot.

 ---

### Sumário

| 1. | ..............................................................................................................Introdução |
| --- | --- |
| 1.1 | ....................................................................................Visão Geral do Documento |
| 2. | ...................................................................................Descrição Geral do Sistema |
| 3. | .....................................................................................Diagrama Entidade Relacionamento |
| 4. | .................................................................Especificação de Requisitos do Sistema |
| 5. | ..........................................................Especificação de Requisitos Não-Funcionais |

## 1. Introdução

### 1.1. Visão Geral do Documento

Além dessa seção introdutória, as seções seguintes estão organizadas como descrito abaixo:

- **Seção 2 - Descrição Geral do Sistema:** apresenta uma visão geral do sistema, caracterizando qual o seu escopo e descrevendo seus usuários (personas).
- **Seção 3 - Diagrama de Casos de Uso:** ilustra o diagrama de casos de uso do sistema.
- **Seção 4 - Especificação de Requisitos Funcionais:** descreve requisitos funcionais de forma mais detalhada. Descreve os fluxos de eventos, prioridades, atores, entradas/saídas e regras de negócio de cada caso de uso a ser implementado
- **Seção 5 - Especificação de Requisitos Não Funcionais:** cita e detalha os requisitos não funcionais do sistema.

## 2. Descrição Geral do Sistema

Banco de horas é um sistema básico, uma crud onde o usuário poderá adicionar um projeto e receber relatórios sobre quanto tempo ele trabalhou no mesmo, juntamente com o calculo completo de seu valor/hora pelo tempo investido. 

### 2.1. Persona

Nome: Lucas Silva
Idade: 32 anos
Profissão: Desenvolvedor de software
Experiência: 8 anos de experiência na área de desenvolvimento de sistemas
Hobbies: Jogos de tabuleiro, leitura e trilhas ao ar livre

Background:
Lucas é um desenvolvedor de software talentoso e dedicado que trabalha em uma empresa de tecnologia. Ele é apaixonado por seu trabalho e está constantemente em busca de novos desafios e oportunidades para aprimorar suas habilidades. Lucas é conhecido por sua natureza organizada e metódica, o que o torna um colaborador confiável em sua equipe.

Desafio:
Embora Lucas goste muito de seu trabalho, ele frequentemente enfrenta dificuldades para rastrear e gerenciar seu tempo gasto em diferentes projetos. Ele precisa registrar todas as suas atividades para que sua empresa possa cobrar os clientes com precisão, mas atualmente ele está fazendo isso manualmente em planilhas, o que consome muito tempo e é suscetível a erros.

Objetivo:
Lucas está buscando uma solução eficiente para gerenciar seu tempo e calcular seu valor/hora de forma automática e precisa. Ele gostaria de ter acesso a relatórios detalhados que mostrem quanto tempo ele investiu em cada projeto, além de calcular o valor total que deve ser faturado com base nas horas trabalhadas.

Comportamento:
Lucas é um usuário técnico, familiarizado com sistemas de software e está acostumado a trabalhar com interfaces de usuário intuitivas. Ele valoriza a eficiência e a facilidade de uso em um sistema, e está sempre disposto a experimentar novas tecnologias que possam melhorar sua produtividade. Lucas é dedicado ao seu trabalho, mas também valoriza um equilíbrio saudável entre a vida pessoal e profissional, reservando tempo para seus hobbies e para passar com a família e amigos.

Expectativas:
Lucas espera que o sistema de banco de horas seja fácil de usar, com uma interface intuitiva que permita adicionar rapidamente projetos e registrar o tempo trabalhado. Ele gostaria de receber relatórios detalhados e personalizáveis que possam ser facilmente compartilhados com sua equipe e sua empresa. Além disso, Lucas espera que o sistema faça automaticamente o cálculo de seu valor/hora com base nas horas trabalhadas, permitindo-lhe ter uma visão clara e precisa de quanto será remunerado por seu trabalho.

### 3. Diagrama Entidade Relacionamento

![ER](https://github.com/VitorL-Dev/Banco-de-Horas/assets/138712602/ee58c774-c76d-4fd5-9f84-cfebd402dd11)

### 4. **Especificação de Requisitos Funcionais**

| ID e Nome: | [RF001] - Cadastrar Projeto |
| --- | --- |
| Autor: | Vitor José |
| Módulo: | Cadastro |
| Data da Produção: | 07/07/2023 |
| Data da Última Alteração: | 07/07/2023 |
| Detalhamento: | O usuário poderá cadastrar projetos em que esteja trabalhando, dando ao sistemas informações como:
||- Nome do Projeto*;
||- Valor/hora*;
||- Data de Inicio do Projeto*;
||- Data de Limite de Entrega do Projeto;
||- Nome do Cliente*. |
| Regras de Negocio: | 1. Caso o usuário não informe todas as informações necessárias para a criação do projeto, o sistema apresentará a seguinte mensagem: “Por favor, preencha todas as informações necessárias.”. |

| ID e Nome: | [RF002] - Gerenciar Projetos |
| --- | --- |
| Autor: | Vitor José |
| Módulo: | Cadastro |
| Data da Produção: | 07/07/2023 |
| Data da Última Alteração: | 07/07/2023 |
| Detalhamento: | O usuário poderá ver uma lista com todos os seus projetos, onde ele poderá selecionar qual deles deseja continuar [RF003], modificar, deletar e finalizar projeto [RF005]. |
| Regras de Negocio: | 1. Antes de qualquer modificação ser realizada, uma caixa de dialogo será apresentada ao usuário pedindo a confirmação da ação. |

| ID e Nome: | [RF003] - Inicio de Trabalho |
| --- | --- |
| Autor: | Vitor José |
| Módulo: | Fluxo de Tela |
| Data da Produção: | 07/07/2023 |
| Data da Última Alteração: | 07/07/2023 |
| Detalhamento: | Ao clicar em continuar trabalho, o sistema salvará o horário em que o usuário começou seu trabalho no projeto e habilitará a opção “Parar Trabalho” [RF004]. |

| ID e Nome: | [RF004] - Parar Trabalho |
| --- | --- |
| Autor: | Vitor José |
| Módulo: | Fluxo de Tela |
| Data da Produção: | 07/07/2023 |
| Data da Última Alteração: | 07/07/2023 |
| Detalhamento: | Ao clicar em parar trabalho, o sistema salvará o horário em que o usuário parou seu trabalho no projeto e apresentará o total de horas que o usuário trabalhou no dia. |

| ID e Nome: | [RF005] - Terminar Projeto |
| --- | --- |
| Autor: | Vitor José |
| Módulo: | Finalização |
| Data da Produção: | 07/07/2023 |
| Data da Última Alteração: | 07/07/2023 |
| Detalhamento: | Ao clicar em finalizar projeto, o usuário marcará aquele projeto como finalizado, e poderá consulta-lo para verificar a quantidade de horas totais trabalhadas no mesmo, juntamente com o valor/hora total e a data de finalização do projeto. |
| Regras de Negocio: | 1. Após finalizado, o projeto não pode mais ser modificado. |
