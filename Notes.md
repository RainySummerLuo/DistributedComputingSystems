# Distributed Computing Systems

## Introduction

## A distributed system is: 

- One in which components located at networked computers communicate and coordinate their actions only by passing messages. -G. Coulouris

- A collection of independent computers that appears to its users as a single coherent system.  -S. Tanenbaum

## Characteristics of Distributed Systems: 
- Concurrency of components
  - In a network of computers, concurrent program execution is the norm, sharing resources
- No global clock
  - When programs need to cooperate, they coordinate their actions by exchanging messages 
  - Close coordination depends on shared time 
  - There are limits to the accuracy with which the computers in a network can synchronize their clocks – there is no single global notion of the correct time [Section 6.1.1 of Tanenbaum]
  - This is a consequence of the fact that the only communication is by sending messages through the network 
- Independent failures of components
  - Each component of a distributed system can fail
    independently, leaving the others still running

## Service, Server, Client

- Request, respond

- A complete interaction between a client and a server, is called a remote invocation

## Challenges in building distributed systems
- Heterogeneity of components

  多样性

- Openness

- Security

- Scalability

- Failure handling

- Concurrency

- Transparency 