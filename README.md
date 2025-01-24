<h1>Projeto: Sistema de Gerenciamento com DAO e JDBC</h1>
    <p>Este projeto é um sistema de gerenciamento de vendedores e departamentos utilizando o padrão <strong>DAO</strong> (<em>Data Access Object</em>) e JDBC (<em>Java Database Connectivity</em>). Ele permite realizar operações básicas (CRUD) em um banco de dados relacional.</p>
    
<h2>📋 Descrição do Projeto</h2>
<p>O sistema implementa duas entidades principais:</p>
<ul>
    <li><strong>Department:</strong> Representa os departamentos do sistema.</li>
    <li><strong>Seller:</strong> Representa os vendedores associados a um departamento.</li>
</ul>
<p>Com este sistema, é possível:</p>
<ul>
    <li>Criar, ler, atualizar e excluir departamentos e vendedores.</li>
    <li>Filtrar vendedores por departamento.</li>
    <li>Trabalhar com conexões JDBC de forma segura e organizada.</li>
</ul>

<h2>🗂️ Estrutura do Projeto</h2>
<p>O projeto segue a seguinte estrutura:</p>
<ul>
    <li><strong>model.entities:</strong> Contém as classes que representam as entidades do banco de dados (<code>Seller</code> e <code>Department</code>).</li>
    <li><strong>model.dao:</strong> Define as interfaces DAO (<code>SellerDao</code> e <code>DepartmentDao</code>) com os métodos que implementam o acesso ao banco.</li>
    <li><strong>model.dao.impl:</strong> Implementações das interfaces DAO utilizando JDBC (<code>SellerDaoJDBC</code> e <code>DepartmentDaoJDBC</code>).</li>
    <li><strong>db:</strong> Gerencia a conexão com o banco de dados e trata exceções relacionadas.</li>
    <li><strong>DaoFactory:</strong> Uma fábrica de objetos para criar instâncias das implementações DAO.</li>
</ul>

<h2>🛠️ Funcionalidades</h2>
<h3>Para <code>Department</code></h3>
<ul>
    <li>Inserir um novo departamento.</li>
    <li>Atualizar um departamento existente.</li>
    <li>Deletar um departamento pelo ID.</li>
    <li>Buscar um departamento pelo ID.</li>
    <li>Listar todos os departamentos.</li>
</ul>
<h3>Para <code>Seller</code></h3>
<ul>
    <li>Inserir um novo vendedor.</li>
    <li>Atualizar um vendedor existente.</li>
    <li>Deletar um vendedor pelo ID.</li>
    <li>Buscar um vendedor pelo ID.</li>
    <li>Listar todos os vendedores.</li>
    <li>Filtrar vendedores por departamento.</li>
</ul>


<h2>Para configurar o banco de dados:</h2>
    <pre><code>
CREATE TABLE department (
Id INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(50) NOT NULL
);

CREATE TABLE seller (
Id INT PRIMARY KEY AUTO_INCREMENT,
Name VARCHAR(100),
Email VARCHAR(100),
BirthDate DATE,
BaseSalary DOUBLE,
DepartmentId INT,
FOREIGN KEY (DepartmentId) REFERENCES department(Id)
);
    </code></pre>
</li>
<li>Configure a conexão com o banco no arquivo <code>db.properties</code>:
    <pre><code>
private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";
    </code></pre>
</li>
