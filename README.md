# desafio

FIXME: description

## Installation

Download from http://example.com/FIXME.

## Usage

FIXME: explanation

    $ java -jar desafio-0.1.0-standalone.jar [args]

## Options

FIXME: listing of options this app accepts.

## Examples

...

### Bugs

...

### Desafio
In this challenge, suppose we are looking to do social network
analysis for prospective customers. We want to extract from
their social network a metric called "closeness centrality".
Centrality metrics try to approximate a measure of influence
of an individual within a social network. The distance between
any two vertices is their shortest path. The *farness*
of a given vertex *v* is the sum of all distances from each vertex
to *v*. Finally, the *closeness* of a vertex *v* is the inverse
of the *farness*.
The goal of the challenge is to rank the vertices in a given
graph by their *closeness*. The graph is provided in the attached
file; each line of the file consists of two vertex names separated by
a single space, representing an edge between those two nodes.

You should deliver a github repository with your code and a short README
file outlining the solution and explaining how to build and run the
code. We'll analyse the structure and readability of the code-base.
 There is no problem in using
libraries, for instance for testing or network interaction, but please
avoid using a library that already implements the core graph or social
network algorithms.

The code must be delivered in a functional programming language. Clojure, Haskell, ML, F# and Scala are acceptable.
Developing automated tests while creating your work will be essential to ensure everything is working properly and avoiding wasting time.  

Don't shy away from asking questions whenever you encounter a problem.
Also, please do get in touch at any moment if you believe the timeframe
is unrealistic.
References:
- Closeness Centrality: http://en.wikipedia.org/wiki/Centrality#Closeness_centrality
- Shortest path: http://en.wikipedia.org/wiki/Shortest_path_problem

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
