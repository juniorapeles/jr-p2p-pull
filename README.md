# 📝 Gerenciador de Versões Distribuído (MVP)

## 📌 Visão Geral
Este projeto é um sistema de controle de versões distribuído, permitindo compartilhamento de código entre máquinas via IP. O foco é criar um cliente leve, capaz de baixar apenas as diferenças e sincronizar arquivos com um servidor central ou diretamente entre máquinas.

## 🎯 Objetivo
Criar um **MVP funcional** que permita:
1. Inicializar um repositório local.
2. Conectar a um servidor ou outra máquina via IP.
3. Detectar diferenças em arquivos.
4. Sincronizar mudanças (download/upload incremental).

## 🛠 Tecnologias Utilizadas
- **Linguagem:** Python (para prototipação rápida) ou Java.
- **Comunicação:** HTTP, WebSockets ou P2P.
- **Algoritmos de Comparação:** `difflib`, `rsync`, `hashlib`.
- **Armazenamento:** SQLite ou JSON para histórico de versões.

## 🚀 Funcionalidades do MVP
### 📂 Cliente (`myversion`)
✅ `init` - Inicializa um repositório local.
```sh
myversion init --remote http://192.168.1.10:8080
```
✅ `pull` - Baixa atualizações mais recentes.
```sh
myversion pull
```
✅ `push` - Envia mudanças para o servidor ou outra máquina.
```sh
myversion push
```
✅ `diff` - Mostra as diferenças entre versões locais e remotas.
```sh
myversion diff
```

### 🖥️ Servidor (Opcional para centralizar repositórios)
- Recebe arquivos e versões dos clientes.
- Armazena histórico e metadados.
- Envia apenas diferenças para os clientes.

## 🔄 Fluxo de Funcionamento
1. O usuário inicializa o repositório com `myversion init`.
2. O cliente verifica o estado dos arquivos e calcula as diferenças.
3. No `pull`, apenas mudanças são baixadas.
4. No `push`, apenas arquivos modificados são enviados.
5. Se houver conflitos, o cliente solicita resolução manual ou automática.

## 🗺️ Roadmap Inicial
- [ ] Criar estrutura do CLI básico.
- [ ] Implementar detecção de mudanças (`diff`, `hash` de arquivos).
- [ ] Criar um servidor simples para receber arquivos.
- [ ] Implementar sincronização incremental.
- [ ] Adicionar suporte a múltiplos clientes (P2P ou servidor centralizado).

## 💡 Próximos Passos
📌 Escolher entre arquitetura **centralizada** (servidor único) ou **P2P** (máquinas se comunicando entre si).  
📌 Criar um **esqueleto do código** para o CLI e servidor.  
📌 Implementar um **sistema simples de versões** com armazenamento leve.  