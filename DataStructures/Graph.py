# undirected
# weighted
class Graph:
    def __init__(self):
        self.edges = {}

    def add_vertex(self, label):
        if label not in self.edges:
            self.edges[label] = []

    def remove_vertex(self, label):
        if label in self.edges:
            adj_vertices = [edge.y for edge in self.edges[label]]
            for vertex in adj_vertices:
                edges = self.edges[vertex]
                # reduce to edge -> label
                # remove edge
            edges.pop(label)

    def add_edge(self,x,y,weight=0):
        if x not in self.edges:
            self.add_vertex(x)
        if y not in self.edges:
            self.add_vertex(y)
        self.edges[x].append(Edge(y,weight))
        self.edges[y].append(Edge(x,weight))

    def remove_edge(self,x,y):
        if x in self.edges and y in self.edges:
            for edge in self.edges[x]:
                if edge.y == y:
                    

class Edge:
    def __init__(self,y,weight=0):
        self.y = y
        self.weight = weight