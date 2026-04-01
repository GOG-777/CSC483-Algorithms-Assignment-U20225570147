<div align="center">
  <h1>🚀 CSC 483 - Algorithms Analysis and Design</h1>
  <p><strong>University of Port Harcourt</strong> • Faculty of Computing • 2025/2026</p>
  
  <img src="https://img.shields.io/badge/Java-17%2B-007396?style=for-the-badge&logo=java&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Maven-3.9%2B-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white" alt="JUnit">
  <img src="https://img.shields.io/badge/Arch%20Linux-EndeavourOS-1793D1?style=for-the-badge&logo=archlinux&logoColor=white" alt="Linux">
</div>

---

# CSC483 Algorithms Analysis and Design Assignment

**University of Port Harcourt**  
**Department of Computer Science**  
**Course:** CSC 483.1 – Algorithms Analysis and Design  
**Session:** 2025/2026 | First Semester  
**Student ID:** U20225570147  
**Submission Date:** April 5, 2026  

---

## 📋 Project Overview

Complete implementation of the CSC 483 assignment covering:
- **Question 1**: Online Store Search Optimization (Sequential, Binary, and Hybrid search with performance analysis)
- **Question 2**: Algorithm Analysis, Empirical Benchmarking, and Decision Tree

**Technologies used:**
- Java 17+
- Maven 3.9+
- JUnit 5
- Arch Linux (Endeavour OS)

---

## 🚀 How to Build and Run

```bash
# Clone the repository
git clone https://github.com/GOG-777/CSC483-Algorithms-Assignment-U20225570147.git

# Build and run Question 1 (TechMart Search)
mvn clean compile
mvn exec:java -Dexec.mainClass="com.csc483.assignment.TechMartSearchTest"

# Run Question 2 (Sorting Benchmarks)
mvn exec:java -Dexec.mainClass="com.csc483.assignment2.sorting.SortingBenchmark"

# Run all JUnit tests
mvn test
```

## 📁 Project Structure

```bash
.
├── pom.xml
├── README.md
├── screenshots/
│   ├── decision-tree.png
│   ├── junit-tests.png
│   ├── nearly sorted, many duplicates data sorting.png
│   ├── performance-table.png
│   ├── Q2-algorithm-comparison-part1.png
│   ├── Q2-algorithm-comparison-part2.png
│   ├── Q2-algorithm-comparison-part3.png
│   └── Random, sorted, reverse data sorting.png
├── src/
│   ├── main/java/com/csc483/
│   │   ├── assignment/           # Question 1
│   │   └── assignment2/sorting/  # Question 2
│   └── test/java/com/csc483/assignment/
└── target/                       # ignored by .gitignore
```

## 📸 Screenshots
All program outputs and benchmark results are available in the screenshots/ folder:

- Question 1: Performance comparison table and JUnit results

- Question 2: Full sorting benchmark tables (random, nearly-sorted, etc.)

## ✅ Features Implemented
Fully commented, production-style Java code

JUnit 5 tests with edge cases

Realistic 100,000-product dataset generation

Hybrid search with O(log n) ID + O(1) name lookup

Complete sorting benchmarks with comparison/swaps counters

Algorithm decision tree (Part D)



Made with care for CSC 483.1 @ University of Port Harcourt
Last updated: April 1, 2026.