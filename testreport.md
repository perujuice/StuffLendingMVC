# Test Report: Member Management

Version: 
Date: 2023-10-09
Environment: MacOS 
Performed by: Murtaza Subhani, Marteinn Hjaltason, Sean Patrick Chukuemeka Dureke

## General

- Clone the application from gitlab into a new directory.
- Run the application with `./gradlew run -q --console=plain`.
- If any issues are encountered during the steps above, document them and proceed with the remaining test cases.

# Stuff Lending System Test Report

## Overview
This test report covers the testing of the Stuff Lending System, including the Member Management, Item Management, Contract Management, and Time Management.

## Table of Contents
1. [Member Management Tests](#member-management-tests)
2. [Item Management Tests](#item-management-tests)
3. [Contract Management Tests](#contract-management-tests)
4. [Time Management Tests](#time-management-tests)


---
## Test Results

| Case  | Result  | Note               |
|-------|---------|--------------------|
| 1.1   | [ok]    |                    |
| 1.2   | [ok]    |                    |
| 1.3   | [ok]    |                    |
| 2.1   | [ok]    |                    |
| 2.2   | [ok]    |                    |
| 2.3   | [ok]    |                    |
| 3.1   | [ok]    |                    |
| 3.2   | [ok]    |                    |
| 3.3   | [ok]    |                    |
| 4.1   | [ok]    |                    |
---------------------------------------

---

## 1. Member Management Tests

### Test Case 1.1: Create Member
- **Description:** Tests the creation of a new member and verifies if it's added successfully.
- **Test Steps:**
  1. Create a new member with valid details.
- **Expected Result:** The member is created and added successfully.

### Test Case 1.2: Delete Member
- **Description:** Tests the deletion of an existing member.
- **Test Steps:**
  1. Create a new member.
  2. Delete the member.
- **Expected Result:** The member was deleted successfully.

### Test Case 1.3: Update Member Information
- **Description:** Tests updating member attributes.
- **Test Steps:**
  1. Create a new member.
  2. Update the member's name and contact information.
- **Expected Result:** Member attributes were updated successfully.

---

## 2. Item Management Tests

### Test Case 2.1: Create Item
- **Description:** Tests the creation of a new item and verifies if it's added successfully.
- **Test Steps:**
  1. Create a member.
  2. Create a new item with valid details.
- **Expected Result:** The item was created and added successfully.

### Test Case 2.2: Delete Item
- **Description:** Tests the deletion of an existing item.
- **Test Steps:**
  1. Create a member.
  2. Create a new item.
  3. Delete the item.
- **Expected Result:** The item was deleted successfully.

### Test Case 2.3: Update Item Information
- **Description:** Tests updating various item attributes.
- **Test Steps:**
  1. Create a member.
  2. Create a new item.
  3. Update the item's name, description, category, and cost per day.
- **Expected Result:** Item attributes were updated successfully.

---

## 3. Contract Management Tests

### Test Case 3.1: Create Contract
- **Description:** Tests the creation of a new lending contract.
- **Test Steps:**
  1. Create a borrower member.
  2. Create a lender member.
  3. Create an item.
  4. Create a contract between the borrower, lender, and item.
- **Expected Result:** The contract was created successfully.

### Test Case 3.2: List All no
- **Description:** Tests listing all contracts in the system.
- **Test Steps:**
  1. Create multiple contracts.
  2. List all contracts.
- **Expected Result:** All contracts were listed correctly.

---

## 4. Time Management Tests

### Test Case 4.1: Advance Time
- **Description:** Tests the advancement of time in the system.
- **Test Steps:**
  1. Advance time by a specified number of days.
- **Expected Result:** The current day was updated correctly.

---

## Conclusion
The Stuff Lending System has been thoroughly tested for its major components, including Member Management, Item Management, Contract Management, and Time Management. All major functionalities have been verified to work as expected.

---
