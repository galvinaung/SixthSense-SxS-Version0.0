# SixthSense (SxS)

## Version 0.0 Proof of Concept (PoC)

## Project Information

**Project Name:** SixthSense
**Short Name:** SxS
**Version:** 0.0
**Status:** Proof of Concept (PoC)
**Platform:** Windows Only
**Language:** Java
**UI Framework:** JavaFX
**Database:** SQLite

---

# 1. Overview

SixthSense (SxS) is a device awareness and security monitoring concept.

The purpose of SixthSense is to act like a user's "sixth sense" by recording awareness information when a registered device is used.

Version 0.0 is a small Proof of Concept designed to prove the core idea:

> A lightweight Windows desktop application can identify the current device, record activity information, and display previous activity history.

---

# 2. Vision

Future versions of SixthSense will become a cross-platform security awareness system supporting:

* Windows
* Android
* Linux
* macOS
* iPhone

Future capabilities may include:

* Cloud synchronization
* Push notifications
* Multiple device monitoring
* AI-based security analysis
* Enterprise management

However, Version 0.0 focuses only on the foundation.

---

# 3. Problem Statement

People often leave personal computers in locations such as:

* Home
* School
* Office
* Library
* Hotel
* Dormitory

If someone accesses the computer, the owner may not immediately know.

SixthSense explores the idea of creating awareness when a device is used.

---

# 4. Version 0.0 Goal

The goal of Version 0.0 is:

> Build the smallest working application that demonstrates device activity awareness.

The application should:

* Detect the current Windows computer
* Detect the current Windows user
* Record application activity
* Store records locally
* Display activity history

---

# 5. Scope

## Supported

* Windows 10
* Windows 11

## Not Supported

* Android
* Linux
* macOS
* iOS
* Web
* Cloud services

---

# 6. Features

## Feature 1: Device Information Detection

The application displays:

* Computer name
* Windows username
* Operating system
* Current date
* Current time

---

## Feature 2: Activity Recording

When SixthSense starts, it creates a local activity record.

Recorded information:

* Date
* Time
* Computer name
* Username

---

## Feature 3: Local Database Storage

Activity records are stored locally using SQLite.

Database table:

History

Fields:

* ID
* Date
* Time
* ComputerName
* Username

---

## Feature 4: History Viewer

Users can view previous activity records.

Example:

```
18 July 2026
09:30
DESKTOP-HOME
Kaung
```

---

## Feature 5: Simple JavaFX Interface

The interface is intentionally simple.

No:

* Animation
* Dashboard
* Charts
* Cloud UI

Only essential information is displayed.

---

# 7. Features Excluded From Version 0.0

The following features are planned for future versions:

* User accounts
* Cloud server
* Android application
* Push notification
* GPS location
* Webcam capture
* Screenshot capture
* Remote lock
* AI analysis
* Multi-user support

---

# 8. Technology Stack

| Component            | Technology         |
| -------------------- | ------------------ |
| Programming Language | Java 21 LTS        |
| UI                   | JavaFX             |
| Database             | SQLite             |
| IDE                  | Visual Studio Code |
| Version Control      | Git + GitHub       |

---

# 9. Success Criteria

Version 0.0 is complete when:

* Application starts successfully
* Device information is displayed
* Activity records are saved
* History can be viewed
* Application runs without crashing

---

# 10. Future Roadmap

## Version 1.0

* Windows + Android
* Cloud API
* Push notifications
* Spring Boot backend

## Version 2.0

* Linux support

## Version 3.0

* macOS support

## Version 4.0

* Multi-device ecosystem


