# 📊 Dashboard de Vendas - DSSales

Sistema completo de dashboard de vendas desenvolvido com Spring Boot e React, oferecendo análises detalhadas de performance comercial através de gráficos interativos e relatórios em tempo real.

![Dashboard](https://img.shields.io/badge/Dashboard-Sales%20Analytics-blue)
![Spring Boot](https://img.shields.io/badge/Backend-Spring%20Boot%202.4.4-green)
![React](https://img.shields.io/badge/Frontend-React%2018.3.1-blue)
![TypeScript](https://img.shields.io/badge/Language-TypeScript-blue)
![Java](https://img.shields.io/badge/Language-Java%2011-orange)

## 🎯 Visão Geral

O DSSales é uma aplicação full-stack que permite visualizar e analisar dados de vendas de uma rede de lojas. O sistema oferece insights valiosos através de gráficos dinâmicos, filtros avançados e métricas de performance, auxiliando na tomada de decisões estratégicas.

### ✨ Principais Funcionalidades

- 📈 **Gráficos Interativos**: Visualização de vendas por data, loja e método de pagamento
- 🔍 **Filtros Avançados**: Filtragem por período, gênero e outras dimensões
- 📊 **Métricas Resumidas**: Estatísticas de vendas (média, mínima, máxima, quantidade)
- 🏪 **Análise por Loja**: Performance comparativa entre diferentes unidades
- 💳 **Análise por Pagamento**: Distribuição de vendas por método de pagamento
- 📅 **Evolução Temporal**: Tendências de vendas ao longo do tempo
- 📋 **Tabela Detalhada**: Listagem paginada de todas as vendas

## 🏗️ Arquitetura do Sistema

### Backend (Spring Boot)
- **Framework**: Spring Boot 2.4.4
- **Java Version**: 11
- **Banco de Dados**: H2 (desenvolvimento/teste), PostgreSQL (produção)
- **Segurança**: Spring Security
- **ORM**: JPA/Hibernate
- **API**: REST com paginação

### Frontend (React + TypeScript)
- **Framework**: React 18.3.1
- **Linguagem**: TypeScript
- **Build Tool**: Vite
- **Charts**: ApexCharts
- **HTTP Client**: Axios
- **Date Picker**: React Flatpickr

## 📁 Estrutura do Projeto

```
Projeto-Dashboard-ReactJS/
├── dssales-backend/           # API Spring Boot
│   ├── src/main/java/
│   │   └── com/devsuperior/dssales/
│   │       ├── config/        # Configurações de segurança
│   │       ├── controllers/   # Controllers REST
│   │       ├── dto/          # Data Transfer Objects
│   │       ├── entities/     # Entidades JPA
│   │       ├── repositories/ # Repositórios de dados
│   │       └── services/     # Lógica de negócio
│   └── src/main/resources/
│       ├── application*.properties
│       └── data.sql          # Dados iniciais
└── dssales-frontend/         # Interface React
    ├── src/
    │   ├── components/       # Componentes React
    │   │   ├── filter/       # Filtros de data e gênero
    │   │   ├── header/       # Cabeçalho da aplicação
    │   │   ├── pie-chart-card/ # Gráficos de pizza
    │   │   ├── sales-by-date/ # Gráfico de evolução
    │   │   ├── sales-summary/ # Cards de métricas
    │   │   └── sales-table/  # Tabela de vendas
    │   ├── types/           # Definições TypeScript
    │   ├── utils/           # Utilitários e formatação
    │   └── assets/          # Ícones e imagens
    ├── package.json
    └── vite.config.ts
```

## 🚀 Como Executar o Projeto

### Pré-requisitos

- **Java 11** ou superior
- **Node.js 16** ou superior
- **Yarn** ou **npm**
- **Maven 3.6** ou superior

### 1. Configuração do Backend

```bash
# Navegue para o diretório do backend
cd dssales-backend

# Instale as dependências e compile o projeto
./mvnw clean install

# Execute a aplicação
./mvnw spring-boot:run
```

O backend estará disponível em: `http://localhost:8080`

### 2. Configuração do Frontend

```bash
# Navegue para o diretório do frontend
cd dssales-frontend

# Instale as dependências
yarn install

# Execute a aplicação em modo de desenvolvimento
yarn dev
```

O frontend estará disponível em: `http://localhost:5173`

### 3. Acessando o Sistema

1. Abra seu navegador e acesse `http://localhost:5173`
2. O sistema carregará automaticamente os dados de exemplo
3. Use os filtros para explorar diferentes períodos e segmentos

## 📊 Dados e Configurações

### Banco de Dados

O sistema utiliza dados de exemplo pré-carregados incluindo:

- **4 Lojas**: Uberaba, Uberlândia, Araguari, Ituiutaba
- **4 Categorias**: Comidas e bebidas, Cosméticos, Utilidades domésticas, Roupas e acessórios
- **3 Métodos de Pagamento**: Crédito, Débito, Dinheiro
- **Mais de 2000 registros de vendas** entre 2017-2020

### Configurações de Ambiente

#### Desenvolvimento/Teste
- **Banco**: H2 (em memória)
- **Console H2**: `http://localhost:8080/h2-console`
- **Perfil ativo**: `test`

#### Produção
- **Banco**: PostgreSQL
- **Perfil ativo**: `prod`
- Configure as variáveis de ambiente necessárias

## 🔧 API Endpoints

### Vendas
- `GET /sales` - Lista paginada de vendas com filtros
- `GET /sales/summary` - Resumo estatístico das vendas
- `GET /sales/by-store` - Vendas agrupadas por loja
- `GET /sales/by-payment-method` - Vendas por método de pagamento
- `GET /sales/by-date` - Vendas agrupadas por data

### Parâmetros de Filtro
- `minDate` - Data inicial (formato: YYYY-MM-DD)
- `maxDate` - Data final (formato: YYYY-MM-DD)
- `gender` - Gênero (MALE, FEMALE, OTHER)
- `page` - Número da página (para paginação)
- `size` - Tamanho da página (para paginação)

### Exemplo de Requisição
```bash
GET /sales?minDate=2017-01-01&maxDate=2017-12-31&gender=FEMALE&page=0&size=20
```

## 🎨 Componentes do Frontend

### SalesSummary
Exibe métricas principais em cards:
- **Média** de vendas
- **Quantidade** total de vendas
- **Valor mínimo** de venda
- **Valor máximo** de venda

### SalesByDate
Gráfico de barras mostrando evolução das vendas ao longo do tempo com:
- Visualização de tendências
- Período selecionado nos filtros
- Total de vendas no período

### PieChartCard
Gráficos de pizza para:
- **Vendas por Loja**: Distribuição percentual entre unidades
- **Vendas por Método de Pagamento**: Preferências de pagamento

### SalesTable
Tabela paginada com:
- Listagem detalhada de vendas
- Informações de loja, categoria, pagamento
- Paginação para grandes volumes de dados

### Filter
Sistema de filtros com:
- **Seletor de Data**: Período customizável
- **Filtro de Gênero**: Masculino, Feminino, Outros
- Aplicação em tempo real nos gráficos

## 🔒 Segurança

O backend implementa Spring Security com:
- Configuração de CORS para comunicação com o frontend
- Endpoints protegidos (configurável por ambiente)
- Headers de segurança configurados

## 🧪 Testes

### Backend
```bash
cd dssales-backend
./mvnw test
```

### Frontend
```bash
cd dssales-frontend
yarn test
```

## 📦 Deploy

### Backend (Heroku)
```bash
# Configure as variáveis de ambiente
heroku config:set APP_PROFILE=prod
heroku config:set DATABASE_URL=postgresql://...

# Deploy
git push heroku main
```

### Frontend (Vercel/Netlify)
```bash
# Build para produção
yarn build

# Deploy dos arquivos da pasta dist/
```

## 🛠️ Tecnologias Utilizadas

### Backend
- **Spring Boot 2.4.4** - Framework Java
- **Spring Data JPA** - Persistência de dados
- **Spring Security** - Segurança da aplicação
- **H2 Database** - Banco em memória (dev/test)
- **PostgreSQL** - Banco de produção
- **Maven** - Gerenciamento de dependências

### Frontend
- **React 18.3.1** - Biblioteca de interface
- **TypeScript** - Linguagem tipada
- **Vite** - Build tool moderno
- **ApexCharts** - Biblioteca de gráficos
- **Axios** - Cliente HTTP
- **React Flatpickr** - Seletor de datas
- **ESLint + Prettier** - Qualidade de código

## Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

⭐ **Se este projeto foi útil para você, não esqueça de dar uma estrela!**
