-- SQL File
-- Yves Dupont <ydupont@uni-koblenz.de>
--
-- Host: yd.wks001.int.ngineer.de
-- Generation Time: Jan 19, 2013 at 10:51 AM
-- MySQL server version: 5.5.28

USE `MySQLOneExtended`;

--
-- Constraints for table `bonus`
--
ALTER TABLE `bonus`
  ADD CONSTRAINT `bonus_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `review` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`did`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`jid`) REFERENCES `jobdescription` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`did`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `review_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
