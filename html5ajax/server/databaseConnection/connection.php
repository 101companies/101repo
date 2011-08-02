<?php

    function startServer($data) {
        // if the content-type is json, start loading
        if ($_SERVER['CONTENT_TYPE'] == "application/json"
                // BAD windows+mozilla workaround!!!
                || $_SERVER['CONTENT_TYPE'] == "application/json; charset=UTF-8") {
            // open connection to database
            $con = establishConnection();

            $jsonObject = json_decode($data);

            // create JSON-String and return it to the client
            echo json_encode(perform($jsonObject));

            // close connection to database
            closeConnection($con);

        // else send a warning
        } else {
            $error = new Statusmessage();
            $error->addFailure("Wrong content-type. Content-Type: application/json expected!");
            echo json_encode($error);
        }
    }
           
    // ---------------------------------------- connection management
    // establish connection to database
    function establishConnection() {
        $con = mysql_connect ("localhost", "root", "")
               or die ("Connection failed. Name or password wrong!");

        mysql_select_db("test") or die ("Database does not exist.");
        return $con;
    }

    // close connection
    function closeConnection($con) {
        mysql_close($con);
    }
?>
