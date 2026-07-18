SixthSense (SxS)
Smart Cross-Platform Device Security & Awareness System

SixthSense (SxS) Master Project Documentation
Purpose
This document summarizes the SixthSense (SxS) concept so another AI or developer can understand the project and continue development.


Vision
SixthSense (SxS) is a cross-platform device awareness and security system. Its goal is to notify the owner when registered devices are used and provide activity history.
Roadmap
v0.0: Windows-only Proof of Concept. One owner, two Windows devices (home PC and laptop), no accounts, no cloud, no server, local history, simple text UI.
v1.0: Windows + Android, push notifications, device pairing, cloud/server.
v2.0: Add Linux support.
v3.0: Add macOS support.
v4.0: Multi-device ecosystem.

v0.0 Scope
Java + JavaFX desktop application.
Display computer name, Windows username, date/time.
Save session/login records locally (SQLite or text file).
History screen.
Very simple UI.
Designed as a personal prototype.
Technology
Java 21, JavaFX, SQLite, Git/GitHub. Spring Boot will introduce  in v1.0.
Development Flow
Create project
Build UI
Read Windows information
Save local history
Test
Package as EXE/JAR


1. Project Overview
Product Name: SixthSense
Brand Logo: S×S
Short Name: SxS
Category:
 Cybersecurity • Device Monitoring • Cross-Platform Security
Platform
Windows

(Future)
Android
macOS
Linux
iPhone (iOS)

2. Vision
Create a personal security system that acts as a user’s “sixth sense,” instantly informing them whenever their computer or phone is used—even when they are far away.
Example:
The owner leaves home for school or work.
Someone turns on the owner’s laptop and successfully logs in.
Within seconds, SixthSense sends a secure notification to the owner’s phone.
The owner immediately knows:
Which device was accessed
When it happened
Where it happened (best effort)
Who logged in (Windows account)
Network information
Device status

3. Problem Statement
People often leave laptops at:
Home
School
Office
Library
Hotel
Dormitory
If someone accesses the device, the owner usually has no immediate way of knowing.
Current solutions mainly focus on:
Device tracking
Remote desktop
Anti-theft
Few solutions focus on real-time login awareness across personal devices.

4. Main Goal
Provide real-time awareness whenever any registered device is used.

5. Target Users
Students
Office workers
Developers
IT professionals
Families
Small businesses

6. Core Features
Device Registration
Register multiple devices under one account.
Examples
Laptop
Desktop
Android phone

Login Detection
Detect successful logins.
Record
Date
Time
Username
Device name
Operating System

Instant Notification
Send a push notification to the owner’s Android device.
Example
SxS Alert
Laptop Login Detected
Time
 10:35 AM

Device Status
Display
Online / Offline
Battery
Network
Last Active
Last Login

Login History
Maintain a complete activity log.
Example
09:10 Login
09:45 Logout
13:22 Login

Device Location
Android
GPS
Windows
Approximate location using available network information

Wi-Fi Information
Display
Wi-Fi SSID
Public IP Address

Multi-Device Dashboard
Monitor
Laptop
Desktop
Phone
From one application.

Cross Notification
Phone unlocked
↓
Laptop receives notification.
Laptop logged in
↓
Phone receives notification.

7. Premium Security Features
Failed login detection
Webcam capture (owner-enabled only)
Desktop screenshot (owner-enabled only)
Remote lock
Remote logout
Remote alarm
Custom warning message
Device finder
Login history cloud backup

8. AI Features (Future)
AI can detect:
Login at unusual times
Unknown Wi-Fi
Unknown location
Suspicious travel pattern
Multiple failed login attempts
Risk levels
Low
Medium
High
Critical

9. Architecture
Android App
↓
Cloud API
↓
Spring Boot Server
↓
Database
↓
Windows Client

10. Suggested Technology
Windows
Java
JavaFX
Windows Service
Android
Kotlin
Backend
Spring Boot
Database
MySQL
Authentication
JWT
Notification
Firebase Cloud Messaging (FCM)
Communication
HTTPS REST API
WebSocket (live updates)

11. Database Design
Users
User ID
Name
Email
Password Hash
Devices
Device ID
User ID
Device Name
Platform
Login History
Login ID
Login Time
Logout Time
IP Address
Wi-Fi
Location
Notifications
Notification ID
Status
Time

12. Security
HTTPS encryption
JWT authentication
Password hashing
Secure API access
Device verification
Notification encryption
Session management

13. User Flow
Install SixthSense
↓
Create Account
↓
Register Device
↓
Link Phone and Laptop
↓
Background monitoring starts
↓
Login detected
↓
Cloud receives event
↓
Push notification sent
↓
Owner views details
↓
Owner may remotely respond (if enabled)

14. Example Notification
SxS Alert
Laptop Login Detected
Device
HOME-LAPTOP
User
Kaung
Time
10:35 AM
Location
Approximate Home
Battery
82%

15. Possible Future Features
Smartwatch support
Browser extension
macOS support
Linux support
iPhone support
Enterprise dashboard
Family sharing
Team monitoring
Security reports
AI risk scoring
Biometric login analytics

16. Business Model
Free
Device monitoring
Login alerts
Activity history
Basic dashboard
Premium
Webcam snapshots
Screenshot capture
Remote lock/logout
Cloud history
AI security alerts
Unlimited devices
Priority support

17. Project Scope
This project combines:
Desktop Application Development
Android Development
Backend API Development
Database Design
Authentication
Networking
Push Notifications
Cybersecurity Concepts
Cloud Computing
System Architecture
Real-Time Communication

18. Notes
This is a conceptual software design. Some features—such as webcam snapshots, screenshots, remote actions, or login monitoring—require explicit user permission, appropriate operating system privileges, and compliance with privacy laws and platform policies. The software should only monitor devices that the user owns or is authorized to manage.




