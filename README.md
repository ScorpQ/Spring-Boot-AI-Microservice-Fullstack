# AI Microservice - Fitness Platform

Mikroservis mimarisi kullanılarak geliştirilmiş bir fitness platformu. Kullanıcı yönetimi ve aktivite takibi için iki ayrı mikroservis içerir.

## 🏗️ Proje Yapısı

```
AI-Microservice/
├── userService/          # Kullanıcı yönetimi servisi (PostgreSQL)
└── activityService/       # Aktivite takibi servisi (MongoDB)
```

## 🛠️ Teknolojiler

### userService
- **Framework**: Spring Boot 3.5.7
- **Java**: 21
- **Database**: PostgreSQL
- **ORM**: Spring Data JPA
- **Validation**: Jakarta Validation
- **Build Tool**: Maven

### activityService
- **Framework**: Spring Boot 3.5.7
- **Java**: 21
- **Database**: MongoDB
- **ORM**: Spring Data MongoDB
- **Build Tool**: Maven

## 📋 Gereksinimler

- Java 21
- Maven 3.6+
- Docker (veritabanları için)
- PostgreSQL (userService için)
- MongoDB (activityService için)

## 🚀 Kurulum

### 1. PostgreSQL Container'ını Başlat (userService için)

```bash
docker run --name postgres-user -e POSTGRES_USER=postgres-java -e POSTGRES_PASSWORD=password -e POSTGRES_DB=userservice -p 5432:5432 -d postgres:latest
```

### 2. MongoDB Container'ını Başlat (activityService için)

```bash
docker run --name mongodb-activity -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=password -p 27017:27017 -d mongo:latest
```

### 3. Servisleri Çalıştır

#### userService

```bash
cd userService
./mvnw spring-boot:run
```

Veya:

```bash
cd userService
./mvnw clean install
java -jar target/userservice-0.0.1-SNAPSHOT.jar
```

#### activityService

```bash
cd activityService
./mvnw spring-boot:run
```

Veya:

```bash
cd activityService
./mvnw clean install
java -jar target/activityservice-0.0.1-SNAPSHOT.jar
```

## 🔧 Yapılandırma

### userService

Veritabanı bağlantı bilgileri `userService/src/main/resources/application.yaml` dosyasında:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/userservice
    username: postgres-java
    password: password
```

### activityService

MongoDB bağlantı bilgileri `activityService/src/main/resources/application.properties` dosyasında yapılandırılabilir:

```properties
spring.data.mongodb.uri=mongodb://admin:password@localhost:27017/activityservice?authSource=admin
```

## 📡 API Endpoints

### userService

- **Base URL**: `http://localhost:8080/api/users`

- `GET /{userId}` - Kullanıcı profilini getir
- `POST /register` - Yeni kullanıcı kaydı

### activityService

- **Base URL**: `http://localhost:8081` (varsayılan port)

## 🐳 Docker Komutları

### Container'ları Durdurma

```bash
docker stop postgres-user
docker stop mongodb-activity
```

### Container'ları Tekrar Başlatma

```bash
docker start postgres-user
docker start mongodb-activity
```

### Container'ları Silme

```bash
docker rm postgres-user
docker rm mongodb-activity
```

### Container Loglarını Görüntüleme

```bash
docker logs postgres-user
docker logs mongodb-activity
```

## 📝 Notlar

- Her servis bağımsız olarak çalışabilir
- Veritabanları Docker container'larında çalışmaktadır
- Geliştirme ortamı için hazırlanmıştır

## 🔄 Geliştirme Durumu

- ✅ UserService temel yapısı
- ✅ ActivityService temel yapısı
- ⏳ Servisler arası iletişim
- ⏳ Error handling iyileştirmeleri
- ⏳ Redis cache entegrasyonu
- ⏳ Postman Collection

## 👤 Geliştirici

Bu proje öğrenme amaçlı geliştirilmiştir.

