![Java CI with Maven](https://github.com/mlemnian/diamond-kata/workflows/Java%20CI%20with%20Maven/badge.svg)

# About this Kata

[Alistair Cockburn wrote a blog post](https://alistair.cockburn.us/coming-soon/) about this kata, in response to the [Seb Rose kata proposition](http://claysnow.co.uk/recycling-tests-in-tdd/).

# Problem Description

Given a letter, print a diamond starting with ‘A’ with the supplied letter at the widest point.

For example: print-diamond 'C' prints
````
  A
 B B
C   C
 B B
  A
````
## Addition
In case of an invalid character an IllegalArgumentException should be thrown.