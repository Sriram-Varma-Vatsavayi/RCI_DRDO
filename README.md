# System Security Audit Tool (RCI DRDO Project)

[![Java](https://img.shields.io/badge/Java-SE%208+-orange.svg)](https://www.oracle.com/java/)
[![Platform](https://img.shields.io/badge/Platform-Windows-blue.svg)](https://www.microsoft.com/windows/)
[![License](https://img.shields.io/badge/License-Open%20Source-green.svg)](#license)

A comprehensive Windows system security auditing tool developed during a one-month internship project at Research Centre Imarat (RCI), Defence Research and Development Organisation (DRDO), Hyderabad. This tool performs automated security assessments by analyzing 15+ critical system parameters to evaluate the security posture of Windows systems.

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [System Parameters Monitored](#system-parameters-monitored)
- [API Reference](#api-reference)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features

### 🔍 **Comprehensive Security Auditing**
- **Antivirus Detection**: Checks for installed antivirus software and their status
- **System Encryption**: Monitors BitLocker encryption status for drives
- **USB Security**: Detects USB storage blocking policies and connected devices
- **Network Security**: Monitors WiFi and Bluetooth connectivity status
- **System Updates**: Tracks Windows OS update history and status
- **License Validation**: Verifies Windows license authenticity

### 🛡️ **System Monitoring**
- **Hardware Inventory**: Lists connected USB devices and drives
- **Software Inventory**: Catalogs installed software applications
- **User Management**: Displays system users and password policies
- **Registry Analysis**: Examines security-related registry entries
- **Unwanted Software Detection**: Identifies potentially unwanted programs (PUPs)

### 📊 **Reporting & Output**
- **Automated Report Generation**: Creates detailed system audit reports
- **File Output**: Saves results to `systemdetails.txt` for documentation
- **Real-time Analysis**: Provides immediate feedback on system status
- **Notepad Integration**: Automatically opens results in Notepad for review

## Installation

### Prerequisites
- **Java SE 8 or higher**
- **Windows Operating System** (7/8/10/11)
- **Administrator privileges** (required for some system checks)
- **PowerShell** (for advanced system queries)

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/RCI_DRDO.git
   cd RCI_DRDO
   ```

2. **Compile the Java files**
   ```bash
   javac *.java
   ```

3. **Run the main system checker**
   ```bash
   java SystemChecker
   ```

## Usage

### Basic System Audit
```bash
# Run comprehensive system audit
java SystemChecker
```

### Individual Component Checks
```bash
# Check antivirus status
java CheckAntiVirus

# Check BitLocker status
java CheckBitLockerStatus

# Check USB storage blocking
java CheckUSBStorageBlockStatus

# Check WiFi status
java CheckWiFiStatus

# Check Bluetooth status
java CheckBluetoothStatus
```

### Advanced Usage
```bash
# Run IT audit with update information
java ITAudit

# Detect unwanted software
java UnwantedSoftwareDetector

# List installed software
java InstalledSoftwareList

# Count USB drives
java USBDriveCount
```

## System Parameters Monitored

| Parameter | Description | Class |
|-----------|-------------|--------|
| **Antivirus Status** | Checks for installed antivirus software and protection status | `CheckAntiVirus.java` |
| **Windows License** | Validates Windows operating system licensing | `WindowsOSLicenseCheck.java` |
| **BitLocker Encryption** | Monitors drive encryption status (C: and D: drives) | `CheckBitLockerStatus.java` |
| **USB Storage Policy** | Checks if USB storage devices are blocked via registry | `CheckUSBStorageBlockStatus.java` |
| **WiFi Connectivity** | Monitors wireless network adapter status | `CheckWiFiStatus.java` |
| **Bluetooth Status** | Checks Bluetooth service and connectivity | `CheckBluetoothStatus.java` |
| **USB Device Inventory** | Lists all connected USB devices and drives | `USBDevices.java`, `USBDriveCount.java` |
| **System Updates** | Tracks Windows update history and latest patches | `LastOSUpdate.java`, `SystemUpdateInfo.java` |
| **Installed Software** | Catalogs all installed applications | `InstalledSoftwareList.java` |
| **User Accounts** | Lists system users and password policies | `Users.java` |
| **Unwanted Software** | Detects potentially unwanted programs (toolbars, adware) | `UnwantedSoftwareDetector.java` |
| **AutoPlay Settings** | Checks AutoPlay configuration for removable media | `CheckAutoPlay.java` |
| **Registry Security** | Analyzes security-related registry entries | `RegistryAccess.java` |
| **File System Analysis** | Counts and analyzes file types and locations | `FileCounter.java`, `FileFinder.java` |
| **Batch File Detection** | Identifies potentially malicious batch files | `BatchFileFinder.java` |

## API Reference

### Core Classes

#### `SystemChecker`
Main orchestration class that performs comprehensive system auditing.

```java
// Check if antivirus is installed
public static boolean isAntivirusInstalled()

// Verify Windows license status
public static boolean isWindowsLicensed()

// Count connected USB drives
public static int countConnectedUSBDrives()

// Get last OS update information
public static String getLastOSUpdateDate()

// Check if USB storage is blocked
public static boolean isUSBStorageBlocked()

// Check Bluetooth status
public static boolean isBluetoothEnabled()

// Check WiFi status
public static boolean isWiFiEnabled()

// Check BitLocker encryption status
public static boolean isBitLockerEnabled()
```

#### `ExecuteSystemCommand`
Utility class for executing Windows system commands and PowerShell scripts.

```java
// Execute system command and return output
private static String executeCommand(String command)
```

### Security Features

All system checks are performed using standard Windows APIs and commands:
- **WMI (Windows Management Instrumentation)** for hardware and software inventory
- **PowerShell cmdlets** for advanced system queries
- **Registry queries** for security policy verification
- **Windows command-line tools** for system status checks

## Dependencies

This project uses only **Java Standard Edition** libraries and Windows built-in tools:

### Java Dependencies
- `java.io.*` - File I/O operations
- `java.util.*` - Collections and utilities
- `java.lang.*` - Process execution

### System Dependencies
- **Windows Management Instrumentation (WMI)**
- **PowerShell 3.0+**
- **Windows Registry**
- **Command Prompt utilities** (`reg`, `wmic`, `netsh`, `manage-bde`)

### No External Libraries Required
This tool is designed to run on any Windows system with Java installed, without requiring additional dependencies or installations.

## Contributing

We welcome contributions to improve the system audit capabilities! Here's how you can help:

### Development Guidelines
1. **Fork the repository**
2. **Create a feature branch** (`git checkout -b feature/new-audit-check`)
3. **Follow Java coding conventions**
4. **Add comprehensive documentation**
5. **Test on multiple Windows versions**
6. **Submit a pull request**

### Areas for Contribution
- **Additional security checks** (firewall status, Windows Defender settings)
- **Enhanced reporting formats** (JSON, XML, HTML output)
- **GUI interface** for non-technical users
- **Configuration file support**
- **Scheduled auditing capabilities**
- **Integration with enterprise security tools**

### Code Style
- Use descriptive variable and method names
- Include JavaDoc comments for public methods
- Handle exceptions gracefully
- Follow existing naming conventions

## License

This project is open source and available under the [MIT License](LICENSE).

```
MIT License

Copyright (c) 2024 RCI DRDO System Audit Tool

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
```

## Contact

This project was developed as part of an internship at:

**Research Centre Imarat (RCI)**  
Defence Research and Development Organisation (DRDO)  
Hyderabad, India

### Support
- **Issues**: Report bugs and feature requests via [GitHub Issues](https://github.com/yourusername/RCI_DRDO/issues)
- **Documentation**: Comprehensive documentation available in source code comments
- **Community**: Join discussions in the repository discussions section

### Acknowledgments
- Research Centre Imarat (RCI), DRDO for providing the internship opportunity
- The cybersecurity team for guidance and requirements definition
- Open source community for Java development resources

---

**⚠️ Security Notice**: This tool is designed for legitimate system administration and security auditing purposes. Always ensure you have proper authorization before running system audits on any machine. The tool requires administrator privileges for comprehensive system analysis.
