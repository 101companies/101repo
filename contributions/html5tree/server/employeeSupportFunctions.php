<?php
    // calculates the minimum value for the employee salary
    function getMinimumSalaryForEmployee($parent, $manager) {
        // min value = 0, if there is no inferior employee
        $minValue = 0;
        
        if ($manager == 1) {
            $request = "SELECT * FROM employee WHERE did = " . $parent;
            $result = mysql_query($request);
            while($row = mysql_fetch_object($result)) {
                if ($row->manager == 0 && $row->salary > $minValue) {
                    $minValue = $row->salary;
                }
            }
        }
        
        // employees of subdepartments
        $request = "SELECT * FROM employee WHERE did IN (SELECT id FROM department WHERE did =" . $parent . ")";
        $result = mysql_query($request);
        while($row = mysql_fetch_object($result)) {
            $salary = $row->salary;
            if ($salary > $minValue) {
                $minValue = $salary;
            }
        }
        
        return $minValue;
    }
    
    // calculates the minimum value for the employee salary
    function getMaximumSalaryForEmployee($parent, $manager) {
        // max value = 2000000, if there is no superior employee
        $maxValue = 2000000;
        
        if ($manager == 0) {
            $request = "SELECT * FROM employee WHERE did = " . $parent . " AND manager = 1";
            $result = mysql_query($request);
            
            if (mysql_num_rows($result) > 0) {
                $row = mysql_fetch_object($result);
                $maxValue = $row->salary;
            }
        }
        
        // superior department
        $request = "SELECT * FROM department WHERE id = (SELECT did FROM department WHERE id = " . $parent . ")";
        $result = mysql_query($request);
        if ($result != null && mysql_num_rows($result) > 0) {
            $row = mysql_fetch_object($result);
            $superiorDepId = $row->id;
            $request2 = "SELECT * FROM employee WHERE did = " . $superiorDepId;
            $result2 = mysql_query($request2);
            while($row2 = mysql_fetch_object($result2)) {
                $salary = $row2->salary;
                if ($salary < $maxValue) {
                    $maxValue = $salary;
                }
            }
        }
        
        return $maxValue;        
    }
?>
