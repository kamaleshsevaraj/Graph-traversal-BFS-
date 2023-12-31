class Node 
{
    int data;
    Node next;
    public Node(int d) 
    {
        data = d;
        next = null;
    }
}
class Queue 
{
    Node front, rear;
    public Queue() 
    {
        this.front = this.rear = null;
    }
    public void enqueue(int data) 
    {
        Node newNode = new Node(data);
        if (rear == null) 
        {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    public int dequeue() 
    {
        if (front == null) 
        {
            return -1; 
        }
        int data = front.data;
        front = front.next;
        if (front == null) 
        {
            rear = null;
        }
        return data;
    }
    public boolean isEmpty() 
    {
        return front == null;
    }
}
class Graph 
{
    int V; // Number of vertices 6
    Node[] adjList;
    public Graph(int V) 
    {
        this.V = V;
        adjList = new Node[V];
        for (int i = 0; i < V; i++) 
        {
            adjList[i] = null;
        }
    }
    public void addEdge(int src, int dest) 
    {
        Node newNode = new Node(dest);
        newNode.next = adjList[src];
        adjList[src] = newNode;
        newNode = new Node(src);
        newNode.next = adjList[dest];
        adjList[dest] = newNode;
    }
    public void BFS(int source) 
    {
        boolean[] visited = new boolean[V];
        Queue queue = new Queue();
        visited[source] = true;
        queue.enqueue(source);
        while (!queue.isEmpty()) 
        {
            int temp = queue.dequeue();
            System.out.print(temp + " ");
            Node head = adjList[temp];
            while (head != null) 
            {
                int neighbor = head.data;
                if (!visited[neighbor]) 
                {
                    visited[neighbor] = true;
                    queue.enqueue(neighbor);
                }
                head = head.next;
            }
        }
    }
}
public class Main 
{
    public static void main(String[] args) 
    {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        System.out.println("BFS Traversal starting from vertex 0:");
        graph.BFS(0); 
    }
}
