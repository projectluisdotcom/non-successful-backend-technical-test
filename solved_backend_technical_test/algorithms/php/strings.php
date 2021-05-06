<?php

function cypherString(string $str)
{
    $superEncriptionConfiguration = array(
        "A" => 4,
        "a" => 4,
        "E" => 3,
        "e" => 3,
        "I" => 1,
        "i" => 1,
        "O" => 0,
        "o" => 0,
        "B" => 8,
        "b" => 8,
        "S" => 6,
        "s" => 6,
    );

    foreach ($superEncriptionConfiguration as $encriptionOrigin => $encriptionTarget)
    {
        $str = str_replace($encriptionOrigin, $encriptionTarget, $str);
    }

    return $str;
}

echo cypherString('Brave soldiers who sacrificed their lives').PHP_EOL;
echo cypherString('Tom, Harry and Jack').PHP_EOL;
echo cypherString('{Company Name} is a great place to work').PHP_EOL;
echo cypherString('This exercise is a bit quirky!').PHP_EOL;
echo cypherString('AEIOBSzzzzaeiobszzzz!').PHP_EOL;
