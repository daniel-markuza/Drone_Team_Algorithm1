# Outline
## Ideas on how to make:

### Graph ADT: (non directed)

- Build a graph adt with the given paths
- make the graphs weighted by a ratio between passengers and distance to find best next point

### Algorithm:
- Build graph ADT, insert existant paths and current node  
- calculate ratio
- travel to the best choice from current location
- using recursion, repeat above steps with the new node being the current location and the old path removed

### file format
- first coordinate in the file is the start point
- coordinates should be one set per line, longitude and latitude should be seperated by a space
