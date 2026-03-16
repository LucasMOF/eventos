## Events API - Gerenciador de Eventos

Esta é uma API REST desenvolvida para o gerenciamento de eventos, permitindo desde o cadastro de informações básicas até o controle de cupons de desconto e localização geográfica. O projeto foi construído com foco em performance de busca (filtragem avançada) e escalabilidade.

---

### Tecnologias Utilizadas
 - **Java 21:** Versão mais estável e moderna 
 - **Spring Boot:** Web, Data JPA
 - **PostgreSQL:** Banco de dados relacional
 - **Hibernate:** ORM para mapeamento de entidades
 - **Lombok:** Para redução de código boilerplate
 - **Maven:** Gerenciador de dependências

### Modelagem de Dados (Diagrama)
O sistema baseia-se em três entidades principais relacionadas:
 - **Event (Eventos):** Entidade central que armazena título, descrição, data e se o evento é remoto ou presencial.
 - **Address (Endereços):** Armazena a localização (UF e Cidade). Relacionado opcionalmente ao evento (caso não seja remoto).
 - **Coupon (Cupons):** Gerencia códigos de desconto e validade para eventos específicos.

### Funcionalidades Principais
 - **Cadastro de Eventos:** Criação de eventos presenciais ou remotos.

 - **Gestão de Cupons:** Cadastro de cupons vinculados a um ID de evento específico.

 - **Listagem com Paginação:** Endpoint otimizado para retornar eventos em páginas.

 - **Filtros Avançados:** Busca inteligente de eventos por:

    - Título (Case insensitive)
    - Cidade e UF (Estado)
    - Intervalo de Datas (Start/End Date)
    - Eventos Futuros (Filtro automático para datas ≥ data atual)

 - **Lógica de Localização:** Tratamento para eventos remotos (que não possuem endereço físico).

### Endpoints
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| POST | /event | Cadastra um novo evento |
| GET | /event | Lista eventos com paginação |
| GET | /upcoming | Lista eventos futuros |
| GET | /filter | Lista eventos com filtros |
| POST | /coupon/{evendId} | Adiciona cupom a um evento | 
