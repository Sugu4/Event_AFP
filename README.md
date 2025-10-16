# 🎫 Event-Ticketing-Plattform API (Backend)

Dies ist das Backend der Event-Ticketing-Plattform, entwickelt als Teil eines Umschulungsprojekts. Das System dient als zentrale, sichere Geschäftslogik für die Verwaltung von Veranstaltungen und den **atomaren Ticketverkauf**.

---

## 1. Projektverlauf und Architektur

### Technologie-Stack

| Komponente | Technologie | Zweck |
| :--- | :--- | :--- |
| **Backend/Logik** | **Java 21 (LTS)** / Spring Boot 3 (REST) | Implementiert die Geschäftslogik und API-Endpunkte. |
| **Datenbank** | **MariaDB 10.x** (via XAMPP) | Datenpersistenz; gewährleistet Transaktionssicherheit (ACID). |
| **Persistenz** | Spring Data JPA / Hibernate | Mappt die Java-Entitäten auf die MariaDB-Tabellen. |
| **Build-Tool** | Maven (`pom.xml`) | Verwaltet Abhängigkeiten und den Build-Prozess. |

### Kritische Funktionalität: Atomare Transaktion

Der Kern des Systems ist die **Transaktionssicherheit** beim Ticketverkauf (`POST /orders`). Um Überbuchungen zu verhindern, wird die gesamte Kauflogik in einem **`@Transactional`**-Block ausgeführt, der eine **Rollback-Garantie** bietet.

---

## 2. Aktueller Status und Meilensteine

Das Projekt hat die gesamte **Setup- und Kompilierungsphase** erfolgreich abgeschlossen. Der Code ist fehlerfrei und die Kommunikation ist hergestellt.

| Bereich | Zustand | Details |
| :--- | :--- | :--- |
| **Systemstart** | **LÄUFT STABIL** | Tomcat läuft auf **`http://localhost:8080`**. Die Datenbankverbindung ist stabil. |
| **Kompilierung** | **ERFOLGREICH** | Alle Kompilierungsfehler (Package-Konflikte, fehlende Getter, etc.) wurden behoben. |
| **Frontend-Integration** | **HERGESTELLT** | Der **CORS-Filter** ist aktiv und ermöglicht die Kommunikation zwischen dem Frontend (`:5500`) und dem Backend (`:8080`). |
| **`GET /events/{id}`** | **FUNKTIONAL** | Der Endpunkt reagiert korrekt mit **`404 Not Found`** bei fehlenden Daten und ist bereit, die **Verfügbarkeit (SUM-Abfrage)** zu liefern. |
| **Datenbank-Setup** | **GESICHERT** | Die Tabellen wurden erstellt und der dedizierte **`app_user`** löst das `Access denied`-Problem. |

---

## 3. Nächster Meilenstein: Transaktionslogik

Der Fokus liegt jetzt auf der Implementierung des **Order-Services**, dem wichtigsten und letzten großen Meilenstein.

### 3.1. ToDo für das Backend-Team

1.  **Repositorys erstellen:** **`BestellungRepository.java`** und **`TicketKategorieRepository.java`** erstellen (falls noch nicht geschehen).
2.  **DTOs erstellen:** **`OrderRequestDto.java`** definieren (für die eingehenden Bestelldaten).
3.  **Controller:** **`OrderController.java`** (`POST /api/v1/orders`) implementieren.
4.  **Service (KRITISCH):** **`OrderService.java`** implementieren. Die Methode `processTicketOrder()` muss die **`@Transactional`**-Annotation verwenden und folgende Schritte in der Logik abdecken:
    * Kapazitäts-Check (`SUM`-Abfrage).
    * **Rollback**, wenn die Kapazität nicht ausreicht.
    * Speicherung der **`Bestellung`** und **`Bestellposition`**.

### 3.2. ToDo für das Frontend-Team

* **API-Client-Anpassung:** Den `POST`-Aufruf zum Endpunkt `/api/v1/orders` mit dem **`OrderRequestDto`** als Body implementieren.
* **Fehlerbehandlung:** Die UI muss auf die Statuscodes **`409 Conflict`** (Kapazität erschöpft) und **`400 Bad Request`** (Datenfehler) reagieren.

---

## 4. Startanleitung und Debugging

### A. Konfiguration (application.properties)

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/event_db
spring.datasource.username=app_user 
spring.datasource.password=ihr_passwort
spring.jpa.hibernate.ddl-auto=update
```

### B. Anwendung starten (Kommando)

`mvnw.cmd spring-boot:run`

### C. Testaufruf (Funktionalität)

- URL: http://localhost:8080/api/v1/events/1  
- Erwartet: HTTP 200 OK mit JSON-Daten (wenn Event 1 existiert) oder 404 Not Found.

---
