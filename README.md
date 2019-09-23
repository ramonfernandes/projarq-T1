# projarq-T1


[Front](https://github.com/mrRodrigo/hackatona-front)


## Perfis de acesso
 - Aluno
    - Logar
    - Gerenciar time (incluir, remover aluno)
    - Quando inserido em um time, este time pode ser gerenciado por este aluno
 - Professor
    - Ver times
    - Avaliar times
  
## API ENDPOINTS
### ALUNO

   **Login**

  - GET /aluno/login?matricula=matricula&senha=senha 
   
---

   **Cadastrar usuario**

  - POST /aluno/cadastrar
    
   ```javascript
   {
    "nome" : String,
    "matricula" : String,
    "senha": String,
    "curso": String,
    "isAluno": Boolean
   }
   ```
   
---

   **Listar Usuários**
   
  - GET /aluno/usuarios?nome=nome&curso=curso&matricula=matricula

---

### TIME

  **Listar times**
  
  - GET /time

---

   **Cadastrar time**
  - POST /time
  
   ```javascript
   [
      {
         "nome" : String,
         "matricula" : String,
         "senha": String,
         "curso": String,
         "isAluno": Boolean
      }
   ]
   ```

  ---
 
  
  **Atualizar time**
  - POST /time/:id
  
   ```javascript
   [
      {
         "nome" : String,
         "matricula" : String,
         "senha": String,
         "curso": String,
         "isAluno": Boolean
      }
   ]
   ```

---

  **Buscar time**
  - GET /time/:id


---

  **Buscar time por alunos**
  - GET /time/timeByAlunos
   ```javascript
   [String]
   ```

---

  **Avaliar time**
  - POST /time/:id
   ```javascript
   {
      "funcionamento": Number,
      "inovacao": Number,
      "pitch": Number,
      "processo": Number,
      "time": Number,
      "timeId":Number
   }
   ```
   
   
  
