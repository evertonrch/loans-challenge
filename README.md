# 💰 Sistema de Empréstimos

Este projeto é um serviço REST que determina quais modalidades de empréstimo uma pessoa pode acessar com base em sua idade, renda e localização. Teve como inspiração um desafio proposto pelo repositório **Backend Brasil**. Mais detalhes você encontra [aqui](https://github.com/backend-br/desafios/blob/master/loans/PROBLEM.md).

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Maven**
  
---

## 🏗 Arquitetura e padrões do Projeto

A aplicação segue uma estrutura baseada em padrões arquiteturais bem definidos:

- **Padrão em Camadas**: Organização do código em camadas distintas (Controller, Service e Repository).
- **Strategy Pattern**: Utilizado para definir as regras de concessão de empréstimos dinamicamente.
- **Rule Pattern**: Encapsula regras de validações que podem ser reutilizáveis.

---

## 📡 Endpoints da API

### 🔹 Determinar Modalidades de Empréstimos

**[POST] /customer-loans**

#### 📥 Request:
```
{
    "age": 20,
    "cpf": "275.484.389-23",
    "name": "Vuxaywua Zukiagou",
    "income": 4500.00,
    "location": "SP"
}
```

#### 📤 Response:
```
{
    "customer": "Vuxaywua Zukiagou",
    "loans": [
        {
            "type": "PERSONAL",
            "interest_rate": 4
        },
        {
            "type": "GUARANTEED",
            "interest_rate": 3
        }
    ]
}
```

---

## 🏗 Como Executar o Projeto

1. **Clone o repositório:**
   ```
   git clone https://github.com/seu-usuario/loans-challenge .git
   cd loans-challenge 
   ```
   
2. **Execute a aplicação:**
   ```
   mvn spring-boot:run
   ```

3. **A API estará disponível em:**
   ```
   http://localhost:8080
   ```

---

## 🤝 Contribuição

Contribuições são bem-vindas! Para contribuir:

1. **Fork** o repositório.
2. **Crie uma branch** (`git checkout -b feature/nova-funcionalidade`).
3. **Faça commit das mudanças** (`git commit -m 'Adiciona nova funcionalidade'`).
4. **Envie um PR**!

