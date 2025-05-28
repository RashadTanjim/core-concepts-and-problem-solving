# Distributed Systems & Infrastructure Papers

A curated list of high-impact engineering papers and systems from top tech companies like Google, Amazon, Meta, LinkedIn, and more. This list includes distributed systems, databases, file systems, graph processing, machine learning platforms, caching, and more.

---

## 📦 Google

* **Google File System** - A scalable distributed file system for large distributed data-intensive applications.
* **MapReduce** - A programming model for processing large data sets with a parallel, distributed algorithm.
* **BigTable** - A distributed storage system for managing structured data.
* **Colossus** - Next-gen file system replacing GFS.
* **Megastore** - A storage system blending the scalability of NoSQL with traditional RDBMS features.
* **Monarch** - High-performance time-series database.
* **Chubby** - Lock service for loosely-coupled distributed systems.
* **Spanner** - Globally-distributed database with strong consistency.

* *CAP theorem considerations* - How Spanner balances consistency, availability, and partition tolerance.
* **Dapper** - Large-scale distributed systems tracing infrastructure.
* **Borg** - Google's cluster management system.
* **Zanzibar** - Global authorization system.
* **Pregel** - Scalable graph processing system.
* **Napa** - Distributed data warehousing system.
* **Partitioning Algorithm** - Details on Napa’s strategy for data partitioning.
* **TensorFlow** - Machine learning framework for scalable training and inference.
* **F1** - Real-time distributed SQL database for analytics.
* **HALP** - YouTube’s high availability low latency CDN.
* **Mesa** - Robust data warehousing system.
* **Firestore** - Serverless NoSQL document database.
* **Improving CDN Path Latencies** - Techniques used to reduce latency in content delivery.([Murat Buffalo][1])

---

## ☁️ Amazon

* **Amazon Aurora** - High-performance, MySQL- and PostgreSQL-compatible cloud-native database.
* **DynamoDB** - Fully managed NoSQL database with millisecond performance.
* **Physalia** - Managing millions of tiny databases at scale.
* **Collaborative Filtering** - Recommendation algorithm used in Amazon.

---

## 🧠 Meta (Facebook)

* **Gorilla** - High-performance time-series database.
* **Cassandra** - Highly scalable NoSQL distributed database.
* **FlexiRaft** - Optimized consensus protocol balancing tradeoffs.
* **Memcache** - Distributed memory caching system.
* **Millisampler** - Efficient network traffic sampling.
* **TAO** - Distributed graph database for Facebook's social graph.
* **MineSweeper** - Root cause analysis for performance regressions.
* **Prophet** - Forecasting tool at scale.
* **ShardManager** - Service-aware shard management.
* **Hive** - Data warehouse system built on Hadoop for running SQL-like queries.
* **Thrift** - Interface definition language and RPC framework.
* **Twine** - Cluster management and deployment system.
* **ServiceRouter** - Meta's hyperscale service mesh for routing.

---

## 🐘 Apache

* **Hadoop File System (HDFS)** - Distributed file system designed for big data.
* **Flink** - Stream processing framework.

---

## 💼 LinkedIn

* **Finding N-hop Connections** - Algorithm for friend-of-a-friend queries.
* **Catching Fake Profiles** - Security systems used to detect fake accounts.
* **Magnet** - Scalable data processing framework.
* **Kafka** - Distributed event streaming platform.

---

## 🌐 Miscellaneous

* **FoundationDB** - Distributed NewSQL database with ACID transactions.
* **Monolith Embedding in Real Time** - Embedding monoliths for real-time data.
* **Scalability! But at what COST?** - Cost analysis of scalable systems.
* **SIEVE** - A simpler and more effective caching algorithm than LRU.
* **Caching Strategies at Twitter** - How Twitter scales its caching layer.
* **Improving Multi-CDN Delivery at Netflix** - Enhancing reliability and performance of global content delivery.
* **ZooKeeper:** Wait-free Coordination for Internet-scale Systems 
* **Brewer’s Conjecture** and the Feasibility of Consistent, Available, Partition-Tolerant Web Service

---

## 📚 Foundational & Influential Papers

* **Time, Clocks, and the Ordering of Events in a Distributed System** – Leslie Lamport (1978)
* **Impossibility of Distributed Consensus with One Faulty Process (FLP)** – Fischer, Lynch, Paterson (1985)
* **The Byzantine Generals Problem** – Lamport, Shostak, Pease (1982)
* **Paxos Made Simple** – Leslie Lamport (2001)
* **Raft Consensus Algorithm** – Diego Ongaro and John Ousterhout (2014)
* **Unreliable Failure Detectors for Reliable Distributed Systems** – Chandra and Toueg (1996)
* **The Log: What every software engineer should know about real-time data's unifying abstraction** – Jay Kreps (2013)
* **Life Beyond Distributed Transactions: An Apostate’s Opinion** – Pat Helland (2007)
* **CAP Twelve Years Later: How the "Rules" Have Changed** – Eric Brewer (2012)
* **Scalable, Elastic, and Fault-Tolerant Distributed Systems** – Various Authors([Wikipedia][2], [Dan Cres][3], [Wikipedia][4])

---

## 🧪 Blockchain & Consensus

* **Bitcoin: A Peer-to-Peer Electronic Cash System** – Satoshi Nakamoto (2008)
* **Hyperledger Fabric: A Distributed Operating System for Permissioned Blockchains** – Androulaki et al. (2018)
* **Untangling Blockchain: A Data Processing View of Blockchain Systems** – Dinh et al. (2017)([arXiv][5], [arXiv][6])

---

## 🧠 Machine Learning & Data Processing

* **A Survey on Distributed Machine Learning** – Verbraeken et al. (2019)
* **TensorFlow: Large-Scale Machine Learning on Heterogeneous Distributed Systems** – Abadi et al. (2016)
* **MapReduce: Simplified Data Processing on Large Clusters** – Dean and Ghemawat (2004)([arXiv][7], [Wikipedia][8])

---

## 🛠️ Tools & Frameworks

* **Jepsen** – A framework for distributed systems verification, with fault injection.
* **CADP (Construction and Analysis of Distributed Processes)** – A toolbox for the design of communication protocols and distributed systems.
* **PSync** – A partially synchronous language for fault-tolerant distributed algorithms.([GitHub][9], [Wikipedia][4])

---

## 📖 Books & Textbooks

* **Distributed Systems: Principles and Paradigms** – Andrew S. Tanenbaum, Maarten Van Steen
* **Distributed Systems: An Algorithmic Approach** – Wan Fokkink
* **Distributed Algorithms** – Nancy Lynch
* **Distributed Systems: Principles and Paradigms** – Andrew S. Tanenbaum, Maarten Van Steen

---

## 📝 Additional Resources

* **Distributed Systems Reading List** – A comprehensive reading list of distributed systems papers and resources.
* **Dijkstra Prize** – Awarded for outstanding papers in distributed computing.
* **Foundational Distributed Systems Papers** – A collection of foundational papers in distributed systems.
* **Operating Systems Design and Implementation** – A classic textbook on operating systems, including distributed systems concepts.


[1]: https://muratbuffalo.blogspot.com/2021/02/foundational-distributed-systems-papers.html?utm_source=chatgpt.com "Foundational distributed systems papers - Metadata"
[2]: https://de.wikipedia.org/wiki/Dijkstra-Preis?utm_source=chatgpt.com "Dijkstra-Preis"
[3]: https://dancres.github.io/Pages/?utm_source=chatgpt.com "Distributed Systems Reading List"
[4]: https://en.wikipedia.org/wiki/Construction_and_Analysis_of_Distributed_Processes?utm_source=chatgpt.com "Construction and Analysis of Distributed Processes"
[5]: https://arxiv.org/abs/1801.10228?utm_source=chatgpt.com "Hyperledger Fabric: A Distributed Operating System for Permissioned Blockchains"
[6]: https://arxiv.org/abs/1708.05665?utm_source=chatgpt.com "Untangling Blockchain: A Data Processing View of Blockchain Systems"
[7]: https://arxiv.org/abs/1912.09789?utm_source=chatgpt.com "A Survey on Distributed Machine Learning"
[8]: https://en.wikipedia.org/wiki/Operating_Systems_Design_and_Implementation?utm_source=chatgpt.com "Operating Systems Design and Implementation"
[9]: https://github.com/theanalyst/awesome-distributed-systems?utm_source=chatgpt.com "theanalyst/awesome-distributed-systems: A curated list to ... - GitHub"
