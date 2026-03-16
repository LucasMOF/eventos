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
