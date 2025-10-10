# 🎫 Event-Ticketing-Plattform API

Dies ist das Backend der Event-Ticketing-Plattform, entwickelt als Teil eines Umschulungsprojekts. Die API dient als zentrale Geschäftslogik für die Verwaltung von Veranstaltungen, Ticketkontingenten und dem sicheren Bestellprozess.

---

**🚀 Technologie-Stack**

| Komponente | Technologie | Zweck |
| :--- | :--- | :--- |
| **Programmiersprache** | Java 21 (LTS) | Die primäre Sprache für die Backend-Logik. |
| **Framework** | Spring Boot 3 | Bietet das Gerüst für die REST-API und Dependency Injection. |
| **ORM** | Spring Data JPA / Hibernate | Stellt die Verbindung zum Datenmodell her und verwaltet die MariaDB-Sitzungen. |
| **Datenbank** | MariaDB 10.x | Relationales Datenbanksystem (über XAMPP) für hohe Transaktionssicherheit (ACID). |
| **Build-Tool** | Maven (`pom.xml`) | Verwaltet Abhängigkeiten und kompiliert das Projekt. |

---

**🗃️ Datenmodell (ERM/RDM)**

Das Datenmodell ist in der dritten Normalform gehalten, um die kritische Integrität der Ticketkontingente zu gewährleisten.

**Kritische Entitäten:**

* **`Event`:** Kerninformationen zur Veranstaltung.
* **`TicketKategorie`:** Definiert die **`kontingent_max`** (maximale Kapazität) und den **Preis**.
* **`Bestellung` & `Bestellposition`:** Verwalten den Kaufprozess und speichern die tatsächlich verkauften Mengen, die für die **atomare Kapazitätsprüfung** verwendet werden.

---

**🛠️ Einrichten und Starten der Entwicklungsumgebung**

Um das Backend lokal zu starten und zu entwickeln, folgen Sie diesen Schritten:

### 1. MariaDB einrichten


1.  **XAMPP starten:** Öffnen Sie das XAMPP Control Panel und starten Sie das Modul **"MySQL"** (MariaDB).
2.  **Datenbank erstellen:** Melden Sie sich über phpMyAdmin (oder PowerShell) an und erstellen Sie die Datenbank, die in der `application.properties` konfiguriert ist.

    ```sql
    CREATE DATABASE IF NOT EXISTS event_db;
    ```

3.  **Benutzer anlegen:** Falls die `root` Anmeldung fehlschlägt, aus Sicherheitsgründen, legt ein Benutzer an.

    ```sql
    CREATE USER 'app_user'@'localhost' IDENTIFIED BY 'ihr_passwort';
    GRANT ALL PRIVILEGES ON event_db.* TO 'app_user'@'localhost';
    FLUSH PRIVILEGES;
    ```

### 2. Konfiguration (application.properties)

    Passen Sie die Zugangsdaten in `src/main/resources/application.properties` an:

    ´´´properties
    spring.datasource.url=jdbc:mariadb://localhost:3306/event_db
    spring.datasource.username=app_user 
    spring.datasource.password=ihr_passwort
    spring.jpa.hibernate.ddl-auto=update  # Erstellt/aktualisiert die Tabellen beim Start

### 3. Anwendung starten

    .\mvnw.cmd spring-boot:run


