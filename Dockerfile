# Etapa 1: Build do projeto
FROM maven:3.8.3-openjdk-17 AS build

# Definir o diretório de trabalho para o build
WORKDIR /app

# Copiar somente os arquivos necessários inicialmente para instalar dependências (cache eficiente)
COPY pom.xml ./
COPY mvnw ./
COPY .mvn .mvn/

# Instalar dependências do Maven (caching)
RUN mvn dependency:resolve

# Copiar o restante do código-fonte do projeto
COPY src ./src

# Compilar o projeto e gerar o JAR
RUN mvn clean install -DskipTests

# Etapa 2: Configurar a imagem para execução
FROM openjdk:17-jdk-slim

# Definir diretório de trabalho na imagem final
WORKDIR /app

# Copiar o JAR gerado para o contêiner final
COPY --from=build /app/target/agendamentos-1.0.0.jar /app/app.jar

# Expôr a porta em que a aplicação será executada
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "/app/app.jar"]