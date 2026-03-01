# 🚀High-Throughput-Java-HTTP-Server

This project demonstrates the evolution of a socket server built in Java — starting from a simple single-threaded server, improving it to a multi-threaded version, and finally optimizing it using a ThreadPool.

The final version is highly scalable and capable of handling up to 60,000 requests per second under load, tested using Apache JMeter.

# 📂 Project Structure
SingleThreaded.java — Basic server that handles one client at a time.

MultiThreaded.java — Improved version where each client connection is handled by a new thread.

ThreadPool.java — Final optimized server using a fixed-size thread pool for better resource management and performance tuning.

# ⚙️ Features
**Single-threaded version :** basic blocking I/O.

**Multi-threaded version :** separate thread per client connection.

**ThreadPool Version :**

* Efficient thread reuse.

* Controlled concurrency.

* High throughput without exhausting server resources.

Performance tuned to handle 60,000 requests/sec.

Load Testing done using Apache JMeter.

# 📈 Performance Benchmark
Load Testing Tool: Apache JMeter

Peak Throughput: 60,000 requests per second

Test Setup:

High-concurrency virtual users.

1-second ramp-up time.

TCP Sampler (for raw socket testing).

# 🚀 How to Run
Clone the repository:

git clone https://github.com/vishal20csu/High-Throughput-Java-HTTP-Server.git

Compile and Run (example for ThreadPoolServer):

javac ThreadPool.Server.java

java ThreadPool.Server

Testing:

Start the server.

Use any TCP client or JMeter test plan to simulate concurrent client connections.

# 🛠️ Technologies Used
Java (Socket Programming, Threads, ExecutorService)

Apache JMeter (for benchmarking and load testing)

# 📚 Learnings
How to build scalable socket servers in Java.

Importance of thread management and system resource optimization.

Real-world performance testing using JMeter.

