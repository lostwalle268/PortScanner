# PortScanner

A minimal single-file Java TCP port scanner that attempts connections to a range of ports on a target host and reports which ports are open.

This repository contains:
- [PortScanner.java](PortScanner.java) — main scanner implementation (`PortScanner` class).

What it does
- Iterates a configurable port range and tries to open a TCP `Socket` to each port on the target host.
- Prints a table with Port, Status (OPEN), and a guessed service name for a set of well-known ports.
- Uses ANSI color codes for colored console output (green for open ports) when the terminal supports them.

How it works
- The scanner creates a `Socket` to `host:port`. If connect succeeds the port is reported as OPEN; failures are ignored by default.
- See the implementation in [`PortScanner`](PortScanner.java).

Installation and usage

Prerequisites
- Java JDK 8+ installed and on your PATH.

Build (compile)
- Open a terminal in the project directory (where [PortScanner.java](PortScanner.java) is located).

PowerShell / Windows:
```powershell
javac [PortScanner.java](http://_vscodecontentref_/3)
```