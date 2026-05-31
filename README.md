# 📡 OrbitAlert — Sistema de Monitoramento de Desastres Climáticos

O **OrbitAlert** é um ecossistema de monitoramento ambiental de missão crítica projetado para coletar, persistir e gerenciar dados de telemetria climática (como índices pluviométricos e leituras de sensores de superfície). O projeto simula a interface de um Centro de Controle de Missão Orbital, fornecendo inteligência em tempo real para a prevenção de desastres em áreas urbanas de risco.

Esta solução foi desenvolvida de forma integrada para a **Global Solution 2026** da FIAP.

---

## 🌌 Visão Geral da Arquitetura

O ecossistema é dividido em duas frentes independentes e desacopladas que se comunicam via protocolo HTTP utilizando endpoints REST e troca de dados estruturados em formato JSON:

1. **Backend (API Rest):** Construído com Java e Spring Boot, responsável pelas regras de negócio, processamento síncrono dos níveis de risco e persistência local por meio de banco de dados H2.
2. **Frontend Mobile (App Móvel):** Desenvolvido em React Native com Expo e TypeScript, utilizando uma interface escura cibernética baseada em um *Design System* espacial de painel de controle.

---

## 📂 Estrutura do Repositório

O repositório está organizado em uma arquitetura monorepo com duas pastas principais:

```text
orbit-alert-projeto/
│
├── orbitalert-backend/         # PASTA 1: API REST construída em Spring Boot
│   ├── src/main/java/          # Código-fonte Java (Model, Repository, Controller)
│   ├── src/main/resources/     # application.properties (Configurações do H2)
│   ├── data/                   # Arquivo local de banco de dados (.mv.db)
│   └── pom.xml                 # Dependências do projeto Maven
│
└── orbitalert-mobile/          # PASTA 2: Aplicativo móvel em React Native + Expo
    ├── src/
    │   ├── components/         # Componentes reusáveis (OrbitCard)
    │   ├── screens/            # Telas (Listagem, Cadastro, Detalhes)
    │   ├── services/           # Camada de rede HTTP (Axios API Client)
    │   └── styles/             # Paleta de cores centralizada (Design System)
    ├── App.tsx                 # Orquestrador do Ciclo de Vida do App
    └── package.json            # Dependências JavaScript/TypeScript
```

## 🛠️ Tecnologias Utilizadas

### Backend
* **Java 17** (Linguagem de programação)
* **Spring Boot 3.x** (Framework de desenvolvimento ágil)
* **Spring Data JPA / Hibernate** (Mapeamento Objeto-Relacional)
* **H2 Database (Mode File)** (Banco de dados de persistência local)

### Frontend Mobile
* **React Native** / **Expo** (Interface nativa móvel)
* **TypeScript** (Tipagem estática e segurança)
* **Axios** (Cliente HTTP para integração assíncrona)

---

## 🚀 Como Executar o Ecossistema

### ☕ 1. Executando o Servidor Java (Backend)
1. Navegue até a pasta do backend:
   ```bash
   cd orbitalert-backend
   ```
2.Execute a aplicação utilizando o wrapper do Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

###📱 2. Executando o Aplicativo Móvel (Frontend)
1.Abra um segundo terminal e navegue até a pasta do mobile:
   ```bash
   cd orbitalert-mobile
   ```

2.Inicie o servidor de desenvolvimento do Expo em modo Web:
   ```bash
   npm run web
   ```

## 🛰️ Endpoints da API para Validação (Roteiro de Testes)

* **`GET /api/alertas`**: Retorna um array JSON com todos os logs ambientais armazenados.
* **`POST /api/alertas`**: Registra uma nova telemetria climática capturada na superfície.
    * *Payload esperado:*
        ```json
        {
          "regiao": "Zona Sul - Capão Redondo",
          "tipoSensor": "Pluviômetro Urbano",
          "leitura": 65.4,
          "nivelRisco": "ALTO"
        }
        ```

---

## 🤖 Autores do Projeto
*  **Estudante:** Arthur Macedo Gouvea **RM:** 556499
* **Estudante:** Clara Jullia Kondrasovas Costa e Silva **RM:** 556064
*  **Estudante:** Juliana Barbosa Sandes **RM:** 555605
* **Curso:**  3ECR - Engenharia de Computação — FIAP
