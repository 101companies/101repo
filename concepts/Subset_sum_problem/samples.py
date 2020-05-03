'''
Samples have two parts each: the actual subset and a target sum.
The simple sample would be solvable by brute force without problems.
The complex sample needs some optimization to get runtime under 1min.
We use precise floats to be shielded against float representation issues.
'''

from decimal import *

simple = (
    [
        Decimal('5.99'),
        Decimal('6.53'),
        Decimal('11.58'),
        Decimal('22.02'),
        Decimal('55.32'),
        Decimal('58.81'),
        Decimal('61.98'),
        Decimal('83.07'),
        Decimal('240.33'),
    ],
    Decimal('145.05')
)

complex = (
    [
        Decimal('615.11'),
        Decimal('319.52'),
        Decimal('685.44'),
        Decimal('61.98'),
        Decimal('518.8'),
        Decimal('624.14'),
        Decimal('1196.52'),
        Decimal('783.49'),
        Decimal('690'),
        Decimal('309.38'),
        Decimal('350.57'),
        Decimal('560.61'),
        Decimal('55.32'),
        Decimal('240.33'),
        Decimal('419.85'),
        Decimal('610.09'),
        Decimal('1600.51'),
        Decimal('737.92'),
        Decimal('83.07'),
        Decimal('401.97'),
        Decimal('11.58'),
        Decimal('788.01'),
        Decimal('22.02'),
        Decimal('771.66'),
        Decimal('1437.61'),
        Decimal('1003.46'),
        Decimal('730.39'),
        Decimal('5.99'),
        Decimal('1264.17'),
        Decimal('58.81'),
        Decimal('662.09'),
        Decimal('6.53'),
        Decimal('323.49'),
        Decimal('930.96'),
        Decimal('871.29'),
        Decimal('415.46'),
        Decimal('347.34'),
        Decimal('268.31'),
        Decimal('308.44'),
        Decimal('248.71'),
        Decimal('707.24'),
        Decimal('1478.42'),
        Decimal('677.63'),
        Decimal('3234.29'),
    ],
    Decimal('4027.15')
)
