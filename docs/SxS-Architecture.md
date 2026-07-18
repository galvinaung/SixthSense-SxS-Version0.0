# SixthSense (SxS)

## Version 0.0 Architecture Documentation

# 1. Architecture Overview

Version 0.0 uses a simple local desktop architecture.

No Internet communication is used.

All information remains on the local Windows computer.

```
+-----------------------+
|   SixthSense App      |
|      JavaFX UI        |
+-----------+-----------+
            |
            |
+-----------v-----------+
|    Service Layer       |
| System Information    |
| Activity Recording    |
+-----------+-----------+
            |
            |
+-----------v-----------+
|     Database Layer    |
|       SQLite          |
+-----------------------+
```

---

# 2. Application Flow

```
Application Start

        |
        v

Read Windows Information

        |
        v

Collect:
- Computer Name
- Username
- OS Information
- Date
- Time

        |
        v

Create Activity Record

        |
        v

Save Record to SQLite

        |
        v

Display Main Screen

        |
        v

User Opens History

```

---

# 3. Project Structure

```
SixthSense-SxS-Version0.0

src/
└── main/
    ├── java/
    │   └── com/
    │       └── sixthsense/
    │
    └── resources/

docs/

database/

screenshots/
```

---

# 4. Software Layers

## UI Layer

Technology:

JavaFX

Responsibility:

* Display information
* Receive user actions
* Show history

Example:

```
Main Screen
History Screen
```

---

## Service Layer

Responsibility:

Process application logic.

Examples:

* Read system information
* Create activity records
* Manage history data

Possible classes:

```
SystemInfoService
HistoryService
```

---

## Database Layer

Technology:

SQLite

Responsibility:

Store local activity records.

Database:

```
History Table
```

Structure:

| Field        | Type    |
| ------------ | ------- |
| ID           | Integer |
| Date         | Text    |
| Time         | Text    |
| ComputerName | Text    |
| Username     | Text    |

---

# 5. Security Design

Version 0.0:

* No cloud communication
* No user account
* No password system
* No remote access

All data remains locally stored.

---

# 6. Development Principles

The project follows:

* Simple design
* Clean code
* Small classes
* Feature-by-feature development
* Frequent Git commits
* Maintainable architecture

---

# 7. Future Architecture Expansion

Future versions will introduce:

```
Android App

      |

Cloud API

      |

Spring Boot Server

      |

Database

      |

Windows Client
```

Future components:

* Authentication
* JWT security
* Push notifications
* Multi-device management
* AI risk analysis

---

# 8. Version 0.0 Philosophy

Version 0.0 is not a commercial product.

It is a technical foundation proving that the SixthSense concept works and show in interview as porfolio

The priority is:

1. Stability
2. Clean architecture
3. Working prototype
4. Future scalability
