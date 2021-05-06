<?php

interface ISortable {
    public static function Sort(ClientReading $first, ClientReading $second): int;
}

class ClientReading implements ISortable {
    private $id;
    private $reading;

    public function __construct($id, $reading) {
        $this->id = $id;
        $this->reading = $reading;
    }

    public function __toString() {
        return $this->id.' '.$this->reading;
    }

    public function getClientReading() {
        return $this->reading;
    }

    public static function Sort(ClientReading $first, ClientReading $second): int {
        if(is_null($first)) {
            return -1;
        }

        if(is_null($second)) {
            return 1;
        }

        if(is_null($first) && is_null($second)) {
            return 0;
        }

        if($first->reading == $second->reading) {
            return 0;
        } 

        if($first->reading > $second->reading) {
            return -1;
        }

        return 1;
    }
}

$clients = [
    new ClientReading(uniqid(), 2000),
    new ClientReading(uniqid(), 1000),
    new ClientReading(uniqid(), 300),
    new ClientReading(uniqid(), 500),
    new ClientReading(uniqid(), 50),
    new ClientReading(uniqid(), 3000),
    new ClientReading(uniqid(), 1000),
];

usort($clients, array('ClientReading','Sort')); 
print_r($clients);
