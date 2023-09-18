# Outline
## Ideas on how to make:

### Graph ADT: (non directed)

- Each node will contain coordinates, 
and be connected to every single other node  
- Adjacency list to represent connections, will start of
as a huge list but will increase in efficiency as we visit points
(since we don't want to visit that point again we can remove its edge)  
-compute distance between two given points

### Shortest Path:
- find shortest next waypoint  
- if diversion rerun and find new waypoint

### file format
- first coordinate in the file is the start point
- coordinates should be one set per line, longitude and latitude should be seperated by a space