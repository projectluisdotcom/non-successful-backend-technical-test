<?php

function getMatrixMax($matrix)
{
    $isValid = !is_null($matrix) && !empty($matrix);
    if(!$isValid)
    {
        throw new Exception('Invalid input.');    
    }
    
    $merged = array();
    foreach ($matrix as $row)
    {
       $merged = array_merge($merged, $row);
    }

    return max($res);
}

$matrixPositive = [
    [10, 100, 3],
    [12, 200, 154],
    [3, 30, 2],
];

$matrixMixed = [
    [-10, 100, 3],
    [12, -200, 154],
    [3, 30, -2],
];

$matrixNegative = [
    [-10, -100, -3],
    [-12, -200, -154],
    [-3, -30, -2],
];

echo getMatrixMax($matrixPositive).PHP_EOL; // Should return 200
echo getMatrixMax($matrixMixed).PHP_EOL; // Should return 154
echo getMatrixMax($matrixNegative).PHP_EOL; // Should return -2
