# projarq-T1

## Perfis de acesso
 - Aluno
    - Logar
    - Gerenciar time (incluir, remover aluno)
    - Quando inserido em um time, este time pode ser gerenciado por este aluno
 - Professor
    - Ver times
    - Avaliar times
  
## API ENDPOINTS

**Logar**

  - /login 
  
   ```javascript
   {
    "usuario" : "" ,
    "senha" : ""
   }
   ```
   
   **Listar alunos**
  - GET /alunos


   **Time**
  - GET /times/:id
  
  __________________

  
  - POST /times
  
   ```javascript
   {
    "alunos" : [] ,
    "nomeEquipe" : ""
   }
   ```

  __________________
 
  
  - DELETE /times/:id

  __________________

  - PATCH /times/:id
   
   ```javascript
   {
    "id": 0,
    "alunos" : [] ,
    "nomeEquipe" : ""
   }
   ```
   
   
  
