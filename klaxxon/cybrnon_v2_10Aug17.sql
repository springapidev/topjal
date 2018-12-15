-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 10, 2017 at 01:11 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cybrnon_v2`
--

-- --------------------------------------------------------

--
-- Table structure for table `armstypes`
--

CREATE TABLE `armstypes` (
  `ARMSTypeID` int(11) NOT NULL,
  `ARMSType` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `armstypes`
--

INSERT INTO `armstypes` (`ARMSTypeID`, `ARMSType`) VALUES
(1, 'Avoid'),
(2, 'Retain'),
(3, 'Modify'),
(4, 'Share');

-- --------------------------------------------------------

--
-- Table structure for table `categorytypes`
--

CREATE TABLE `categorytypes` (
  `CategoryTypeID` int(11) NOT NULL,
  `CategoryType` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `companies`
--

CREATE TABLE `companies` (
  `CompanyID` int(11) NOT NULL,
  `CompanyName` varchar(255) NOT NULL,
  `CompanyAddress` varchar(255) DEFAULT NULL,
  `CompanyCity` varchar(255) DEFAULT NULL,
  `CompanyPhone` varchar(255) DEFAULT NULL,
  `CompanyEmail` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `companies`
--

INSERT INTO `companies` (`CompanyID`, `CompanyName`, `CompanyAddress`, `CompanyCity`, `CompanyPhone`, `CompanyEmail`) VALUES
(5, 'Lulu Elearning', '5 Deena Court', 'Brisbane', '32465464', 'info@dhis.co'),
(6, 'Cybrnon', '123 fake street', 'Adelaide', '82170101', 'info@cobitism.com.au'),
(8, 'Telstra', '15789', 'Sydney', '03 3877 4586', 'yuii@test.com'),
(14, 'Tanzo', '123 fake street', 'Aberquerqu', '08 8552 5544', 'info@tanzo.com'),
(18, 'Lead Laundry', '10 downing street', 'Brisbane', '0425 225 165', 'Adam@leadlaundry.com'),
(19, 'Fightclub', '123 fightclub', 'fightclub', 'n/a', 'fight@fightclub.com'),
(21, 'Yuki Corp', '123a Alpha St', 'New York', '055546546', 'yuki@corp.net'),
(22, 'Rontech', '123 Bangalore Rd', 'Bangalore', '+910229983883', 'ron@rontech.com'),
(23, 'Ishikawa', '15 Gourger Street', 'Adelaide', '75444', 'information@Ishikawa.com.au'),
(24, 'NTT Docomo', '34 Ichikawa', 'Tokyo', '03187878', 'information@ntt.co.jp'),
(25, 'Iran Nuclear Facility', '123 Nuke street', 'Iran', '7455881154', 'INF@iran.com');

-- --------------------------------------------------------

--
-- Table structure for table `contacts`
--

CREATE TABLE `contacts` (
  `ContactID` int(11) NOT NULL,
  `ContactName` varchar(255) DEFAULT NULL,
  `ContactPhone` int(11) DEFAULT '0',
  `ContactEmail` varchar(255) DEFAULT NULL,
  `DepartmentID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contacts`
--

INSERT INTO `contacts` (`ContactID`, `ContactName`, `ContactPhone`, `ContactEmail`, `DepartmentID`) VALUES
(1, 'Barry Smith', 82268111, 'barrysmith@dfg.com.au', 1),
(2, 'Nina', 2147483647, 'nina@dfg.com.au', 2),
(3, 'Tom', 0, 'Tom@dgf.com.au', 3),
(4, 'Teena', 41114777, 'Teena@cybernon.com.au', 4),
(5, 'Lisa', 0, 'Lisa@google.com.au', 5),
(6, 'Michelle', 0, 'Michelle@cybernon.com.au', 6),
(7, 'Kei Nishikori', 0, 'Kei@test.com.au', 9),
(8, 'Joe Barnes', 0, 'Joe@tutuito.com', 7),
(9, 'Lucy Bell', 0, 'lucybell@test.com.au', 10),
(10, 'rrrr', 8888, 'rtrtr@vvvvcom.au', 11),
(11, 'Tottori', 1223, '1112@vv.com', 12),
(12, 'Tom Hart', 7848458, 'tomH@dfg.com.au', 13),
(13, 'Elanour Cook', 12454545, 'Elanour@lulu.com.au', 14),
(14, 'Michael Smith', 8844888, 'maichael@telstra.com.au', 15),
(15, 'Brito', 14444444, 'brito@telstra.com.au', 16),
(16, 'Tom Tadarovski', 45457878, 'Tom@cybrnon.com.au', 27),
(17, 'Tina Smith', 45457777, 'tina@tanzo.com.au', 25),
(18, 'Gina', 48753859, 'gina@cybrnon.com.au', 27),
(19, 'Ralph Langner', 1552244540, 'Ralph.Langner@inc.com', 29);

-- --------------------------------------------------------

--
-- Table structure for table `csfentry`
--

CREATE TABLE `csfentry` (
  `CSFEntryID` int(11) NOT NULL,
  `VBFEntryID` int(11) NOT NULL,
  `CSFTypeID` int(11) NOT NULL,
  `ProcessTypeID` int(11) NOT NULL,
  `ServiceTypeID` int(11) NOT NULL,
  `ImpactTypeID` int(11) NOT NULL,
  `RiskImpactTypeID` int(11) NOT NULL,
  `LifeCycleID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `csfentry`
--

INSERT INTO `csfentry` (`CSFEntryID`, `VBFEntryID`, `CSFTypeID`, `ProcessTypeID`, `ServiceTypeID`, `ImpactTypeID`, `RiskImpactTypeID`, `LifeCycleID`) VALUES
(1, 2, 6, 4, 1, 4, 5, 6),
(2, 8, 43, 3, 2, 5, 5, 6),
(3, 8, 6, 2, 2, 3, 3, 5),
(4, 9, 24, 3, 1, 5, 5, 1),
(5, 9, 18, 2, 2, 4, 4, 5),
(6, 9, 50, 2, 2, 2, 2, 1),
(7, 2, 8, 1, 1, 5, 5, 5),
(8, 3, 8, 1, 1, 5, 5, 5),
(9, 22, 54, 2, 1, 5, 5, 2),
(10, 18, 52, 1, 1, 5, 5, 2),
(11, 22, 8, 1, 1, 5, 5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `csftypes`
--

CREATE TABLE `csftypes` (
  `CSFTypeID` int(11) NOT NULL,
  `CSFType` varchar(255) NOT NULL,
  `ProcessTypeID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `csftypes`
--

INSERT INTO `csftypes` (`CSFTypeID`, `CSFType`, `ProcessTypeID`) VALUES
(1, 'Skills and Knowledge', 4),
(2, 'Training', 4),
(3, 'Incident Management', 3),
(4, 'Problem Management', 1),
(5, 'Change Management', 3),
(6, 'Asset/Configuration Management', 3),
(7, 'Release & Deployment Management', 3),
(8, 'Access Management', 3),
(9, 'Capacity Management', 3),
(10, 'Availability Management', 3),
(11, 'Information Security Management', 3),
(12, 'Demand Management', 3),
(13, 'Financial Management', 3),
(14, 'Service Catalogue Management', 3),
(15, 'IT Service Continuity Management', 3),
(16, 'E-Learning Portal', 2),
(17, 'Payment Gateway', 2),
(18, 'Database', 2),
(19, 'Content Management System (CMS)', 2),
(20, 'Electricity/Power Supply', 2),
(21, 'Customer Relation Management (CRM)', 2),
(22, 'Systems, Applications & Products (SAP)', 2),
(23, 'Service Desk', 4),
(24, 'Accounts', 1),
(25, 'Payroll', 4),
(26, 'Information Security Team', 4),
(27, 'Human Resource Security', 4),
(28, 'Application Management', 3),
(29, 'Technical Management', 3),
(30, 'IT Operations Management', 3),
(31, 'Hewlett Packard 日本語', 1),
(32, 'Dell', 1),
(33, 'Apple', 1),
(34, 'IBM', 1),
(35, 'Microsoft', 1),
(36, 'Utilities - Power', 1),
(37, 'Utilities - Water', 1),
(38, 'Utilities - Gas', 1),
(39, 'Facilities Management (Partner)', 1),
(40, 'Material/Product Supplier', 2),
(41, 'TELSTRA', 1),
(42, 'database external', 1),
(43, 'Supplier Management', 3),
(44, 'Transition planning and Support', 3),
(45, 'Document Management', 2),
(46, 'Information Retention', 3),
(47, 'Information Disposal', 3),
(48, 'Change Evaluation', 3),
(49, 'Service Validation & Testing', 3),
(50, 'Knowlege Management', 3),
(51, 'Microsoft windows', 2),
(52, 'Centrifuge', 2),
(53, 'Siemens PCS 7', 2),
(54, 'WinCC', 2),
(55, 'STEP7 industrial software applications', 2);

-- --------------------------------------------------------

--
-- Table structure for table `departmentcontacts`
--

CREATE TABLE `departmentcontacts` (
  `ContactID` int(11) NOT NULL,
  `DepartmentID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `departmentcontacts`
--

INSERT INTO `departmentcontacts` (`ContactID`, `DepartmentID`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(6, 6),
(8, 8),
(10, 10),
(11, 11),
(12, 5);

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

CREATE TABLE `departments` (
  `DepartmentID` int(11) NOT NULL,
  `DepartmentName` varchar(255) DEFAULT NULL,
  `CompanyID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`DepartmentID`, `DepartmentName`, `CompanyID`) VALUES
(1, 'Human resources', 6),
(2, 'Accounting', 5),
(3, 'Production', 5),
(4, 'Data base', 6),
(5, 'Human resources', 8),
(6, 'IT\r\nIT', 6),
(7, 'Accounting', 8),
(8, 'tutuito', 6),
(9, 'IT', 8),
(10, 'Sales', 6),
(11, 'Yonago', 6),
(12, 'Yonago', 19),
(13, 'Sales', 23),
(14, 'Human resouces', 23),
(15, 'Human resources', 22),
(16, 'Accounting', 14),
(17, 'Accounting', 24),
(18, 'Elearning', 21),
(19, 'Accounting', 24),
(20, 'Accounting', 18),
(21, 'Human Resources', 18),
(22, 'Sales', 14),
(23, 'Sales', 14),
(24, 'Sales', 14),
(25, 'seees', 14),
(26, 'reee', 21),
(27, 'Elearning', 6),
(28, 'Accounting', 6),
(29, 'Natanz nuclear facilities', 25);

-- --------------------------------------------------------

--
-- Table structure for table `impacttypes`
--

CREATE TABLE `impacttypes` (
  `ImpactTypeID` int(11) NOT NULL,
  `Impact` varchar(255) NOT NULL,
  `Weight` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `impacttypes`
--

INSERT INTO `impacttypes` (`ImpactTypeID`, `Impact`, `Weight`) VALUES
(1, 'Low', 2),
(2, 'Low - Medium', 4),
(3, 'Medium', 6),
(4, 'Medium - High', 8),
(5, 'High', 10);

-- --------------------------------------------------------

--
-- Table structure for table `kpis`
--

CREATE TABLE `kpis` (
  `KPIID` int(11) NOT NULL,
  `CategoryTypeID` int(11) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Priority` varchar(255) DEFAULT NULL,
  `CSFEntryID` int(11) NOT NULL,
  `DepartmentID` int(11) NOT NULL,
  `ContactID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `lifecycles`
--

CREATE TABLE `lifecycles` (
  `LifeCycleID` int(11) NOT NULL,
  `LifeCycle` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lifecycles`
--

INSERT INTO `lifecycles` (`LifeCycleID`, `LifeCycle`) VALUES
(1, 'Design'),
(2, 'Operation'),
(3, 'Strategy'),
(4, 'Transition'),
(5, 'Continual improvement'),
(6, 'Not yet identified');

-- --------------------------------------------------------

--
-- Table structure for table `processtypes`
--

CREATE TABLE `processtypes` (
  `ProcessTypeID` int(11) NOT NULL,
  `ProcessType` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `processtypes`
--

INSERT INTO `processtypes` (`ProcessTypeID`, `ProcessType`) VALUES
(1, 'Partner'),
(2, 'Product'),
(3, 'Process'),
(4, 'People');

-- --------------------------------------------------------

--
-- Table structure for table `processtypestakeholdertypes`
--

CREATE TABLE `processtypestakeholdertypes` (
  `ProcessTypeID` int(11) NOT NULL,
  `StakeholderTypeID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rateoccurences`
--

CREATE TABLE `rateoccurences` (
  `RateOccurenceID` int(11) NOT NULL,
  `Occurence` varchar(255) NOT NULL,
  `Rate` double DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rateoccurences`
--

INSERT INTO `rateoccurences` (`RateOccurenceID`, `Occurence`, `Rate`) VALUES
(1, 'Daily', 10),
(2, 'Weekly', 1.42428),
(3, 'Monthly', 0.3287),
(4, 'Yearly', 0.027397);

-- --------------------------------------------------------

--
-- Table structure for table `reviewperiods`
--

CREATE TABLE `reviewperiods` (
  `ReviewPeriodID` int(11) NOT NULL,
  `ReviewPeriod` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reviewperiods`
--

INSERT INTO `reviewperiods` (`ReviewPeriodID`, `ReviewPeriod`) VALUES
(1, 'Daily'),
(2, 'Weekly'),
(3, 'Monthly'),
(4, 'Yearly');

-- --------------------------------------------------------

--
-- Table structure for table `riskentry`
--

CREATE TABLE `riskentry` (
  `RiskEntryID` int(11) NOT NULL,
  `CSFEntryID` int(11) NOT NULL,
  `RiskName` varchar(255) DEFAULT NULL,
  `RiskTreatment` varchar(255) DEFAULT NULL,
  `ImplementationCost` double DEFAULT '0',
  `StartDate` date DEFAULT NULL,
  `ExpiryDate` date DEFAULT NULL,
  `ReviewDate` date DEFAULT NULL,
  `ContactID` int(11) NOT NULL,
  `AttachRiskTreatmentPlan` varchar(255) DEFAULT NULL,
  `ARMSTypeID` int(11) DEFAULT NULL,
  `ReviewPeriodID` int(11) DEFAULT '4',
  `RiskAversion` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `riskentry`
--

INSERT INTO `riskentry` (`RiskEntryID`, `CSFEntryID`, `RiskName`, `RiskTreatment`, `ImplementationCost`, `StartDate`, `ExpiryDate`, `ReviewDate`, `ContactID`, `AttachRiskTreatmentPlan`, `ARMSTypeID`, `ReviewPeriodID`, `RiskAversion`) VALUES
(2, 2, 'Business taken over', 'To collect information', 50000, '2017-02-01', '2017-02-28', '2017-03-31', 4, 'upload a file later', 3, 4, 20),
(3, 4, 'To be hacked', 'Install a software', 5000, '2017-04-01', '2017-04-30', '2017-05-31', 2, '', 3, 1, 25),
(4, 5, 'Database', 'Maintenance', 1500, '2017-05-01', '2017-04-01', '2017-05-31', 2, '', 1, 3, 80),
(5, 9, 'Malware', 'See image', 500000, '2017-03-07', '2019-03-14', '2017-08-16', 19, '', 3, 2, 10);

-- --------------------------------------------------------

--
-- Table structure for table `servicetypes`
--

CREATE TABLE `servicetypes` (
  `ServiceTypeID` int(11) NOT NULL,
  `ServiceType` varchar(255) NOT NULL,
  `Weigh` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `servicetypes`
--

INSERT INTO `servicetypes` (`ServiceTypeID`, `ServiceType`, `Weigh`) VALUES
(1, 'Core Service', 8),
(2, 'Enabling Service', 6),
(3, 'Enhancing Service', 3);

-- --------------------------------------------------------

--
-- Table structure for table `stakeholderentry`
--

CREATE TABLE `stakeholderentry` (
  `StakeholderEntryID` int(11) NOT NULL,
  `CSFEntryID` int(11) NOT NULL,
  `ValueAndImportanceImpactTypeID` int(11) NOT NULL,
  `RiskImpactTypeID` int(11) NOT NULL,
  `StakeholderTypeID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stakeholderentry`
--

INSERT INTO `stakeholderentry` (`StakeholderEntryID`, `CSFEntryID`, `ValueAndImportanceImpactTypeID`, `RiskImpactTypeID`, `StakeholderTypeID`) VALUES
(1, 2, 5, 5, 3),
(2, 3, 5, 3, 6),
(3, 4, 3, 3, 4),
(4, 5, 3, 2, 8),
(5, 6, 4, 4, 1),
(7, 9, 5, 4, 5);

-- --------------------------------------------------------

--
-- Table structure for table `stakeholdertypes`
--

CREATE TABLE `stakeholdertypes` (
  `StakeholderTypeID` int(11) NOT NULL,
  `StakeholderType` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stakeholdertypes`
--

INSERT INTO `stakeholdertypes` (`StakeholderTypeID`, `StakeholderType`) VALUES
(1, 'Customers & Clients'),
(2, 'Owners'),
(3, 'Commodity Suppliers'),
(4, 'Employees'),
(5, 'Legal & Regulatory Authorities'),
(6, 'Competitors & Industry Bodies'),
(8, 'Operational Suppliers');

-- --------------------------------------------------------

--
-- Table structure for table `threatimpacttypes`
--

CREATE TABLE `threatimpacttypes` (
  `ImpactTypeID` int(11) NOT NULL,
  `Impact` varchar(255) NOT NULL,
  `Weight` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `threatimpacttypes`
--

INSERT INTO `threatimpacttypes` (`ImpactTypeID`, `Impact`, `Weight`) VALUES
(1, 'Low', 2),
(2, 'Low - Medium', 4),
(3, 'Medium', 6),
(4, 'Medium - High', 8),
(5, 'High', 10);

-- --------------------------------------------------------

--
-- Table structure for table `threatsentry`
--

CREATE TABLE `threatsentry` (
  `ThreatsEntryID` int(11) NOT NULL,
  `ThreatTypeID` int(11) NOT NULL,
  `ThreatImpactTypeID` int(11) NOT NULL,
  `ThreatIikelihoodTypeID` int(11) NOT NULL,
  `CSFEntryID` int(11) NOT NULL,
  `RateOccurenceID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `threatsentry`
--

INSERT INTO `threatsentry` (`ThreatsEntryID`, `ThreatTypeID`, `ThreatImpactTypeID`, `ThreatIikelihoodTypeID`, `CSFEntryID`, `RateOccurenceID`) VALUES
(1, 1, 4, 3, 2, 3),
(2, 37, 1, 3, 3, 4),
(3, 1, 3, 3, 4, 4),
(4, 39, 4, 2, 5, 2),
(5, 7, 5, 1, 6, 3),
(6, 7, 5, 5, 8, 1),
(7, 24, 5, 5, 9, 3);

-- --------------------------------------------------------

--
-- Table structure for table `threattypes`
--

CREATE TABLE `threattypes` (
  `ThreatTypeID` int(11) NOT NULL,
  `ThreatType` varchar(255) NOT NULL,
  `VulnerabilityReference` varchar(255) DEFAULT NULL,
  `ThreatTypeDuration` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `threattypes`
--

INSERT INTO `threattypes` (`ThreatTypeID`, `ThreatType`, `VulnerabilityReference`, `ThreatTypeDuration`) VALUES
(1, 'BUSINESS TAKE OVER', 'Business Take over', ''),
(2, 'Phishing Email', '', ''),
(3, 'Malware', '', ''),
(4, 'Brute Force Password Hack', '', ''),
(5, 'REALLY BIG THREAT', '', ''),
(6, 'REALL SMALL THREAT', '', ''),
(7, 'A MEDIUM SMALL THREAT', '', ''),
(8, 'Terrorist Strike', '', ''),
(9, 'SERVER CRASH', '', ''),
(10, 'PERSONAL DECEPTION', '', ''),
(11, 'VIRUS', '', ''),
(12, 'Rain', '', ''),
(13, 'Industrial espionage', '', ''),
(14, 'CAR CRASH INTO POWER POLE', 'Electricity/Power Supply - POWER FAILURE', ''),
(15, 'LIGHTNING STRIKE', 'Electricity/Power Supply - POWER FAILURE', ''),
(16, 'STORM', 'Electricity/Power Supply - POWER FAILURE', ''),
(17, 'TERRORISM', 'Electricity/Power Supply - POWER FAILURE', ''),
(18, 'no threat to see here', 'Systems, Applications & Products (SAP) - A lightweight excuse for a poor example', ''),
(19, 'Misinformation', 'Human Resource Security - MisInformation', ''),
(20, 'Outage in Street', 'TELSTRA - Cable Supplier to Premises', ''),
(21, 'Main international Cable breaks', 'TELSTRA - Cable Supplier to Premises', ''),
(22, 'Microsoft goes out of business', 'Microsoft - Software is no longer supported', ''),
(23, 'A user could have access to sensitive data', 'Database - Incorrect Security Permissions', ''),
(24, 'A weak platform for Database structure', 'Database - Broken or Corrupt database structure', ''),
(25, 'Malware -', 'Utilities - Power - Outdated antivirus', ''),
(26, 'Social engineering', 'Human Resource Security - SOCIAL MEDIA', ''),
(27, 'Disaster from floods', 'IT Service Continuity Management - No plan in place', ''),
(28, 'Observation of sensitive information', 'Skills and Knowledge', ''),
(29, 'Nuclear meltdown', 'Incident Management', ''),
(30, 'Misuse of database', 'Training', ''),
(31, 'Bomb', 'Utilities - Power', ''),
(32, 'Car could crash into Pole', 'Electricity/Power Supply', ''),
(33, 'Steal database', 'database external', ''),
(34, 'Social engineering2', 'Financial Management', ''),
(35, 'Criminals can gain access un noticed', 'Utilities - Power', ''),
(36, 'Sensitive exposure to company/client secrets', 'Skills and Knowledge', ''),
(37, 'Databse being stolen and mined for data', 'database external', ''),
(38, 'Grey training companies', 'ATO - Aisa', ''),
(39, 'Incidents occuring', 'Incident Management', ''),
(40, 'Staff not following procedure', '', ''),
(41, 'Modifying reports to cover issues in training and transition', '', ''),
(42, 'STUXNET type virus that takes control of PLC''s', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `vbfbusinessimpacttypes`
--

CREATE TABLE `vbfbusinessimpacttypes` (
  `ImpactTypeID` int(11) NOT NULL,
  `Impact` varchar(255) NOT NULL,
  `Weight` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vbfbusinessimpacttypes`
--

INSERT INTO `vbfbusinessimpacttypes` (`ImpactTypeID`, `Impact`, `Weight`) VALUES
(1, 'Low', 1),
(2, 'Low - Medium', 2),
(3, 'Medium', 3),
(4, 'Medium - High', 4),
(5, 'High', 5);

-- --------------------------------------------------------

--
-- Table structure for table `vbfentry`
--

CREATE TABLE `vbfentry` (
  `VBFEntryID` int(11) NOT NULL,
  `VBFTypeID` int(11) NOT NULL,
  `Vision` varchar(500) DEFAULT NULL,
  `Misson` varchar(500) DEFAULT NULL,
  `BusinessImpactTypeID` int(11) NOT NULL,
  `LikelihoodFallingImpactTypeID` int(11) NOT NULL,
  `DepartmentID` int(11) NOT NULL,
  `Revenue` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vbfentry`
--

INSERT INTO `vbfentry` (`VBFEntryID`, `VBFTypeID`, `Vision`, `Misson`, `BusinessImpactTypeID`, `LikelihoodFallingImpactTypeID`, `DepartmentID`, `Revenue`) VALUES
(1, 4, 'VISION: <br/>To provide power to the main vbfs, ensuri', '', 3, 3, 5, 1239000),
(2, 8, 'VISION: Electronic ordering system for taking orde', NULL, 5, 1, 6, 20000000),
(3, 13, 'VISION: To make $1mil per month with 10,000 custom', 'To make interactive elearning course', 5, 3, 1, 5000000),
(4, 4, 'VISION: To be a major market player, Strategic par', NULL, 5, 1, 1, 50000),
(5, 11, 'VISION: Produce and supply support to all campuses', NULL, 5, 1, 1, 1560900),
(6, 12, 'VISION: To offer training to all departments aroun', NULL, 3, 3, 2, 240000),
(7, 13, 'VISION: To offer training to all departments aroun', NULL, 3, 3, 5, 240000),
(8, 13, 'To offer training tp all departments around the country using this elearning portal', 'Step by step integration with each state and department, to ensure effective and efficient training', 5, 3, 1, 250000),
(9, 3, 'To provide secure payment', 'To receive and track the order, send invoices and receive payments.', 4, 1, 2, 500),
(10, 13, 'offering auality services', NULL, 5, 1, 6, 2000000),
(11, 8, 'provide staible PC service', NULL, 5, 5, 7, 2000000),
(12, 7, 'Install payroll system', 'Find a good payroll system', 4, 2, 2, 30000),
(13, 8, 'rrr', 'bbb', 5, 5, 20, 150000),
(14, 8, 'rrr', 'ttt', 5, 5, 14, 150),
(15, 8, 'test', 'test', 3, 3, 16, 500),
(16, 8, 'ttt', 'rrr', 5, 5, 12, 1100),
(17, 8, 'rrr', 'eee', 5, 5, 12, 150),
(18, 8, 'rrr', 'eee', 5, 5, 20, 150),
(19, 4, 'rrr', 'ttt', 5, 5, 14, 235000),
(20, 4, 'test vision', 'test misson', 5, 3, 2, 2100101),
(21, 16, 'To offer clean and renewable energy cost effcetively and safely', 'Using state of the art technology to maintain nuclear cetrifuges and exceed our countries reuqrement', 5, 2, 2, 30000000),
(22, 16, 'To offer clean and efficeint energy to the coutry and comply with Kyoto requirements.', 'Clean effective centruges to create electricity for our country', 5, 2, 29, 30000000);

-- --------------------------------------------------------

--
-- Table structure for table `vbflikelihoodtypes`
--

CREATE TABLE `vbflikelihoodtypes` (
  `ImpactTypeID` int(11) NOT NULL,
  `Impact` varchar(255) NOT NULL,
  `Weight` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vbflikelihoodtypes`
--

INSERT INTO `vbflikelihoodtypes` (`ImpactTypeID`, `Impact`, `Weight`) VALUES
(1, 'Low', 1),
(2, 'Low - Medium', 2),
(3, 'Medium', 3),
(4, 'Medium - High', 4),
(5, 'High', 5);

-- --------------------------------------------------------

--
-- Table structure for table `vbftypes`
--

CREATE TABLE `vbftypes` (
  `VBFTypeID` int(11) NOT NULL,
  `VBFType` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vbftypes`
--

INSERT INTO `vbftypes` (`VBFTypeID`, `VBFType`) VALUES
(1, 'Email'),
(2, 'Power'),
(3, 'Online Payment Gateway'),
(4, 'Database Collaboration Engine'),
(5, 'Telephone'),
(6, 'Service Desk'),
(7, 'Payroll'),
(8, 'Computer Hardware'),
(9, 'HR (Human Resource Development)'),
(10, 'Examination sales'),
(11, 'Continuous integration'),
(12, 'Elearning Portal (ITIL Training)'),
(13, 'Elearning Portal (ITIL Training)'),
(14, 'Test VBF'),
(15, 'Wire harness provision'),
(16, 'Nuclear centrifuge');

-- --------------------------------------------------------

--
-- Table structure for table `vulnerabilityentry`
--

CREATE TABLE `vulnerabilityentry` (
  `VulnerabilityEntryID` int(11) NOT NULL,
  `CSFEntryID` int(11) NOT NULL,
  `VulnerabilityTypeID` int(11) NOT NULL,
  `ImpactTypeID` int(11) NOT NULL,
  `CurrentLevelCover` float DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vulnerabilityentry`
--

INSERT INTO `vulnerabilityentry` (`VulnerabilityEntryID`, `CSFEntryID`, `VulnerabilityTypeID`, `ImpactTypeID`, `CurrentLevelCover`) VALUES
(1, 2, 31, 2, 1545000),
(2, 6, 13, 2, 15000),
(3, 4, 44, 5, 50000),
(4, 5, 27, 3, 8500),
(5, 9, 51, 5, 10),
(6, 11, 41, 5, 1500);

-- --------------------------------------------------------

--
-- Table structure for table `vulnerabilitytypes`
--

CREATE TABLE `vulnerabilitytypes` (
  `VulnerabilityTypeID` int(11) NOT NULL,
  `VulnerabilityType` varchar(255) NOT NULL,
  `LifeCycleID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vulnerabilitytypes`
--

INSERT INTO `vulnerabilitytypes` (`VulnerabilityTypeID`, `VulnerabilityType`, `LifeCycleID`) VALUES
(1, 'establish governance', 3),
(2, 'manage stakeholders', 3),
(3, 'Manage Stakeholder - Gathering requirements', 3),
(4, 'create and manage policies', 3),
(5, 'manage audit and compliance', 3),
(6, 'Strategy management for IT Services', 3),
(7, 'Service portfolio management', 3),
(8, 'Financial management for IT Services', 3),
(9, 'Demand management', 3),
(10, 'Business Relationship Management', 3),
(11, 'Human resource security', 1),
(12, 'System acquisition, development, architecture and design', 1),
(13, 'Supplier and 3rd party security', 1),
(14, 'Endpoint security', 1),
(15, 'Cryptography', 1),
(16, 'Business continuity', 1),
(17, 'Design co-ordination', 1),
(18, 'Service catalogue management', 1),
(19, 'Service level management', 1),
(20, 'Availability management', 1),
(21, 'Capacity management', 1),
(22, 'IT service continuity management', 1),
(23, 'Supplier management', 1),
(24, 'Asset management and configuration management', 4),
(25, 'Asset Classification and handling', 4),
(26, 'Data transportation and removable media', 4),
(27, 'Change management', 4),
(28, 'Testing', 4),
(29, 'Training', 4),
(30, 'Document management', 4),
(31, 'Information retention', 4),
(32, 'Information disposal', 4),
(33, 'Transition planning and support', 4),
(34, 'Change management', 4),
(35, 'Service asset and configuration management', 4),
(36, 'Release and deployment management', 4),
(37, 'Service validation and testing', 4),
(38, 'Change evaluation', 4),
(39, 'Knowledge management', 4),
(40, 'Management of organizational change', 4),
(41, 'Access control', 2),
(42, 'Network security management', 2),
(43, 'Physical security', 2),
(44, 'Operations security', 2),
(45, 'Incident management', 2),
(46, 'Event management', 2),
(47, 'Incident management', 2),
(48, 'Request fulfilment', 2),
(49, 'Problem management', 2),
(50, 'Access management', 2),
(51, 'Windows Operating system', 2),
(52, 'PLC (siemens)', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `armstypes`
--
ALTER TABLE `armstypes`
  ADD PRIMARY KEY (`ARMSTypeID`);

--
-- Indexes for table `categorytypes`
--
ALTER TABLE `categorytypes`
  ADD PRIMARY KEY (`CategoryTypeID`);

--
-- Indexes for table `companies`
--
ALTER TABLE `companies`
  ADD PRIMARY KEY (`CompanyID`);

--
-- Indexes for table `contacts`
--
ALTER TABLE `contacts`
  ADD PRIMARY KEY (`ContactID`),
  ADD KEY `DepartmentID` (`DepartmentID`) USING BTREE;

--
-- Indexes for table `csfentry`
--
ALTER TABLE `csfentry`
  ADD PRIMARY KEY (`CSFEntryID`),
  ADD KEY `VBFEntryID` (`VBFEntryID`) USING BTREE,
  ADD KEY `CSFTypeID` (`CSFTypeID`) USING BTREE,
  ADD KEY `ProcessTypeID` (`ProcessTypeID`) USING BTREE,
  ADD KEY `ServiceTypeID` (`ServiceTypeID`) USING BTREE,
  ADD KEY `ImpactTypeID` (`ImpactTypeID`) USING BTREE,
  ADD KEY `RiskImpactTypeID` (`RiskImpactTypeID`) USING BTREE,
  ADD KEY `LifeCycleID` (`LifeCycleID`) USING BTREE;

--
-- Indexes for table `csftypes`
--
ALTER TABLE `csftypes`
  ADD PRIMARY KEY (`CSFTypeID`),
  ADD KEY `ProcessTypeID` (`ProcessTypeID`) USING BTREE;

--
-- Indexes for table `departmentcontacts`
--
ALTER TABLE `departmentcontacts`
  ADD PRIMARY KEY (`ContactID`,`DepartmentID`),
  ADD KEY `ContactID` (`ContactID`) USING BTREE,
  ADD KEY `DepartmentID` (`DepartmentID`) USING BTREE;

--
-- Indexes for table `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`DepartmentID`),
  ADD KEY `CompanyID` (`CompanyID`) USING BTREE;

--
-- Indexes for table `impacttypes`
--
ALTER TABLE `impacttypes`
  ADD PRIMARY KEY (`ImpactTypeID`);

--
-- Indexes for table `kpis`
--
ALTER TABLE `kpis`
  ADD PRIMARY KEY (`KPIID`),
  ADD KEY `CategoryTypeID` (`CategoryTypeID`) USING BTREE,
  ADD KEY `CSFEntryID` (`CSFEntryID`) USING BTREE,
  ADD KEY `DepartmentID` (`DepartmentID`) USING BTREE,
  ADD KEY `ContactID` (`ContactID`) USING BTREE;

--
-- Indexes for table `lifecycles`
--
ALTER TABLE `lifecycles`
  ADD PRIMARY KEY (`LifeCycleID`);

--
-- Indexes for table `processtypes`
--
ALTER TABLE `processtypes`
  ADD PRIMARY KEY (`ProcessTypeID`);

--
-- Indexes for table `processtypestakeholdertypes`
--
ALTER TABLE `processtypestakeholdertypes`
  ADD PRIMARY KEY (`ProcessTypeID`,`StakeholderTypeID`),
  ADD KEY `StakeholderTypeID` (`StakeholderTypeID`) USING BTREE;

--
-- Indexes for table `rateoccurences`
--
ALTER TABLE `rateoccurences`
  ADD PRIMARY KEY (`RateOccurenceID`);

--
-- Indexes for table `reviewperiods`
--
ALTER TABLE `reviewperiods`
  ADD PRIMARY KEY (`ReviewPeriodID`);

--
-- Indexes for table `riskentry`
--
ALTER TABLE `riskentry`
  ADD PRIMARY KEY (`RiskEntryID`),
  ADD UNIQUE KEY `CSFEntryID` (`CSFEntryID`) USING BTREE,
  ADD KEY `ARMSTypeID` (`ARMSTypeID`) USING BTREE,
  ADD KEY `ContactID` (`ContactID`) USING BTREE,
  ADD KEY `ReviewPeriodID` (`ReviewPeriodID`) USING BTREE;

--
-- Indexes for table `servicetypes`
--
ALTER TABLE `servicetypes`
  ADD PRIMARY KEY (`ServiceTypeID`);

--
-- Indexes for table `stakeholderentry`
--
ALTER TABLE `stakeholderentry`
  ADD PRIMARY KEY (`StakeholderEntryID`),
  ADD UNIQUE KEY `CSFEntryID` (`CSFEntryID`) USING BTREE,
  ADD KEY `ValueAndImportanceImpactTypeID` (`ValueAndImportanceImpactTypeID`) USING BTREE,
  ADD KEY `RiskImpactTypeID` (`RiskImpactTypeID`) USING BTREE,
  ADD KEY `StakeholderTypeID` (`StakeholderTypeID`) USING BTREE;

--
-- Indexes for table `stakeholdertypes`
--
ALTER TABLE `stakeholdertypes`
  ADD PRIMARY KEY (`StakeholderTypeID`);

--
-- Indexes for table `threatimpacttypes`
--
ALTER TABLE `threatimpacttypes`
  ADD PRIMARY KEY (`ImpactTypeID`);

--
-- Indexes for table `threatsentry`
--
ALTER TABLE `threatsentry`
  ADD PRIMARY KEY (`ThreatsEntryID`),
  ADD UNIQUE KEY `CSFEntryID` (`CSFEntryID`) USING BTREE,
  ADD KEY `ThreatTypeID` (`ThreatTypeID`) USING BTREE,
  ADD KEY `ThreatImpactTypeID` (`ThreatImpactTypeID`) USING BTREE,
  ADD KEY `ThreatIikelihoodTypeID` (`ThreatIikelihoodTypeID`) USING BTREE,
  ADD KEY `RateOccurenceID` (`RateOccurenceID`) USING BTREE;

--
-- Indexes for table `threattypes`
--
ALTER TABLE `threattypes`
  ADD PRIMARY KEY (`ThreatTypeID`);

--
-- Indexes for table `vbfbusinessimpacttypes`
--
ALTER TABLE `vbfbusinessimpacttypes`
  ADD PRIMARY KEY (`ImpactTypeID`);

--
-- Indexes for table `vbfentry`
--
ALTER TABLE `vbfentry`
  ADD PRIMARY KEY (`VBFEntryID`),
  ADD KEY `VBFTypeID` (`VBFTypeID`) USING BTREE,
  ADD KEY `BusinessImpactTypeID` (`BusinessImpactTypeID`) USING BTREE,
  ADD KEY `LikelihoodFallingImpactTypeID` (`LikelihoodFallingImpactTypeID`) USING BTREE,
  ADD KEY `DepartmentID` (`DepartmentID`) USING BTREE;

--
-- Indexes for table `vbflikelihoodtypes`
--
ALTER TABLE `vbflikelihoodtypes`
  ADD PRIMARY KEY (`ImpactTypeID`);

--
-- Indexes for table `vbftypes`
--
ALTER TABLE `vbftypes`
  ADD PRIMARY KEY (`VBFTypeID`);

--
-- Indexes for table `vulnerabilityentry`
--
ALTER TABLE `vulnerabilityentry`
  ADD PRIMARY KEY (`VulnerabilityEntryID`),
  ADD UNIQUE KEY `CSFEntryID` (`CSFEntryID`) USING BTREE,
  ADD KEY `VulnerabilityTypeID` (`VulnerabilityTypeID`) USING BTREE,
  ADD KEY `ImpactTypeID` (`ImpactTypeID`) USING BTREE;

--
-- Indexes for table `vulnerabilitytypes`
--
ALTER TABLE `vulnerabilitytypes`
  ADD PRIMARY KEY (`VulnerabilityTypeID`),
  ADD KEY `LifeCycleID` (`LifeCycleID`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `armstypes`
--
ALTER TABLE `armstypes`
  MODIFY `ARMSTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `categorytypes`
--
ALTER TABLE `categorytypes`
  MODIFY `CategoryTypeID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `companies`
--
ALTER TABLE `companies`
  MODIFY `CompanyID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `contacts`
--
ALTER TABLE `contacts`
  MODIFY `ContactID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `csfentry`
--
ALTER TABLE `csfentry`
  MODIFY `CSFEntryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `csftypes`
--
ALTER TABLE `csftypes`
  MODIFY `CSFTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;
--
-- AUTO_INCREMENT for table `departments`
--
ALTER TABLE `departments`
  MODIFY `DepartmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `impacttypes`
--
ALTER TABLE `impacttypes`
  MODIFY `ImpactTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `kpis`
--
ALTER TABLE `kpis`
  MODIFY `KPIID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `lifecycles`
--
ALTER TABLE `lifecycles`
  MODIFY `LifeCycleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `processtypes`
--
ALTER TABLE `processtypes`
  MODIFY `ProcessTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `rateoccurences`
--
ALTER TABLE `rateoccurences`
  MODIFY `RateOccurenceID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `reviewperiods`
--
ALTER TABLE `reviewperiods`
  MODIFY `ReviewPeriodID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `riskentry`
--
ALTER TABLE `riskentry`
  MODIFY `RiskEntryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `servicetypes`
--
ALTER TABLE `servicetypes`
  MODIFY `ServiceTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `stakeholderentry`
--
ALTER TABLE `stakeholderentry`
  MODIFY `StakeholderEntryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `stakeholdertypes`
--
ALTER TABLE `stakeholdertypes`
  MODIFY `StakeholderTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `threatimpacttypes`
--
ALTER TABLE `threatimpacttypes`
  MODIFY `ImpactTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `threatsentry`
--
ALTER TABLE `threatsentry`
  MODIFY `ThreatsEntryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `threattypes`
--
ALTER TABLE `threattypes`
  MODIFY `ThreatTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT for table `vbfbusinessimpacttypes`
--
ALTER TABLE `vbfbusinessimpacttypes`
  MODIFY `ImpactTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `vbfentry`
--
ALTER TABLE `vbfentry`
  MODIFY `VBFEntryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `vbflikelihoodtypes`
--
ALTER TABLE `vbflikelihoodtypes`
  MODIFY `ImpactTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `vbftypes`
--
ALTER TABLE `vbftypes`
  MODIFY `VBFTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `vulnerabilityentry`
--
ALTER TABLE `vulnerabilityentry`
  MODIFY `VulnerabilityEntryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `vulnerabilitytypes`
--
ALTER TABLE `vulnerabilitytypes`
  MODIFY `VulnerabilityTypeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `contacts`
--
ALTER TABLE `contacts`
  ADD CONSTRAINT `FK_Contacts_Departments_DepartmentID` FOREIGN KEY (`DepartmentID`) REFERENCES `departments` (`DepartmentID`);

--
-- Constraints for table `csfentry`
--
ALTER TABLE `csfentry`
  ADD CONSTRAINT `FK_CSFEntry_CSFTypes_CSFTypeID` FOREIGN KEY (`CSFTypeID`) REFERENCES `csftypes` (`CSFTypeID`),
  ADD CONSTRAINT `FK_CSFEntry_ImpactTypes_ImpactTypeID` FOREIGN KEY (`ImpactTypeID`) REFERENCES `impacttypes` (`ImpactTypeID`),
  ADD CONSTRAINT `FK_CSFEntry_ImpactTypes_RiskImpactTypeID` FOREIGN KEY (`RiskImpactTypeID`) REFERENCES `impacttypes` (`ImpactTypeID`),
  ADD CONSTRAINT `FK_CSFEntry_LifeCycles_LifeCycleID` FOREIGN KEY (`LifeCycleID`) REFERENCES `lifecycles` (`LifeCycleID`),
  ADD CONSTRAINT `FK_CSFEntry_ProcessTypes_ProcessTypeID` FOREIGN KEY (`ProcessTypeID`) REFERENCES `processtypes` (`ProcessTypeID`),
  ADD CONSTRAINT `FK_CSFEntry_ServiceTypes_ServiceTypeID` FOREIGN KEY (`ServiceTypeID`) REFERENCES `servicetypes` (`ServiceTypeID`),
  ADD CONSTRAINT `FK_CSFEntry_VBFEntry_VBFEntryID` FOREIGN KEY (`VBFEntryID`) REFERENCES `vbfentry` (`VBFEntryID`);

--
-- Constraints for table `csftypes`
--
ALTER TABLE `csftypes`
  ADD CONSTRAINT `FK_CSFTypes_ProcessTypes_LifeCycleID` FOREIGN KEY (`ProcessTypeID`) REFERENCES `processtypes` (`ProcessTypeID`);

--
-- Constraints for table `departmentcontacts`
--
ALTER TABLE `departmentcontacts`
  ADD CONSTRAINT `FK_DepartmentContacts_Departments_ContactID` FOREIGN KEY (`ContactID`) REFERENCES `contacts` (`ContactID`),
  ADD CONSTRAINT `FK_DepartmentContacts_Departments_DepartmentID` FOREIGN KEY (`DepartmentID`) REFERENCES `departments` (`DepartmentID`);

--
-- Constraints for table `departments`
--
ALTER TABLE `departments`
  ADD CONSTRAINT `FK_Departments_Companies_CompanyID` FOREIGN KEY (`CompanyID`) REFERENCES `companies` (`CompanyID`);

--
-- Constraints for table `kpis`
--
ALTER TABLE `kpis`
  ADD CONSTRAINT `FK_KPIs_CSFEntry_CSFEntryID` FOREIGN KEY (`CSFEntryID`) REFERENCES `csfentry` (`CSFEntryID`),
  ADD CONSTRAINT `FK_KPIs_CategoryTypes_CategoryTypeID` FOREIGN KEY (`CategoryTypeID`) REFERENCES `categorytypes` (`CategoryTypeID`),
  ADD CONSTRAINT `FK_KPIs_Contacts_ContactID` FOREIGN KEY (`ContactID`) REFERENCES `contacts` (`ContactID`),
  ADD CONSTRAINT `FK_KPIs_Departments_DepartmentID` FOREIGN KEY (`DepartmentID`) REFERENCES `departments` (`DepartmentID`);

--
-- Constraints for table `processtypestakeholdertypes`
--
ALTER TABLE `processtypestakeholdertypes`
  ADD CONSTRAINT `FK_PTST_ProcessTypes_ProcessTypeID` FOREIGN KEY (`ProcessTypeID`) REFERENCES `processtypes` (`ProcessTypeID`),
  ADD CONSTRAINT `FK_PTST_StakeholderTypes_StakeholderTypeID` FOREIGN KEY (`StakeholderTypeID`) REFERENCES `stakeholdertypes` (`StakeholderTypeID`);

--
-- Constraints for table `riskentry`
--
ALTER TABLE `riskentry`
  ADD CONSTRAINT `FK_RiskEntry_ARMSTypes_ARMSTypeID` FOREIGN KEY (`ARMSTypeID`) REFERENCES `armstypes` (`ARMSTypeID`),
  ADD CONSTRAINT `FK_RiskEntry_CSFEntry_CSFEntryID` FOREIGN KEY (`CSFEntryID`) REFERENCES `csfentry` (`CSFEntryID`),
  ADD CONSTRAINT `FK_RiskEntry_Contacts_ContactID` FOREIGN KEY (`ContactID`) REFERENCES `contacts` (`ContactID`),
  ADD CONSTRAINT `FK_RiskEntry_ReviewPeriods_ReviewPeriodID` FOREIGN KEY (`ReviewPeriodID`) REFERENCES `reviewperiods` (`ReviewPeriodID`);

--
-- Constraints for table `stakeholderentry`
--
ALTER TABLE `stakeholderentry`
  ADD CONSTRAINT `FK_StakeholderEntry_CSFEntry_CSFEntryID` FOREIGN KEY (`CSFEntryID`) REFERENCES `csfentry` (`CSFEntryID`),
  ADD CONSTRAINT `FK_StakeholderEntry_ImpactTypes_RiskImpactTypeID` FOREIGN KEY (`RiskImpactTypeID`) REFERENCES `impacttypes` (`ImpactTypeID`),
  ADD CONSTRAINT `FK_StakeholderEntry_ImpactTypes_ValueAndImportanceImpactTypeID` FOREIGN KEY (`ValueAndImportanceImpactTypeID`) REFERENCES `impacttypes` (`ImpactTypeID`),
  ADD CONSTRAINT `FK_StakeholderEntry_StakeholderTypes_StakeholderTypeID` FOREIGN KEY (`StakeholderTypeID`) REFERENCES `stakeholdertypes` (`StakeholderTypeID`);

--
-- Constraints for table `threatsentry`
--
ALTER TABLE `threatsentry`
  ADD CONSTRAINT `FK_ThreatsEntry_CSFEntry_CSFEntryID` FOREIGN KEY (`CSFEntryID`) REFERENCES `csfentry` (`CSFEntryID`),
  ADD CONSTRAINT `FK_ThreatsEntry_ImpactTypes_ThreatIikelihoodTypeID` FOREIGN KEY (`ThreatIikelihoodTypeID`) REFERENCES `impacttypes` (`ImpactTypeID`),
  ADD CONSTRAINT `FK_ThreatsEntry_ImpactTypes_ThreatImpactTypeID` FOREIGN KEY (`ThreatImpactTypeID`) REFERENCES `impacttypes` (`ImpactTypeID`),
  ADD CONSTRAINT `FK_ThreatsEntry_RateOccurences_RateOccurenceID` FOREIGN KEY (`RateOccurenceID`) REFERENCES `rateoccurences` (`RateOccurenceID`),
  ADD CONSTRAINT `FK_ThreatsEntry_ThreatTypes_ThreatTypeID` FOREIGN KEY (`ThreatTypeID`) REFERENCES `threattypes` (`ThreatTypeID`);

--
-- Constraints for table `vbfentry`
--
ALTER TABLE `vbfentry`
  ADD CONSTRAINT `FK_VBFE_Departments_DepartmentID` FOREIGN KEY (`DepartmentID`) REFERENCES `departments` (`DepartmentID`),
  ADD CONSTRAINT `FK_VBFE_ImpactTypes_BusinessImpactTypeID` FOREIGN KEY (`BusinessImpactTypeID`) REFERENCES `impacttypes` (`ImpactTypeID`),
  ADD CONSTRAINT `FK_VBFE_ImpactTypes_LikelihoodFallingImpactTypeID` FOREIGN KEY (`LikelihoodFallingImpactTypeID`) REFERENCES `impacttypes` (`ImpactTypeID`),
  ADD CONSTRAINT `FK_VBFEntry_VBFTypes_VBFTypeID` FOREIGN KEY (`VBFTypeID`) REFERENCES `vbftypes` (`VBFTypeID`);

--
-- Constraints for table `vulnerabilityentry`
--
ALTER TABLE `vulnerabilityentry`
  ADD CONSTRAINT `FK_VulnerabilityEntry_CSFEntry_CSFEntryID` FOREIGN KEY (`CSFEntryID`) REFERENCES `csfentry` (`CSFEntryID`),
  ADD CONSTRAINT `FK_VulnerabilityEntry_ImpactTypes_ImpactTypeID` FOREIGN KEY (`ImpactTypeID`) REFERENCES `impacttypes` (`ImpactTypeID`),
  ADD CONSTRAINT `FK_VulnerabilityEntry_VulnerabilityTypes_VulnerabilityTypeID` FOREIGN KEY (`VulnerabilityTypeID`) REFERENCES `vulnerabilitytypes` (`VulnerabilityTypeID`);

--
-- Constraints for table `vulnerabilitytypes`
--
ALTER TABLE `vulnerabilitytypes`
  ADD CONSTRAINT `FK_VulnerabilityTypes_LifeCycles_LifeCycleID` FOREIGN KEY (`LifeCycleID`) REFERENCES `lifecycles` (`LifeCycleID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
